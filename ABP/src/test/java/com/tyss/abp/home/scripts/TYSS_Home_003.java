package com.tyss.abp.home.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Home_003
 * TestScript Name: TYSS_Home_003
 * Description: Verify whether user is able to view the categories section and click and check on all the categories in home page
 * 
 * Author: Sreelatha
 */
public class TYSS_Home_003 extends BaseTest {
	@Test(description = "Verify whether user is able to view the categories section and click and check on all the categories in home page")
	public void TC_TYSS_Home_003() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click and Validate Categories in home page */
		pages.homePage.clickAndValidateCategories();
	}
}
