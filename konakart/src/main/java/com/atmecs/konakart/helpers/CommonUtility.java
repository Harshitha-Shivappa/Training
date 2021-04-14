package com.atmecs.konakart.helpers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * This class has different method for different types of functionality to be
 * perform by web element
 *
 */
public class CommonUtility {
	WebDriver driver;
	WaitForElement waitObject = new WaitForElement();

	public CommonUtility(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * the method is used for clicking the element using fluent wait
	 * 
	 * @param locator
	 */
	public void clickTheElement(String locator) {
		try {
			WebElement element = waitObject.WaitForFluent(driver, locator);
			element.click();
		} catch (Exception exception) {
			System.out.println("Element not clickable");
			exception.printStackTrace();
		}
	}

	/**
	 * the method is used for clicking the element and sending the text using fluent
	 * wait
	 * 
	 * @param locator
	 * @param text
	 */
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

	/**
	 * the method is used for clicking the element using explicit wait
	 * 
	 * @param locator
	 */
	public void clickOnElement(String locator) {
		try {
			WebElement element = waitObject.waitForElementToBeClickable(driver, locator);
			element.click();
		} catch (Exception exception) {
			System.out.println("Element not clickable");
			exception.printStackTrace();
		}
	}

	/**
	 * the method is used for sending the text and then press enter for entering the
	 * data using fluent wait
	 * 
	 * @param locator
	 * @param text
	 */
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

	/**
	 * the method is used for switching to frame
	 * 
	 * @param locator
	 */
	public void frameSwitch(String locator) {
		driver.switchTo().frame(locator);
	}

	/**
	 * the method is used for getting list of text
	 * 
	 * @param locator
	 */
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

	/**
	 * the method is used for getting the text using explicit wait
	 * 
	 * @param locator
	 */
	public String getText(String locator) {
		try {
			WebElement element = waitObject.waitForElementToBeClickable(driver, locator);
			String text = element.getText();
			return text;
		} catch (Exception exception) {
			System.out.println("unable to get the text");
			exception.printStackTrace();
		}
		return null;
	}

	/**
	 * the method is used for getting the title of web page
	 * 
	 * @param locator
	 */
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

	/**
	 * the method is used for clicking the element and getting the text using
	 * explicit wait
	 * 
	 * @param locator
	 */
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

	/**
	 * the method is used for navigating in dropdown and selecting the element
	 * 
	 * @param locator
	 * @param text
	 */
	public void selectDropdown(final String text, String locators) {
		try {
			Select value = new Select(GetElementFromLocators.matchLocatorsAndFetchElements(locators, driver));
			value.selectByVisibleText(text);
		} catch (Exception exception) {
			System.out.println("unable to select the option");
			exception.printStackTrace();
		}
	}

	/**
	 * the method is used for moving the mouse cursor to the element using explicit
	 * wait
	 * 
	 * @param locator
	 */
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

	/**
	 * the method is used for getting the text of attribute using explicit wait
	 * 
	 * @param locator
	 */
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

	/**
	 * the method is used for getting the elements of the locator
	 * 
	 * @param locator
	 */
	public List<WebElement> getElements(String locator) {
		try {
			return  GetElementFromLocators.matchLocatorsAndFetchElement(locator, driver);
		} catch (Exception exception) {
			System.out.println("unable to get the elements");
			exception.printStackTrace();
		}
		return null;
	}
}
