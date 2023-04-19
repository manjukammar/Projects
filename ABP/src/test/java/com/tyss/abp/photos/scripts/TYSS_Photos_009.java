package com.tyss.abp.photos.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Photos_009
 * TestScript Name: TYSS_Photos_009
 * Description: Verify when user click News category able to navigate to News page  
 *
 * Author: Sanjay
 */
public class TYSS_Photos_009 extends BaseTest {

	@Test(description = "Verify when user click News category able to navigate to News page")
	public void TC_TYSS_Photos_009() {

		/* Validate Home page */
		pages.homePage.validateHomePage();

		/* Mouse-over on Others drop-down */
		pages.homePage.moveCursorOnOthers();

		/* Select Photos from Others drop-down */
		pages.homePage.sltOthersTab(prop_constants.getProperty("textPhotos"));

		/* Click on news category */
		pages.photoGalleryPage.clkOnCategoryUnderPhotoGalleryPage(prop_constants.getProperty("category_News"));

		/* Validate News page */
		pages.photoGalleryPage.validateCategoryPage(prop_constants.getProperty("category_News_Page"));

	}
}
