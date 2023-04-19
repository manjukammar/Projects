package com.tyss.abp.footer.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Footer_004
 * TestScript Name: TYSS_Footer_004
 * Description: Verify the functionality of ADVERTISE WITH US link.
 * 
 * Author: Sreelatha
 */
public class TYSS_Footer_004 extends BaseTest {
	@Test(description = "Verify the functionality of ADVERTISE WITH US link")
	public void TC_TYSS_Footer_004() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Advertise with us footer */
		pages.footerPage.clkFooterLink(prop_constants.getProperty("footer_AdvertiseWithUs"));
		
		/* Validate Advertise with us Page is displayed */
		pages.footerPage.validateFooterPage(prop_constants.getProperty("advertiseWithUs"));
	
	
	}
}
