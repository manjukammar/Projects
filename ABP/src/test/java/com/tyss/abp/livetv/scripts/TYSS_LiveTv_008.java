package com.tyss.abp.livetv.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: TYSS_LiveTv_008
 * TestScript Name: TYSS_LiveTv_008
 * Description: Verify whether user is able to click on the TV shows on live tv page.
 *
 * Author: Sanjay
 */
public class TYSS_LiveTv_008 extends BaseTest {

	@Test(description = "Verify whether user is able to click on the TV shows on live tv page")
	public void TC_TYSS_LiveTv_008() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on live tv link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_tv"));
		
		/*  Click on view all options under TV shows */
		pages.liveTvPage.clickOnViewAll(prop_constants.getProperty("tv_shows_sectionType"));
		
		/* Click on any tv show */
		pages.liveTvPage.clickOnTopTvShowDisplayed();
		
		/* Validate user should be able to navigate to tv-shows page */	
		pages.liveTvPage.validateHeader(prop_constants.getProperty("txtTv_show"));
		

		

	}
}
