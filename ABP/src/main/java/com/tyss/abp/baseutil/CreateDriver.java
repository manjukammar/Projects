package com.tyss.abp.baseutil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import com.tyss.abp.util.WebActionUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

/***********************************************************************
 * Description : This class has method implementation for creating browser
 * instance killing browser instance, download latest browser driver version.
 * set browser driver capabilities.
 * 
 * @author sajal jain , vikas kc
 */
public class CreateDriver {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	private static CreateDriver instance = null;
	private CreateDriver() {	
	}
	
	public static CreateDriver getInstance() {
		if (instance == null) {
			instance =new CreateDriver();
		}
		return instance;
	} 
	public void  setDriver(String browserName) {

//		if (driver.get() == null) {
//			try {
				driver.set(createDriver(browserName));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}

//		return driver.get();
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void cleanDriver() {

		driver.get().quit();
		driver.remove();

	}
	
	/**
	 * Description: Sets the web driver according to the Browser
	 * 
	 * @author Sajal,vikas
	 * @param browserName
	 */
	public static WebDriver createDriver(String browserName) {
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", BaseTest.sDirPath + "/drivers/chromedriver.exe");
				String userPath = System.getProperty("user.home") + "/AppData/Local/Google/Chrome/UserData";
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("safebrowsing.enabled", "true");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-notifications");
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				chromeOptions.merge(capabilities);
				chromeOptions.addArguments("user-data-dir=" + userPath);
				chromeOptions.setExperimentalOption("prefs", prefs);
				return new ChromeDriver(capabilities);
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", BaseTest.sDirPath + "/drivers/geckodriver.exe");
				return new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.edge.driver", BaseTest.sDirPath + "/drivers/msedgedriver.exe");
				return new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("Opera")) {
				System.setProperty("webdriver.opera.driver", BaseTest.sDirPath + "/drivers/operadriver.exe");
				// String PROXY = "77.111.246.20";
				// String opera_profile =
				// System.getProperty("user.home")+"\\Users\\Dell\\Downloads" ;
				OperaOptions operaOptions = new OperaOptions();
				// operaOptions.addArguments("user-data-dir", "~/Library/Application
				// Support/com.operasoftware.Opera");
				// operaOptions.addArguments("user-data-dir",opera_profile);
				// operaOptions.addArguments("--proxy-server=%s", "%"+ PROXY);
				// new OperaDriver(operaOptions)
				return new OperaDriver();
			} else if (browserName.equalsIgnoreCase("safari")) {
				return new SafariDriver();
			}
		
		return null;
	}

	/**
	 * Description: Sets the web driver according to the Browser
	 * 
	 * @author Sajal,vikas
	 * @param browserName
	 */
	public WebDriver setWebDriver(String browserName) {
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", BaseTest.sDirPath + "/drivers/chromedriver.exe");
				String userPath = System.getProperty("user.home") + "/AppData/Local/Google/Chrome/UserData";
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("safebrowsing.enabled", "true");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-notifications");
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				chromeOptions.merge(capabilities);
				chromeOptions.addArguments("user-data-dir=" + userPath);
				chromeOptions.setExperimentalOption("prefs", prefs);
				return new ChromeDriver(capabilities);
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", BaseTest.sDirPath + "/drivers/geckodriver.exe");
				return new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.edge.driver", BaseTest.sDirPath + "/drivers/msedgedriver.exe");
				return new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("Opera")) {
				System.setProperty("webdriver.opera.driver", BaseTest.sDirPath + "/drivers/operadriver.exe");
				// String PROXY = "77.111.246.20";
				// String opera_profile =
				// System.getProperty("user.home")+"\\Users\\Dell\\Downloads" ;
				OperaOptions operaOptions = new OperaOptions();
				// operaOptions.addArguments("user-data-dir", "~/Library/Application
				// Support/com.operasoftware.Opera");
				// operaOptions.addArguments("user-data-dir",opera_profile);
				// operaOptions.addArguments("--proxy-server=%s", "%"+ PROXY);
				// new OperaDriver(operaOptions)
				return new OperaDriver();
			} else if (browserName.equalsIgnoreCase("safari")) {
				return new SafariDriver();
			}
		
		return null;
	}

	/**
	 * Description: Download the driver executable files and save it in the drivers
	 * folder
	 * 
	 * @author Manikandan A
	 * @param browserName
	 */
	public static void setupWebDriver(String browserName) {
		try {
			killBrowserTask(browserName);
			if (browserName.equalsIgnoreCase("chrome")) {
//				WebDriverManager.chromedriver().forceDownload().cachePath(BaseTest.driverPath).avoidOutputTree()
//						.setup();
				WebDriverManager.chromedriver().avoidOutputTree()
				.setup();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().cachePath(BaseTest.driverPath).avoidOutputTree().setup();
			} else if (browserName.equalsIgnoreCase("safari")) {
			} else {
				WebActionUtil.error("Unable to download " + browserName + " driver executable");
			}
		} catch (Exception e) {
			WebActionUtil.error("Unable to download " + browserName + " driver executable");
		}

	}

	/**
	 * Description Kills the driver in Task Manager as specified in the parameter
	 * 
	 * @author Sajal, Vikas
	 * @param browserName
	 */
	public static void killBrowserTask(String browserName) {
		try {
			
				if (browserName.equalsIgnoreCase("chrome")) {
					Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
				} else if (browserName.equalsIgnoreCase("firefox")) {
					Runtime.getRuntime().exec("taskkill /IM firefox.exe /F");
				} else if (browserName.equalsIgnoreCase("edge")) {
					Runtime.getRuntime().exec("taskkill /F /IM MicrosoftEdgeCP.exe");
				} else {
					WebActionUtil.error("Browser name not specified properly to kill the task");
				}
			
		} catch (IOException e) {
			WebActionUtil.error("Unable to kill the " + browserName + " browser task");
		}
	}

}
