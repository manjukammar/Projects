package com.tyss.abp.home.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Home_012
 * TestScript Name: TYSS_Home_012
 * Description: Verfiy whether when the user scrolls down in the home page ,taboola feed should be seen.
 * Author: Manjappa 
 */
public class TYSS_Home_012 extends BaseTest {

	@Test(description = "Verfiy whether when the user scrolls down in the home page ,taboola feed should be seen.")
	public void TC_TYSS_Home_012() {
		
		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Validate Taboola logo */
		pages.homePage.scrollAndValidateTaboolaLogo();
		
	}
}
