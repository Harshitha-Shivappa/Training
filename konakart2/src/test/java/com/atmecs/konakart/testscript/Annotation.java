package com.atmecs.konakart.testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.konakart.dataprovider.TestDataProvider;
import com.atmecs.konakart.helpers.WaitForElement;
import com.atmecs.konakart.pages.KonaKart;
import com.atmecs.konakart.testBase.TestBase;

public class Annotation extends TestBase {
	KonaKart konakartObject;

	@BeforeClass
	public void invokeBrowser() throws IOException {
		driver.get("https://www.konakart.com/konakart/Welcome.action");
		driver.manage().window().maximize();
		WaitForElement waitObject = new WaitForElement();
		waitObject.waitForPageLoadTime(driver);
		waitObject.waitForImplicit(driver);
	}
	
	@Test(dataProvider="Testing",dataProviderClass = TestDataProvider.class)
	public void testing1(String values){
	    System.out.println("test has started"); 
		for(int i=0;i<6;i++) {
			Select ele=new Select(driver.findElement(By.xpath("//*[@id=\"top-cat-list\"]")));
			ele.selectByIndex(i);
		    }
			WebElement txt=driver.findElement(By.xpath("//*[@id=\"search-input\"]"));
	        txt.sendKeys(values);

		    driver.findElement(By.xpath("//*[@id=\"search-button\"]")).click();
	}
	
}
