package com.tyss.abp.article.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;
public class Tyss_Article_Demo extends BaseTest{

	@Test(description = "Verify when user click on any article in home page")
	public void TC_TYSS_Article_001() {
	
	/* Validate Home Page */
	pages.homePage.validateHomePage();
	
	/* Click on Any Article */
	pages.homePage.clkonArticlelnk();
	
	/* Validate Article consumption page */
	pages.articlePage.validateArticleConsumptionPage();
	
	/* Validate User is able to share the article link over face book by tapping on FB icon*/
	pages.articlePage.clkonFacebookIcon(prop_constants.getProperty("facebookIcon"));
	
	/* Validate User is able to share the article link over Twitter by tapping on Twitter icon*/
	pages.articlePage.clkonTwitterIcon(prop_constants.getProperty("twitterIcon"));
	
	/* Validate User is able to share the article link over Whatsapp by tapping on Whatsapp icon*/
	pages.articlePage.clkonWhatsappIcon(prop_constants.getProperty("whatsaapIcon"));
	
	/* Validate You May like section */
	pages.articlePage.validateYouMayLikeSection();
	
	/* Validate Related story section */
	pages.articlePage.validateRelatedStorySection();
	
	/* Validate Top story section */
	pages.articlePage.validateTopStorySection();
	
	/* Validate Tags */
	pages.articlePage.validateTags();
	
	/* Click on Tag */
	pages.articlePage.clkOnTag();
	
	/* Validate Respective tag topic is displayed */
	pages.articlePage.validateTag();
	
	/* Validate For you section is displayed */
	pages.articlePage.validateForYouSection();
	
	/* Validate Taboolalogo */
	pages.articlePage.scrollAndValidateTaboolaLogo();	
	
	}
}
