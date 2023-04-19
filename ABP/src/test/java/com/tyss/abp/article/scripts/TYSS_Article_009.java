package com.tyss.abp.article.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Article_009
 * TestScript Name: TYSS_Article_009
 * Description: Verify if  user click on tag links, user is able to navigate to respective topic page 
 * 
 * Author: Manjappa 
 */
public class TYSS_Article_009 extends BaseTest {

	@Test(description = "Verify if  user click on tag links, user is able to navigate to respective topic page ")
	public void TC_TYSS_Article_009() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Any Article */
		pages.homePage.clkonArticlelnk();
		
		/* Click on Tag */
		pages.articlePage.clkOnTag();
		
		/* Validate Respective tag topic is displayed */
		pages.articlePage.validateTag();
	}
}
