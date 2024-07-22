package com.orangehrm.utilities;

import java.time.Instant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.orangehrm.driverfactory.DriverFactory;

public class CommonObjects {

	private WebDriver driver;
//	WebElement element;
	WebElement text_box;
	WebElement button;
	WebElement successMsg;
	WebElement chekbox;
	WebElement errormsg;
	WebElement radiobtn;
	WebElement dropDown;
	WebElement dropDown_options;

	public static Logger logger = LogManager.getLogger(CommonObjects.class);
//	public DriverFactory DriverFactory = new DriverFactory();
	/*
	 * Constructor
	 */
	public CommonObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Enter Text method. Below method common for all enter text by tagname = input,
	 * locator = ID.
	 */

	public WebElement enterTextByID(String value, String enterText) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		String xpath = "//*[@id='" + value + "']";
		WebElement element = DriverFactory.getDriver().findElement(By.xpath(xpath));
		js.executeScript("arguments[0].style.border='3px solid blue'", element);
		element.sendKeys(Keys.HOME);
		element.sendKeys(Keys.CONTROL + "A");
		element.sendKeys(Keys.DELETE);
		appyWaitForElement();
		element.sendKeys(enterText);
		logger.info("Entered username is :" + enterText);
		Thread.sleep(3000);
		return element;
	}

	/**
	 * Enter Text Method. Below method common for all enter text by tagname = input
	 * locator = Type
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public WebElement enterTextByType(String value, String enterText) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		String xpath = "//*[@type='" + value + "']";
		appyWaitForElement();
		WebElement element = DriverFactory.getDriver().findElement(By.xpath(xpath));
		js.executeScript("arguments[0].style.border='3px solid blue'", element);
		element.sendKeys(Keys.HOME);
		element.sendKeys(Keys.CONTROL + "A");
		element.sendKeys(Keys.DELETE);
		appyWaitForElement();
		element.sendKeys(enterText);
		logger.info("Entered username is :" + enterText);
		return element;

	} // formcontrolname

	/**
	 * Enter Text Method. Below method common for all enter text by tagname =
	 * formcontrolname locator = Type
	 * 
	 */
	public WebElement enterTextByFormcontrolName(String value, String enterText) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		String xpath = "//*[@formcontrolname='" + value + "']";
		appyWaitForElement();
		WebElement element = DriverFactory.getDriver().findElement(By.xpath(xpath));
		js.executeScript("arguments[0].style.border='3px solid blue'", element);
		element.sendKeys(Keys.HOME);
		element.sendKeys(Keys.CONTROL + "A");
		element.sendKeys(Keys.DELETE);
		appyWaitForElement();
		element.sendKeys(enterText);
		logger.info("Entered username is :" + enterText);
		Thread.sleep(3000);
		return element;

	} // formcontrolname

	/**
	 * Click on Button Method, This method is created to click on button by tagname = input,
	 * locator = ID. with = ID
	 * @return 
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public WebElement clickOnButtonByID(String buttonName) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		String xpath = "//*[@id='" + buttonName + "']";
		appyWaitForElement();
		WebElement element = DriverFactory.getDriver().findElement(By.xpath(xpath));
		js.executeScript("arguments[0].style.border='3px solid blue'", element);
//		this.button = element;
		Thread.sleep(3000);
		element.click();
		return element;

	}

	/**
	 * Click on Button Method. This method is created to click on button by tagname = button,
	 * locator = type.
	 * 
	 * @throws InterruptedException
	 */
	public WebElement clickOnButtonByType(String buttonName) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		String xpath = "//*[@type='" + buttonName + "']";
		appyWaitForElement();
		WebElement element = DriverFactory.getDriver().findElement(By.xpath(xpath));
		js.executeScript("arguments[0].style.border='3px solid blue'", element);
		element.click();
		Thread.sleep(3000);
		return element;
	}
	
	
	
	/**
	 * Click on Button Method. This method is created to click on button by tagname = button,
	 * locator = type.
	 * 
	 * 
	 */
	public WebElement clickOnButtonByContainText(String buttonName) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		String xpath = "//*[contains(text(),'"+buttonName+"')]";
		appyWaitForElement();
		WebElement element = DriverFactory.getDriver().findElement(By.xpath(xpath));
		js.executeScript("arguments[0].style.border='3px solid blue'", element);
		Thread.sleep(3000);
		element.click();
		return element;
	}
	

	/**
	 * Click On link Method. This method is created for click on link by contains
	 * text()
	 * 
	 * @throws InterruptedException
	 */
	public WebElement clickOnLinkByContainsText(String value) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		String xpath = "//*[contains(text(),'" + value + "')]";
		appyWaitForElement();
		WebElement element = DriverFactory.getDriver().findElement(By.xpath(xpath));
		js.executeScript("arguments[0].style.border='3px solid blue'", element);
		element.click();
		Thread.sleep(3000);
		return element;
	}

	/**
	 * Click On link Method. This method is created for click on Link locatory =
	 * Class
	 * 
	 */
	public WebElement clickOnLinkByClass(String value) {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		String xpath = "//*[@class='" + value + "']";
		appyWaitForElement();
		WebElement element = DriverFactory.getDriver().findElement(By.xpath(xpath));
		js.executeScript("arguments[0].style.border='3px solid blue'", element);
		element.click();
		return element;
	}

	/*
	 * Verify text Method
	 * This method is created for verify text by contains text()
	 */

	public WebElement verifyTextByContainText(String value) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		String xpath = "//*[contains(text(),'" + value + "')]";
		appyWaitForElement();
		WebElement element = DriverFactory.getDriver().findElement(By.xpath(xpath));
		String actualText = element.getText();
		System.err.println(" Popup message :  " + actualText);
		js.executeScript("arguments[0].style.border='3px solid blue'", element);
		Assert.assertEquals(value,actualText);
		return element;

	}

	public WebDriverWait appyWaitForElement() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), ConstantsValues.EXPLICIT_WAIT);
		return wait;

	}

	public Instant startTime() {

		Instant startTime = Instant.now();
		return startTime;

	}

	public Instant endTime() {
		Instant endTime = Instant.now();
		return endTime;
	}

}
