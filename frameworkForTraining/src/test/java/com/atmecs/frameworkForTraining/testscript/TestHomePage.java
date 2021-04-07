package com.atmecs.frameworkForTraining.testscript;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.frameworkForTraining.dataprovider.TestDataProvider;
import com.atmecs.frameworkForTraining.helpers.WaitForElement;
import com.atmecs.frameworkForTraining.pages.HomePage;
import com.atmecs.frameworkForTraining.testBase.TestBase;

public class TestHomePage extends TestBase {
	HomePage homepageObject;

	@BeforeClass
	public void invokeBrowser() throws IOException {
		driver.get("https://www.atmecs.com/");
		driver.manage().window().maximize();
		WaitForElement waitObject = new WaitForElement();
		waitObject.waitForPageLoadTime(driver);
		waitObject.waitForImplicit(driver);
	}
	
	@Test(priority=1, dataProvider="headerData",dataProviderClass = TestDataProvider.class)
	public void validateHeader(String expectedHeaderName)
	{
		homepageObject=new HomePage(driver);
		homepageObject.validateHeaders(expectedHeaderName);
	}
	
}
