package com.tyss.abp.home.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Home_011
 * TestScript Name: TYSS_Home_011
 * Description: Verify whether user is able to click on any random article and it is navigating to particular page
 * Author: Manjappa 
 */
public class TYSS_Home_011 extends BaseTest {

	@Test(description = "Verify whether user is able to click on any random article and it is navigating to particular page")
	public void TC_TYSS_Home_011() {
		
		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Any Article */
		pages.homePage.clkonArticlelnk();
		
		/* Validate Article consumption page */
		pages.homePage.validateArticleConsumptionPage();
		
	}
}
