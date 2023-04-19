package com.tyss.abp.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.github.javafaker.Faker;
import com.tyss.abp.baseutil.BaseTest;
import com.tyss.abp.baseutil.CreateDriver;
import com.tyss.abp.reports.ExtentManager;

/**
 * Description:: All the action utilities added in this class e.g click on
 * element, WaitforElement etc
 * 
 * @author Manikandan ,Ramya R
 */
public class WebActionUtil {
	public static WebDriver driver;
	public WebDriverWait wait;
	public long ETO;
	public static JavascriptExecutor jsExecutor;
	public Actions action;
	public String mainWindowID;

	public static BaseTest b;

	public WebActionUtil(WebDriver driver, long ETO) {
		this.driver = driver;
		this.ETO = ETO;
		wait = new WebDriverWait(driver, ETO);
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		b = new BaseTest();
	}

	/**
	 * Description: Method to provide info in the log,testNg reports
	 * 
	 * @author Manikandan
	 * @param message
	 */
	public static void info(String message) {
		BaseTest.logger.info(message);
	}

	/**
	 * Description: Method for the error updation in logs
	 * 
	 * @author Manikandan
	 * @param message
	 */
	public static void error(String message) {
		BaseTest.logger.error(message);
	}

	/**
	 * Description: Method to provide info in the extent report
	 * 
	 * @author Manikandan
	 * @param message
	 */
	public static void extentinfo(String message) {
		ExtentManager.getTestReport().info(message);
	}

	/**
	 * Description: Method for the pass updation in extent Report
	 * 
	 * @author Manikandan
	 * @param message
	 */
	public static void pass(String message) {
		ExtentManager.getTestReport().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}

	/**
	 * Description: Method for the info/error updation in extent Report
	 * 
	 * @author Manikandan
	 * @param message
	 * @param color
	 */
	public static void validationinfo(String message, String color) {
		if (color.equalsIgnoreCase("blue"))
			ExtentManager.getTestReport().info(MarkupHelper.createLabel(message, ExtentColor.BLUE));
		else if (color.equalsIgnoreCase("green"))
			ExtentManager.getTestReport().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
		else if (color.equalsIgnoreCase("red"))
			ExtentManager.getTestReport().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	/**
	 * Description: Method for the error updation in extent Report
	 * 
	 * @author Manikandan
	 * @param message
	 */
	public static void fail(String message) {
		ExtentManager.getTestReport().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	/**
	 * Description: Method for fetching Current Date Time
	 * 
	 * @author Manikandan
	 */
	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}

	/**
	 * Description: Method for fetching Current Date Time
	 * 
	 * @author Manikandan
	 */

	public static String getCurrentDateTime1() {
		DateFormat customFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}

	/**
	 * Description: Method to delete the directory
	 * 
	 * @author Manikandan
	 * @param pathToDeleteFolder
	 */
	public static void deleteDir(String pathToDeleteFolder) {
		File extefolder = new File(pathToDeleteFolder);
		if ((extefolder.exists())) {
			deleteFolderDir(extefolder);
		}
	}

	/**
	 * Description:: Method to delete folder directory for time period above 30days
	 * 
	 * @author Manikandan
	 * @param folderToDelete
	 */
	public static synchronized void deleteDirectory(String folderToDelete) {
		try {
			File dir = new File(folderToDelete);
			File[] files = dir.listFiles();
			if (files.length > 1) {
				for (File file : files) {
					String name = file.getName();
					if (name.toLowerCase().contains("automation")) {
						String[] dateTime = name.split("- ");
						if (calculateDateDifference(dateTime[1]) > 30) {
							String tempXLFile = new StringBuffer(folderToDelete).append(File.separator).append(name)
									.toString();
							deleteDir(tempXLFile);
						}
					}
				}
			}
		} catch (Exception e) {
			error("Unable to delete the directory");
			fail("Unable to delete the directory");
		}
	}

	/**
	 * Description: Method to delete folder directory
	 * 
	 * @author Manikandan
	 * @param folderToDelete
	 */
	public static void deleteFolderDir(File folderToDelete) {
		File[] folderContents = folderToDelete.listFiles();
		if (folderContents != null) {
			for (File folderfile : folderContents) {
				if (!Files.isSymbolicLink(folderfile.toPath())) {
					deleteFolderDir(folderfile);
				}
			}
		}
		folderToDelete.delete();
	}

	/**
	 * Description:: Method to find difference between current date and mentioned
	 * date
	 * 
	 * @author Manikandan
	 * @param actualDateTime
	 * @return days_difference
	 */
	public static synchronized long calculateDateDifference(String actualDateTime) {
		// Create an instance of the SimpleDateFormat class
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		long days_difference = 0;
		String currentDateTime = getCurrentDateTime();
		try {
			// Use parse method to get date object of both dates
			Date date1 = customFormat.parse(actualDateTime);
			Date date2 = customFormat.parse(currentDateTime);
			// Calculate time difference in milliseconds
			long time_difference = date2.getTime() - date1.getTime();
			// Calculate time difference in days using TimeUnit class
			days_difference = TimeUnit.MILLISECONDS.toDays(time_difference) % 365;
		} catch (Exception e) {
			error("Unable to calculate Date difference");
			fail("Unable to calculate Date difference");

		}
		return days_difference;
	}

	/**
	 * Description: Capture the screenshot of the complete screen
	 * 
	 * @author Manikandan
	 * @param path
	 * @return destinationPath
	 */
	public synchronized static String getScreenShot(String path, String className) {
		TakesScreenshot screenshot = (TakesScreenshot) CreateDriver.getInstance().getDriver();
		File src = (screenshot.getScreenshotAs(OutputType.FILE));
		String currentDateTime = getCurrentDateTime();
		String destinationPath = path + className + "-" + currentDateTime + ".png";
		File destination = new File(destinationPath);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "./Screenshots/" + className + "-" + currentDateTime + ".png";
	}

	/**
	 * Description: Clear the Text
	 * 
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 */
	public void clearText(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
			info("Cleared the text present in" + elementName);
		} catch (Exception e) {
			error("Unable to clear the text in " + elementName);
			Assert.fail("Unable to clear the text in " + elementName);
		}
	}

