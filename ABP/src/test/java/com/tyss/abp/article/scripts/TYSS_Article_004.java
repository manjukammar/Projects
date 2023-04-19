package com.tyss.abp.article.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Article_004
 * TestScript Name: TYSS_Article_004
 * Description: Verify if the user is able to share the article via Whatsapp
 * 
 * Author: Manjappa 
 */
public class TYSS_Article_004 extends BaseTest {

	@Test( description = "Verify if the user is able to share the article via Whatsapp")
	public void TC_TYSS_Article_004() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Click on Any Article */
		pages.homePage.clkonArticlelnk();
				
		/* Validate User is able to share the article link over Whatsapp by tapping on Whatsapp icon*/
		pages.articlePage.clkonWhatsappIcon(prop_constants.getProperty("whatsaapIcon"));
	}
}
