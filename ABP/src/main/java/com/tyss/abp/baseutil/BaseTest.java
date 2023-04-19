package com.tyss.abp.baseutil;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.mysql.cj.jdbc.Driver;
import com.tyss.abp.commonutils.FileOperation;
import com.tyss.abp.reports.ExtentManager;
import com.tyss.abp.reports.ExtentReport;
import com.tyss.abp.util.WebActionUtil;

/***********************************************************************
 * Description: Implements Application Precondition and Postcondition.
 * 
 * @BeforeSuite Creates all the folder structure for Extent Reports
 * @BeforeClass Launches the browser according to the browser name specified
 * @BeforeTest Download current web driver executables as specified in the
 *             parameter
 * @BeforeMethod Creates nodes for the test methods in Extent report
 * @AfterClass Closes the browser after completion of execution
 * @AfterSuite Kills the driver (example chromedriver.exe) according to browser
 *             specified
 */
public class BaseTest {
	public WebDriver driver;
	public static Driver driverDB;
	public static final int ITO = 6;
	public static final int ITO_High = 10;
	public static final int ETO = 60;
	public static final int pageLoadTimeout = 15;
	public static Logger logger = LoggerFactory.getLogger(BaseTest.class);
	public static WebActionUtil actionUtil;
	public String testCaseName;
	public static String className;
	public static Properties properties;
	public static Properties prop_constants;
	public static String sDirPath = System.getProperty("user.dir");
	public static final String driverPath = sDirPath + "/drivers";
	public static final String TESTDATAEXCELPATH = sDirPath + "/src/main/resources/TestData/_Data.xlsx";
	public static final String CONFIGPATH = sDirPath + "/src/main/resources/EnvironmentVariables/config.properties";
	public static final String VALIDATIONCONSTANTS = sDirPath
			+ "/src/main/resources/TestData/Validation_Constants.properties";
	public static String currentDateAndTime;
	public static String currentDateAndTimeNewFormat;
	public static InitializePages pages;

	static {
		try {
			properties = new Properties();
			prop_constants = new Properties();
			FileInputStream fis = new FileInputStream(CONFIGPATH);
			properties.load(fis);
			FileInputStream fis1 = new FileInputStream(VALIDATIONCONSTANTS);
			prop_constants.load(fis1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Description: Creates folder structure for Extent reports and Establishing
	 * 
	 * @author: Manikandan A
	 */
	@BeforeSuite(alwaysRun = true)
	public synchronized void createFiles() {
		try {

			WebActionUtil.info("Folder creation for Extent");
			FileOperation fileOperation = new FileOperation();
			fileOperation.CreateFiles();

		} catch (Exception e) {
			WebActionUtil.info("Exception while report inititation");
		}
	}

	/**
	 * Description: Download current web driver executables as specified in the
	 * parameter
	 * 
	 * @author: Manikandan A
	 * @param browserName
	 */
	@Parameters({ "browserName" })
	@BeforeTest(alwaysRun = true)
	public synchronized void downloadDriverExecutables(String browserName) {

		CreateDriver.getInstance().setupWebDriver(browserName);

	}

	/**
	 * Description: Launches the browser as specified in the parameter
	 * 
	 * @author Manikandan A
	 * @param browserName
	 */
	@Parameters("browserName")
	@BeforeClass
	public synchronized void launchApp(String browserName) {

		className = getClass().getSimpleName();
		logger = LoggerFactory.getLogger(getClass().getName());
		ExtentTest parentExtentTest = ExtentReport.createTest(getClass().getSimpleName());
		ExtentManager.setParentReport(parentExtentTest);
	}

	/**
	 * Description: Creates nodes for the test methods in Extent report.
	 * 
	 * @author Manikandan A
	 * @param browserName
	 * @param methodName
	 */

	@Parameters("browserName")
	@BeforeMethod
	public synchronized void setExtentReport(String browserName, Method methodName) {

		CreateDriver.getInstance().setDriver(browserName);
		driver = CreateDriver.getInstance().getDriver();
		driver.manage().timeouts().implicitlyWait(pageLoadTimeout, TimeUnit.SECONDS);
		actionUtil = new WebActionUtil(CreateDriver.getInstance().getDriver(), ETO);
		pages = new InitializePages(driver, ETO, actionUtil);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(properties.getProperty("App_URL"));
		logger = LoggerFactory.getLogger(getClass().getName());

//		try {
//			actionUtil.waitForInvisibilityOfElement(driver.findElement(By.xpath("//iframe/following-sibling::div")),
//					"Ad", (long) 5);
//		} catch (Exception e) {
//		}

		this.testCaseName = methodName.getName();
		String description = methodName.getAnnotation(Test.class).description();
		ExtentTest testReport = ExtentManager.getParentReport().createNode(testCaseName, "Description: " + description);
		ExtentManager.setTestReport(testReport);

		if (driver.getWindowHandles().size() > 0) {
			actionUtil.validationinfo(browserName.toUpperCase() + " Browser is launched", "blue");
			actionUtil.info(browserName.toUpperCase() + " Browser is launched");
		} else {
			actionUtil.fail("Failed to launch the Browser");
			actionUtil.error("Failed to launch the Browser");
		}
	}

	/**
	 * Description: Closes the driver
	 * 
	 * @author Manikandan A
	 */
	@AfterMethod(alwaysRun = true)
	public synchronized void closeBrowser() {
		try {
			CreateDriver.cleanDriver();
		} catch (Exception e) {

		}
	}

	/**
	 * Description: Kills the driver in Task Manager as specified in the parameter
	 * and sending E-mail.
	 * 
	 * @author Manikandan A
	 * @param browserName
	 * @throws EmailException
	 */
	@AfterSuite(alwaysRun = true)
	@Parameters("browserName")
	public synchronized void killTask(String browserName) throws EmailException {

		CreateDriver.killBrowserTask(browserName);

	}

}