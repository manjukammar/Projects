package com.tyss.abp.search.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Search_001
 * TestScript Name: TYSS_Search_001
 * Description: Verify whether user is able to search the necessary data/topic/keyword in the search bar.
 * 
 * Author: Sreelatha
 */
public class TYSS_Search_001 extends BaseTest {

	@Test(description = "Verify whether user is able to search the necessary data/topic/keyword in the search bar")
	public void TC_TYSS_Search_001() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Search and validate any data in home page*/
		pages.homePage.setSearch(prop_constants.getProperty("ipl"));
		
	
	
	}
}
