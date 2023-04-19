package com.tyss.abp.footer.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Footer_003
 * TestScript Name: TYSS_Footer_003
 * Description: Verify the functionality of FEEDBACK link.
 * 
 * Author: Sreelatha
 */
public class TYSS_Footer_003 extends BaseTest {

	@Test(description = "Verify the functionality of FEEDBACK link")
	public void TC_TYSS_Footer_003() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Feedback footer */
		pages.footerPage.clkFooterLink(prop_constants.getProperty("footer_Feedback"));
		
		/* Validate Feedback Page is displayed */
		pages.footerPage.validateFooterPage(prop_constants.getProperty("feedBack"));
	
	
	}
}
