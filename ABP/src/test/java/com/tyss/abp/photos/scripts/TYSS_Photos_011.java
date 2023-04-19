package com.tyss.abp.photos.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Photos_011
 * TestScript Name: TYSS_Photos_011
 * Description: Verify when user click Sports category able to navigate to Sports page  
 *
 * Author: Sanjay
 */
public class TYSS_Photos_011 extends BaseTest {

	@Test(description = "Verify when user click Sports category able to navigate to Sports page ")
	public void TC_TYSS_Photos_011() {

		/* Validate Home page */
		pages.homePage.validateHomePage();

		/* Mouse-over on Others drop-down */
		pages.homePage.moveCursorOnOthers();

		/* Select Photos from Others drop-down */
		pages.homePage.sltOthersTab(prop_constants.getProperty("textPhotos"));

		/* Click on Sports category */
		pages.photoGalleryPage.clkOnCategoryUnderPhotoGalleryPage(prop_constants.getProperty("category_Sports"));

		/* Validate Sports page */
		pages.photoGalleryPage.validateCategoryPage(prop_constants.getProperty("category_Sports_Page"));

	}
}
