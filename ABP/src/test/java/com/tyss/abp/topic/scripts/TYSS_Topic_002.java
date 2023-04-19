package com.tyss.abp.topic.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId:Topic_002
 * TestScript Name: TYSS_Topic_002
 * Description: Verify if alphabet "A" is selected as default in alphabetical search for Topics
 * 
 * Author: Sreelatha
 */
public class TYSS_Topic_002 extends BaseTest {

	@Test(description = "Verify if alphabet 'A' is selected as default in alphabetical search for Topics")
	public void TC_TYSS_Topic_002() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();
		
		/* Navigate to Topic page */
		pages.homePage.navigateTo();
		
		/* Validate Topic Page */
		pages.homePage.validateTopicPage();
		
		/* Validate A is selected by default */
		pages.homePage.validateASelectedByDefault();
		
	
	
	}
}
