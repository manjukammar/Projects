package com.tyss.abp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.abp.baseutil.BaseTest;
import com.tyss.abp.util.WebActionUtil;

/**
 * Description : This class has the implementations for Article page.
 * 
 * @author Manjappa
 */
public class Article_Page {
	public WebDriver driver;
	public WebActionUtil actionUtil;
	public long ETO;

	public Article_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* Article link */
	@FindBy(xpath = "//p[contains(text(),'LIVE')]/ancestor::div[@class='_tHome']/descendant::div[@class='uk-grid-collapse uk-grid']")
	private WebElement lnkArticle;

	/* Article text */
	@FindBy(xpath = "//h1[@class='article-title ' or @class='article-title']")
	private WebElement txtArticle;

	/* Share icons */
	private WebElement icnShare(String shareIcones) {
		String xpath = "//div[@class='story_social_share']//span[@class='" + shareIcones + "']";
		return driver.findElement(By.xpath(xpath));
	}

	/* You May Like text */
	@FindBy(xpath = "//span[normalize-space()='You May Like']")
	private WebElement txtYouMayLike;

	/* Related Stories section text */
	@FindBy(xpath = "//h2[text()='Related Stories']")
	private WebElement txtRelatedStories;

	/* Top Stories section text */
	@FindBy(xpath = "//h2[text()='Top Stories']")
	private WebElement txtTopStories;

	/* Tags link text */
	@FindBy(xpath = "//span[@class='blog-tags']")
	private WebElement txtTags;

	/* Tag link */
	@FindBy(xpath = "//span[@class='blog-tags']/child::span[@class='tag']")
	private WebElement lnkTag;

	/* Tag text */
	@FindBy(xpath = "//h1[@class='fz28']")
	private WebElement txtTag;

	/* For you text */
	@FindBy(xpath = "//a[normalize-space()='For You']")
	private WebElement txtForYou;

	/* Taboola logo */
	@FindBy(xpath = "//div[@class='tbl-feed-header-logo']")
	private WebElement lnkTaboolaFeedLogo;

	/* Want to login text */
	@FindBy(xpath = "//span[text()='Want to log in first?']")
	private WebElement txtWantToLogin;

	/* Facebook text */
	@FindBy(xpath = "//h2[text()='Facebook']")
	private WebElement txtFacebook;

	/* Whatsapp text */
	@FindBy(xpath = "//div[text()='WhatsApp Web']")
	private WebElement txtWhatsapp;


	/**
	 * Description : This method used to validate Article consumption page
	 * 
	 * @author Manjappa
	 */
	public synchronized void validateArticleConsumptionPage() {
		try {
			actionUtil.waitForElement(txtArticle, "Article hedline text");
			actionUtil.validateisElementDisplayed(txtArticle, "Article hedline text",
					"Able to validate Article consumption page",
					"Unable to validate Article consumption page", "green");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Article consumption page");
			Assert.fail("Unable to validate Article consumption page");
		}
	}

	/**
	 * Description : This method used for click on Facebook icon
	 * 
	 * @author Manjappa
	 * @param shareIcons
	 */
	public synchronized void clkonFacebookIcon(String shareIcons) {
		try {
			WebActionUtil.poll(2000);
			actionUtil.scrollToElement(icnShare(shareIcons), "Facebook icon");
			actionUtil.clickOnElementUsingJS(icnShare(shareIcons), "Facebook icon");
			actionUtil.switchToNewTab();
			actionUtil.waitForPageToLoad();
			ValidateFacebookPage();
			driver.close();
			actionUtil.switchToMainTab();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click  on Facebook icon");
			Assert.fail("Unable to click  on Facebook icon");
		}
	}

	/**
	 * Description : This method used for click on Twitter icon
	 * 
	 * @author Manjappa
	 * @param shareIcons
	 */
	public synchronized void clkonTwitterIcon(String shareIcons) {
		try {
			actionUtil.scrollToElement(icnShare(shareIcons), "Twitter icon");
			actionUtil.clickOnElement(icnShare(shareIcons), "Twitter icon");
			actionUtil.switchToNewTab();
			actionUtil.waitForPageToLoad();
			ValidateTwitterPage();
			driver.close();
			actionUtil.switchToMainTab();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click  on Twitter  icon");
			Assert.fail("Unable to click  on Twitter  icon");
		}
	}

	/**
	 * Description : This method used for click on Whatsapp icon
	 * 
	 * @author Manjappa
	 * @param shareIcons
	 */
	public synchronized void clkonWhatsappIcon(String shareIcons) {
		try {
			actionUtil.scrollToElement(icnShare(shareIcons), "Whatasapp icon");
			actionUtil.clickOnElement(icnShare(shareIcons), "Whatasapp icon");
			actionUtil.switchToNewTab();
			actionUtil.waitForPageToLoad();
			ValidateWhatsappPage();
			driver.close();
			actionUtil.switchToMainTab();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click  on whatsapp  icon");
			Assert.fail("Unable to click  on whatsapp  icon");
		}
	}

	/**
	 * Description : This method used to validate Related story section
	 * 
	 * @author Manjappa
	 */
	public synchronized void validateRelatedStorySection() {
		try {
			actionUtil.scrollToElement(txtRelatedStories, "Related story section text");
			actionUtil.validateisElementDisplayed(txtRelatedStories, "Related story section text",
					"Able to validate Related story section text", "Unable to validate Related story section text",
					"blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Related story section text");
			Assert.fail("Unable to validate Related story section text");
		}
	}

