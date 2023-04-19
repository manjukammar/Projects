package com.tyss.abp.livetv.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:LiveTv_002
 * TestScript Name: TYSS_LiveTv_002
 * Description:Verify whether user scrolls the home page and click on Live TV view all button.
 * 
 * Author: Shivananda T S
 */
public class TYSS_LiveTv_002 extends BaseTest {
	@Test(description = "Verify whether user scrolls the home page and click on Live TV view all button")
	public void TC_TYSS_LiveTv_002() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Live TV view all buttons */
		pages.homePage.clickOnViewAll(prop_constants.getProperty("liveTv_ViewAll"));

		/* validate User should be be able to click on view all button and navigating to Live TV page */
		pages.liveTvPage.validateLiveTvPage();
	}
}