package com.tyss.abp.cricket.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Cricket_006
 * TestScript Name: TYSS_Cricket_006
 * Description:Verify when user click any one article it should navigate to respective page.
 * 
 * Author: Shivananda T S
 */
public class TYSS_Cricket_006 extends BaseTest {
	@Test(description = "Verify when user click any one article it should navigate to respective page")
	public void TC_TYSS_Cricket_006() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* move cursor on Others */
		pages.homePage.moveCursorOnOthers();

		/* click on Cricket Category */
		pages.cricketPage.clkOnCricketCategory(prop_constants.getProperty("linkCricket"));

		/* click on article */
		pages.cricketPage.clkOnArticle();

		/* validate User should able to view article page */
		pages.cricketPage.validateArticlePage();

	}
}