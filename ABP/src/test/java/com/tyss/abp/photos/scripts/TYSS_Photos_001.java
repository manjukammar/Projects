package com.tyss.abp.photos.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Photos_001
 * TestScript Name: TYSS_Photos_001
 * Description: Verify when user click Photos category able to navigate to Photos page
 * 
 * Author: Sanjay
 */
public class TYSS_Photos_001 extends BaseTest {

	@Test(description = "Verify when user click Photos category able to navigate to Photos page")
	public void TC_TYSS_Photos_001() {
		
		/* Validate Home page */
		pages.homePage.validateHomePage();
		
		/* Mouse-over on Others drop-down */
		pages.homePage.moveCursorOnOthers();
		
		/* Select Photos from Others drop-down */
		pages.homePage.sltOthersTab(prop_constants.getProperty("textPhotos"));
		
		/* Validate Photos page */
		pages.photoGalleryPage.validatePhotoGalleryPage();
	
	}
}