	/**
	 * Description : This method used to validate Top story section
	 * 
	 * @author Manjappa
	 */
	public synchronized void validateTopStorySection() {
		try {
			actionUtil.scrollToElement(txtTopStories, "Top story section text");
			actionUtil.validateisElementDisplayed(txtTopStories, "Top story section text",
					"Able to validate Top story section text", "Unable to validate Top story section text", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Top story section text");
			Assert.fail("Unable to validate Top story section text");
		}
	}

	/**
	 * Description : This method used to validate Tags
	 * 
	 * @author Manjappa
	 */
	public synchronized void validateTags() {
		try {
			// actionUtil.scrollToElement(txtTags, "Tags text");
			actionUtil.waitForElement(txtTags, "Tags text");
			actionUtil.validateisElementDisplayed(txtTags, "Tags text", "Able to validate Tags",
					"Unable to validate Tags", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Tags");
			Assert.fail("Unable to validate Tags");
		}
	}

	/**
	 * Description : This method used to click on any one tag
	 * 
	 * @author Manjappa
	 */
	public synchronized void clkOnTag() {
		try {
			actionUtil.scrollToElement(lnkTag, "Tag link");
			actionUtil.clickOnElement(lnkTag, "Tag link");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Tag");
			Assert.fail("Unable to click on Tag");
		}
	}

	/**
	 * Description : This method used to validate Tag topic headline
	 * 
	 * @author Manjappa
	 */
	public synchronized void validateTag() {
		try {
			actionUtil.validateisElementDisplayed(txtTag, "Tag text", "Able to validate respective tag topic",
					"Unable to validate respective tag topic", "blue");
			driver.navigate().back();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate respective tag topic");
			Assert.fail("Unable to validate respective tag topic");
		}
	}

	/**
	 * Description : This method used to validate for you text
	 * 
	 * @author Manjappa
	 */
	public synchronized void validateForYouSection() {
		try {
			actionUtil.scrollToElement(txtForYou, "For you text");
			actionUtil.validateisElementDisplayed(txtForYou, "For you text", "For you text is displayed",
					"For you text is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate For you section text");
			Assert.fail("Unable to validate For you section text");
		}
	}

	/**
	 * Description : This method used to validate Taboola feed logo 
	 * 
	 * @author Manjappa
	 */
	public synchronized void scrollAndValidateTaboolaLogo() {
		try {
			actionUtil.scrollToElement(txtForYou, "For You text");
			actionUtil.scrollToElement(lnkTaboolaFeedLogo, "Taboola Feed Logo");
			actionUtil.validateisElementDisplayed(lnkTaboolaFeedLogo, "Taboola Feed Logo",
					"Taboola Feed Logo is displayed", "Taboola Feed Logo is not displayed", "green");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Taboola feed Logo");
			Assert.fail("Unable to validate Taboola feed Logo");
		}
	}

	/**
	 * Description : This method used to validate Twitter page
	 * 
	 * @author Manjappa
	 */
	private synchronized void ValidateTwitterPage() {
		try {
			String actualURL = driver.getCurrentUrl();
			if (actualURL.contains(BaseTest.prop_constants.getProperty("twitter_Url"))) {
				WebActionUtil.info("Twitter page is displayed");
				WebActionUtil.validationinfo("Twitter page is displayed", "green");

			} else {
				WebActionUtil.error("Twitter page is not dispalyed");
				WebActionUtil.fail("Twitter page is not dispalyed");
				Assert.fail("Twitter page is not dispalyed");
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Twitter page is not dispalyed");
			Assert.fail("Twitter page is not dispalyed");
		}
	}

	/**
	 * Description : This method used to validate Facebook page
	 * 
	 * @author Manjappa
	 */
	private synchronized void ValidateFacebookPage() {
		try {
			actionUtil.waitForElement(txtFacebook, "Facebook text");
			actionUtil.validateisElementDisplayed(txtFacebook, "Facebook text", "Facebook page is dispalyed",
					"Facebook page is dispalyed", "green");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Facebook page is not dispalyed");
			Assert.fail("Facebook page is not dispalyed");
		}
	}

	/**
	 * Description : This method used to validate Whatsapp page
	 * 
	 * @author Manjappa
	 */
	private synchronized void ValidateWhatsappPage() {
		try {
			actionUtil.waitForElement(txtWhatsapp, "Whatsapp text");
			actionUtil.validateisElementDisplayed(txtWhatsapp, "Whatsapp text", "Whatsapp page is dispalyed",
					"Whatsapp page is dispalyed", "green");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Whatsapp page is not dispalyed");
			Assert.fail("Whatsapp page is not dispalyed");
		}
	}

	/**
	 * Description : This method used to validate You may like text
	 * 
	 * @author Manjappa
	 */
	public synchronized void validateYouMayLikeSection() {
		try {
			actionUtil.waitForPageToLoad();
			actionUtil.scrollToElement(txtRelatedStories, "Related story text");
			actionUtil.scrollToElement(txtYouMayLike, "You may like text");
			actionUtil.validateisElementDisplayed(txtYouMayLike, "You may like text",
					"Able to validate You may like text", "Unable to validate You may like text", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate You may like text");
			Assert.fail("Unable to validate You may like text");
		}
	}
}