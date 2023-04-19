package com.tyss.abp.photos.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Photos_002
 * TestScript Name: TYSS_Photos_002
 * Description: Verify when user click any one photo it should navigate to respective page
 * 
 * Author: Sanjay
 */
public class TYSS_Photos_002 extends BaseTest {

	@Test(description = "Verify when user click any one photo it should navigate to respective page")
	public void TC_TYSS_Photos_002() {

		/* Validate Home page */
		pages.homePage.validateHomePage();

		/* Mouse-over on Others drop-down */
		pages.homePage.moveCursorOnOthers();

		/* Select Photos from Others drop-down */
		pages.homePage.sltOthersTab(prop_constants.getProperty("textPhotos"));

		/* Validate Photos page */
		pages.photoGalleryPage.validatePhotoGalleryPage();

		/* Click on first photo */	
		pages.photoGalleryPage.clkOnPhotoUnderGallerySection();

		/* Validate on first photo title */	
		pages.photoGalleryPage.validateFirstPhoto();
	}
}
