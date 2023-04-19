package com.tyss.abp.topic.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Topic_003
 * TestScript Name: TYSS_Topic_003
 * Description: Verify user is able to navigate to respective page by clicking any one alphabet character icon and click any one topic 
 * 
 * Author: Sreelatha
 */
public class TYSS_Topic_003 extends BaseTest {

	@Test(description = "Verify user is able to navigate to respective page by clicking any one alphabet character icon and click any one topic")
	public void TC_TYSS_Topic_003() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Navigate to Topic page */
		pages.homePage.navigateTo();
		
		/* Validate Topic Page */
		pages.homePage.validateTopicPage();
		
		/* Click on Alphabets */
		pages.homePage.clickOnAlphabetLink();
		
		/* Validate Searched Alphabet page is displayed */
		pages.homePage.validateSearchedAlphabetPage();
		
		
	
	
	}
}
