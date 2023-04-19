package com.tyss.abp.livetv.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:LiveTv_004
 * TestScript Name: TYSS_LiveTv_004
 * Description:Verify whether user is able to view and click the For you on live tv page.
 * 
 * Author: Shivananda T S
 */
public class TYSS_LiveTv_004 extends BaseTest {
	@Test(description = "Verify whether user is able to view and click the For you on live tv page")
	public void TC_TYSS_LiveTv_004() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on live tv link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_tv"));

		/* Click on view all option under For you */
		pages.liveTvPage.clickOnAnyForYouCardDisplayed();

		/* validate User should be able to view the For you */
		pages.liveTvPage.validateTitle(prop_constants.getProperty("for_you_sectionType"));

	}
}