	/**
	 * Description: To Enter the Text to the Text filed
	 * 
	 * @author Manikandan
	 * @param element
	 * @param value
	 * @param elementName
	 */
	public synchronized void typeText(WebElement element, String value, String elementName) {
		try {
			info("Enter the value into " + elementName);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.sendKeys(value);
			info(value + " typed into " + elementName);
		} catch (AssertionError error) {
			error("Unable to type " + value + " into " + elementName);
			Assert.fail("Unable to type in " + elementName);
		} catch (Exception e) {
			error(" Unable to type " + value + "into " + elementName);
			Assert.fail("Unable to type in " + elementName);
		}
	}

	/**
	 * Description: To Select the value by the Visible Text
	 * 
	 * @author Manikandan
	 * @param element
	 * @param value
	 * @param elementName
	 */
	public synchronized void selectByText(WebElement element, String value, String elementName) {
		try {
			info("Select the value " + value + " from " + elementName);
			Select selecvalue = new Select(element);
			selecvalue.selectByVisibleText(value);
			info("Able to select the value " + value + " from " + elementName);
			extentinfo("Able to select the value  " + value + " from " + elementName);
		} catch (Exception e) {
			error("Unable to select the value " + value + " from " + elementName);
			fail("Unable to select the value " + value + " from " + elementName);
			Assert.fail("Unable to select the value " + value + " from " + elementName);
		}
	}

	/**
	 * 
	 * Description: This method selects the options by value using Select Class.
	 * 
	 * @author Ramya R
	 * @param element
	 * @param value
	 * @param elementName
	 */
	public synchronized void selectByValue(WebElement element, String value, String elementName) {
		try {
			waitForElement(element, elementName);
			Select sc = new Select(element);
			sc.selectByValue(value);
			info(value + " is selected from " + elementName);
			extentinfo(value + " is selected from " + elementName);
		} catch (Exception e) {
			error("Unable to select " + value + " from " + elementName);
			fail("Unable to select " + value + " from " + elementName);
			Assert.fail("Unable to select " + value + " from " + elementName);
		}
	}

	/**
	 * Description: This method will deselect all the value from drop down
	 * 
	 * @author Ramya R
	 * @param element
	 */
	public synchronized void deSelectAll(WebElement element) {
		try {
			info("Deselect all value from dropdown");
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Select selecvalue = new Select(element);
			selecvalue.deselectAll();
			info("Able to deselect all value from dropdown");
			extentinfo("Able to deselect all value from dropdown");
		} catch (Exception e) {
			error("Unable to deselect all value from dropdown");
			fail("Unable to deselect all value from dropdown");
			Assert.fail("Unable to deselect all value from dropdown");
		}
	}

