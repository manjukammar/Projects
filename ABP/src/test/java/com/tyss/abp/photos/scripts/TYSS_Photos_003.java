package com.tyss.abp.photos.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Photos_003
 * TestScript Name: TYSS_Photos_003
 * Description: Verify whether user is able to view Top Galleries in Photos page of Top Galleries section 
 * 
 * Author: Sanjay
 */
public class TYSS_Photos_003 extends BaseTest {

	@Test(description = "Verify whether user is able to view Top Galleries in Photos page of Top Galleries section")
	public void TC_TYSS_Photos_003() {

		/* Validate Home page */
		pages.homePage.validateHomePage();

		/* Mouse-over on Others drop-down */
		pages.homePage.moveCursorOnOthers();

		/* Select Photos from Others drop-down */
		pages.homePage.sltOthersTab(prop_constants.getProperty("textPhotos"));

		/* Validate Top Galleries section */
		pages.photoGalleryPage.validateTopGalleriesText();

	}
}
