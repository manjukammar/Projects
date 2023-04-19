package com.tyss.abp.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tyss.abp.baseutil.BaseTest;
import com.tyss.abp.util.WebActionUtil;

import ch.qos.logback.core.joran.action.ActionUtil;

/**
 * Description This class has the implementations for Live TV Page.
 * 
 * @author Sushmita P H
 */
public class LiveTv_Page {
	public WebDriver driver;
	public WebActionUtil webActionUtil;
	public long ETO;

	public LiveTv_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.webActionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* Live Tv text */
	@FindBy(xpath = "//ul[@class='uk-breadcrumb']/li[last()]/a")
	private WebElement txtLiveTv;

	/* Live tv video playing screen */
	@FindBy(xpath = "//div[@id='playerContainer']")
	private WebElement vdoPlayingScreen;

	/* Pause button */
	@FindBy(xpath = "//span[text()='Pause']")
	private WebElement btnPause;
	
	/* Play button */
	@FindBy(xpath = "//span[text()='Play']")
	private WebElement btnPlay;

	/* View all button */
	private WebElement btnViewAll(String sectionType) {
		String xpath = "//h2[text()='" + sectionType + "']/parent::a/following-sibling::div/a[text()='View All ']";
		driver.manage().timeouts().implicitlyWait(BaseTest.ITO, TimeUnit.SECONDS);
		return driver.findElement(By.xpath(xpath));
	}

	/* Any top story or video link */
	@FindBy(xpath = "//h2[@class='fontFeatured fz26 uk-margin-remove']")
	private WebElement lnkAnyTopStoryOrVideo;

	/* Top story title text */
	@FindBy(xpath = "//h1[contains(@class,'article-title')]")
	private WebElement txtAnyTopStoryOrVideoOrCardTitle;

	/* Top sports header text */
	@FindBy(xpath = "//ul[@class='uk-breadcrumb']/li/span")
	private WebElement txtTopSportsInHeader;

	/* Top story/video header text */
	private WebElement txtPageHeader(String sectionType) {
		String xpath = "//ul[@class='uk-breadcrumb']/li/a[@title='" + sectionType
				+ "']/parent::li/following-sibling::li";
		driver.manage().timeouts().implicitlyWait(BaseTest.ITO, TimeUnit.SECONDS);
		return driver.findElement(By.xpath(xpath));
	}

	/* Any top tv show link */
	@FindBy(xpath = "//div[@class='news_content newsList_ht']")
	private WebElement lnkTopTvShows;

	/* Any for you card link */
	@FindBy(xpath = "//a[text()='For You']/parent::div/following-sibling::div/descendant::div[contains(@id,'internal_trc')]"
			+ "/div/a/span/span[contains(@class,'video-label video-title trc_ellipsis')]")
	private WebElement lnkAnyForYouCardDisplayed;

	/* All page title text */
	@FindBy(xpath = "//h1[@class='title fz32uk-width-1-1']")
	private WebElement txtAllPageTitle;

	/* Top stories text */
	@FindBy(xpath = "//h2[text()='Top Stories']")
	private WebElement txtTopStories;

	/* Footer text */
	@FindBy(xpath = "//a[text()='ICC Ranking']")
	private WebElement txtFooter;

	/* Footer */
	@FindBy(xpath = "//footer[@id='wah_footer_nav_bar_container']")
	private List<WebElement> tbFooter;

	/* Footer header text */
	@FindBy(xpath = "//h1[@class='h2 title btn px-md-0']")
	private WebElement txtFooterHeader;
	
	/* Video title */
	@FindBy(xpath = "//h1[@class='red-blob-label title']")
	private WebElement txtVideoTitle;
	
	/**
	 * Description: Method used to validate Title of the element.
	 * 
	 * @author Sushmita P H
	 */
	public synchronized void validateLiveTvPage() {
		try {
			webActionUtil.validateisElementDisplayed(txtLiveTv, "Live TV text",
					"User is able to navigate to Live Tv page", "User is not able to navigate to Live Tv page", "blue");
			validatePauseBtn();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Live Tv page");
			Assert.fail("Unable to validate Live Tv page");
		}
	}

	/**
	 * Description: Method used to click on any Top story link.
	 * 
	 * @author Sushmita P H
	 */
	public synchronized void clickOnAnyStoryOrVideoOrCardDisplayed() {
		try {
			webActionUtil.scrollToElement(lnkAnyTopStoryOrVideo, "Top Story link");
			webActionUtil.clickOnElementUsingJS(lnkAnyTopStoryOrVideo, "Top Story link");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Top Story");
			Assert.fail("Unable to click on Top Story");
		}
	}

	/**
	 * Description: Method used to click on Top tv shows displayed.
	 * 
	 * @author Sushmita P H
	 */
	public synchronized void clickOnTopTvShowDisplayed() {
		try {
			webActionUtil.scrollToElement(lnkTopTvShows, "Top tv show link");
			webActionUtil.clickOnElement(lnkTopTvShows, "Top tv show link");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on top Tv show link");
			Assert.fail("Unable to click on top tv show link");
		}
	}

