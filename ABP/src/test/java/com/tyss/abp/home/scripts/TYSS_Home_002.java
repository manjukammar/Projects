package com.tyss.abp.home.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Home_002
 * TestScript Name: TYSS_Home_002
 * Description: Verify whether user is able to view the banner ad on the top of the home page
 * 
 * Author: Sreelatha
 */
public class TYSS_Home_002 extends BaseTest {

	@Test(description = "Verify whether user is able to view the banner ad on the top of the home page")
	public void TC_TYSS_Home_002() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Validate Ad in Home Page */
		pages.homePage.validateAd();
	
	}
}
