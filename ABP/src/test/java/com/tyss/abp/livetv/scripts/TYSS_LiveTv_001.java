package com.tyss.abp.livetv.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:LiveTv_001
 * TestScript Name: TYSS_LiveTv_001
 * Description:Verify whether user is able to navigate to Live TV page when they click on Live TV button on Top navigation bar.
 * 
 * Author: Shivananda T S
 */
public class TYSS_LiveTv_001 extends BaseTest {
	@Test(description = "Verify whether user is able to navigate to Live TV page when they click on Live TV button on Top navigation bar")
	public void TC_TYSS_LiveTv_001() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on live tv link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_tv"));

		/* validate User should be able to navigate to live tv page and watch live video */
		pages.liveTvPage.validateLiveTvPage();
	}
}