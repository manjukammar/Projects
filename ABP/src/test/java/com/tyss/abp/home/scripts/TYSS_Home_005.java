package com.tyss.abp.home.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Home_005
 * TestScript Name: TYSS_Home_005
 * Description: Verify whether user is able to click on video widget on home page.
 * 
 * Author: Sreelatha
 */
public class TYSS_Home_005 extends BaseTest {

	@Test(description = "Verify whether user is able to click on video widget on home page")
	public void TC_TYSS_Home_005() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Video Widget */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_videos"));
	   
		/* Validate Video Page */
		pages.videosPage.validateVideoPage();
	}
}
