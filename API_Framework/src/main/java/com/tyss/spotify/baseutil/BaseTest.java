package com.tyss.spotify.baseutil;

import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import com.aventstack.extentreports.ExtentTest;
import com.tyss.spotify.authorizations.ReneweToken;
import com.tyss.spotify.commonutils.ExcelUtil;
import com.tyss.spotify.commonutils.FileOperation;
import com.tyss.spotify.extentreports.ExtentManager;
import com.tyss.spotify.extentreports.ExtentReport;
import com.tyss.spotify.utils.ApiActionUtil;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;

import io.restassured.specification.RequestSpecification;

/***********************************************************************
 * Description : Implements Application Precondition and Postcondition.
 * 
 * @BeforeSuite: Creates all the folder structure for Extent Reports
 */

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;
	public static Properties prop_constants;
	public static long maxResponseTime = 2000L;
	public static String sDirPath = System.getProperty("user.dir");
	public static Logger logger = LoggerFactory.getLogger(BaseTest.class);
	public static final String EXCELPATH = sDirPath + "./src/main/resources/data/Data.xlsx";
	public static final String JSONFILEPATH = sDirPath + "./src/main/resources/TestData/JsonFilePath.properties";
	public static ApiActionUtil actionUtil;
	public String testCaseName;
	public static String className;
	public static Properties properties;
	public static final String CONFIGPATHEN = sDirPath + "./src/main/resources/EnvironmentVariables/config.properties";
	public static final String VALIDATIONCONSTANTS = sDirPath
			+ "./src/main/resources/TestData/Validation_Constants.properties";
	public static RequestSpecBuilder requestSpecBuilder;
	public static RequestSpecification requestSpecification;
	public static String baseUrl = "";
	public static String sheetName = "Spotify_Data";
	public static int rowNumber = 1;
	public static int columnNumber = 1;
	public static Properties jsonFilePath;
	public static String accessToken;

	static {
		try {
			prop_constants = new Properties();
			properties = new Properties();
			
			FileInputStream fis = new FileInputStream(CONFIGPATHEN);
			properties.load(fis);
			FileInputStream fis1 = new FileInputStream(VALIDATIONCONSTANTS);
			prop_constants.load(fis1);
			jsonFilePath = new Properties();
			FileInputStream fis2 = new FileInputStream(JSONFILEPATH);
			jsonFilePath.load(fis2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Description : Creates folder structure for Extent reports.
	 * 
	 * @author:
	 */
	@BeforeSuite(alwaysRun = true)
	public synchronized void createFiles() {
		try {
			logger.info("Folder creation for Extent");
			FileOperation fileOperation = new FileOperation();
			fileOperation.CreateFiles();
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception while report inititation");
		}

	}

	/**
	 * Description: Launches the browser as specified in the parameter
	 * 
	 * @author Manjappa
	 */
	@BeforeClass(alwaysRun = true)
	public synchronized void launchApp() {
		try {

			className = getClass().getSimpleName();
			logger = LoggerFactory.getLogger(getClass().getName());
			ExtentTest parentExtentTest = ExtentReport.createTest(getClass().getSimpleName());
			ExtentManager.setParentReport(parentExtentTest);

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Able to set Report");
		}
	}

	/**
	 * Description: Creates nodes for the test methods in Extent report.
	 * 
	 * @author:Manjappa
	 * @param: methodName
	 */
	@BeforeMethod(alwaysRun = true)
	public synchronized void setExtentReport(Method methodName) {
		this.testCaseName = methodName.getName();
		String description = methodName.getAnnotation(Test.class).description();
		try {
			String baseUrl = "https://api.spotify.com/v1";
			requestSpecBuilder = new RequestSpecBuilder().setBaseUri(baseUrl);
			ExtentTest testReport = ExtentManager.getParentReport().createNode(testCaseName, description);
			ExtentManager.setTestReport(testReport);
			ReneweToken.getToken();
			accessToken=ApiActionUtil.readDataFromJson();
		} catch (Exception e) {
			e.printStackTrace();
			ApiActionUtil.fail(e.getMessage());
			ApiActionUtil.error("Failed to set Extent Report");

		}
	}

}