package com.tyss.abp.footer.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Footer_001
 * TestScript Name: TYSS_Footer_001
 * Description: Verify the functionality of  ABOUT US link.
 * 
 * Author: Sreelatha
 */
public class TYSS_Footer_001 extends BaseTest {
	@Test(description = "Verify the functionality of  ABOUT US link")
	public void TC_TYSS_Footer_001() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on About Us footer */
		pages.footerPage.clkFooterLink(prop_constants.getProperty("footer_AboutUs"));
		
		/* Validate About Us Page is displayed */
		pages.footerPage.validateAboutUsPage();
	
	
	}
}
