package com.browser.locator;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindow {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\WebDriver\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		// new tab
		driver.findElement(By.xpath("//button[@id='tabButton']")).click();
		ArrayList<String> newTb = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		System.out.println("New tab: " + driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(newTb.get(0));
		System.out.println("Parent window: " + driver.getTitle());

		// new window
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@id='windowButton']")).click();

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			driver.manage().window().maximize();
			System.out.println("New window: " + driver.getCurrentUrl());
		}
		driver.close();
		// Switch back to parent browser
		driver.switchTo().window(parentWindow);
	}
}
