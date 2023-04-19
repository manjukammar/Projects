package com.tyss.abp.article.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Article_011
 * TestScript Name: TYSS_Article_011
 * Description:Verify whether user can see taboola feeds when they scroll down the page 
 * 
 * Author: Manjappa 
 */
public class TYSS_Article_011 extends BaseTest {

	@Test(description = "Verify whether user can see taboola feeds when they scroll down the page")
	public void TC_TYSS_Article_011() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Any Article */
		pages.homePage.clkonArticlelnk();
		
		/* Validate Taboolalogo */
		pages.articlePage.scrollAndValidateTaboolaLogo();
	}
}
