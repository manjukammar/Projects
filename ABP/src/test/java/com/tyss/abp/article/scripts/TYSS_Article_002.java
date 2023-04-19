package com.tyss.abp.article.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Article_002
 * TestScript Name: TYSS_Article_002
 * Description: Verify if the user is able to share the article via facebook
 * 
 * Author: Manjappa 
 */
public class TYSS_Article_002 extends BaseTest {

	@Test(description = "Verify if the user is able to share the article via facebook")
	public void TC_TYSS_Article_002() {
		
		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Any Article */
		pages.homePage.clkonArticlelnk();
				
		/* Validate User is able to share the article link over face book by tapping on FB icon*/
		pages.articlePage.clkonFacebookIcon(prop_constants.getProperty("facebookIcon"));
	}
}
