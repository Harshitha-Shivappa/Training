package com.atmecs.frameworkForTraining.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.frameworkForTraining.constants.FileConstant;
import com.atmecs.frameworkForTraining.helpers.CommonUtility;
import com.atmecs.frameworkForTraining.utils.ReadPropertiesFile;

public class HomePage {
Properties locators;
CommonUtility commonUtility;
	
	public HomePage(WebDriver driver)
	{
		try {
			locators=ReadPropertiesFile.loadProperty(FileConstant.lOCATORS_FILE);
			commonUtility=new CommonUtility(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void validateHeaders(String expectedHeaderName) {
		
		String actualHeaderName=commonUtility.getText(locators.getProperty("loc_header_name").replace("[xxxx]", expectedHeaderName));
		Assert.assertEquals(actualHeaderName,expectedHeaderName);
		System.out.println("the headers of atmecs site:-"+actualHeaderName);
	}
}
