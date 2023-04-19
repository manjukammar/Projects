package com.tyss.abp.article.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Article_008
 * TestScript Name: TYSS_Article_008
 * Description: Verify whether user is able to view the tags in article page
 * 
 * Author: Manjappa 
 */
public class TYSS_Article_008 extends BaseTest {

	@Test(description = "Verify whether user is able to view the tags in article page")
	public void TC_TYSS_Article_008() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Any Article */
		pages.homePage.clkonArticlelnk();
				
		/* Validate Tags */
		pages.articlePage.validateTags();
	}
}