	/**
	 * Description: Method used to click on any For You Card.
	 * 
	 * @author Sushmita P H
	 */
	public synchronized void clickOnAnyForYouCardDisplayed() {
		try {
			webActionUtil.scrollDownByCoordinates();
			try {
				webActionUtil.clickOnElement(lnkAnyForYouCardDisplayed, "For you card link");
			} catch (Exception e) {
				WebActionUtil.info("In for you section stories are not displayed");
			}
			webActionUtil.validateisElementDisplayed(txtAnyTopStoryOrVideoOrCardTitle, "For you card title",
					"User is able to view For you card", "User is unable to view For you card", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click For you card");
			Assert.fail("Unable to click on For you card");
		}
	}

	/**
	 * Description: Method used to validate Title of the top story/video.
	 * 
	 * @author Sushmita P H
	 * @param sectionType
	 */
	public synchronized void validateTitle(String sectionType) {
		try {
			webActionUtil.validateisElementDisplayed(txtAnyTopStoryOrVideoOrCardTitle,
					"Title of top " + sectionType + " video/story",
					"User is able to view & navigate to the top " + sectionType + " video/story",
					"User is unable to view & navigate to the top " + sectionType + " video/story", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate title of top " + sectionType + " video/story");
			Assert.fail("Unable to validate title of top " + sectionType + " video/story");
		}
	}

	/**
	 * Description: Method used to validate Title of the element.
	 * 
	 * @author Sushmita P H
	 * @paramsectionType
	 */
	public synchronized void validateHeader(String sectionType) {
		try {
			webActionUtil.poll(2000);
			if (sectionType.equalsIgnoreCase("Sports")) {
				webActionUtil.validateisElementDisplayed(txtTopSportsInHeader, "Top Sports header",
						"User is able to view & navigate to the top Sports page",
						"User is unable to view & navigate to the top Sports page", "blue");
			} else {
				webActionUtil.validateisElementDisplayed(txtPageHeader(sectionType), "Top " + sectionType + " header",
						"User is able to view & navigate to the top " + sectionType + " video/story",
						"User is unable to view & navigate to the top " + sectionType + " video/story", "blue");
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate top " + sectionType + " video/story header");
			Assert.fail("Unable to validate top " + sectionType + " video/story header");
		}
	}

	/**
	 * Description: Method used to validate Pause button
	 * 
	 * @author Sushmita P H
	 */
	private synchronized void validatePauseBtn() {
		try {
			webActionUtil.scrollToElement(txtVideoTitle, "Video title text");
			webActionUtil.waitForVisibilityOfElement(vdoPlayingScreen, "Video playing screen");
			webActionUtil.validateisElementDisplayed(vdoPlayingScreen, "Video playing screen",
					"User is able to watch the video in Live Tv page",
					"User is not able to watch the video in Live Tv page", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Pause button");
			Assert.fail("Unable to validate title Pause button");
		}
	}

	/**
	 * Description: Method used to click on View All button
	 * 
	 * @author Sushmita P H
	 */
	public synchronized void clickOnViewAllBtn(String sectionType) {
		try {
			webActionUtil.scrollToElement(btnViewAll(sectionType), "View All button");
			webActionUtil.waitForElement(btnViewAll(sectionType), "View All button");
			webActionUtil.clickOnElement(btnViewAll(sectionType), "View All button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on View All button");
			Assert.fail("Unable to click on View All button");
		}
	}

	/**
	 * Description: This method is used to validate Top stories.
	 * 
	 * @author Shivananda
	 * 
	 */
	public synchronized void validateTopStories() {
		try {

			webActionUtil.scrollToElement(txtTopStories, "Top stories text");
			webActionUtil.validateisElementDisplayed(txtTopStories, "Top stories text", "Top stories text is displayed",
					"Top stories text is not displayed", "blue");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Top stories text ");
			Assert.fail("Unable to validate Top stories text");
		}
	}

	/**
	 * Description: Method used to click on View all button
	 * 
	 * @author Sushmita P H
	 */
	public synchronized void clickOnViewAll(String sectionType) {
		try {

			webActionUtil.clickOnElementUsingJS(btnViewAll(sectionType), "View all button");
			webActionUtil.info("Able to click on View all button");
			webActionUtil.validationinfo("Able to click on View all button", "blue");
			webActionUtil.poll(2000);

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on View all button");
			Assert.fail("Unable to click on View all button");
		}
	}

	/**
	 * Description: This method is used to click on Footer.
	 * 
	 * @author Shivananda
	 * 
	 */
	public synchronized void clickOnFooter() {
		try {
			WebActionUtil.scrollDown();
			webActionUtil.clickOnElement(txtFooter, "Footer text");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Footer");
			Assert.fail("Unable to validate Footer");
		}
	}

	/**
	 * Description: This method is used to validate Footer page.
	 * 
	 * @author Shivananda
	 * 
	 */
	public synchronized void validateFooterPage() {
		try {

			webActionUtil.scrollToElement(txtFooterHeader, "Footer header text");
			webActionUtil.validateisElementDisplayed(txtFooterHeader, "Footer header text",
					"Footer header text is displayed", "Footer header text is not displayed", "blue");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Footer header text");
			Assert.fail("Unable to validate Footer header text");
		}
	}
}