package com.tyss.abp.photos.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Photos_010
 * TestScript Name: TYSS_Photos_010
 * Description: Verify when user click Entertainment category able to navigate to Entertainment page  
 *
 * Author: Sanjay
 */
public class TYSS_Photos_010 extends BaseTest {

	@Test(description = "Verify when user click Entertainment category able to navigate to Entertainment page ")
	public void TC_TYSS_Photos_010() {

		/* Validate Home page */
		pages.homePage.validateHomePage();

		/* Mouse-over on Others drop-down */
		pages.homePage.moveCursorOnOthers();

		/* Select Photos from Others drop-down */
		pages.homePage.sltOthersTab(prop_constants.getProperty("textPhotos"));

		/* Click on Entertainment category */
		pages.photoGalleryPage.clkOnCategoryUnderPhotoGalleryPage(prop_constants.getProperty("category_Entertainment"));

		/* Validate Entertainment page */
		pages.photoGalleryPage.validateCategoryPage(prop_constants.getProperty("category_Entertainment_Page"));

	}
}
