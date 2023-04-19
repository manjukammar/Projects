package com.tyss.abp.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tyss.abp.baseutil.BaseTest;
import com.tyss.abp.util.WebActionUtil;

/**
 * 
 * Description : This class has the implementations for Home Cricket Page.
 * 
 * @author Shivananda
 *
 */

public class Cricket_Page {
	public WebDriver driver;
	public WebActionUtil actionUtil;
	public long ETO;

	public Cricket_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* Link list */
	private WebElement links(String linkTabs) {
		String xpath = "//a[text()='" + linkTabs + "']";
		driver.manage().timeouts().implicitlyWait(BaseTest.ITO, TimeUnit.SECONDS);
		return driver.findElement(By.xpath(xpath));
	}

	/* Header text list */
	private WebElement txtHeader(String text) {
		String xpath = "//h2[text()='" + text + "']";
		driver.manage().timeouts().implicitlyWait(BaseTest.ITO, TimeUnit.SECONDS);
		return driver.findElement(By.xpath(xpath));
	}

	/* List of header text */
	private WebElement txtHeaderList(String text) {
		String xpath = "//h4[text()='" + text + "']";
		driver.manage().timeouts().implicitlyWait(BaseTest.ITO, TimeUnit.SECONDS);
		return driver.findElement(By.xpath(xpath));
	}

	/* News image */
	@FindBy(xpath = "//img[@alt='News']")
	private WebElement imgAbp;

	/* Wah cricket image */
	@FindBy(xpath = "//img[contains(@alt,'Wah cricket')]")
	private WebElement imgWahCricket;

	/* Articles text */
	@FindBy(xpath = "//div[@class='featured-stories']")
	private WebElement txtArticles;

	/* Team ranking text */
	@FindBy(xpath = "//h3[text()='TEAM RANKINGS']")
	private WebElement txtTeamRanking;

	/* Video text */
	@FindBy(xpath = "//h2[text()='Videos']/ancestor::div[@class='section-title']/following-sibling::div/descendant::div[@class='text']")
	private WebElement txtVideo;

	/* Video title */
	@FindBy(id = "videoTitleElement")
	private WebElement txtVideoTitle;

	/* Photo image */
	@FindBy(xpath = "//img[@class='card-img']/parent::div[@class='img-wrapper card-img img-4x3 h-100 card-top']")
	private WebElement imgPhoto;

	/* Photo article image */
	@FindBy(xpath = "//img[@class='article_feature _lLoad']")
	private WebElement imgPhotoArticle;

	/* Footer text */
	@FindBy(xpath = "//h2[text()='Sports']")
	private WebElement txtFooter;

	/* Footer */
	@FindBy(xpath = "//footer[@id='wah_footer_nav_bar_container']")
	private List<WebElement> tbFooter;

	/* Article title text */
	@FindBy(xpath = "//h1[@class='article-title ']")
	private WebElement txtCricketPageTitle;

	/**
	 * Description: This method is used to validate Cricket category is displayed.
	 * 
	 * @author Shivananda
	 * @param cricket
	 */
	public synchronized void validateCricketCategory(String cricket) {
		try {
			actionUtil.validateisElementDisplayed(links(cricket), "link", "Cricket category link is displayed",
					"Cricket category link is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Cricket category link is displayed");
			Assert.fail("Unable to validate Cricket category link is displayed");
		}
	}

	/**
	 * Description: This method is used to validate Cricket Page.
	 * 
	 * @author Shivananda
	 * 
	 */
	public synchronized void validateCricketPage() {
		try {
			actionUtil.validateUrl(BaseTest.prop_constants.getProperty("cricket_page_url"), "Cricket page url");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to naviget Cricket page");
			Assert.fail("Unable to naviget Cricket page");
		}
	}

	/**
	 * Description : This method is used to click on Home category.
	 * 
	 * @author Shivananda
	 * @param Home
	 */
	public synchronized void clkOnHomeCategory(String Home) {
		try {
			actionUtil.clickOnElement(links(Home), "Home link");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Home link");
			Assert.fail("Unable to click on Home link");
		}
	}

	/**
	 * Description: This method is used to validate Home Page.
	 * 
	 * @author Shivananda
	 * 
	 */
	public synchronized void validateHomePage() {
		try {
			actionUtil.validateUrl(BaseTest.prop_constants.getProperty("home_page_url"), "Home page url");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to navigate Home page");
			Assert.fail("Unable to navigate Home page");
		}
	}

	/**
	 * Description: This method is used to validate Wah cricket page.
	 * 
	 * @author Shivananda
	 * 
	 */
	public synchronized void validateWahcricketPage() {
		try {
			actionUtil.validateisElementDisplayed(imgWahCricket, "Wah cricket image", "Wah cricket page is displayed",
					"Wah cricket page is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Wah cricket page");
			Assert.fail("Unable to validate Wah cricket page");
		}
	}

	/**
	 * Description: This method is used to validate article section.
	 * 
	 * @author Shivananda
	 * 
	 */
	public synchronized void validateArticleSection() {
		try {
			actionUtil.validateisElementDisplayed(txtArticles, "Articles text", "Article text is displayed",
					"Article text is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Article text");
			Assert.fail("Unable to validate Article text");
		}
	}

	/**
	 * Description : This method is used to click on Article.
	 * 
	 * @author Shivananda
	 */
	public synchronized void clkOnArticle() {
		try {
			actionUtil.clickOnElement(txtArticles, "Article text");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Article text");
			Assert.fail("Unable to click on Article text");
		}
	}

