package com.tyss.abp.livetv.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:LiveTv_009
 * TestScript Name: TYSS_LiveTv_009
 * Description:Verify whether user is able to view the footer.
 * 
 * Author: Shivananda T S
 */
public class TYSS_LiveTv_009 extends BaseTest {
	@Test(description = "Verify whether user is able to view the footer")
	public void TC_TYSS_LiveTv_009() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on live tv link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_tv"));

		/* Click on view all option under Sports category */
		pages.homePage.clickOnViewAll(prop_constants.getProperty("sports_sectionType"));

		/*click on footer*/
		pages.liveTvPage.clickOnFooter();
		
		/*validate User should able to see and navigate to the respective page when clicked*/
		pages.liveTvPage.validateFooterPage();

		

	}
}