package com.browser.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]")).click();
		String flag = "False";

		while (flag == "False") {
			if (driver.findElements(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label,'Aug 11 2021')]")).size() > 0) {
				driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label,'Aug 11 2021')]")).click();
				flag = "True";
			} else {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}

		driver.findElement(By.xpath("//span[text()='RETURN']")).click();
		driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label,'Aug 14 2021')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click(); 
	}
}