	/**
	 * Description: This method is used to validate Team ranking text.
	 * 
	 * @author Shivananda
	 * 
	 */
	public synchronized void validateTeamRanking() {
		try {
			actionUtil.validateisElementDisplayed(txtTeamRanking, "Team ranking text", "Team ranking text is displayed",
					"Team ranking text is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Team ranking text");
			Assert.fail("Unable to validate Team ranking text");
		}
	}

	/**
	 * Description : This method is used to click on Video.
	 * 
	 * @author Shivananda
	 */
	public synchronized void clkOnVideo() {
		try {
			actionUtil.scrollToElement(txtVideo, "Video text");
			actionUtil.clickOnElement(txtVideo, "Video text");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Video text");
			Assert.fail("Unable to click on Video text");
		}
	}

	/**
	 * Description: This method is used to validate Video page.
	 * 
	 * @author Shivananda
	 * 
	 */
	public synchronized void validateVideoPage() {
		try {
			actionUtil.validateisElementDisplayed(txtVideoTitle, "Video title text", "Video title text is displayed",
					"Video title text is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Video title text");
			Assert.fail("Unable to validate Video title text");
		}
	}

	/**
	 * Description : This method is used to click on Photo.
	 * 
	 * @author Shivananda
	 */
	public synchronized void clkOnPhoto() {
		try {
			WebActionUtil.scrollDownByCoordinates();
			actionUtil.clickOnElement(imgPhoto, "Photo image");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Photo image");
			Assert.fail("Unable to click on Photo image");
		}
	}

	/**
	 * Description: This method is used to validate Photo page.
	 * 
	 * @author Shivananda
	 * 
	 */
	public synchronized void validatePhotoPage() {
		try {
			actionUtil.validateisElementDisplayed(imgPhotoArticle, "Photo article image",
					"Photo article image is displayed", "Photo article image is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Photo article image");
			Assert.fail("Unable to validate Photo article image");
		}
	}

	/**
	 * Description : This method is used to click on ViewMore.
	 * 
	 * @author Shivananda
	 * @param ViewMore
	 */
	public synchronized void clkOnViewMore(String ViewMore) {
		try {
			actionUtil.clickOnElement(links(ViewMore), "View more text");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on View more text");
			Assert.fail("Unable to click on View more text");
		}
	}

	/**
	 * Description: This method is used to validate View more page.
	 * 
	 * @author Shivananda
	 * @param News
	 * 
	 */
	public synchronized void validateViewMorePage(String News) {
		try {
			WebActionUtil.poll(2000);
			actionUtil.validateisElementDisplayed(txtHeader(News), "News text", "News text is displayed",
					"News text is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate News text");
			Assert.fail("Unable to validate News text");
		}
	}

	/**
	 * Description: This method is used to validate Schedule section.
	 * 
	 * @author Shivananda
	 * @param Schedule
	 * 
	 */
	public synchronized void validateSchedule(String Schedule) {
		try {
			actionUtil.scrollToElement(txtHeaderList(Schedule), "Schedule text");
			actionUtil.validateisElementDisplayed(txtHeaderList(Schedule), "Schedule text",
					"Schedule text is displayed", "Schedule text is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Schedule text");
			Assert.fail("Unable to validate Schedule text");
		}
	}

	/**
	 * Description: This method is used to validate Results section.
	 * 
	 * @author Shivananda
	 * @param Results
	 * 
	 *                t
	 */
	public synchronized void validateResults(String Results) {
		try {
			actionUtil.scrollToElement(txtHeaderList(Results), "Results text");
			actionUtil.validateisElementDisplayed(txtHeaderList(Results), "Results text", "Results text is displayed",
					"Results text is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Results text");
			Assert.fail("Unable to validate Results text");
		}
	}

	/**
	 * Description: This method is used to validate Latest news section.
	 * 
	 * @author Shivananda
	 * @param LatestNews
	 * 
	 */
	public synchronized void validateLatestNews(String LatestNews) {
		try {
			actionUtil.scrollToElement(txtHeader(LatestNews), "Latest news text");
			actionUtil.validateisElementDisplayed(txtHeader(LatestNews), "Latest news text",
					"Latest news text is displayed", "Latest news text is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Latest news text");
			Assert.fail("Unable to validate Latest news text");
		}
	}

	/**
	 * Description: This method is used to validate random Footer.
	 * 
	 * @author Shivananda
	 * 
	 */
	public synchronized void validateRandomFooter() {
		try {
			WebActionUtil.scrollDown();
			WebDriverWait wait = new WebDriverWait(driver, ETO);
			wait.until(ExpectedConditions.visibilityOfAllElements(tbFooter));
			WebActionUtil.validationinfo("Footer is displayed", "blue");
			WebActionUtil.info("Footer is displayed");
			actionUtil.clickOnElement(txtFooter, "Footer text");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Footer");
			Assert.fail("Unable to validate Footer");
		}
	}

	/**
	 * Description : This method is used to click on Cricket category.
	 * 
	 * @author Shivananda
	 * @param ViewMore
	 */
	public synchronized void clkOnCricketCategory(String cricketcategory) {
		try {
			actionUtil.clickOnElement(links(cricketcategory), "Cricket category text");
			actionUtil.switchToNewTab();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Cricket category text");
			Assert.fail("Unable to click on Cricket category text");
		}
	}

	/**
	 * Description: This method is used to validate Article section.
	 * 
	 * @author Shivananda
	 */
	public synchronized void validateArticlePage() {
		try {
			actionUtil.validateisElementDisplayed(txtCricketPageTitle, "Article title text",
					"Article title text is displayed", "Article title text is not displayed", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Article title text");
			Assert.fail("Unable to validate Article title text");
		}
	}
}