	/**
	 * Description: :This method will perform mouse over action context click
	 * 
	 * @author Ramya R
	 * @param element
	 */
	public synchronized void mouseHoverToContextClick(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			action.contextClick(element).perform();
			info("Able to perform mouse hover context click");
			extentinfo("Able to perform mouse hover context click");
		} catch (Exception e) {
			error("Unable to perform mouse hover context click");
			fail("Unable to perform mouse hover context click");
			Assert.fail("Unable to perform mouse hover context click");
		}
	}

	/**
	 * Description: Scroll to the Element
	 * 
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 */
	public void scrollToElement(WebElement element, String elementName) {
		info("Scroll till the " + elementName);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
			info("Scroll till the " + elementName + " completed");
		} catch (Exception e) {
			error("Scroll till the " + elementName + " failed");
			Assert.fail("Scroll till the " + elementName + " failed");
		}
	}

	/**
	 * Description: Scroll up
	 * 
	 * @author Manikandan
	 */
	public synchronized void scrollUp() {
		try {
			jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight , 0)");
			info("Scroll up");
		} catch (Exception e) {
			error("Scroll up failed");
			Assert.fail("Scroll up failed");
		}
	}

	/**
	 * Description: Wait for given time
	 * 
	 * @author Manikandan
	 * @param millis
	 */
	public synchronized static void poll(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Description: Wait for the angular page to load
	 * 
	 * @author Manikandan
	 */
	public static synchronized void waitForAngularPageToLoad() {
		try {
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return Boolean.valueOf(((JavascriptExecutor) driver)
							.executeScript("return (window.angular !== undefined) "
									+ "&& (angular.element(document).injector() !== undefined) "
									+ "&& (angular.element(document).injector().get('$http').pendingRequests.length === 0)")
							.toString());
				}
			};
			BaseTest b1 = new BaseTest();
			WebDriverWait wait = new WebDriverWait(b1.driver, 3);
			wait.until(pageLoadCondition);
		} catch (Exception e) {
			// error("Unable to load the page correctly");
		}
	}

	/**
	 * Description: Wait for the Element is displayed with expected conditions
	 * 
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 */
	public synchronized void waitForElement(WebElement element, String elementName) {
		try {
			info("Wait for " + elementName);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)) != null);

		} catch (Exception e) {
			error(elementName + " is not visible");
			Assert.fail(elementName + " is not visible");
		}
	}

	/**
	 * Description: Wait for invisibility of element
	 * 
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 * @param timeInSecs
	 */
	public synchronized void waitForInvisibilityOfElement(WebElement element, String elementName, Long timeoutInSecs) {
		info("Wait for invisiblity of " + elementName);
		WebDriverWait wait1 = new WebDriverWait(driver, timeoutInSecs);
		try {
			wait1.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			error(elementName + " is still visible");
//			fail(elementName + " is still visible");
//			Assert.fail(elementName + " is still visible");

		}
	}

	/**
	 * Description: Wait for the Element is displayed with expected conditions
	 * 
	 * @author Manikandan, Sushmita
	 * @param element
	 * @param elementName
	 */
	public void waitForElements(List<WebElement> elements, String elementName) {
		try {
			info("Wait for " + elementName);
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfAllElements(elements)) != null);
		} catch (Exception e) {
			error(elementName + " is not visible");
			Assert.fail(elementName + " is not visible");

		}
	}

	/**
	 * Description: Wait for Visibility of element
	 * 
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 */
	public synchronized void waitForVisibilityOfElement(WebElement element, String elementName) {// ,
																									// Long
																									// timeoutInSecs)
																									// {
		info("Wait for Visiblity of " + elementName);
		// WebDriverWait wait1 = new WebDriverWait(driver, timeoutInSecs);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			error(elementName + " is not visible");
			Assert.fail(elementName + " is not visible");

		}
	}

	/**
	 * Description: :Checks whether an element is visible
	 *
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 */
	public synchronized boolean isElementVisible(WebElement element, String elemantName) {

		try {
			info("Validate " + elemantName + " is visible");
			wait.until(ExpectedConditions.visibilityOf(element));
			info(elemantName + " is visible");
			return true;
		} catch (Exception e) {
			info(elemantName + " is not visible");
			return false;
		}
	}

	/**
	 * Description: Check whether the Element is displayed with expected conditions
	 *
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 */
	public synchronized boolean isElementClickable(WebElement element, String elementName) {

		info("Validate " + elementName + " is clickable");
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			error(elementName + " is not clickable");
			return false;
		}
	}

	/**
	 * Description: File upload by using sendkeys
	 * 
	 * @author Manikandan
	 * @param element
	 * @param imagePath
	 */
	public synchronized void uploadImageUsingSendKeys(WebElement element, String imagePath) {
		try {
			info("Uploading the image");
			element.sendKeys(imagePath);
		} catch (Exception e) {
			error("Unable to upload the image");
			fail("Unable to upload the image");
			Assert.fail("Unable to upload the image");
		}
	}

	/**
	 * Description: :File upload by using the image path
	 *
	 * @author Manikandan
	 * @param imagePath
	 */
	public synchronized void upload(String imagePath) {
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		poll(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		poll(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		poll(3000);
	}

	/**
	 * Description: This method validates the current url of the application
	 * 
	 * @author Ramya R
	 * @param expectedUrl
	 * @param elementName
	 */
	public synchronized void validateUrl(String expectedUrl, String elementName) {
		try {
			String actualUrl = driver.getCurrentUrl();
			Assert.assertEquals(expectedUrl, actualUrl);
			info(elementName + " page is displayed");
			validationinfo(elementName + " page is displayed", "green");
		} catch (Exception e) {
			error(elementName + " page is not displayed");
			fail(elementName + " page is not displayed");
			Assert.fail(elementName + " page is not displayed");
		}
	}

	/**
	 * Description: Validate the Text partially
	 * 
	 * @author Manikandan
	 * @param expected
	 * @param element
	 * @param elementname
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validatePartialText(String expected, WebElement element, String elementname,
			String validationPassMessage, String validationFailMessage, String color) {
		String actual = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			actual = element.getText();
			Assert.assertTrue(actual.contains(expected));
			info("Expected text " + expected + " is present in " + actual + " text in the application");
			validationinfo(validationPassMessage, color);
			info(validationPassMessage);
		} catch (Exception e) {
			error("Expected text " + expected + " is not present in " + actual + " text in the application ");
			error(validationFailMessage);
			fail(validationFailMessage);
			Assert.fail(validationFailMessage);

		}
	}

	/**
	 * Description: Validate the Text
	 * 
	 * @author Manikandan
	 * @param expected
	 * @param element
	 * @param elementname
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateText(String expected, WebElement element, String elementname,
			String validationPassMessage, String validationFailMessage, String color) {
		wait.until(ExpectedConditions.visibilityOf(element));
		String actual = element.getText();
		try {
			Assert.assertTrue(actual.toLowerCase().contains(expected.toLowerCase()));
			// Assert.assertEquals(actual, expected);
			info("Expected text " + expected + " is matching with the " + actual + " text in the application ");
			validationinfo(validationPassMessage, color);
			info(validationPassMessage);
		} catch (Exception e) {
			error("Expected text " + expected + " is not  matching with the " + actual + " text in the application ");
			error(validationFailMessage);
			fail(validationFailMessage);
			Assert.fail(validationFailMessage);

		}
	}

	/**
	 * Description: Check whether the Element is displayed with expected conditions
	 * 
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateisElementDisplayed(WebElement element, String elementName,
			String validationPassMessage, String validationFailMessage, String color) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(element.isDisplayed());
			validationinfo(validationPassMessage, color);
			info(validationPassMessage);
		} catch (AssertionError e) {
			fail(validationFailMessage);
			error(validationFailMessage);
			Assert.fail(validationFailMessage);
		}
	}

	/**
	 * Description: Verify the attribute value of an element
	 * 
	 * @author Manikandan
	 * @param element
	 * @param attribute
	 * @param valuetobecompared
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateAttribute(WebElement element, String attribute, String valuetobecompared,
			String elementName, String validationPassMessage, String validationFailMessage, String color) {
		String actualvalue = element.getAttribute(attribute);
		try {
			wait.until(ExpectedConditions.attributeContains(element, attribute, valuetobecompared));
			Assert.assertEquals(element.getAttribute(attribute), valuetobecompared);
			info("Expected attribute value " + valuetobecompared + " is matching with the actual attribute value "
					+ actualvalue + " of " + elementName);
			info(validationPassMessage);
			validationinfo(validationPassMessage, color);
		} catch (Exception e) {
			error("Expected attribute value " + valuetobecompared + " is not matching with the actual attribute value "
					+ actualvalue + " of " + elementName);
			error(validationFailMessage);
			fail(validationFailMessage);
			Assert.fail(validationFailMessage);
		}
	}

	/**
	 * Description: Validate the value entered in an element
	 * 
	 * @author Manikandan
	 * @param expectedValue
	 * @param actualvalue
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateEnteredValue(String expectedValue, String actualvalue, String elementName,
			String validationPassMessage, String validationFailMessage, String color) {
		try {
			Assert.assertEquals(expectedValue, actualvalue);
			info("Valid value is entered in " + elementName);
			info(validationPassMessage);
			validationinfo(validationPassMessage, color);
		} catch (Exception e) {
			error("Valid value is not entered in " + elementName);
			error(validationFailMessage);
			fail(validationFailMessage);
			Assert.fail(validationFailMessage);

		}
	}

	/**
	 * Description: Check whether the Element is Enabled
	 * 
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateisElementEnabled(WebElement element, String elementName,
			String validationPassMessage, String validationFailMessage, String color) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(element.isEnabled());
			validationinfo(validationPassMessage, color);
			info(validationPassMessage);
		} catch (AssertionError e) {
			fail(validationFailMessage);
			error(validationFailMessage);
			Assert.fail(validationFailMessage);

		}
	}

	/**
	 * Description: :Retrieves text of the web element
	 * 
	 * @author Manikandan
	 * @param element
	 * @param attribute
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateAttributeIsEmpty(WebElement element, String attribute, String elementName,
			String validationPassMessage, String validationFailMessage, String color) {
		String actualvalue = element.getAttribute(attribute);
		try {
			if (actualvalue.isEmpty()) {
				validationinfo(validationPassMessage, color);
				info(validationPassMessage);
			} else {
				error(validationFailMessage);
				fail(validationFailMessage);
				Assert.fail(validationFailMessage);

			}
		} catch (Exception e) {
			error(validationFailMessage);
			fail(validationFailMessage);
			Assert.fail(validationFailMessage);

		}
	}

	/**
	 * Description: Check whether the Element is selected with expected conditions
	 * 
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 * @param validationPassMessage
	 * @param validationFailMessage
	 * @param color
	 */
	public synchronized void validateisElementSelected(WebElement element, String elementName,
			String validationPassMessage, String validationFailMessage, String color) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(element.isSelected());
			validationinfo(validationPassMessage, color);
			info(validationPassMessage);
		} catch (AssertionError e) {
			fail(validationFailMessage);
			error(validationFailMessage);
			Assert.fail(validationFailMessage);

		}
	}

	/**
	 * Description: Get file path
	 * 
	 * @author Manikandan
	 * @param fileFormat
	 * @return filePath + fileName
	 */
	public synchronized String getSampleFilePath(String fileFormat) {

		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\UploadFiles\\";
		String fileName = "Sample." + fileFormat;
		return filePath.replaceAll("\\\\", "\\\\\\\\") + fileName;

	}

	/**
	 * Description: Retrives the value entered in an element
	 * 
	 * @author Manikandan
	 * @param elementId
	 * @return entereddValue
	 */
	public synchronized String getTextUsingJS(String elementId) {
		String entereddValue = null;
		try {
			poll(1000);
			String script = "return document.getElementById('" + elementId + "').value";
			entereddValue = (String) (jsExecutor.executeScript(script));
			// info("The value entered in element is " + entereddValue);
		} catch (Exception e) {
			error("Unable to get entered value from element with id " + elementId);
			Assert.fail("Unable to get entered value from element with id " + elementId);

		}
		return entereddValue;
	}

	/**
	 * Description: :Retrieves text of the Webelement
	 * 
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 */
	public synchronized String getText(WebElement element, String elementName) {
		String text = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			info(elementName + " is visible");
			text = element.getText();
			info(text + " text is retrieved from the element " + elementName);
			return text;
		} catch (Exception e) {
			error("Failed to retrieve " + text + " text from the element " + elementName);
			return null;
		}
	}

	/**
	 * Description: :Compares text of the webelement
	 * 
	 * @author Manikandan
	 * @param actual
	 * @param expected
	 * @param color
	 */
	public synchronized void comparetText(String actual, String expected, String color) {
		try {
			Assert.assertEquals(actual, expected);
			info(actual + " is matching with " + expected);
			validationinfo(actual + " is matching with " + expected, color);
		} catch (Exception e) {
			error(actual + " is not  matching with " + expected);
			fail(actual + " is not  matching with " + expected);
			Assert.fail(actual + " is not  matching with " + expected);

		}
	}

	/**
	 * Description: :Retrieves text of the Web element
	 * 
	 * @author Manikandan
	 * @param element
	 */
	public synchronized String getTextusingJSWithXpath(WebElement element) {
		String entereddValue = null;
		try {
			poll(5000);
			entereddValue = (String) (jsExecutor.executeScript("return arguments[0].value", element));
			info("The value entered in element is" + entereddValue);
		} catch (Exception e) {
			error("Unable to entered value using JS with xpath");
			Assert.fail("Unable to entered value using JS with xpath");
		}
		return entereddValue;
	}

	/**
	 * Description: Get file Name
	 * 
	 * @author Manikandan
	 * @param fileFormat
	 * @return fileName
	 */
	public synchronized String getSampleFileName(String fileFormat) {
		String fileName = "Sample" + fileFormat.toUpperCase() + "." + fileFormat;
		return fileName;
	}

	/**
	 * Description: Method to return data for excel upload
	 * 
	 * @author Manikandan
	 * @param data
	 * @param format
	 */
	public synchronized Map<String, String> getData_FormatMap(String[] data, String[] format) {
		Map<String, String> mapDataAndFormat = new LinkedHashMap<String, String>();
		for (int i = 0; i < data.length; i++) {
			mapDataAndFormat.put(data[i], format[i]);
		}
		return mapDataAndFormat;
	}

	/**
	 * Description: Method to switch driver focus to New Tab/window
	 * 
	 * @author Manikandan
	 */
	public synchronized void switchToNewTab() {
		try {
			mainWindowID = driver.getWindowHandle();
			Set<String> allWindowID = driver.getWindowHandles();
			for (String id : allWindowID) {
				if (!id.equals(mainWindowID)) {
					driver.switchTo().window(id);
				}
			}
//
//			try {
//				waitForInvisibilityOfElement(driver.findElement(By.xpath("//iframe/following-sibling::div")), "Ad",
//						(long) 5);
//			} catch (Exception e) {
//			}
//			info("Switched to New Tab");
//			extentinfo("Switched to New Tab");

		} catch (Exception e) {
			error("Unable to switch to New Tab");
			fail("Unable to switch to New Tab");
			Assert.fail("Unable to switch to New Tab");
		}
	}

	/**
	 * 
	 * Description: Method to switch driver focus to Main Tab/window
	 * 
	 * @author Manikandan
	 */
	public synchronized void switchToMainTab() {
		try {
			driver.switchTo().window(mainWindowID);
			info("Switched to Main Tab");
			extentinfo("Switched to Main Tab");
		} catch (Exception e) {
			error("Unable to switch to Main Tab");
			fail("Unable to switch to Main Tab");
			Assert.fail("Unable to switch to Main Tab");
		}
	}

	/**
	 * Description: Method to select calendar date
	 * 
	 * @param elementId
	 * @param date
	 * @param elementName
	 * @author Ramya R
	 */
	public synchronized void select_CalendarDate(String elementId, String date, String elementName) {
		try {
			WebActionUtil.poll(1000);
			waitForElement(driver.findElement(By.id(elementId)), elementName);
			String script = "document.getElementById('" + elementId + "').value=" + "\"" + date + "\" ";
			jsExecutor.executeScript(script);
			info(date + " is selected");
		} catch (Exception e) {
			error("Unable to select " + date);
			Assert.fail("Unable to select " + date);
		}
	}

	/**
	 * Description: Click on the check box
	 * 
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 */
	public void clickCheckBox(WebElement element, String elementname) {

		wait.until(ExpectedConditions.visibilityOf(element));
		if (element.isSelected()) {
			info(elementname + " selected by default");
			extentinfo(elementname + " selected by default");
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			info(elementname + " is selected");
			extentinfo(elementname + " is selected");
		}
	}

	/**
	 * Description: To create the duration of the Test Run
	 * 
	 * @author Manikandan
	 * @param millis
	 */
	public static String formatDuration(long millis) {
		long seconds = (millis / 1000) % 60;
		long minutes = (millis / (1000 * 60)) % 60;
		long hours = millis / (1000 * 60 * 60);

		StringBuilder b = new StringBuilder();
		b.append(hours == 0 ? "00" : hours < 10 ? String.valueOf("0" + hours) : String.valueOf(hours));
		b.append(":");
		b.append(minutes == 0 ? "00" : minutes < 10 ? String.valueOf("0" + minutes) : String.valueOf(minutes));
		b.append(":");
		b.append(seconds == 0 ? "00" : seconds < 10 ? String.valueOf("0" + seconds) : String.valueOf(seconds));
		return b.toString();
	}

	/**
	 * Description: Mouse over on an element
	 * 
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 */
	public synchronized void actionMouseOver(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			action.moveToElement(element).build().perform();
			info("Able to mouse over on " + elementName);
			extentinfo("Able to mouse over on " + elementName);
		} catch (Exception e) {
			error("Unable to mouse over on " + elementName);
			fail("Unable to mouse over on " + elementName);
			Assert.fail("Unable to mouse over on " + elementName);
		}
	}

	/**
	 * Description: Method clicks on web element
	 *
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 */
	public synchronized void clickOnElement(WebElement element, String elementName) {
		if (isElementClickable(element, elementName)) {
			element.click();
			info("Clicked on " + elementName);
			extentinfo("Clicked on " + elementName);
		} else {
			error("Unable to click on " + elementName);
			fail("Unable to click on " + elementName);
			Assert.fail("Unable to click on " + elementName);
			// Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(element))==
			// null);
		}
	}

	/**
	 * Description: Click on the Element using JavaSCript
	 *
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 */
	public void clickOnElementUsingJS(WebElement element, String elementName) {
		try {
			if (isElementClickable(element, elementName)) {
				jsExecutor.executeScript("arguments[0].click();", element);
				info("Clicked on " + elementName);
				extentinfo("Clicked on " + elementName);
			}
		} catch (NoSuchElementException e) {
			error("Unable to click on " + elementName);
			fail("Unable to click on " + elementName);
			Assert.fail("Unable to click on " + elementName);
//	 Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)) == null);
		}
	}

	/**
	 * Description: Click on element using action class
	 * 
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 */
	public synchronized void actionClick(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			action.click(element).build().perform();
			info("Clicked on " + elementName);
			extentinfo("Clicked on " + elementName);
		} catch (Exception e) {
			error("Unable to click on " + elementName);
			fail("Unable to click on " + elementName);
			Assert.fail("Unable to click on " + elementName);
		}
	}

	/**
	 * Description: Click on the check box using JavaScript
	 * 
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 */
	public void clickCheckBoxUsingJS(WebElement element, String elementName) {
		try {
			if (element.isSelected()) {
				info(elementName + " selected by default");
				extentinfo(elementName + " selected by default");
			} else {
				jsExecutor.executeScript("arguments[0].click();", element);
				info(elementName + " is selected");
				extentinfo(elementName + " is selected");
			}
		} catch (NoSuchElementException e) {
			error("Unable to click on " + elementName);
			fail("Unable to click on " + elementName);
			Assert.fail("Unable to click on " + elementName);
		}
	}

	/**
	 * Description: Double Click On Element
	 * 
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 */
	public void doubleClickOnElement(WebElement element, String elementName) {
		try {
			action.doubleClick(element).perform();
			info("Double clicked on " + elementName);
			extentinfo("Double clicked on " + elementName);
		} catch (Exception e) {
			error("Unable to double click on " + elementName);
			fail("Unable to double click on " + elementName);
			Assert.fail("Unable to double click on " + elementName);
		}
	}

	/**
	 * Description: Method to press Enter key
	 * 
	 * @author Manikandan
	 */
	public synchronized void actionEnter() {
		try {
			action.sendKeys(Keys.ENTER).build().perform();
			info("Enter Key pressed");
			extentinfo("Enter Key  is pressed");
		} catch (Exception e) {
			error("Unable to press Enter Key");
			fail("Unable to press Enter Key");
			Assert.fail("Unable to press Enter Key");
		}
	}

	/**
	 * Description: :This method move the mouse from current position to given
	 * method
	 *
	 * @author Ramya R
	 * @param xOffset
	 * @param yOffset
	 */
	public void moveByOffset(int xOffset, int yOffset) {
		try {
			info("move mouse from current position to given method ");
			Actions action = new Actions(driver);
			action.moveByOffset(xOffset, yOffset).click().perform();
			pass("move mouse from current position to given method ");

		} catch (Exception e) {
			fail("Unable to move mouse from current position to given method ");
			Assert.fail("Unable to move mouse from current position to given method ");
		}
	}

	/**
	 * Description: Copy file from source directory to destination directory
	 * 
	 * @author Manikandan, Sushmita
	 * @param destinationPath
	 * @param imageName
	 */
	public static void copyFile(String destinationPath, String imageName) {
		String srcPath = System.getProperty("user.dir") + "./company_logo/" + imageName;
		File src = new File(srcPath);
		File destination = new File(destinationPath);
		try {
			FileUtils.copyFileToDirectory(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Description: Method to navigate to mentioned URL
	 * 
	 * @author Manikandan, Sushmita
	 * @param url
	 */
	public static void navigateToUrl(String url) {
		try {
			b.driver.navigate().to(url);
			waitForAngularPageToLoad();
			info("Navigated to " + url);
			validationinfo("Navigated to " + url, "blue");
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to naviagte to the URL " + url);
			Assert.fail("Unable to naviagte to the URL " + url);
		}
	}

	/**
	 * Description: Wait for the Frame is displayed with expected conditions and
	 * perform switch to frame action
	 * 
	 * @author Manikandan
	 * @param element
	 * @param elementName
	 */
	public synchronized void waitForiFrameAndPerformSwitchToFrameAction(WebElement element, String elementName) {
		try {
			info("Wait for " + elementName);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
			info("Switched to " + elementName);
		} catch (Exception e) {
			error(elementName + " is not visible");
			Assert.fail(elementName + " is not visible");
		}
	}

	/**
	 * Description: Method to perform switch to default frame action
	 * 
	 * @author Manikandan
	 */
	public synchronized void switchToDefaultFrame() {
		try {
			driver.switchTo().defaultContent();
			info("Switched to default frame");
		} catch (Exception e) {
			error("Unable to perform switch to default frame action");
			Assert.fail("Unable to perform switch to default frame action");
		}
	}

	/**
	 * Description: Method to clear text using JS
	 * 
	 * @author Sushmita P H
	 */
	public synchronized void clearTextUsingJS(WebElement element, String elementName) {
		try {
			jsExecutor.executeScript("arguments[0].value = '';", element);
			info("Cleared" + elementName);
		} catch (Exception e) {
			error("Unable to clear " + elementName);
			Assert.fail("Unable to clear " + elementName);
		}
	}

	/**
	 * Description: Method to type text using JS
	 * 
	 * @author Sushmita P H
	 */
	public synchronized void typeTextUsingJS(WebElement element, String value, String elementName) {
		try {
			jsExecutor.executeScript("arguments[0].value = '" + value + "';", element);
			info(value + "typed into " + elementName);
		} catch (Exception e) {
			error(value + "typed into " + elementName);
			Assert.fail(value + "typed into " + elementName);
		}
	}

	/**
	 * Description:: This Method is used to fetch the current Date and Time in
	 * defined format
	 * 
	 * @author Manikandan A, Ramya R
	 * @return systemCurrentDateandTime
	 */
	public synchronized String fetchCurrentDateandTime() {
		String systemCurrentDateandTime = null;
		try {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy | HH:mm");
			String strDate = formatter.format(date);
			systemCurrentDateandTime = strDate;
			info("Able to fetch the system Date and Time as " + systemCurrentDateandTime);
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to fetch Current Date and Time");
			Assert.fail("Unable to fetch Current Date and Time");
		}
		return systemCurrentDateandTime;
	}

	/**
	 * Description:: This Method is used to increase the give Time by one
	 * 
	 * @author Manikandan
	 * @param dateTime
	 * @return increasedDateTime
	 */
	public synchronized String increaseTimeByOne(String dateTime) {
		String increasedDateTime = null;
		try {
			String[] split = dateTime.split("\\|");
			DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
			LocalTime time = formatter.parseLocalTime(split[1].trim());
			time = time.plusMinutes(1);
			String print = formatter.print(time);
			increasedDateTime = split[0].trim() + " | " + print;

		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to increase Time by one");
			Assert.fail("Unable to increase Time by one");
		}
		return increasedDateTime;
	}

	/**
	 * Description:: This Method is used to perform navigate back action
	 * 
	 * @author Ramya R
	 */
	public static void navigateToBack() {
		try {
			b.driver.navigate().back();
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to navigate to Previous Page");
			Assert.fail("Unable to navigate to Previous Page");
		}
	}

	/**
	 * Description: Method to select option from Dropdown
	 * 
	 * @author Abhishek
	 * @param element
	 * @param option
	 */
	public synchronized void selectDropDownOptions(WebElement element, String elementName, String option) {
		int count = 0;
		String[] options = option.split("_");
		count = Integer.parseInt(options[1]);

		try {
			// Robot robot = new Robot();
			for (int i = 0; i < count; i++) {
				// robot.keyPress(KeyEvent.VK_DOWN);
				// actionUtil.poll(1000);
				// robot.keyRelease(KeyEvent.VK_DOWN);
				element.sendKeys(Keys.ARROW_DOWN);

			}
			// robot.keyPress(KeyEvent.VK_ENTER);
			// actionUtil.poll(1000);
			// robot.keyRelease(KeyEvent.VK_ENTER);
			element.sendKeys(Keys.ENTER);

		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to select " + options[0] + " option from " + elementName + " dropdown");
			Assert.fail("Unable to select " + options[0] + " option from " + elementName + " dropdown");
		}
	}

	/**
	 * Description: Method to fetch OTP from the data base
	 * 
	 * @author Abhishek,Manikandan
	 * @param mobileNumber
	 * @return otp
	 */
	public synchronized String getOtpFromDB(String mobileNumber) {
		String otp = null;
		try {
			poll(5000);
			String url = "jdbc:mysql:" + BaseTest.properties.getProperty("db_url") + ":"
					+ BaseTest.properties.getProperty("db_portNumber") + "/"
					+ BaseTest.properties.getProperty("databaseName");
			Connection connection = DriverManager.getConnection(url, BaseTest.properties.getProperty("db_UserName"),
					BaseTest.properties.getProperty("db_Password"));
			Statement statement = connection.createStatement();
			String query = "select otp_no from otp_tracking where mobile_no= '" + mobileNumber
					+ "' order by otp_tracking_id desc limit 1";
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				otp = result.getString(1);
			}
			connection.close();

		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to fetch OTP from the Database");
			Assert.fail("Unable to fetch OTP from the Database");
		}
		return otp;
	}

	/**
	 * Description: This Method is used to generate Random Mobile Number
	 *
	 * @author Manikandan A, Ramya R
	 * @return mobileNumber
	 */
	public synchronized String generateMobileNumber() {
		String mobileNumber = "";
		try {
			byte[] array = new byte[256];
			new Random().nextBytes(array);
			String randomString = new String(array, Charset.forName("UTF-8"));
			String numbers = randomString.replaceAll("[^0-9]", "");
			StringBuilder stringBuilder = new StringBuilder(10);
			for (int i = 0; i < 9; i++) {
				int index = (int) (numbers.length() * Math.random());
				StringBuilder number = stringBuilder.append(numbers.charAt(index));
				mobileNumber = number.toString();
			}
			info("Generated Mobile Number is " + mobileNumber);
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to generate Mobile Number");
			Assert.fail("Unable to generate Mobile Number");
		}
		return 9 + mobileNumber;
	}

	/**
	 * Description: Method to generate the random pancard number
	 * 
	 * @author Sushmita Piplodiya
	 * @return pancard
	 */
	public static String getRandomPanCardNumber() {
		String chars = "0123456789";
		StringBuilder sb = new StringBuilder();
		Random rnd = new Random();
		while (sb.length() < 4) {
			/* length of the random string */
			int index = (int) (rnd.nextFloat() * chars.length());
			sb.append(chars.charAt(index));
		}
		StringBuilder sb1 = new StringBuilder();
		sb1.append("DFMPA");
		sb1.append(sb);
		sb1.append("E");

		String panNumber = sb1.toString();
		return panNumber;
	}

	/**
	 * Description: This Method is used to generate Random Account number
	 *
	 * @author Sushmita
	 * @return accountNumber
	 */
	public synchronized String generateAccountNumber() {
		String accountNumber = "";
		try {
			byte[] array = new byte[256];
			new Random().nextBytes(array);
			String randomString = new String(array, Charset.forName("UTF-8"));
			String numbers = randomString.replaceAll("[^0-9]", "");
			StringBuilder stringBuilder = new StringBuilder(10);
			for (int i = 0; i < 12; i++) {
				int index = (int) (numbers.length() * Math.random());
				StringBuilder number = stringBuilder.append(numbers.charAt(index));
				accountNumber = number.toString();
			}
			info("Generated Account Number is " + accountNumber);
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to generate Mobile Number");
			Assert.fail("Unable to generate Mobile Number");
		}
		return accountNumber;
	}

	/**
	 * Description: This Method is used to generate Random User Name
	 *
	 * @author Manikandan A, Ramya R
	 * @return userName
	 */
	public synchronized String generateUserName() {
		String userName = null;
		try {
			String chars = "0123456789";
			StringBuilder sb = new StringBuilder();
			Random rnd = new Random();
			while (sb.length() < 4) {
				/* length of the random string */
				int index = (int) (rnd.nextFloat() * chars.length());
				sb.append(chars.charAt(index));
			}
			userName = sb.toString();
			info("Generated User Name is " + userName);
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to generate User Name");
			Assert.fail("Unable to generate User Name");
		}
		return "user01" + userName;
	}

	/**
	 * Description: Method to Wait for Invisibility Of all the Spinner's present in
	 * the Application.
	 * 
	 * @author Manikandan
	 * @param element
	 */
	public synchronized void waitForInvisibilityOfSpinner(List<WebElement> element) {
		try {
			int count = 0;
			driver.manage().timeouts().implicitlyWait(BaseTest.ITO, TimeUnit.SECONDS);
			while (element.size() > 0) {
				try {
					if (count == 2) {
						break;
					}
					count++;
					new WebDriverWait(driver, 4).until(ExpectedConditions.invisibilityOf(element.get(0)));
				} catch (Exception e) {
					info(e.getMessage());
				}
			}
			driver.manage().timeouts().implicitlyWait(BaseTest.pageLoadTimeout, TimeUnit.SECONDS);
		} catch (Exception e) {
			error(e.getMessage());
			fail("Spinner is still visible");
			Assert.fail("Spinner is still visible");
		}
	}

	/**
	 * Description: Method to generate random user data.
	 * 
	 * @author Ramya R , Sushmita
	 */
	public synchronized static Map<String, String> generateRandomUserData() {
		Map<String, String> userData = new HashMap<>();
		try {
			Faker faker = new Faker();
			String firstName = faker.name().firstName();
			firstName = firstName.replaceAll("[^a-zA-Z0-9]", "");
			String lastName = faker.name().lastName();
			lastName = lastName.replaceAll("[^a-zA-Z0-9]", "");
			String code = faker.code().ean8();
			String pinCode = code.substring(0, 6);
			String address = faker.address().cityName().replaceAll(" ", "").trim();
			String city = faker.address().cityName().replaceAll(" ", "").trim();

			info("Generating random user data");
			userData.put("firstName", firstName);
			userData.put("lastName", lastName);
			userData.put("pinCode", pinCode);
			userData.put("address", address);
			userData.put("city", city);
			info("Random user data is generated successfully");
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to Generate random user data");
			Assert.fail("Unable to Generate random user data");
		}
		return userData;
	}

	/**
	 * Description: This Method is used to decrease the give Time by one
	 * 
	 * @author Manikandan
	 * @param dateTime
	 * @return decreasedDateTime
	 */
	public synchronized String decreaseTimeByOne(String dateTime) {
		String decreasedDateTime = null;
		try {
			String[] split = dateTime.split("\\|");
			DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
			LocalTime time = formatter.parseLocalTime(split[1].trim());
			time = time.minusMinutes(1);
			String print = formatter.print(time);
			decreasedDateTime = split[0].trim() + " | " + print;

		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to decrease Time by one");
			Assert.fail("Unable to decrease Time by one");
		}
		return decreasedDateTime;
	}

	/**
	 * Description: Method to wait For Page To Load using javascript.
	 * 
	 * @author Sushmita P H
	 */
	public synchronized void waitForPageToLoad() {
		try {
			boolean load = jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			if (load)
				info("Page Loaded Successfully");
		} catch (Exception e) {
			error("Unable to Load the Page");
			Assert.fail("Unable to Load the Page");
		}
	}

	/**
	 * Description: Method to generate the random data for Website
	 * 
	 * @author Manikandan
	 * @return email
	 */
	public static String getRandomEmail() {
		String number = "0123456789";
		StringBuilder sb = new StringBuilder();

		Random random = new Random();

		while (sb.length() < 4) {
			int index = (int) (random.nextFloat() * number.length());
			sb.append(number.charAt(index));
		}
		StringBuilder sb1 = new StringBuilder();

		String[] name = { "larry", "barry", "garry", "willy", "gaurav", "sourav", "beast", "hulk", "sachin" };
		int rnd = new Random().nextInt(name.length);

		sb1.append(name[rnd]);
		sb1.append(sb);
		sb1.append("@gmail.com");

		String email = sb1.toString();
		return email;
	}

	/**
	 * Description: Method to send the E-Mail
	 * 
	 * @author Manikandan
	 * @param reportPath
	 */
	public static synchronized void sendEmail(String reportPath) {
		try {
			String maxSize = BaseTest.properties.getProperty("maxAttachmentSize");
			long expectedSize = Long.parseLong(maxSize);
			String[] recipientEmailTo = BaseTest.properties.getProperty("recipientEmailTo").split(",");
			String[] recipientEmailCc = BaseTest.properties.getProperty("recipientEmailCc").split(",");
			String msgBodyWithAttachment = BaseTest.properties.getProperty("msgBodyWithAttachment");
			String msgBodyWithoutAttachment = BaseTest.properties.getProperty("msgBodyWithoutAttachment");

			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(reportPath);
			attachment.setDisposition(EmailAttachment.ATTACHMENT);

			MultiPartEmail email = new MultiPartEmail();
			email.setHostName(BaseTest.properties.getProperty("setHostName"));
			String port = BaseTest.properties.getProperty("setPort");
			email.setSmtpPort(Integer.parseInt(port));
			email.setAuthenticator(new DefaultAuthenticator(BaseTest.properties.getProperty("setUserMail"),
					BaseTest.properties.getProperty("setUserPassword")));
			email.setSSLOnConnect(true);
			email.setFrom(BaseTest.properties.getProperty("setUserMail"));
			email.setSubject(BaseTest.properties.getProperty("setSubject") + BaseTest.currentDateAndTimeNewFormat);
			if (calculateFilesize(reportPath) <= expectedSize) {
				email.attach(attachment);
				email.setMsg(msgBodyWithAttachment);
			} else {
				email.setMsg(msgBodyWithoutAttachment);
			}
			email.addTo(recipientEmailTo);
			email.addCc(recipientEmailCc);
			email.send();
			info("E-Mail sent");
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to send the E-Mail");
			Assert.fail("Unable to send the E-mail");
		}
	}

	/**
	 * Description: Method to calculate the file size
	 * 
	 * @author Manikandan
	 * @param reportPath
	 */
	public static synchronized long calculateFilesize(String reportPath) {
		long size = 0;
		try {
			File fil1 = new File(reportPath);
			size = fil1.length() / 1024 / 1024;

		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to calculate the file size");
			Assert.fail("Unable to calculate the file size");
		}
		return size;
	}

	/**
	 * Description Method is used to Scroll down
	 * 
	 * @author Sajal
	 */
	public synchronized static void scrollDownByCoordinates() {
		try {
			jsExecutor.executeScript("window.scrollBy(0,750)");
			info("Scroll down");
		} catch (Exception e) {
			error("Scroll down failed");
		}
	}

	/**
	 * Description Method is used to Scroll down
	 * 
	 * @author Sajal
	 */
	public synchronized static void scrollDown() {
		try {
			jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			info("Scroll down");
		} catch (Exception e) {
			error("Scroll down failed");
		}
	}
	
	/*******10/04/23******/
	/**
	 * Description:Method is used to switch the control of window
	 * 
	 * @author Abhishek,Manjappa Kammar
	 */
	public static void switchToParentWindow() {
		try {
			String currentWindow = driver.getWindowHandle();
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it=windows.iterator();
			while (it.hasNext()) {
				String child_window=it.next();

				if(!(currentWindow.equals(child_window))) 
				{
					try {
						driver.switchTo().window(child_window);
						info("Able to switch the control of window");
				
					} catch (Exception e) {
						error(e.getMessage());
						Assert.fail("Unable to switch the control of window");
						
					}
				}
			}
		} catch (Exception e) {
			error(e.getMessage());
			Assert.fail("Unable to switch the control of window");
		}
	}
}
