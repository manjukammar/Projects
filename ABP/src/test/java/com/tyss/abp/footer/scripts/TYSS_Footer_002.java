package com.tyss.abp.footer.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Footer_002
 * TestScript Name: TYSS_Footer_002
 * Description: Verify the functionality of CAREERS link.
 * 
 * Author: Sreelatha
 */
public class TYSS_Footer_002 extends BaseTest {

	@Test(description = "Verify the functionality of CAREERS link")
	public void TC_TYSS_Footer_002() {
		
		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Careers footer */
		pages.footerPage.clkFooterLink(prop_constants.getProperty("footer_Careers"));
		
		/* Validate Careers Page is displayed */
		pages.footerPage.validateCareersPage();
	
	
	}
}
