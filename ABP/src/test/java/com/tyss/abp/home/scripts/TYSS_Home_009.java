package com.tyss.abp.home.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Home_009
 * TestScript Name: TYSS_Home_009
 * Description: Verify whether user is able to select language from the select language dropdrown.
 * 
 * Author: Sreelatha
 */
public class TYSS_Home_009 extends BaseTest {
	
@Test(description = "Verify whether user is able to select language from the select language dropdrown")

	public void TC_TYSS_Home_009() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Select Language from Select Language drop down */
		pages.homePage.setLanguage();

		/* Validate Selected Language is displayed */
		pages.homePage.validateLanguage("होम");

	}
}
