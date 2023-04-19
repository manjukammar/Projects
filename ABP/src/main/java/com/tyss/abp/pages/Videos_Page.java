package com.tyss.abp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.abp.util.WebActionUtil;

/**
 * Description This class has the implementations for videos Page.
 * 
 * @author Abhishek
 * 
 */
public class Videos_Page {
	public WebDriver driver;
	public WebActionUtil actionUtil;
	public long ETO;

	public Videos_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/* Videos link */
	@FindBy(xpath = "//ul[@class='uk-padding-remove']/descendant::a[text()='Videos']")
	private WebElement lnkVideos;
	
	/* Uncut link */
	@FindBy(xpath = "//ul[@class='uk-padding-remove']/descendant::a[text()='Uncut']")
	private WebElement lnkUncut;
	
	/* Tv shows link */
	@FindBy(xpath = "//ul[@class='uk-padding-remove']/descendant::a[text()='TV Shows']")
	private WebElement lnkTvShows;
	
	/* Links in Videos page text */
	private WebElement lnksInVideosPage(String link) {
		String xpath = "//ul[@class='uk-padding-remove']/descendant::a[text()='"+link+"']";
		return driver.findElement(By.xpath(xpath));
	}
	
	/* Videos tab */
	@FindBy(xpath = "//a[text()='Videos']")
	private WebElement tabVideos;
	
	/* Uncut image */
	@FindBy(xpath = "//img[@alt='Logo']")
	private WebElement imgUncut;
	
	/* Tv shows text */
	@FindBy(xpath = "//h1[text()='TV SHOWS']")
	private WebElement txtTvShows;
	
	/* First story text */
	@FindBy(xpath = "//div[@class='uk-width-expand uk-first-column']/child::a/descendant::div[@class='news_content']")
	private WebElement txtFirstStory;
	
	/* View All option */
	private WebElement btnViewAll(String category) {
		String xpath = "//h2[text()='"+category+"']/parent::a/following-sibling::div/child::a[text()='View All ']";
		return driver.findElement(By.xpath(xpath));
	}
	
	/* Title of first story text */
	@FindBy(xpath = "//h1[@id='videoTitleElement']")
	private WebElement txtTitleOfFirstStory;
	
	/* See more button */
	@FindBy(xpath = "//button[@class='see-more-btn sec']")
	private WebElement btnSeeMore;
	
	/* More videos section */
	@FindBy(id = "load_more_videos")
	private WebElement secMoreVideos;
	
	
	/**
	 * Description: Method used to validate video, uncut and TV link are displayed
	 * 
	 * @author Abhishek
	 */
	public synchronized void validateVideoUncutTvLinks() {
		try {

			actionUtil.validateisElementDisplayed(lnkVideos, "Videos link",
					"Videos link is displayed", "Videos link is not displayed", "blue");
			actionUtil.validateisElementDisplayed(lnkUncut, "Uncut link",
					"Uncut link is displayed", "Uncut link is not displayed", "blue");
			actionUtil.validateisElementDisplayed(lnkTvShows, "Tv shows link",
					"Tv shows link is displayed", "Tv shows link is not displayed", "blue");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Videos,Uncut and Tv shows links are not displayed");
			Assert.fail("Videos,Uncut and Tv shows links are not displayed");
		}
	}
	
	/**
	 * Description: Method used to click on links in Videos page
	 * 
	 * @author Abhishek
	 * @param link 
	 */
	public synchronized void clkOnLinksInVideosPage(String link) {
		try {
			actionUtil.clickOnElement(lnksInVideosPage(link), "Links in Videos page");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on Link "+link+" in videos page");
			Assert.fail("Unable to perform action on Link "+link+" in videos page");
		}
	}
	
	/**
	 * Description: Method used to validate video page
	 * 
	 * @author Abhishek
	 */
	public synchronized void validateVideoPage() {
		try {
			actionUtil.validateisElementDisplayed(tabVideos, "Videos tab",
					"Videos page is displayed", "Videos page is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Videos page is not displayed");
			Assert.fail("Videos page is not displayed");
		}
	}
	
	
	/**
	 * Description: Method used to validate uncut page
	 * 
	 * @author Abhishek
	 */
	public synchronized void validateUncutPage() {
		try {
			actionUtil.validateisElementDisplayed(imgUncut, "Uncut image",
					"Uncut page is displayed", "Uncut page is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Uncut page is not displayed");
			Assert.fail("Uncut page is not displayed");
		}
	}
	
	/**
	 * Description: Method used to validate Tv shows page
	 * 
	 * @author Abhishek
	 */
	public synchronized void validateTvShowsPage() {
		try {
			actionUtil.validateisElementDisplayed(txtTvShows, "Tv shows text",
					"Tv shows page is displayed", "Tv shows page is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Tv shows page is not displayed");
			Assert.fail("Tv shows page is not displayed");
		}
	}
	
	/**
	 * Description: Method used to click on view all button of different categories
	 * 
	 * @author Abhishek
	 * @param category 
	 */
	public synchronized void clkOnViewAllButtonOfCategory(String category) {
		try {
			actionUtil.clickOnElement(btnViewAll(category), "View all button");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on "+category+" button in videos page");
			Assert.fail("Unable to perform action on "+category+" button in videos page");
		}
	}
	
	/**
	 * Description: Method used to click on First story
	 * 
	 * @author Abhishek
	 * @return storyName
	 */
	public synchronized String clkOnFirstStory() {
		String storyName=null;
		try {
			 storyName = txtFirstStory.getText();
			actionUtil.clickOnElement(txtFirstStory, "First story text");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on first story");
			Assert.fail("Unable to perform action on first story");
		}
		return storyName;
	}
	
	/**
	 * Description: Method used to validate story page 
	 * 
	 * @author Abhishek
	 * @param storyname
	 */
	public synchronized void validateStoryTitle(String storyname) {
		try {
			actionUtil.waitForPageToLoad();
			String titleText = txtTitleOfFirstStory.getText();
			if (titleText.toLowerCase().contains(storyname.toLowerCase())) {
				WebActionUtil.validationinfo("Navigated to respective story page", "blue");
			}else {
				WebActionUtil.error("Unable to navigate to respective story page");
				WebActionUtil.fail("Unable to navigate to respective story page");
				Assert.fail("Unable to navigate to respective story page");
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to navigate to respective story page");
			Assert.fail("Unable to navigate to respective story page");
		}
	}
	
	/**
	 * Description: Method used to click on see more button
	 * 
	 * @author Abhishek
	 */
	public synchronized void clkOnSeeMoreButton() {
		try {
			actionUtil.clickOnElement(btnSeeMore, "See more button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on See more button");
			Assert.fail("Unable to perform action on See more button");
		}
	}
	
	
	/**
	 * Description: Method used to validate more videos loaded
	 * 
	 * @author Abhishek
	 */
	public synchronized void validateMoreVideosLoaded() {
		try {
			actionUtil.validateisElementDisplayed(secMoreVideos, "Section of videos",
					"More videos loaded and displayed", "Unable to display the videos after loading", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to display the videos after loading");
			Assert.fail("Unable to display the videos after loading");
		}
	}
	
	
	
}
