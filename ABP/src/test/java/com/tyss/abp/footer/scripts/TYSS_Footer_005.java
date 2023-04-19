package com.tyss.abp.footer.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Footer_005
 * TestScript Name: TYSS_Footer_005
 * Description: Verify the functionality of SITE MAP link.
 * 
 * Author: Sreelatha
 */
public class TYSS_Footer_005 extends BaseTest {

	@Test(description = "Verify the functionality of SITE MAP link")
	public void TC_TYSS_Footer_005() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Sitemap footer */
		pages.footerPage.clkFooterLink(prop_constants.getProperty("footer_SiteMap"));
		
		/* Validate Sitemap page is displayed */
		pages.footerPage.validateFooterPage(prop_constants.getProperty("siteMap"));
	
	
	}
}
