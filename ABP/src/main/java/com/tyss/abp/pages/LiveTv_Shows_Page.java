package com.tyss.abp.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.abp.baseutil.BaseTest;
import com.tyss.abp.util.WebActionUtil;

/**
 * Description This class has the implementations for Live_TVShows_Page.
 * 
 * @author Manjappa
 */
public class LiveTv_Shows_Page {
	public WebDriver driver;
	public WebActionUtil actionUtil;
	public long ETO;

	public LiveTv_Shows_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* TV shows */
	private WebElement lnkTvShows(String tvShows) {
		String xpath = "//a[@title='" + tvShows + "']//span[@class='text-wrapper']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Video TV */
	private WebElement txtVideo(String videoPage) {
		String xpath = "//h1[normalize-space()='" + videoPage + "']";
		driver.manage().timeouts().implicitlyWait(BaseTest.ITO, TimeUnit.SECONDS);
		return driver.findElement(By.xpath(xpath));
	}

	/* Live TV image */
	@FindBy(xpath = "//div[@class='active_video_tab']")
	private WebElement imgVideos;
	
	/* First video */
	@FindBy(xpath = "//div[@class='uk-width-1-2 uk-first-column']")
	private WebElement imgFirstVideo;
	
	/* Playing Video image */
	@FindBy(xpath = "//div[@class='video_section']")
	private WebElement imgVideo;
	
	/* Video playing screen */
	@FindBy(id = "holaPlayerFloat")
	private WebElement vdoPlayingScreen;
	
	/* Pause text */
	@FindBy(xpath = "//button[contains(@class,'vjs-play-control')]/child::span[@class='vjs-control-text']")
	private WebElement txtPause;

	/**
	 * Description : This method used to validate Live Tv Page
	 * 
	 * @author Manjappa
	 */
	public synchronized void validateLiveTvPage() {
		try {
			actionUtil.validateUrl(BaseTest.prop_constants.getProperty("livetv_Url"), "green");		
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Live Tv page");
			Assert.fail("Unable to validate Live Tv page");
		}
	}

	/**
	 * Description : This method used to click on any one video in TV show category
	 * 
	 * @author Manjappa
	 * @param tvShows
	 * @param videosTextHeadline
	 */
	public synchronized void clkOnAnyVideoOnTvShow(String tvShows, String videosTextHeadline) {
		try {
	//		actionUtil.scrollToElement(lnkTvShows(tvShows), "Video show headline");
			actionUtil.clickOnElement(lnkTvShows(tvShows), "Video show headline");
			actionUtil.validateisElementDisplayed(txtVideo(videosTextHeadline), "Video show headline",
					"Able to validate Video show headline", "Unable to validate Video show headline", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Tv show");
			WebActionUtil.fail("Unable to validate Video show headline");
			Assert.fail("Unable to validate Video show headline");
		}
	}

	/**
	 * Description : This method used to validate view videos
	 * 
	 * @author Manjappa
	 */
	public synchronized void validateViewVideos() {
		try {
			actionUtil.validateisElementDisplayed(imgVideos, "Videos iamges", "Able to validate videos",
					"Unable to validate videos", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate videos");
			Assert.fail("Unable to validate videos");
		}
	}
	
	
	
	/**
	 * Description : This method used to click on first video
	 * 
	 * @author Manjappa
	 */
	public synchronized void clkOnVideo() {
		try {
			actionUtil.clickOnElement(imgFirstVideo, "Video image");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on video");
			Assert.fail("Unable to click on video");
		}
	}
	
	/**
	 * Description : This method used to validate video is palying
	 * 
	 * @author Manjappa
	 */
	public synchronized void validateVideoIsPalying() {
		try {
			actionUtil.waitForElement(imgVideo, "First video");
			actionUtil.actionMouseOver(vdoPlayingScreen,"First video");
			String actualText = actionUtil.getText(txtPause, "Pause text");
			Assert.assertEquals(actualText, "Pause");
			WebActionUtil.info("Video is palying");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Video is palying");
			Assert.fail("Unable to validate Video is palying");
		}
	}

}