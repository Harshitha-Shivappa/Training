package com.atmecs.konakart.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.konakart.constants.FileConstant;
import com.atmecs.konakart.helpers.CommonUtility;
import com.atmecs.konakart.utils.ReadPropertiesFile;

public class KonaKart {
	Properties locators;
	CommonUtility commonUtility;

	public KonaKart(WebDriver driver) {
		try {
			locators = ReadPropertiesFile.loadProperty(FileConstant.lOCATORS_FILE);
			commonUtility = new CommonUtility(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void clickImage() {
		commonUtility.clickOnElement(locators.getProperty("loc_image_name"));
	}

	public void validateContents(String headerContent, String tab, String locator, String coffeeDescription,
			String kindleDescription) {
		String header = commonUtility.getText(locators.getProperty("loc_header_name"));
		if (header.equals(headerContent)) {
			commonUtility.clickOnElement(locators.getProperty("loc_tab_name").replace("[xxxx]", tab));
			if (locators.getProperty("loc_tab_name").replace("[xxxx]", tab).contains("reviews")) {
				// commonUtility.clickOnElement(locators.getProperty("loc_star").replace("[xxxx]",locator));
				validateReviews(coffeeDescription, kindleDescription);
			} else {
				String actualContent = commonUtility
						.getText(locators.getProperty("loc_description_name").replace("[xxxx]", locator));
				Assert.assertEquals(actualContent, coffeeDescription);
				System.out.println("Description: " + actualContent);
			}
		} else {
			commonUtility.clickOnElement(locators.getProperty("loc_tab_name").replace("[xxxx]", tab));
			if (locators.getProperty("loc_tab_name").replace("[xxxx]", tab).contains("reviews")) {
				// commonUtility.clickOnElement(locators.getProperty("loc_star").replace("[xxxx]", locator));
				validateReviews(coffeeDescription, kindleDescription);
			} else {
				String actualContent = commonUtility
						.getText(locators.getProperty("loc_description_name").replace("[xxxx]", locator));
				String t = "";
				String[] tests = actualContent.split("\\r?\\n");
				for (String value : tests)
					t = t.concat(value + " ");
				t = t.trim();
				Assert.assertEquals(t, kindleDescription);
				System.out.println("Description: " + actualContent);
			}
		}
	}

	public void validateReviews(String coffeeDescription, String kindleDescription) {
		commonUtility.selectDropdown(kindleDescription,
				locators.getProperty("loc_select").replace("[xxxx]", coffeeDescription));
		List<Date> listDates = new ArrayList<>();
		List<WebElement> elementList = commonUtility.getElements(locators.getProperty("loc_date"));
		SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE dd MMM yyyy");
		for (WebElement we : elementList) {
			if (!(we.getText().isEmpty()))
				try {
					listDates.add(dateFormatter.parse(we.getText()));
				} catch (Exception e) {
					System.out.println("Cannot convert date");
					e.printStackTrace();
				}
		}
		ArrayList<Date> sortedList = new ArrayList<>();
		for (Date s : listDates) {
			sortedList.add(s);
		}
		if (kindleDescription.equals("Oldest first")) {

			Collections.sort(sortedList);
			Assert.assertEquals(listDates, sortedList);
			System.out.println("Oldest first: " + sortedList);
		} else if (kindleDescription.equals("Most recent first")) {
			Collections.sort(sortedList);
			Collections.reverse(sortedList);
			Assert.assertEquals(listDates, sortedList);
			System.out.println("Most recent first: " + sortedList);
		}
	}
}
