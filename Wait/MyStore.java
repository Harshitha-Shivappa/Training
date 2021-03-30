package com.browser.locator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
// import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStore {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\WebDriver\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		String search = "//input[@id='search_query_top']";
		double total = 0;
		driver.findElement(By.xpath(search)).sendKeys("Dress");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ac_results']//child::ul/li[1]"))).click();

		driver.findElement(By.xpath("//button[@name='Submit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='button-container']//child::a"))).click();
		driver.findElement(By.xpath("//div[@id='header_logo']//child::a")).click(); 

		driver.findElement(By.xpath(search)).sendKeys("Dress");
		driver.findElement(By.xpath(search)).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 


		WebElement element;
		Actions action = new Actions(driver);
	/*	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element); */


		for(int i=1; i<=3; i++) {
			element = driver.findElement(By.xpath("//div[@id='center_column']/ul/li["+i+"]/div/div/div/a/img"));
			action.moveToElement(element).perform();
			driver.findElement(By.xpath("//div[@id='center_column']/ul/li["+i+"]/div/div/div/a[@title='Add to cart']")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			if(i!=3) 
				driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
			else
				driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		}
		
		List<WebElement> price = driver.findElements(By.xpath("//td[@data-title='Total']"));
		
		for(int i=0; i<price.size(); i++) {
			String s = price.get(i).getText();
			s = s.substring(1);
			total = total + Double.parseDouble(s);
		}
		System.out.println("Total: "+total);
		String check = driver.findElement(By.xpath("//td[@id='total_product']")).getText();
		String finalPrice = "$"+total;
		System.out.println("Final Price: "+finalPrice);
		if(finalPrice.equalsIgnoreCase(check)) 
			System.out.println("Same total price");
		else 
			System.out.println("Not same total price");
	}
}
