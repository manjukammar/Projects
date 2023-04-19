package com.tyss.abp.footer.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Footer_007
 * TestScript Name: TYSS_Footer_007
 * Description: Verify the functionality of CONTACT US link.
 * 
 * Author: Sreelatha
 */
public class TYSS_Footer_007 extends BaseTest {

	@Test(description = "Verify the functionality of CONTACT US link")
	public void TC_TYSS_Footer_007() {
		
		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Contact Us footer */
		pages.footerPage.clkFooterLink(prop_constants.getProperty("footer_ContactUs"));
		
		/* Validate Contact Us Page is displayed */
		pages.footerPage.validateContactUsPage();
	
	
	}
}
