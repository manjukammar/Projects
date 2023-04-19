package com.tyss.abp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.abp.util.WebActionUtil;

/**
 * Description This class has the implementations for Photo Gallery Page.
 * 
 * @author Sanjay
 */
public class Photo_Gallery_Page {
	public WebDriver driver;
	public WebActionUtil actionUtil;
	public long ETO;

	public Photo_Gallery_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionUtil = WebActionUtil;
		this.ETO = ETO;
	}


	/* Photo Gallery text */
	@FindBy(xpath = "//h1[normalize-space()='Photo Gallery']")
	private WebElement txtPhotoGallery;

	/* Photo in Photo Gallery section */
	@FindBy(xpath = "//div[@class='uk-grid']/div[contains(@class,'uk-width-1-3')]/a")
	private WebElement Photo;

	/* First photo in Photo Gallery section */
	@FindBy(xpath = "//ul[@class='uk-breadcrumb']")
	private WebElement txtFirstPhoto;

	/* Top Galleries text */
	@FindBy(xpath = "//a[normalize-space()='Top Galleries']")
	private WebElement txtTopGalleries;

	/* See More button */
	@FindBy(xpath = "//button[normalize-space()='See More']")
	private WebElement btnSeeMore;

	/* Section under Photo Gallery Section */
	private WebElement sectionUnderPhotoGallerySection(String section) {
		String xpath = "//h2[normalize-space()='"+section+"']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Category under Photo Gallery Page */
	private WebElement categoryUnderPhotoGalleryPage(String category) {
		String xpath = "//a[@href='https://news.abplive.com/photo-gallery/"+category+"']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Category Page */
	private WebElement txtCategoryPage(String categoryPage) {
		String xpath = "//h1[text()='"+categoryPage+"']";
		return driver.findElement(By.xpath(xpath));
	}




	/**
	 * This method is used to validate Photo Gallery Page
	 * 
	 * @author Sanjay
	 */
	public synchronized void validatePhotoGalleryPage() {

		try {
			actionUtil.waitForElement(txtPhotoGallery, "Photo Gallery text");
			actionUtil.validateisElementDisplayed(txtPhotoGallery, "Photo Gallery text", "Validation of Photo Gallery page pass",
					"Validation of Photo Gallery page fail", "green");

		}catch(Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to validate Photo Gallery Page");
			Assert.fail("Unable to validate Photo Gallery Page");
		}
	}

	/**
	 * This method is used to click on Photo under Photo Gallery section
	 * 
	 * @author Sanjay
	 */
	public synchronized void clkOnPhotoUnderGallerySection() {

		try {
			actionUtil.waitForElement(Photo, "Photo in Photo Gallery section");
			actionUtil.clickOnElement(Photo, "Photo in Photo Gallery section");
		}catch(Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Photo under Photo Gallery section");
			Assert.fail("Unable to click on Photo under Photo Gallery section");
		}
	}

	/**
	 * This method is used to validate Top Galleries text
	 * 
	 * @author Sanjay
	 */
	public synchronized void validateTopGalleriesText() {

		try {
			actionUtil.waitForElement(txtTopGalleries, "Top Galleries text");
			actionUtil.validateisElementDisplayed(txtTopGalleries, "Top Galleries text", "Validation of Top Galleries text pass",
					"Validation of Top Galleries text fail", "blue");
		}catch(Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to validate Top Galleries text");
			Assert.fail("Unable to validate Top Galleries text");
		}
	}

	/**
	 * This method is used to validate See More button
	 * 
	 * @author Sanjay
	 */
	public synchronized void validateSeeMoreButton() {

		try {
			actionUtil.scrollToElement(btnSeeMore, "See More button");
			actionUtil.validateisElementDisplayed(btnSeeMore, "See More button", "Validation of See More button pass",
					"Validation of See More button fail", "blue");
		}catch(Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to validate on See More button");
			Assert.fail("Unable to validate on See More button");
		}
	}

	/**
	 * This method is used to click on See More button
	 * 
	 * @author Sanjay
	 */
	public synchronized void clkOnSeeMoreButton() {

		try {
			actionUtil.scrollToElement(btnSeeMore, "See More button");
			actionUtil.clickOnElementUsingJS(btnSeeMore, "See More button");
		}catch(Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on See More button");
			Assert.fail("Unable to click on See More button");
		}
	}

	/**
	 * This method is used to validate Section under Photo Gallery section
	 * 
	 * @author Sanjay
	 * @param section
	 */
	public synchronized void validateSectionUnderPhotoGallerySection(String section) {

		try {
			actionUtil.scrollToElement(sectionUnderPhotoGallerySection(section), section+" section under Photo Gallery section");
			actionUtil.validateisElementDisplayed(sectionUnderPhotoGallerySection(section), "section under Photo Gallery section",
					"Validation of "+section+" section under Photo Gallery section pass",
					"Validation of "+section+" section under Photo Gallery section fail", "blue");
		}catch(Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to validate "+section+" section under Photo Gallery section");
			Assert.fail("Unable to validate "+section+" section under Photo Gallery section");
		}
	}

	/**
	 * This method is used to click on Category under Photo Gallery page
	 * 
	 * @author Sanjay
	 * @param category
	 */
	public synchronized void clkOnCategoryUnderPhotoGalleryPage(String category) {

		try {
			actionUtil.waitForElement(categoryUnderPhotoGalleryPage(category),category+ " category under Photo Gallery page");
			actionUtil.clickOnElement(categoryUnderPhotoGalleryPage(category),category+ " category under Photo Gallery page");
		}catch(Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on "+category+" category under Photo Gallery page");
			Assert.fail("Unable to click on "+category+" category under Photo Gallery page");
		}
	}

	/**
	 * This method is used to validate Category page
	 * 
	 * @author Sanjay
	 * @param categoryPage
	 */
	public synchronized void validateCategoryPage(String categoryPage) {

		try {
			actionUtil.waitForElement(txtCategoryPage(categoryPage),categoryPage+" category page");
			actionUtil.validateisElementDisplayed(txtCategoryPage(categoryPage), "category page",
					"Validation of "+categoryPage+" page pass",
					"Validation of "+categoryPage+" page fail", "green");
		}catch(Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to validate "+categoryPage+" page");
			Assert.fail("Unable to validate "+categoryPage+" page");
		}
	}

	/* DNPA text */
	@FindBy(xpath = "//span[text()='DNPA code of Ethics']")
	private WebElement txtDNPA;

	/* Taboola Feed logo */
	@FindBy(xpath = "//div[@class='tbl-feed-header-logo']")
	private WebElement lnkTaboolaFeedLogo;

	/**
	 * Description : This method used to scroll and validate Taboola Feed logo
	 * 
	 * @author Sanjay
	 */
	public synchronized void scrollAndValidateTaboolaLogo(){
		try {
			actionUtil.scrollToElement(txtDNPA,"Taboola Feed logo");
			Thread.sleep(5000l);
			actionUtil.validateisElementDisplayed(lnkTaboolaFeedLogo, "Taboola Feed logo",
					"Taboola Feed logo is displayed", "Taboola Feed logo is not displayed", "green");
		}catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Taboola Feed logo");
			Assert.fail("Unable to validate Taboola Feed logo");
		}
	}

	/**
	 * This method is used to validate First photo in Photo Gallery section
	 * 
	 * @author Sanjay
	 */
	public synchronized void validateFirstPhoto() {

		try {
			actionUtil.waitForElement(txtFirstPhoto, "First photo in Photo Gallery section");
			actionUtil.validateisElementDisplayed(txtFirstPhoto, "First photo in Photo Gallery section",
					"Validation of first photo in Photo Gallery section pass", 
					"Validation of first photo in Photo Gallery section fail", "blue");
		}catch(Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to validate first photo in Photo Gallery section");
			Assert.fail("Unable to validate first photo in Photo Gallery section");
		}
	}

}