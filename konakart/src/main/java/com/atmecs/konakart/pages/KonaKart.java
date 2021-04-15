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
				commonUtility.clickOnElement(locators.getProperty("loc_star").replace("[xxxx]", locator));
				validateReviews(coffeeDescription, kindleDescription);
				validateStars(locator);
			} else {
				String actualContent = commonUtility
						.getText(locators.getProperty("loc_description_name").replace("[xxxx]", locator));
				Assert.assertEquals(actualContent, coffeeDescription);
				System.out.println("Description: " + actualContent);
			}
		} else {
			commonUtility.clickOnElement(locators.getProperty("loc_tab_name").replace("[xxxx]", tab));
			if (locators.getProperty("loc_tab_name").replace("[xxxx]", tab).contains("reviews")) {
				commonUtility.clickOnElement(locators.getProperty("loc_star").replace("[xxxx]", locator));
				
				validateReviews(coffeeDescription, kindleDescription);
				validateStars(locator);
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
		commonUtility.selectDropdown(kindleDescription,	locators.getProperty("loc_select").replace("[xxxx]", coffeeDescription));
		if (kindleDescription.contains("Rating:")) {
			int ele = commonUtility.getElementCount(locators.getProperty("loc_review_count"));
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 1; i <= ele; i++) {
				String str = String.valueOf(i);
				int star = commonUtility.getElementCount(locators.getProperty("loc_star_count").replace("xxxx", str));
				list.add(star);
			}
			ArrayList<Integer> sorted = new ArrayList<>();
			if (kindleDescription.equals("Rating: high to low")) {
				sorted.addAll(list);
				Collections.sort(sorted);
				Collections.reverse(sorted);
				Assert.assertEquals(list, sorted);
				System.out.println("Validated Rating: high to low");
			} else if (kindleDescription.equals("Rating: low to high")) {
				sorted.addAll(list);
				Collections.sort(sorted);
				Assert.assertEquals(list, sorted);
				System.out.println("Validated Rating: low to high");
			}
		}
		if (kindleDescription.contains("Oldest") || kindleDescription.contains("recent")) {
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
				System.out.println("Validated Oldest first");
			} else if (kindleDescription.equals("Most recent first")) {
				Collections.sort(sortedList);
				Collections.reverse(sortedList);
				Assert.assertEquals(listDates, sortedList);
				System.out.println("Validated Most recent first");
			}
		}
	}

	public void validateStars(String locator) {
		char review = locator.charAt(locator.length() - 1);
		int ele = commonUtility.getElementCount(locators.getProperty("loc_review_count"));
		for (int i = 1; i <= ele; i++) {
			String str = String.valueOf(i);
			int star = commonUtility.getElementCount(locators.getProperty("loc_star_count").replace("xxxx", str));
			int check = Character.getNumericValue(review);
			Assert.assertEquals(star, check);
		}
		System.out.println("Validated stars");
	}
}
