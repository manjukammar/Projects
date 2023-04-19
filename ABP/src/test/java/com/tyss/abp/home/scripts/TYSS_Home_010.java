package com.tyss.abp.home.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Home_010
 * TestScript Name: TYSS_Home_010
 * Description: Verify whether user is able to search the necessary data in the search bar.
 * 
 * Author: Manjappa 
 */
public class TYSS_Home_010 extends BaseTest {

	@Test(description = "Verify whether user is able to search the necessary data in the search bar.")
	public void TC_TYSS_Home_010() {
		
		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Search icon */
		pages.homePage.setSearch(prop_constants.getProperty("linkCricket"));
		
	}
}
