package com.tyss.abp.home.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Home_013
 * TestScript Name: TYSS_Home_013
 * Description: Verify whether user is able to see and click the footer.
 * Author: Manjappa 
 */
public class TYSS_Home_013 extends BaseTest {

	@Test(description = "Verify whether user is able to see and click the footer")
	public void TC_TYSS_Home_013() {
		
		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on footer */
		pages.homePage.clkFooterLink(prop_constants.getProperty("footer_AboutUs"));
		
	}
}
