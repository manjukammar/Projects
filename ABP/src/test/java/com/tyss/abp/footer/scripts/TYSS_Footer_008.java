package com.tyss.abp.footer.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Footer_008
 * TestScript Name: TYSS_Footer_008
 * Description: Verify the functionality of PRIVACY POLICY link.
 * 
 * Author: Sreelatha
 */
public class TYSS_Footer_008 extends BaseTest {

	@Test(description = "Verify the functionality of PRIVACY POLICY link")
	public void TC_TYSS_Footer_008() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Privacy Policy footer */
		pages.footerPage.clkFooterLink(prop_constants.getProperty("footer_PrivacyPolicy"));
		
		/* Validate Privacy Policy Page is displayed */
		pages.footerPage.validateFooterPage(prop_constants.getProperty("privacyPolicy"));
	
	
	}
}
