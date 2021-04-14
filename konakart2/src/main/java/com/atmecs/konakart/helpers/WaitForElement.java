package com.atmecs.konakart.helpers;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.konakart.constants.FileConstant;

/**
 * The class has different method for different types of wait
 *
 */

public class WaitForElement {

	/**
	 * this method take the below parameters
	 * @param driver
	 * @param locator
	 * and put the wait in driver until the element to be clickable.
	 */
	public WebElement waitForElementToBeClickable(WebDriver driver,String locator) 
	{
		WebDriverWait wait=new WebDriverWait(driver,FileConstant.EXPLICIT_WAIT);
		return wait.until(ExpectedConditions.elementToBeClickable(GetElementFromLocators.matchLocatorsAndFetchElements(locator, driver)));
	}
	
	/**
	 * this method take the below parameters
	 * @param driver
	 * @param locator
	 * and put the wait in driver until the element to be selected.
	 */
	public void waitForElementToBeSelected(WebDriver driver,String locator) 
	{
		WebDriverWait wait=new WebDriverWait(driver,FileConstant.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.elementToBeSelected(GetElementFromLocators.matchLocatorsAndFetchElements(locator, driver)));
	}
	
	/**
	 * this method take the below parameters
	 * @param driver
	 * @param locator
	 * and put the wait in driver until the frame to be available and switch to it.
	 */
	public void waitForFrameToBeAvailable(WebDriver driver,String locator) 
	{
		WebDriverWait wait=new WebDriverWait(driver,FileConstant.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(GetElementFromLocators.matchLocatorsAndFetchElements(locator, driver)));
	}
	
	/**
	 * this method take the below parameter
	 * @param driver
	 * and put the implicit wait
	 */
	public void waitForImplicit(WebDriver driver) 
	{
		try 
		{
		driver.manage().timeouts().implicitlyWait(FileConstant.FLUENT_WAIT, TimeUnit.SECONDS);
		}catch(Exception e) 
		{
			System.out.println("Element is not available or not clickable");	
		}
	}
	
	/**
	 * this method take the below parameter
	 * @param driver
	 * and put the wait in driver until the page loading. 
	 */
	public void waitForPageLoadTime(WebDriver driver) 
	{
		try {
		driver.manage().timeouts().implicitlyWait(FileConstant.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		}catch(Exception e) 
		{
			System.out.println("Element is not available or not clickable");
		}
	}
	
	/**
	 * this method take the below parameter
	 * @param driver
	 * and put the wait in driver before throw an error to finish the script execution
	 */
	public void waitForSetScripttimeout(WebDriver driver) 
	{
		try {
		driver.manage().timeouts().setScriptTimeout(FileConstant.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		}
		catch(Exception e) 
		{
			System.out.println("Element is not available or not clickable");
		}
	}
	
	/**
	 * this method take the below parameter
	 * @param driver
	 * @param locator
	 * and put the wait for before throwing the exception and poll the element after the specific polling time interval. 
	 */
	public WebElement WaitForFluent(WebDriver driver,String locator) {
		try {
			FluentWait<WebDriver> fluentWait = null;
			fluentWait = new FluentWait<WebDriver>(driver).ignoring(Exception.class).pollingEvery(Duration.ofSeconds(FileConstant.FLUENT_POLL))
					.withTimeout(Duration.ofSeconds(FileConstant.FLUENT_WAIT));
			return fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					WebElement element = GetElementFromLocators.matchLocatorsAndFetchElements(locator, driver);
					return element;
				}

			});
		}catch(Exception e) 
		{
			System.out.println("Element is not available or not clickable");
		}
		return null;
	}

}
