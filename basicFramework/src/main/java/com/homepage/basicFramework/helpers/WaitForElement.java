package com.homepage.basicFramework.helpers;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.homepage.basicFramework.constants.*;

public class WaitForElement {
	public WebElement waitForElementToBeClickable(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, FileConstant.EXPLICIT_WAIT);
		return wait.until(ExpectedConditions
				.elementToBeClickable(GetElementFromLocators.matchLocatorsAndFetchElements(locator, driver)));
	}

	public void waitForElementToBeSelected(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, FileConstant.EXPLICIT_WAIT);
		wait.until(ExpectedConditions
				.elementToBeSelected(GetElementFromLocators.matchLocatorsAndFetchElements(locator, driver)));
	}

	public void waitForFrameToBeAvailable(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, FileConstant.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
				GetElementFromLocators.matchLocatorsAndFetchElements(locator, driver)));
	}

	public void waitForImplicit(WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(FileConstant.FLUENT_WAIT, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Element is not available or not clickable");
		}
	}

	public void waitForPageLoadTime(WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(FileConstant.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Element is not available or not clickable");
		}
	}

	public void waitForSetScripttimeout(WebDriver driver) {
		try {
			driver.manage().timeouts().setScriptTimeout(FileConstant.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Element is not available or not clickable");
		}
	}

	public WebElement WaitForFluent(WebDriver driver, final String locator) {
		try {
			FluentWait<WebDriver> fluentWait = null;
			fluentWait = new FluentWait<WebDriver>(driver).ignoring(Exception.class)
					.pollingEvery(Duration.ofSeconds(FileConstant.FLUENT_POLL))
					.withTimeout(Duration.ofSeconds(FileConstant.FLUENT_WAIT));
			return fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					WebElement element = GetElementFromLocators.matchLocatorsAndFetchElements(locator, driver);
					return element;
				}

			});
		} catch (Exception e) {
			System.out.println("Element is not available or not clickable");
		}
		return null;
	}
}
