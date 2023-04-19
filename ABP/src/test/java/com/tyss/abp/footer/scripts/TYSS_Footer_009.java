package com.tyss.abp.footer.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Footer_009
 * TestScript Name: TYSS_Footer_009
 * Description: Verify the functionality of DNPA CODE OF ETHICS link.
 * 
 * Author: Sreelatha
 */
public class TYSS_Footer_009 extends BaseTest {

	@Test(description = "Verify the functionality of DNPA CODE OF ETHICS link")
	public void TC_TYSS_Footer_009() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on DNPA Code of Ethics footer */
		pages.footerPage.clkFooterLink(prop_constants.getProperty("footer_DNPA_CodeofEthics"));
		
		/* Validate Code of Ethics Page is displayed */
		pages.footerPage.validateFooterPage(prop_constants.getProperty("codeOfEthics"));
	
	
	}
}
