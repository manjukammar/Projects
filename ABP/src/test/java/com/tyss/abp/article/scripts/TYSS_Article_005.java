package com.tyss.abp.article.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Article_005
 * TestScript Name: TYSS_Article_005
 * Description: Verify whether user is able to view You May Like category in article page
 * 
 * Author: Manjappa 
 */
public class TYSS_Article_005 extends BaseTest {

	@Test(description = "Verify whether user is able to view You May Like category in article page")
	public void TC_TYSS_Article_005() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Any Article */
		pages.homePage.clkonArticlelnk();
				
		/* Validate You May like section */
		pages.articlePage.validateYouMayLikeSection();
	}
}
