package com.atmecs.selenium.dataProvider;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.selenium.utils.ProvideData;

public class DataProviderProgram {
	WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.out.println("Before Method Started");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Harshitha.Shivappa\\workspace\\Training\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
		System.out.println("Before Method completed");
	}

	@DataProvider(name = "getTestData")
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> data = ProvideData.getDataFromSheet();
		return data.iterator();
	}

	@Test(dataProvider="getTestData")
	public void signUpPageTest(String firstName, String lastName, String userName, String password, String confirm){
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@aria-label='Confirm']")).sendKeys(confirm);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
