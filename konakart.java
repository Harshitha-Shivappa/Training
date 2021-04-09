package com.browser.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class KonaKart {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.konakart.com/konakart/Welcome.action");
		ChromeOptions chrome = new ChromeOptions();
		chrome.addArguments("--disable-notifications");
		driver.findElement(By.xpath("//picture[@id='slide-1']//img")).click();
		String text = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
		if (text.equals("De'Longhi BCO 410")) {
			driver.findElement(By.xpath("//div[@id='product-description-tab']")).click();
			String expectedDescription = "The De'Longhi BCO 410 is a 15 bar espresso/filter coffee machine that will ensure you get the perfect coffee experience, regardless of your tastes. Able to make 10 cups of filter coffee or individual espressos (either via ground coffee or with \"Easy Serving Espresso\" pods), the BCO 410 is a versatile and high-quality machine. The espresso portion of the machine comes complete with a crema filter holder, adjustable steam emission, removable water reservoir and cup holder. The filter coffee portion of the machine comes complete with a jug warmer to ensure the coffee remains hot after brewing, frontal loading to make the machine incredibly easy to refill (both water and coffee) and a water filtration system to make your coffee taste that much better.";
			String actualDescription = driver.findElement(By.xpath("//div[@id='product-description']//p")).getText();
			if (expectedDescription.equals(actualDescription)) {
				System.out.println("Same description");
			} else {
				System.out.println("Different description");
			}
			driver.findElement(By.xpath("//div[@id='product-specifications-tab']")).click();
			String expectedSpecification = "Add your product specifications here. By default, the Enterprise version of KonaKart displays the template based custom attributes.";
			String actualSpecification = driver.findElement(By.xpath("//div[@id='product-specifications']//p"))
					.getText();
			if (expectedSpecification.equals(actualSpecification)) {
				System.out.println("Same specification");
			} else {
				System.out.println("Different specification");
			}

			driver.findElement(By.xpath("//div[@id='product-reviews-tab']")).click();
			driver.findElement(By.xpath("//span[starts-with(@class,'kk')]")).click();

			Select year = new Select(driver.findElement(By.xpath("//select[@name='orderBy']")));
			year.selectByVisibleText("Oldest first");
			chrome.addArguments("--disable-blink-features=AutomationControlled");
		} else { 
			driver.findElement(By.xpath("//div[@id='product-description-tab']")).click();
			String expectedDescription = "World's most advanced 7\" tablet 1280x800 HD display with polarizing filter and anti-glare technology for rich color and deep contrast from any viewing angle Exclusive Dolby audio and dual-driver stereo speakers for immersive, virtual surround sound World's first tablet with dual-band, dual-antenna Wi-Fi for 40% faster downloads and streaming (compared to iPad 3) High performance 1.2 Ghz dual-core processor with Imagination PowerVR 3D graphics core for fast and fluid performance";
			String actualDescription = driver.findElement(By.xpath("//div[@id='product-description']//p")).getText();
			String t = "";
			String[] tests = actualDescription.split("\\r?\\n");
			for (String value : tests)
				t = t.concat(value + " ");
			t = t.trim();

			if (expectedDescription.equals(t)) {
				System.out.println("Same description");
			} else {
				System.out.println("Different description");
			}

			driver.findElement(By.xpath("//div[@id='product-specifications-tab']")).click();
			String expectedSpecification = "Add your product specifications here. By default, the Enterprise version of KonaKart displays the template based custom attributes.";
			String actualSpecification = driver.findElement(By.xpath("//div[@id='product-specifications']//p"))
					.getText();
			if (expectedSpecification.equals(actualSpecification)) {
				System.out.println("Same specification");
			} else {
				System.out.println("Different specification");
			}

			driver.findElement(By.xpath("//div[@id='product-reviews-tab']")).click();
			driver.findElement(By.xpath("//span[starts-with(@class,'kk')]")).click();

			Select year = new Select(driver.findElement(By.xpath("//select[@name='orderBy']")));
			year.selectByVisibleText("Oldest first");
			chrome.addArguments("--disable-blink-features=AutomationControlled");
		}
		driver.close();
	}
}
