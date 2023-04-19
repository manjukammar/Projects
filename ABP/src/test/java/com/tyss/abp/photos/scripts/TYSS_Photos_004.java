package com.tyss.abp.photos.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Photos_004
 * TestScript Name: TYSS_Photos_004
 * Description: Verify whether user is able to view News section in Photos page of Top Galleries section 
 * 
 * Author: Sanjay
 */
public class TYSS_Photos_004 extends BaseTest {

	@Test(description = "Verify whether user is able to view News section in Photos page of Top Galleries section ")
	public void TC_TYSS_Photos_004() {

		/* Validate Home page */
		pages.homePage.validateHomePage();

		/* Mouse-over on Others drop-down */
		pages.homePage.moveCursorOnOthers();

		/* Select Photos from Others drop-down */
		pages.homePage.sltOthersTab(prop_constants.getProperty("textPhotos"));

		/* Validate News section */
		pages.photoGalleryPage.validateSectionUnderPhotoGallerySection(prop_constants.getProperty("section_News"));

	}
}
