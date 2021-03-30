package com.browser.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheapFlights {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.navigate().to("https://www.in.cheapflights.com/");
		driver.findElement(By.xpath("//div[@aria-label='Flight destination input']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Flight destination input']")).sendKeys("Coimbatore");
		driver.findElement(By.xpath("//input[@aria-label='Flight destination input']")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//div[@class='startDate _id7 _ijM _idA _ioF _ii0 _j0G _j0H']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label='April 1']")).click();
		
		String flag = "False";

		while (flag == "False") {
			if (driver.findElements(By.xpath("//div[@aria-label='June 3']")).size() > 0) {
				driver.findElement(By.xpath("//div[@aria-label='June 3']")).click();
				flag = "True";
			} else {
				driver.findElement(By.xpath("//div[@aria-label='Next month']")).click();
			}
		}
		driver.findElement(By.xpath("//button[@type='submit'][@aria-label='Search flights']")).click();
	}
}
