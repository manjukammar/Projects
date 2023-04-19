package com.tyss.abp.game.scripts;

import org.testng.annotations.Test;

import com.tyss.abp.baseutil.BaseTest;

/*
 * TestCaseId: Game_001
 * TestScript Name: TYSS_Game_001
 * Description: Verify whether user can click on game widget user is redirected to the game page on a New Tab
 * 
 * Author: Ramya R
 */
public class TYSS_Game_001 extends BaseTest {

	@Test(description = "Verify whether user can click on game widget user is redirected to the game page on a New Tab")
	public void TC_TYSS_TBD_001() {

		/* Validate Home Page */
		pages.homePage.validateHomePage();

		/* Click on Games link */
		pages.homePage.clkOnHeader(prop_constants.getProperty("homemenu_games"));

		/* Validate the Game page */
		pages.homePage.validatePage(prop_constants.getProperty("validate_Games"));

	}
}
