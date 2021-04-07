package com.homepage.basicFramework.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.homepage.basicFramework.constants.FileConstant;
import com.homepage.basicFramework.helpers.CommonUtility;
import com.homepage.basicFramework.utils.ReadPropertiesFile;

public class HomePage {
	Properties locators;
	CommonUtility commonUtility;

	public HomePage(WebDriver driver) {
		try {
			locators = ReadPropertiesFile.loadProperty(FileConstant.lOCATORS_FILE);
			commonUtility = new CommonUtility(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void validateHeaders(String expectedHeaderName) {

		String actualHeaderName = commonUtility
				.getText(locators.getProperty("loc_header_name").replace("[xxxx]", expectedHeaderName));
		Assert.assertEquals(actualHeaderName, expectedHeaderName);
		System.out.println("The footer of atmecs site: " + actualHeaderName);
	}
}
