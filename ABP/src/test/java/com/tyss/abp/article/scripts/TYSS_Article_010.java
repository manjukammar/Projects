package com.tyss.abp.article.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Article_010
 * TestScript Name: TYSS_Article_010
 * Description: Verify whether user is able to view For You  in article page 
 * 
 * Author: Manjappa 
 */
public class TYSS_Article_010 extends BaseTest {

	@Test(description = "Verify whether user is able to view For You  in article page")
	public void TC_TYSS_Article_010() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Any Article */
		pages.homePage.clkonArticlelnk();
		
		/* Validate For you section is displayed */
		pages.articlePage.validateForYouSection();
	}
}
