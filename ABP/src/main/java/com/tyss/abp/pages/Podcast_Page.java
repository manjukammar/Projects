package com.tyss.abp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.abp.baseutil.BaseTest;
import com.tyss.abp.util.WebActionUtil;

/**
 * Description This class has the implementations for Podcast page.
 * 
 * @author Bredlin & Abhishek
 * 
 */
public class Podcast_Page {
	public WebDriver driver;
	public WebActionUtil actionUtil;
	public long ETO;

	public Podcast_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* Volume slider */
	@FindBy(id = "volumeSliderDark")
	private WebElement sldrVolume;

	/* Twitter icon */
	@FindBy(xpath = "//a[@class='share-icon tw']")
	private WebElement icnTwitter;

	/* Whatsapp icon */
	@FindBy(xpath = "//a[@class='share-icon wa']")
	private WebElement icnWhatsapp;

	/* Podcast title text */
	@FindBy(xpath = "//a[@class='podcast_title_link media-info-anchor']/child::h3")
	private WebElement txtPodcastTitle;

	/* Skip to previous podcast button */
	@FindBy(xpath = "//button[@class='btn btn-prev']")
	private WebElement btnSkipToPreviousPodcast;

	/* Skip to next podcast button */
	@FindBy(xpath = "//button[@class='btn btn-next']")
	private WebElement btnSkipToNextPodcast;

	/* Pause button */
	@FindBy(xpath = "//span[@class='ap-icon audio-pause']")
	private WebElement btnPause;

	/* Play button */
	@FindBy(xpath = "//button[@class='btn btn-play-pause']//span[@class='ap-icon audio-play_arrow']")
	private WebElement btnPlay;

	/* Podcast titles link */
	private WebElement lnkTitles(String lnkOption) {
		String xpath = "//h2[contains(text(),'" + lnkOption + "')]";
		return driver.findElement(By.xpath(xpath));
	}

	/* Podcast titles text */
	private WebElement txtTitles(String txtOption) {
		String xpath = "//h1[contains(text(),'" + txtOption + "')]";
		return driver.findElement(By.xpath(xpath));
	}

	/* View All button */
	private WebElement btnViewAll(String txtTitle) {
		String xpath = "//h2[contains(text(),'" + txtTitle
				+ "')]/ancestor::div/descendant::a[contains(text(),'View All')]";
		return driver.findElement(By.xpath(xpath));
	}

	/* Facebook icon */
	@FindBy(xpath = "//span[@class='abp-icon abpi-facebook']")
	private WebElement icnFacebook;

	/* Facebook text */
	@FindBy(id = "homelink")
	private WebElement txtFacebook;

