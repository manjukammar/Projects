package com.tyss.abp.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.tyss.abp.baseutil.BaseTest;
/**
 * Description : Creates the HTML report based on the name specified.
 * @author Manikandan,Ramya R
 * 
 */
public class ExtentReport {
	private static ExtentTest extentTtest;
	private static ExtentReports extentReports;

	/**
	 * Description : Creates the HTML report based on the name specified
	 * @author Manikandan,Ramya R
	 * 
	 */
	public static ExtentTest createTest(String name) {

		extentTtest = extentReports.createTest(name);
		return extentTtest;
	}

	public static ExtentReports getExtent() {
		return extentReports;
	}
	/**
	 * Description : Initializes report specified in the file path
	 * @author Manikandan,Ramya R
	 * 
	 */
	public void initReport(String filepath) {
		extentReports = new Extent().getExtent(filepath);
//		BaseTest.getLogger().info("Report Initiated");
	}

}
