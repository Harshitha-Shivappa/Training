package com.atmecs.konakart.testscript;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.konakart.dataprovider.TestDataProvider;
import com.atmecs.konakart.helpers.WaitForElement;
import com.atmecs.konakart.pages.KonaKart;
import com.atmecs.konakart.testBase.TestBase;

public class TestKonaKart extends TestBase {
	KonaKart konakartObject;

	@BeforeClass
	public void invokeBrowser() throws IOException {
		driver.get("https://www.konakart.com/konakart/Welcome.action");
		driver.manage().window().maximize();
		WaitForElement waitObject = new WaitForElement();
		waitObject.waitForPageLoadTime(driver);
		waitObject.waitForImplicit(driver);
	}
	
	@Test
	public void clickImage() {
		konakartObject=new KonaKart(driver);
		konakartObject.clickImage();
	}
	
	@Test(priority=1, dataProvider="headerData",dataProviderClass = TestDataProvider.class)
	public void validateHeaders(String headerContent, String tab, String locator, String coffeeDescription, String kindleDescription)
	{
		konakartObject=new KonaKart(driver);
		konakartObject.validateContents(headerContent, tab, locator, coffeeDescription, kindleDescription);
	} 
	
}
