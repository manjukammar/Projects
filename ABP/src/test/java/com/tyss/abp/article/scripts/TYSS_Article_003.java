package com.tyss.abp.article.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Article_003
 * TestScript Name: TYSS_Article_003
 * Description: Verify if the user is able to share the article via Twitter
 * 
 * Author: Manjappa 
 */
public class TYSS_Article_003 extends BaseTest {

	@Test( description = "Verify if the user is able to share the article via Twitter")
	public void TC_TYSS_Article_003() {
		
		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Any Article */
		pages.homePage.clkonArticlelnk();
			
		/* Validate User is able to share the article link over Twitter by tapping on Twitter icon*/
		pages.articlePage.clkonTwitterIcon(prop_constants.getProperty("twitterIcon"));
	}
}
