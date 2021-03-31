package com.atmecs.selenium;

import com.atmecs.selenium.utils.XlsxReader;

public class App 
{
	public static void main(String[] args) {
	/*	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harshitha.Shivappa\\workspace\\Training\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle()); */
		
		XlsxReader reader = new XlsxReader("C:\\Users\\Harshitha.Shivappa\\workspace\\Training\\TestData\\TestExcelData.xlsx");
		String userName = reader.getData(0, 1, 0);
		String password = reader.getData(0, 1, 1);
		System.out.println("Username: "+userName);
		System.out.println("Password: "+password);
		
		int rowCount = reader.totalRowsInSheet(0);
		System.out.println("Total Row: "+rowCount);
		
		int colCount = reader.totalColsInSheet(0, rowCount);
		System.out.println("Total Column: "+colCount);
	}
}
