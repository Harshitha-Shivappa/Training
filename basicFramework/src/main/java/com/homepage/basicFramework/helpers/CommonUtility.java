package com.homepage.basicFramework.helpers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonUtility {
	WebDriver driver;
	WaitForElement waitObject = new WaitForElement();
	
	public CommonUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void clickTheElement(String locator) {
		try {
			WebElement element = waitObject.WaitForFluent(driver, locator);
			element.click();
		} catch (Exception exception) {
			System.out.println("Element not clickable");
			exception.printStackTrace();
		}
	}
	
	public void clickAndSendText(String text, String locator) {
		try {
			WebElement element = waitObject.WaitForFluent(driver, locator);
			element.click();
			element.sendKeys(text);
		} catch (Exception exception) {
			System.out.println("Element not clickable");
			exception.printStackTrace();
		}
	}
	
	public void clickOnElement(String locator) {
		try {
			WebElement element = waitObject.waitForElementToBeClickable(driver, locator);
			element.click();
		} catch (Exception exception) {
			System.out.println("Element not clickable");
			exception.printStackTrace();
		}
	}
	
	public void sendTextAndPressEnter(String text, String locator) {
		try {
			WebElement element = waitObject.WaitForFluent(driver, locator);
			element.sendKeys(text);
			element.sendKeys(Keys.ENTER);
		} catch (Exception exception) {
			System.out.println("Element not clickable");
			exception.printStackTrace();
		}
	}
	
	public void frameSwitch(String locator) {
		driver.switchTo().frame(locator);
	}
	
	public List<String> getElementsTextList(final String path) {
		try {
			String xpath[] = path.split(";");
			List<WebElement> element = driver.findElements(By.xpath(xpath[1]));
			List<String> stringelement = new ArrayList<>();
			for (WebElement webelement : element) {
				stringelement.add(webelement.getText());
			}
			return stringelement;
		} catch (Exception exception) {
			System.out.println("unable to get text of element");
			exception.printStackTrace();
		}
		return null;
	}
	
	public String getText(String locator) {
		try {
			WebElement element = waitObject.waitForElementToBeClickable(driver, locator);
			return element.getText();
		} catch (Exception exception) {
			System.out.println("unable to get the text");
			exception.printStackTrace();
		}
		return null;
	}
	
	public String getTitle() {
		try {
			String title = driver.getTitle();
			return title;
		} catch (Exception exception) {
			System.out.println("unable to get the title");
			exception.printStackTrace();
		}
		return null;

	}
	
	public String clickAndGetText(String locator) {
		try {
			WebElement element = waitObject.waitForElementToBeClickable(driver, locator);
			element.click();
			String text = element.getText();
			return text;
		} catch (Exception exception) {
			System.out.println("unable to get the text");
			exception.printStackTrace();
		}
		return null;

	}

	public void selectDropdown(final String text, String locators) {
		try {
			Select value = new Select(GetElementFromLocators.matchLocatorsAndFetchElements(locators, driver));
			value.selectByVisibleText(text);
		} catch (Exception exception) {
			System.out.println("unable to select the option");
			exception.printStackTrace();
		}
	}
	
	public void moveToElement(String locator) {
		try {
			WebElement element = waitObject.waitForElementToBeClickable(driver, locator);
			Actions builder = new Actions(driver);
			Action mouseOverHome = builder.moveToElement(element).build();
			mouseOverHome.perform();
		} catch (Exception exception) {
			System.out.println("unable to move to the element");
			exception.printStackTrace();
		}
	}
	
	public String getAttributeText(String locator, String attributeType) {
		try {
			WebElement element = waitObject.waitForElementToBeClickable(driver, locator);
			String text = element.getAttribute(attributeType);
			return text;
		} catch (Exception exception) {
			System.out.println("unable to get the attribute of text");
			exception.printStackTrace();
		}
		return null;
	}
}