	/* Right Arrow icon */
	private WebElement icnRightArrow(String txtTitle) {
		String xpath = "//h2[text()='" + txtTitle
				+ "']/ancestor::div//a[@class='uk-position-center-right-out uk-position-small uk-hidden-hover uk-small-navigation uk-icon uk-slidenav-next uk-slidenav']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Pause or play button */
	@FindBy(xpath = "//button[@class='btn btn-play-pause']/span")
	private WebElement btnPauseOrPlay;

	/* Mute or unmute button */
	@FindBy(xpath = "//button[@class='btn btn-mute']/span")
	private WebElement btnMuteOrUnmute;

	/**
	 * Description: Method used to click on twitter icon and validate twitter login
	 * page is displayed
	 * 
	 * @author Abhishek
	 */
	public synchronized void clkOnTwitterIconAndValidateTwitterLoginPage() {
		try {
			actionUtil.clickOnElementUsingJS(icnTwitter, "Twitter icon");
			actionUtil.switchToNewTab();
			WebActionUtil.poll(7000);
			String currentUrl = driver.getCurrentUrl();
			Assert.assertTrue(currentUrl.contains(BaseTest.prop_constants.getProperty("twitter_Url")));
			WebActionUtil.info("Twitter login page is displayed");
			WebActionUtil.validationinfo("Twitter login page is displayed", "blue");
			actionUtil.switchToMainTab();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Twitter login page");
			Assert.fail("Unable to validate Twitter login page");
		}
	}

	/**
	 * Description: Method used to click on Whatsapp icon and validate whatsapp web
	 * page is displayed
	 * 
	 * @author Abhishek
	 */
	public synchronized void clkOnWhatsappIconAndValidateWhatsappWebPage() {
		try {
			actionUtil.clickOnElement(icnWhatsapp, "Whatsapp icon");
			WebActionUtil.poll(3000);
			actionUtil.switchToNewTab();			
			String currentUrl = driver.getCurrentUrl();
			Assert.assertTrue(currentUrl.contains(BaseTest.prop_constants.getProperty("whatsapp_Url")));
			WebActionUtil.info("Whatsapp web page is displayed");
			WebActionUtil.validationinfo("Whatsapp web page is displayed", "blue");
			actionUtil.switchToMainTab();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Whatsapp web page");
			Assert.fail("Unable to validate Whatsapp web page");
		}
	}

	/**
	 * Description: Method used to modify the volume
	 * 
	 * @author Abhishek
	 * @param noOfTimes
	 */
	public synchronized void modifyTheVolume(String noOfTimes) {
		try {
			actionUtil.poll(10000);
			int count = Integer.parseInt(noOfTimes);
			Actions action = new Actions(driver);
			action.click(sldrVolume).build().perform();
			for (int i = 0; i < count; i++) {
				action.sendKeys(Keys.ARROW_RIGHT).build().perform();
			}
			WebActionUtil.validationinfo("Slider is moved to the right", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to modify the volume");
			Assert.fail("Unable to modify the volume");
		}
	}

	/**
	 * Description:Method to validate Pause button
	 * 
	 * @author Bredlin
	 * 
	 */
	public synchronized void validatePauseBtn() {
		try {

			actionUtil.validateisElementDisplayed(btnPause, "Pause button", "Pause button is displayed",
					"Pause button is not displayed", "blue");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Pause button");
			Assert.fail("Unable to validate Pause button");
		}
	}

	/**
	 * Description:Method to click on View All under the particular title
	 * 
	 * @author Bredlin
	 * @param title
	 */
	public synchronized void clkOnViewAllBtn(String title) {
		try {
			if (btnViewAll(title).isDisplayed()) {
				actionUtil.clickCheckBoxUsingJS(btnViewAll(title), "View All button");
				WebActionUtil.validationinfo("Clicked on View All button under " + title, "blue");
			} else {
				actionUtil.scrollToElement(btnViewAll(title), "View All button");
				actionUtil.clickCheckBoxUsingJS(btnViewAll(title), "View All button");
				WebActionUtil.validationinfo("Clicked on View All button under " + title, "blue");
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on View All button");
			Assert.fail("Unable to click on View All button");
		}
	}

	/**
	 * Description:Method to click on the particular title
	 * 
	 * @author Bredlin
	 * @param title
	 */
	public synchronized void clkOnTheTitle(String title) {
		try {
			if (lnkTitles(title).isDisplayed()) {
				actionUtil.clickCheckBoxUsingJS(lnkTitles(title), title + " link");
				WebActionUtil.validationinfo("Clicked on particular title under " + title + " link", "blue");
			} else {
				actionUtil.scrollToElement(lnkTitles(title), title + " link");
				actionUtil.clickCheckBoxUsingJS(lnkTitles(title), title + " link");
				WebActionUtil.pass("clicked on particular title under " + title + " link");
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on " + title + " link");
			Assert.fail("Unable to click on " + title + " link");
		}
	}

	/**
	 * Description: Method used to click on Facebook icon and validate Facebook
	 * login page
	 * 
	 * @author Bredlin
	 */
	public synchronized void clkOnFacebookIconAndValidateFacebookLoginPage() {
		try {
			actionUtil.waitForElement(icnFacebook, "Facebook icon");
			actionUtil.clickOnElement(icnFacebook, "Facebook icon");
			actionUtil.switchToNewTab();
			String currentUrl = driver.getCurrentUrl();
			Assert.assertTrue(currentUrl.contains(BaseTest.prop_constants.getProperty("facebook_url")));
			WebActionUtil.validationinfo("Facebook login page is displayed", "blue");
			WebActionUtil.info("Facebook login page is displayed");
			actionUtil.switchToMainTab();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Facebook login page");
			Assert.fail("Unable to validate Facebook login page");
		}
	}

	/**
	 * Description:Method to click on Right Arrow under the particular title
	 * 
	 * @author Bredlin
	 * @param title
	 */
	public synchronized void clkOnRightArrowIcn(String title) {
		try {
			actionUtil.scrollToElement(icnRightArrow(title), "Right Arrow icon");
			actionUtil.clickCheckBoxUsingJS(icnRightArrow(title), "Right Arrow icon");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Right Arrow icon");
			Assert.fail("Unable to click on Right Arrow icon");
		}
	}

	/**
	 * Description:Method to validate element is displayed
	 * 
	 * @author Bredlin
	 * @param title
	 */
	public synchronized void validateTitle(String title) {
		try {
			actionUtil.validateisElementDisplayed(lnkTitles(title), title, title + " title is dispalyed",
					title + " title is not dispalyed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate title");
			Assert.fail("Unable to validate title");
		}
	}

	/**
	 * Description:Method to validate the page
	 * 
	 * @author Bredlin
	 * @param expectedUrl
	 * @param title
	 */
	public synchronized void validatePage(String expectedUrl, String title) {
		try {
			actionUtil.validateisElementDisplayed(txtTitles(title), title + " text", title + " text is displayed",
					title + " text is not displayed", "blue");
			actionUtil.validateUrl(expectedUrl, title);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate the page");
			Assert.fail("Unable to validate the page");
		}
	}

	/**
	 * Description: Method used to click on mute button
	 * 
	 * @author Abhishek
	 */
	public synchronized void clkOnMuteOrUnmuteButton() {
		try {
			if (btnMuteOrUnmute.getAttribute("class").contains("audio-volume_off")) {
				WebActionUtil.validationinfo("Audio-volume is off", "blue");
			} else {
				WebActionUtil.validationinfo("Audio-volume is on", "blue");
			}
			actionUtil.clickOnElement(btnMuteOrUnmute, "Mute button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on Mute button");
			Assert.fail("Unable to perform action on Mute button");
		}
	}

	/**
	 * Description: Method used to click on skip to next podcast button
	 * 
	 * @author Abhishek
	 */
	public synchronized void clkonNextOrPreviousPodcastButton() {
		try {
			String podcastTitleBeforeSwitching = txtPodcastTitle.getText();
			actionUtil.clickOnElement(btnSkipToNextPodcast, "Skip to next podcast button");
			String podcastTitleAfterSwitching = txtPodcastTitle.getText();
			if (podcastTitleBeforeSwitching.equals(podcastTitleAfterSwitching)) {
				WebActionUtil.error("Unable to switch the podcast");
				WebActionUtil.fail("Unable to switch the podcast");
				Assert.fail("Unable to switch the podcast");
			} else {
				WebActionUtil.validationinfo("Skipped to next podcast", "blue");
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to switch the podcast");
			Assert.fail("Unable to switch the podcast");
		}
	}

	/********* 09/04/23 ************/
	/**
	 * Description: Method used to click on play button
	 * 
	 * @author Abhishek
	 */
	public synchronized void clkOnPlayOrPauseButton() {
		try {
			//actionUtil.poll(16000);
			if (btnPauseOrPlay.getAttribute("class").contains("audio-play_arrow")) {
				WebActionUtil.validationinfo("Audio-paly is off", "blue");
			} else {
				WebActionUtil.validationinfo("Audio-play is on", "blue");
			}
			actionUtil.clickOnElement(btnPauseOrPlay, "Play button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on Play button");
			Assert.fail("Unable to perform action on Play button");
		}
	}
}
