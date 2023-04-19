package com.tyss.spotify.listener;

import java.io.IOException;
import java.util.ArrayList;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.commonutils.FileOperation;
import com.tyss.spotify.commonutils.FileVariables;
import com.tyss.spotify.extentreports.ExtentManager;
import com.tyss.spotify.extentreports.ExtentReport;
import com.tyss.spotify.utils.ApiActionUtil;

/**
 * Description: This class implements ITestListener and overrides methods like
 * onStart, onFinish, onTestFailure,onTestSkipped,onTestSuccess which are used
 * in Extent report and Emailable report.
 * 
 * @author vikas, sajal
 * 
 */
public class TestListeners implements ITestListener {

	public static String[] sDataGuest = null;
	public static ExtentHtmlReporter sparkReport;
	public static ExtentReports extent;
	public static ExtentTest test;
	int count = 1;
	public static String sExcelDate;
	public static String sExcelPath;
	public static String screenShotPath;
	public static int iPassCount = 0;
	public static int iFailCount = 0;
	public static int iSkippedCount = 0;
	public static int iTotal_Executed;
	public static String sStartTime;
	public static String sEndTime;
	public static long lTotalExecutionTime;
	public static ArrayList<String> sStatus = new ArrayList<String>();
	public static ArrayList<String> sStartMethodTime = new ArrayList<String>();
	public static ArrayList<String> sMethodEndTime = new ArrayList<String>();
	public static ExtentTest parentTest;
	public static ExtentTest childTest;

	public static long startTime;
	public static long endtTime;
	String className;
	public static String current_className;
	int parentCount = 0;

	/**
	 * Description : Create Directories for Extent Reports, Excel Report and
	 * Screenshots based on system time
	 * 
	 * @author: vikas, sajal
	 * @param context
	 */
	public void onStart(ITestContext context) {
		
	}

	/**
	 * Description : Creates node for Extent reports and initializes logger for log.
	 * 
	 * @author: vikas, sajal
	 * @param result
	 */
	public void onTestStart(ITestResult result) {

	}
	/**
	 * Description:Increases the pass count and adds the pass result in Extent
	 * report
	 * 
	 * @author vikas, sajal
	 * @param result
	 * 
	 */
	public void onTestSuccess(ITestResult result) {
		iPassCount = iPassCount + 1;
		ExtentManager.getTestReport().log(Status.PASS, result.getMethod().getMethodName() + "-Test case passed");

	}

	/**
	 * Description:Increases the fail count and adds the fail result in Extent
	 * report
	 * 
	 * @author vikas, sajal
	 * @param result
	 * 
	 */
	public void onTestFailure(ITestResult result) {
		iFailCount = iFailCount + 1;
		ExtentManager.getTestReport().log(Status.FAIL, result.getMethod().getMethodName() + "-Test case failed");	
	}

	/**
	 * Description :Increases the skip count and adds the skip result in Extent
	 * report.
	 * 
	 * @author vikas, sajal
	 * @param result
	 * 
	 */
	public void onTestSkipped(ITestResult result) {
		iSkippedCount = iSkippedCount + 1;
		ExtentManager.getTestReport().log(Status.SKIP, result.getMethod().getMethodName() + "-Test case skipped");
	}

	/**
	 * Description :Flushes the Extent report and sends an email of the report.
	 * 
	 * @author vikas, sajal
	 * @paran context
	 * 
	 */
	public void onFinish(ITestContext context) {
		ExtentReport.getExtent().flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
	

}