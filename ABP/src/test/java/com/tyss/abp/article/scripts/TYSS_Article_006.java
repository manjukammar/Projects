package com.tyss.abp.article.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Article_006
 * TestScript Name: TYSS_Article_006
 * Description: Verify whether user is able to view Related Stories in article page
 * 
 * Author: Manjappa 
 */
public class TYSS_Article_006 extends BaseTest {

	@Test(description = "Verify whether user is able to view Related Stories in article page")
	public void TC_TYSS_Article_006() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Any Article */
		pages.homePage.clkonArticlelnk();
				
		/* Validate Related story section */
		pages.articlePage.validateRelatedStorySection();
	}
}
