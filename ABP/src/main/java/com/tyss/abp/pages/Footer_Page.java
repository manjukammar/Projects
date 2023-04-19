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
 * Description This class has the implementations for Footer Page.
 * 
 * @author SreeLatha
 */
public class Footer_Page {
	public WebDriver driver;
	public WebActionUtil actionUtil;
	public long ETO;

	public Footer_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	
	/* Footers link */
	private WebElement lnkFooters(String footerLink) {
		String xpath = "//span[normalize-space()='" + footerLink + "']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Footers text */
	private WebElement txtFooters(String footerValue) {
		String xpath = "//a[contains(text(),'" + footerValue + "')]";
		driver.manage().timeouts().implicitlyWait(BaseTest.ITO, TimeUnit.SECONDS);
		return driver.findElement(By.xpath(xpath));
	}

	/* Contact Us text */
	@FindBy(xpath = "//li/a[normalize-space()='Contact Us']")
	private WebElement txtContactUs;

	/* Careers text */
	@FindBy(xpath = "//h2[normalize-space()='Career at ABP Network']")
	private WebElement txtCareers;

	/* About Us text */
	@FindBy(xpath = "//h2[normalize-space()='Our Core Purpose']")
	private WebElement txtAboutUs;
	
	
	
	/**
	 * Description: This method is used to click on Footer link.
	 * 
	 * @author SreeLatha
	 * @param footerLink
	 */
	public synchronized void clkFooterLink(String footerLink) {
		try {
			actionUtil.clickOnElementUsingJS(lnkFooters(footerLink), "Footers link");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on + footerLink + link");
			Assert.fail("Unable to perform action on + footerLink + link");
		}
	}

	
	/**
	 * Description: This method is used to validate Contact Us page.
	 * 
	 * @author SreeLatha
	 */
	public synchronized void validateContactUsPage() {
		try {
			actionUtil.validateisElementDisplayed(txtContactUs, "Contact Us text", "Contact Us page is displayed",
					"Contact Us page is not displayed", "Blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Contact Us page is not displayed");
			Assert.fail("Contact Us page is not displayed");
		}

	}

	
	/**
	 * Description: This method is used to validate About Us page.
	 * 
	 * @author SreeLatha
	 */
	public synchronized void validateAboutUsPage() {
		try {
			actionUtil.switchToNewTab();
			actionUtil.validateisElementDisplayed(txtAboutUs, "About Us text", "About Us page is displayed",
					"About Us page is not displayed", "Blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("About Us page is not displayed");
			Assert.fail("About Us page is not displayed");
		}

	}

	
	/**
	 * Description: This method is used to validate Careers page.
	 * 
	 * @author SreeLatha
	 */
	public synchronized void validateCareersPage() {
		try {
			actionUtil.switchToNewTab();
			actionUtil.validateisElementDisplayed(txtCareers, "Careers text", "Careers page is displayed",
					"Careers page is not displayed", "Blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Careers page is not displayed");
			Assert.fail("Careers page is not displayed");
		}

	}

	
	/**
	 * Description: This method is used to validate footers page.
	 * 
	 * @author SreeLatha
	 * @param footerValue
	 */
	public synchronized void validateFooterPage(String footerValue) {
		try {
			actionUtil.waitForPageToLoad();
			actionUtil.validateisElementDisplayed(txtFooters(footerValue), "Footer title text",
					footerValue + " page is displayed", footerValue + " page is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail(footerValue + " page is not displayed");
			Assert.fail(footerValue + " page is not displayed");
		}

	}

}