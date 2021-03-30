package com.browser.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\WebDriver\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/frames");
		driver.switchTo().frame("frame1");
		System.out.println(driver.findElement(By.tagName("h1")).getText());
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		System.out.println(driver.findElement(By.tagName("h1")).getText());
		
	}
}
