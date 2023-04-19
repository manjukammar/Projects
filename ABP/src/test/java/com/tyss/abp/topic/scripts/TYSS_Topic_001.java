package com.tyss.abp.topic.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Topic_001
 * TestScript Name: TYSS_Topic_001
 * Description: Verify user is able to search topics in the alphabetical order
 * 
 * Author: Sreelatha
 */
public class TYSS_Topic_001 extends BaseTest {

	@Test(description = "Verify user is able to search topics in the alphabetical order")
	public void TC_TYSS_Topic_001() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Navigate to Topic page */
		pages.homePage.navigateTo();
		
		/* Validate Topic Page */
		pages.homePage.validateTopicPage();
	
		/* Click on Alphabets */
		pages.homePage.clickOnAlphabetLink();
		
		/* Validate Searched Alphabet is displayed */
		pages.homePage.validateSearchedAlphabet();
		
	}
}
