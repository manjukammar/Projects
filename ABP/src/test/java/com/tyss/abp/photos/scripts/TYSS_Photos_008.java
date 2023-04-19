package com.tyss.abp.photos.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Photos_008
 * TestScript Name: TYSS_Photos_008
 * Description: Verify whether user can see Taboola Feeds when they scroll down the page
 *
 * Author: Sanjay
 */
public class TYSS_Photos_008 extends BaseTest {

	@Test(description = "Verify whether user can see Taboola Feeds when they scroll down the page")
	public void TC_TYSS_Photos_008() {

		/* Validate Home page */
		pages.homePage.validateHomePage();

		/* Mouse-over on Others drop-down */
		pages.homePage.moveCursorOnOthers();

		/* Select Photos from Others drop-down */
		pages.homePage.sltOthersTab(prop_constants.getProperty("textPhotos"));

		/* Validate Taboola feeds */
		pages.photoGalleryPage.scrollAndValidateTaboolaLogo();

	}
}
