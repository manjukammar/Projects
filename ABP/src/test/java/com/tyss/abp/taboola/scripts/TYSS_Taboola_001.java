package com.tyss.abp.taboola.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Taboola_001
 * TestScript Name: TYSS_Taboola_001
 * Description: Verify whether when the user scrolls down in the home page, taboola feed should be seen.
 * 
 * Author:Sreelatha
 */
public class TYSS_Taboola_001 extends BaseTest {

	@Test(description = "Verify whether when the user scrolls down in the home page, taboola feed should be seen")
	public void TC_TYSS_Taboola_001() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Validate Taboola Feed logo is dispalyed */
		pages.homePage.scrollAndValidateTaboolaLogo();
	
	
	}
}
