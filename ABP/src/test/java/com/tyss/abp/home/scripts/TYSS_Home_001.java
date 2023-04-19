package com.tyss.abp.home.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Home_001
 * TestScript Name: TYSS_Home_001
 * Description: Verify whether user is able to view the Home page on entering the URL
 * 
 * Author: Sreelatha
 */
public class TYSS_Home_001 extends BaseTest {
	
	@Test(description = "Verify whether user is able to view the Home page on entering the URL")
	public void TC_TYSS_Home_001() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
	
	
	}
}
