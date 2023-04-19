package com.tyss.abp.livetvshows.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: LiveTv_Shows_001
 * TestScript Name: TYSS_LiveTv_Shows_001
 * Description: Verify whether user is able to Scroll Right or Left on the TV shows widget on live tv page.
 * 
 * Author: Manjappa 
 */
public class TYSS_LiveTv_Shows_001 extends BaseTest {

	@Test(description = "Verify whether user is able to Scroll Right or Left on the TV shows widget on live tv page.")
	public void TC_TYSS_LiveTv_Shows_001() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on live TV link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_tv"));
		
	}
}
