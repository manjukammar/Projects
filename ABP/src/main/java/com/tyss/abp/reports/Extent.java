package com.tyss.abp.reports;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tyss.abp.commonutils.FileVariables;
import com.tyss.abp.util.WebActionUtil;

/**
 * Description: Implements the creation of the Extent Html report with specified
 * name after loading the Extent config file from specified location.
 * 
 * @author Manikandan,Ramya R
 */
public class Extent {

	public static ThreadLocal<ExtentReports> driver = new ThreadLocal<>();
	private ExtentReports extent;
	FileVariables fileVariables = new FileVariables();

	/**
	 * Description: Creates of HTML report in specified path
	 * 
	 * @author Manikandan,Ramya R
	 */
	public ExtentReports getExtent(String filepath) {
		if (extent == null) {
			try {
				extent = new ExtentReports();
				extent.attachReporter(getHtmlReporter(filepath + "/AutomationReport.html"));
				return extent;
			} catch (Exception e) {
				WebActionUtil.info("Exception while creating report html file.");
			}
		}
		return extent;
	}
	private static ExtentTest extentTtest;
	private static ExtentReports extentReports;
	/**
	 * Description : Creates the HTML report based on the name specified
	 * 
	 * @author Sajal
	 * @param name
	 */
	public static ExtentTest createTest(String name) {

		extentTtest = extentReports.createTest(name);
		return extentTtest;
	}

	/**
	 * Description: Loads the Extent-config file specified from the location
	 * 
	 * @author Manikandan,Ramya R
	 */
	private static ExtentHtmlReporter getHtmlReporter(String filePath) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/config/extent-config.xml");
		return htmlReporter;
	}

}
