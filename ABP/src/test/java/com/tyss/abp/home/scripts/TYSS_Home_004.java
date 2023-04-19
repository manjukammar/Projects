package com.tyss.abp.home.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Home_004
 * TestScript Name: TYSS_Home_004
 * Description: Verify whether user is able to click on all social media icons in home page
 * 
 * Author: Sreelatha
 */
public class TYSS_Home_004 extends BaseTest {

	@Test(description = "Verify whether user is able to click on all social media icons in home page")
	public void TC_TYSS_Home_004() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on any Social Media icon */
		pages.homePage.clkOnShareIcn(prop_constants.getProperty("share_youtube"));
		
	
	}
}
