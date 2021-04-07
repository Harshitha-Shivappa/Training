package com.atmecs.demoProject.testscript;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.demoProject.dataprovider.TestDataProvider;
import com.atmecs.demoProject.helpers.WaitForElement;
import com.atmecs.demoProject.pages.HomePage;
import com.atmecs.demoProject.testBase.TestBase;

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
