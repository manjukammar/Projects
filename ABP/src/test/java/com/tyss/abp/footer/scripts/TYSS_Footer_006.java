package com.tyss.abp.footer.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Footer_006
 * TestScript Name: TYSS_Footer_006
 * Description: Verify the functionality of DISCLAIMER link.
 * 
 * Author: Sreelatha
 */
public class TYSS_Footer_006 extends BaseTest {

	@Test(description = "Verify the functionality of DISCLAIMER link")
	public void TC_TYSS_Footer_006() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Disclaimer footer */
		pages.footerPage.clkFooterLink(prop_constants.getProperty("footer_Disclaimer"));
		
		/* Validate Disclaimer Page is displayed */
		pages.footerPage.validateFooterPage(prop_constants.getProperty("disclaimer"));
	
	
	}
}
