package com.tyss.abp.article.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Article_001
 * TestScript Name: TYSS_Article_001
 * Description:Verify when user click on any article in home page
 * 
 * Author: Manjappa 
 */
public class TYSS_Article_001 extends BaseTest {

	@Test(description = "Verify when user click on any article in home page")
	public void TC_TYSS_Article_001() {
		
		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Any Article */
		pages.homePage.clkonArticlelnk();
		
		/* Validate Article consumption page */
		pages.articlePage.validateArticleConsumptionPage();
	}
}
