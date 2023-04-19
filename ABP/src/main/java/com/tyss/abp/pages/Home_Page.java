package com.tyss.abp.pages;

import java.util.List;
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
 * Description This class has the implementations for Home Page.
 * 
 * @author Manikandan
 */
public class Home_Page {
	public WebDriver driver;
	public WebActionUtil actionUtil;
	public long ETO;

	public Home_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* Others dropdown link */
	@FindBy(xpath = "//a[contains(text(),'OTHERS')]")
	private WebElement lnkOthers;

	/* Tab Values */
	private WebElement headerTabName(String value) {
		String xpath = "//div[@class='uk-width-auto uk-text-center uk-margin-auto']//a/span[contains(text(),'" + value
				+ "')]";
		return driver.findElement(By.xpath(xpath));
	}

	/* Others dropdown link */
	@FindBy(xpath = "//div[@class='custom_menuitems _zindx _ipl_menu  d-flex']/span/a")
	private List<WebElement> lnkCategories;

	/* Others dropdown link */
	@FindBy(xpath = "//section[@class='fs-banner-area']/descendant::strong[text()='India']")
	private WebElement txtIndia;

	/* Sub Category Values */
	private List<WebElement> lnkSubCategory(String value) {
		String xpath = "//a[@title='" + value + "']/following-sibling::div/span/a";
		return driver.findElements(By.xpath(xpath));
	}

	/* Tab Values */
	private WebElement txtCategoryPage(String value) {
		String xpath = "//ul[@class='uk-breadcrumb']/descendant::span[contains(text(),'" + value
				+ "')] | //section[@class='pfBreadcrumb']/descendant::a[text()='" + value
				+ "'] | //ul[@class='uk-breadcrumb']/descendant::a[contains(text(),'" + value
				+ "')]| //div[@class='el-outer-wrap']/descendant::span[contains(text(),'" + value + "')]"
				+ "| //h1[contains(text(),'" + value + "')] | //li/a[contains(text(),'" + value + "')]|//li[text()='"
				+ value + "']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Others dropdown link */
	@FindBy(xpath = "//button[@id='allowNotification']")
	private WebElement btnAcceptAlert;

	/* Tab Values */
	private WebElement lnkCategory(String value) {

		String xpath = "//span/a[contains(text(),'" + value + "')] | //span/a[@title='" + value + "'] ";
		driver.manage().timeouts().implicitlyWait(BaseTest.ITO, TimeUnit.SECONDS);
		return driver.findElement(By.xpath(xpath));
	}
	
	/* OTHER Tab Values */
	private WebElement lnkOthers(String value) {
		String xpath = "//div[@class='uk-dropdown uk-dropdown-bottom-right uk-open uk-animation-fade uk-animation-enter']//a[contains(text(),'"
				+ value + "')]";
		return driver.findElement(By.xpath(xpath));
	}

	/* DNPA text */
	@FindBy(xpath = "//a[@title='Tv Shows']")
	private WebElement txtDNPA;

	/* Others dropdown link */
	@FindBy(xpath = "//div")
	private WebElement imgAd;

	/* Tab Values */
	private WebElement txtPageHeader(String value) {
		String xpath = "//ul[@class='uk-breadcrumb']/li/a[contains(text(),'" + value + "')]";
		return driver.findElement(By.xpath(xpath));
	}

	/* Search text box */
	@FindBy(xpath = "//input[@id='search_box_id']")
	private WebElement tbSearch;

	/* Search icon */
	@FindBy(xpath = "//i[@class='abp-icon abpi-search']")
	private WebElement icnSearch;

	/* Search button */
	@FindBy(xpath = "//button[text()='Search']")
	private WebElement btnSearch;

	/* Default Search field */
	@FindBy(xpath = "//div[@class='uk-search uk-search-default']")
	private WebElement tbDefaultSearch;

	/* Select Language link */
	@FindBy(xpath = "//span[text()='Select Language']")
	private WebElement selectLangDdn;

	/* Hindi link */
	@FindBy(xpath = "//a/span[text()='हिन्दी']")
	private WebElement hindiDdn;

	/* Home page */
	@FindBy(xpath = "//a[text()='HOME']")
	private WebElement lnkHome;

	/* Taboola logo */
	@FindBy(xpath = "//div[@class='tbl-feed-header-logo']")
	private WebElement lnkTaboolaFeedLogo;

	/* Select Language drop down */
	@FindBy(xpath = "//span[@class='uk-display-block _hlang']")
	private WebElement txtSelectLanguage;

	/* language dropdown values */
	private WebElement txtLanguage(String languageText) {
		String xpath = "//a[@title='" + languageText + "']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Uncut image */
	@FindBy(xpath = "//img[@alt='Logo']")
	private WebElement imgUncut;

	/* Uncut image */
	@FindBy(xpath = "//div[@class='uk-visible@s uk-background-muted']/descendant::a[@class='brand-logo']")
	private WebElement imgIdeasLogo;

	/* Share Icon */
	private WebElement icnShare(String value) {
		String xpath = "//span/a[@title='" + value + "']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Twitter page */
	@FindBy(xpath = "//input[@placeholder='Search Twitter']")
	private WebElement tbTwitter;

	/* Facebook page */
	@FindBy(xpath = "//div[@class='x6s0dn4 x78zum5 x47corl xh8yej3 x10l6tqk xzkaem6']")
	private WebElement imgFacebook;

	/* Youtube page */
	@FindBy(xpath = "//div[@id='container']/descendant::div[@class='style-scope ytd-topbar-logo-renderer']/descendant::yt-icon[@id='logo-icon']")
	private WebElement imgYoutube;

	/* Gaming Header */
	@FindBy(xpath = "//h1[text()='Free Online Games']")
	private WebElement txtGamingHeader;

	/*Article link*/
	@FindBy(xpath = "//p[contains(text(),'LIVE')]/ancestor::div[@class='_tHome']/descendant::div[@class='uk-grid-collapse uk-grid']")
	private List<WebElement> lnkArticle;

	/* Article text */
	@FindBy(xpath = "//h1[@class='article-title ']")
	private WebElement txtArticle;

	/* Footers link */
	private WebElement lnkFooters(String footerLink) {
		String xpath = "//span[normalize-space()='" + footerLink + "']";
		return driver.findElement(By.xpath(xpath));
	}

	/* Alphabet link */
	@FindBy(xpath = "//a[text()='D']")
	private WebElement lnkAlphabet;

	/* View All Button */
	private WebElement btnViewAll(String sectionType) {
		String xpath = "//h2[text()='" + sectionType + "']/parent::a/following-sibling::div/a[text()='View All ']";
		return driver.findElement(By.xpath(xpath));
	}
	
	/* Searched text */
	@FindBy(xpath = "//div[@class='topic_featured uk-padding-small']/div/h1")
	private WebElement txtSearched;

	/* Alphabet text */
	@FindBy(xpath = "//ul[@class='uk-list uk-width-1-3'][1]/li/a")
	private WebElement txtAlphabetLink;
	
	/* Topic text */
	@FindBy(xpath = "//a[text()='Topic']")
	private WebElement txtTopic;
	
	/* Alphabet tab */
	@FindBy(xpath = "//a[@class='uk-flex uk-flex-center uk-flex-middle active']")
	private WebElement tabAlphabet;

	/**
	 * Description : This method implements click on Header
	 * 
	 * @param header
	 * @author Manikandan A
	 */
	public synchronized void clkOnHeader(String header) {
		try {
			actionUtil.actionClick(headerTabName(header), header);

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on " + header);
			Assert.fail("Unable to perform action on " + header);
		}
	}

	/**
	 * Description : This method implements to validate Home page
	 * 
	 * @author Manikandan A
	 */
	public synchronized void validateHomePage() {
		try {
			actionUtil.validateisElementDisplayed(lnkHome, "Home page", "Home page is displayed",
					"Home page is not displayed", "green");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate the Home page");
			Assert.fail("Unable to validate the Home page");
		}
	}

	/**
	 * Description : This method implements to select Language
	 * 
	 * @author Manikandan A
	 */
	public synchronized void setLanguage() {
		try {
			actionUtil.actionMouseOver(selectLangDdn, "Select Language dropdown");
			actionUtil.clickOnElement(hindiDdn, "Hindi Language");
			actionUtil.getText(selectLangDdn, "Hindi Language");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to select langauge from dropdown");
			Assert.fail("Unable to select langauge from dropdown");
		}
	}

	/**
	 * Description : This method implements Type text in search field
	 * 
	 * @author Manikandan A
	 * @param value
	 */
	public synchronized void setSearch(String value) {
		try {
			actionUtil.clickOnElement(icnSearch, "Search Icon");
			actionUtil.typeText(tbSearch, value, "Search text field");
			actionUtil.clickOnElementUsingJS(btnSearch, "Search Button");
			String searchValue = actionUtil.getText(tbDefaultSearch, "Search value");
			actionUtil.validateisElementDisplayed(tbDefaultSearch, "Default Search page",
					"Searched value " + searchValue + " is displayed with the content",
					"Searched value " + searchValue + " is not displayed with the content", "green");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to set value in search text field");
			Assert.fail("Unable to set value in search text field");
		}
	}

	/**
	 * Description : This method used for mouse over to select language drop down
	 * 
	 * @author Manjappa
	 */
	public synchronized void mouseMoveOnSelectLanguageDropdown() {
		try {
			actionUtil.mouseHoverToContextClick(txtSelectLanguage);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to mouse hover to select language");
			Assert.fail("Unable to mouse hover to select language");
		}
	}

	/**
	 * Description : This method used to validate language
	 * 
	 * @author Manjappa
	 * @param language
	 */
	public synchronized void validateLanguage(String language) {
		try {
			actionUtil.switchToNewTab();
			actionUtil.validateisElementDisplayed(txtLanguage(language), "Language text",
					"Able to validate "+language+" Language text", "Unable to validate "+language+" Language text", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate "+language+" Language text");
			Assert.fail("Unable to validate "+language+" Language text");
		}
	}

	/**
	 * Description : This method used to select the values from OTHERS tab dropdown
	 * 
	 * @author Manikandan
	 * @param value
	 */
	public synchronized void sltOthersTab(String value) {
		try {
			actionUtil.actionMouseOver(lnkOthers, value + " tab");
			actionUtil.clickOnElement(lnkOthers(value), value + " from OTHERS dropdown");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perfom action on " + value);
			Assert.fail("Unable to perfom action on " + value);
		}
	}

	/**
	 * Description : This method used to click and validate categories link
	 * 
	 * @author Manikandan
	 * @param value
	 */
	public synchronized void clickAndValidateCategories() {
		try {

			for (int i = 0; i < lnkCategories.size(); i++) {
				if (lnkCategories.get(i).getText().equalsIgnoreCase("NEWS")) {
					String category = lnkCategories.get(i).getText();
					System.out.println(category);
					actionUtil.clickOnElement(lnkCategory(category), category + " category");
					for (int j = 0; j < lnkSubCategory(category).size(); j++) {
						actionUtil.actionMouseOver(lnkCategories.get(i), "News Category");
						String lnkText = lnkSubCategory(category).get(j).getText();
						actionUtil.clickOnElement(lnkSubCategory(category).get(j), lnkText + " sub Category");
						actionUtil.validateisElementDisplayed(txtCategoryPage(lnkText), lnkText + " page",
								lnkText + " page is displayed", lnkText + " page is not displayed", "green");

					}

				} else if (lnkCategories.get(i).getAttribute("title").equalsIgnoreCase("INDIA AT 2047")) {
					String category = lnkCategories.get(i).getAttribute("title");
					actionUtil.clickOnElement(lnkCategory(category), category + " category");
					actionUtil.validateisElementDisplayed(txtIndia, "India page", "India page is displayed",
							"India page is not displayed", "green");
					driver.navigate().to("https://news.abplive.com/");
				} else if (lnkCategories.get(i).getAttribute("title").equalsIgnoreCase("UNCUT")) {
					String category = lnkCategories.get(i).getAttribute("title");
					actionUtil.clickOnElement(lnkCategory(category), category + " category");
					actionUtil.validateisElementDisplayed(imgUncut, "Uncut image", "Uncut page is displayed",
							"Uncut page is not displayed", "blue");
					driver.navigate().to("https://news.abplive.com/");
				} else if (lnkCategories.get(i).getAttribute("title").equalsIgnoreCase("IDEAS OF INDIA")) {
					String category = lnkCategories.get(i).getAttribute("title");
					actionUtil.clickOnElement(lnkCategory(category), category + " category");
					actionUtil.switchToNewTab();
					actionUtil.validateisElementDisplayed(imgIdeasLogo, "Ideas of India Logo",
							"Ideas of India Logo is displayed", "Ideas of India Logo is not displayed", "blue");
					actionUtil.switchToMainTab();
					driver.navigate().to("https://news.abplive.com/");
				} else if (lnkCategories.get(i).getText().equalsIgnoreCase("BUSINESS")) {
					String category = lnkCategories.get(i).getText();
					actionUtil.clickOnElement(lnkCategory(category), category + " category");

					for (int j = 0; j < lnkSubCategory(category).size(); j++) {
						actionUtil.actionMouseOver(lnkCategories.get(i), "News Category");
						String lnkText = lnkSubCategory(category).get(j).getText();
						actionUtil.clickOnElement(lnkSubCategory(category).get(j), lnkText + " sub Category");
						if (lnkText.contains("Crypto")) {
							actionUtil.validateisElementDisplayed(txtCategoryPage("Crypto"), lnkText + " page",
									lnkText + " page is displayed", lnkText + " page is not displayed", "green");
						} else if (lnkText.contains("Personal Finance")) {
							actionUtil.validateisElementDisplayed(txtCategoryPage("Personal finance"),
									lnkText + " page", lnkText + " page is displayed",
									lnkText + " page is not displayed", "green");
						} else {
							actionUtil.validateisElementDisplayed(txtCategoryPage(lnkText), lnkText + " page",
									lnkText + " page is displayed", lnkText + " page is not displayed", "green");
						}
						driver.navigate().to("https://news.abplive.com/");
					}

				} else if (lnkCategories.get(i).getText().equalsIgnoreCase("SCI & TECH")) {
					String category = lnkCategories.get(i).getText();
					actionUtil.clickOnElement(lnkCategory(category), category + " category");

					for (int j = 0; j < lnkSubCategory(category).size(); j++) {
						actionUtil.actionMouseOver(lnkCategories.get(i), "News Category");
						String lnkText = lnkSubCategory(category).get(j).getText();
						actionUtil.clickOnElement(lnkSubCategory(category).get(j), lnkText + " sub Category");
						actionUtil.validateisElementDisplayed(txtCategoryPage(lnkText), lnkText + " page",
								lnkText + " page is displayed", lnkText + " page is not displayed", "green");

					}

				} else if (lnkCategories.get(i).getText().equalsIgnoreCase("OTHERS")) {
					String category = lnkCategories.get(i).getText();
					actionUtil.clickOnElement(lnkCategory(category), category + " category");

					for (int j = 0; j < lnkSubCategory(category).size(); j++) {
						actionUtil.actionMouseOver(lnkCategories.get(i), "OTHERS Category");
						String lnkText = lnkSubCategory(category).get(j).getText();

						actionUtil.clickOnElement(lnkSubCategory(category).get(j), lnkText + " sub Category");
						if (lnkText.equalsIgnoreCase("Web Stories")) {
							lnkText = lnkText.toUpperCase();
							actionUtil.validateisElementDisplayed(txtCategoryPage(lnkText), lnkText + " page",
									lnkText + " page is displayed", lnkText + " page is not displayed", "green");
						} else if (lnkText.contains("Photo")) {
							lnkText = "Photo Gallery";
							actionUtil.validateisElementDisplayed(txtCategoryPage(lnkText), lnkText + " page",
									lnkText + " page is displayed", lnkText + " page is not displayed", "green");
						} else if (lnkText.equalsIgnoreCase("Cricket")) {
							lnkText = lnkText.toUpperCase();
							actionUtil.switchToNewTab();
							actionUtil.validateisElementDisplayed(txtCategoryPage(lnkText), lnkText + " page",
									lnkText + " page is displayed", lnkText + " page is not displayed", "green");
							actionUtil.switchToMainTab();
						} else if (lnkText.equalsIgnoreCase("PIN Code Finder")) {
							actionUtil.switchToNewTab();
							actionUtil.clickOnElement(btnAcceptAlert, "Accept Alert");
							actionUtil.validateisElementDisplayed(txtCategoryPage(lnkText), lnkText + " page",
									lnkText + " page is displayed", lnkText + " page is not displayed", "green");
							actionUtil.switchToMainTab();
						} else if (lnkText.equalsIgnoreCase("Latest Mobile Phones")) {
							lnkText = "Mobile";
							actionUtil.validateisElementDisplayed(txtCategoryPage(lnkText), lnkText + " page",
									lnkText + " page is displayed", lnkText + " page is not displayed", "green");
							driver.navigate().to("https://news.abplive.com/");

						} else if (lnkText.contains("IFSC")) {
							lnkText = "IFSC Finder";
							actionUtil.switchToNewTab();
							actionUtil.validateisElementDisplayed(txtCategoryPage(lnkText), lnkText + " page",
									lnkText + " page is displayed", lnkText + " page is not displayed", "green");
							actionUtil.switchToMainTab();
						} else if (lnkText.contains("Utility")) {
							lnkText = "Utility Tools";
							actionUtil.switchToNewTab();
							actionUtil.validateisElementDisplayed(txtCategoryPage(lnkText), lnkText + " page",
									lnkText + " page is displayed", lnkText + " page is not displayed", "green");
							actionUtil.switchToMainTab();
						} else {
							actionUtil.validateisElementDisplayed(txtCategoryPage(lnkText), lnkText + " page",
									lnkText + " page is displayed", lnkText + " page is not displayed", "green");
						}
					}
				} else {
					actionUtil.clickOnElement(lnkCategories.get(i), "Category");
				}
				driver.manage().timeouts().implicitlyWait(BaseTest.pageLoadTimeout, TimeUnit.SECONDS);
			}

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform and validate the categories");
			Assert.fail("Unable to perform and validate the categories");
		}
	}

	/**
	 * Description : This method implements click and validate Share icon
	 * 
	 * @param header
	 * @author Manikandan A
	 */
	public synchronized void clkOnShareIcn(String header) {
		try {
			WebActionUtil.poll(3000);
			actionUtil.clickOnElement(icnShare(header), header + " share icon");
			if (header.contains("Facebook")) {
				actionUtil.switchToNewTab();
				actionUtil.validateisElementDisplayed(imgFacebook, "Facebook page", "Facebook Page is displayed",
						"Facebook Page is not displayed", "green");
				actionUtil.switchToMainTab();
			} else if (header.contains("Twitter")) {
				actionUtil.switchToNewTab();
				actionUtil.validateisElementDisplayed(tbTwitter, "Twitter page", "Twitter Page is displayed",
						"Twitter Page is not displayed", "green");
				actionUtil.switchToMainTab();
			} else if (header.contains("Youtube")) {
				actionUtil.switchToNewTab();
				actionUtil.validateisElementDisplayed(imgYoutube, "Youtube page", "Youtube Page is displayed",
						"Youtube Page is not displayed", "green");
				actionUtil.switchToMainTab();
			}

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to perform action on " + header);
			Assert.fail("Unable to perform action on " + header);
		}
	}

	/**
	 * Description : This method implements to validate the page
	 * 
	 * @param value
	 * @author Manikandan A
	 */
	public synchronized void validatePage(String value) {

		try {
			if (value.contains("Games")) {
				actionUtil.switchToNewTab();
				actionUtil.validateisElementDisplayed(txtGamingHeader, value + " page", value + " page is displayed",
						value + " page is not displayed", "green");
				actionUtil.switchToMainTab();
			} else {
				actionUtil.validateisElementDisplayed(txtPageHeader(value), value + " page",
						value + " page is displayed", value + " page is not displayed", "green");
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate " + value + " page");
			Assert.fail("Unable to validate " + value + " page");
		}

	}

	/**
	 * Description : This method used for click on article link
	 * 
	 * @author Manjappa
	 */
	public synchronized void clkonArticlelnk() {
		try {
			for (int i = 0; i < lnkArticle.size(); i++) {
				if (i == 6) {
					actionUtil.clickOnElement(lnkArticle.get(i), "Article link");
				}
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click  on Article link");
			Assert.fail("Unable to click  on Article link");
		}
	}

	/**
	 * Description : This method used to validate Article consumption page
	 * 
	 * @author Manjappa
	 */
	public synchronized void validateArticleConsumptionPage() {
		try {
			actionUtil.validateisElementDisplayed(txtArticle, "Article hedline text",
					"Able to validate Article consumption page text",
					"Unable to validate Article consumption page text", "green");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Article consumption page text");
			Assert.fail("Unable to validate Article consumption page text");
		}
	}

	/**
	 * Description : This method used to move cursor on OTHERS tab dropdown.
	 * 
	 * @author Manikandan
	 * @param value
	 */

	public synchronized void moveCursorOnOthers() {
		try {
			actionUtil.actionMouseOver(lnkOthers, "Others tab dropdown");

		} catch (Exception e) {

			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to move cursor on Others tab dropdown");
			Assert.fail("Unable to move cursor on Others tab dropdown");
		}

	}

	/**
	 * Description : This method used to validate Taboola feed logo
	 * 
	 * @author Manikandan
	 * @param value
	 */
	public synchronized void navigateTo() {
		try {

			driver.navigate().to("https://news.abplive.com/topic");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Taboola feed Logo");
			Assert.fail("Unable to validate Taboola feed Logo");
		}
	}

	/**
	 * Description: Method used to click on Alphabet link
	 * 
	 * @author Sreelatha
	 */
	public synchronized void clickOnAlphabetLink() {

		try {
			actionUtil.clickOnElement(lnkAlphabet, "Alphabets link");
			actionUtil.info("Able to click on Alphabets link");
			actionUtil.validationinfo("Able to click on Alphabets link", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Alphabets link");
			Assert.fail("Unable to click on Alphabets link");

		}

	}

	/**
	 * Description : This method used to validate Searched Alphabet is displayed
	 * 
	 * @author Sreelatha
	 */
	public synchronized void validateSearchedAlphabet() {
		try {
			actionUtil.validateisElementDisplayed(txtAlphabetLink, "Alphabet text", "Able to validate Alphabet text",
					"Unable to validate Alphabet text", "green");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Alphabet text");
			Assert.fail("Unable to validate Alphabet text");
		}
	}

	/**
	 * Description: Method used to click on searched Alphabet
	 * 
	 * @author Sreelatha
	 */
	public synchronized void clickOnSearchedAlphabet() {

		try {
			actionUtil.clickOnElement(txtAlphabetLink, "Alphabet text");
			WebActionUtil.info("Able to click on Alphabet text");
			WebActionUtil.validationinfo("Able to click on Alphabet text", "blue");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on Alphabet text");
			Assert.fail("Unable to click on Alphabet text");

		}

	}

	/**
	 * Description : This method used to validate Topic page
	 * 
	 * @author Sreelatha
	 */
	public synchronized void validateTopicPage() {
		try {
			actionUtil.validateisElementDisplayed(txtTopic, "Topic text", " Topic page is displayed",
					"Topic page is not displayed", "green");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Topic page is not displayed");
			Assert.fail("Topic page is not displayed");
		}
	}

	/**
	 * Description : This method used to validate A is selected by default
	 * 
	 * @author Sreelatha
	 */
	public synchronized void validateASelectedByDefault() {
		try {
			if (tabAlphabet.getAttribute("class").contains("active"))
				actionUtil.validateisElementDisplayed(tabAlphabet, "Alphabet tab", " Alphabet A is selected by default",
						"Alphabet A is not selected by default", "green");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Alphabet A is not selected by default");
			Assert.fail("Alphabet A is not selected by default");
		}
	}

	/**
	 * Description : This method used to validate Searched Alphabet page.
	 * 
	 * @author Sreelatha
	 */
	public synchronized void validateSearchedAlphabetPage() {
		try {
			String value1 = txtAlphabetLink.getText();
			clickOnSearchedAlphabet();
			actionUtil.waitForPageToLoad();
			String value2 = txtSearched.getText();
			if (value1.equalsIgnoreCase(value2)) {
				actionUtil.info("Searched Alphabet page is displayed");
				actionUtil.validationinfo("Searched Alphabet page is displayed", "blue");
			}
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Searched Alphabet page is not displayed");
			Assert.fail("Searched Alphabet page is not displayed");
		}
	}

	/**
	 * Description : This method implements to validate Ad
	 * 
	 * @author Manikandan A
	 */
	public synchronized void validateAd() {

		try {
			driver.switchTo().frame(0);
			try {
				actionUtil.validateisElementDisplayed(imgAd, "Ads", "Ads is displayed", "Ads is not displayed",
						"green");
			} catch (Exception e) {
				driver.switchTo().frame(0);
				actionUtil.validateisElementDisplayed(imgAd, "Ads", "Ads is displayed", "Ads is not displayed",
						"green");
			}
			actionUtil.poll(5000);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate the Ads");
			Assert.fail("Unable to validate the Ads");
		}
	}

	/**
	 * Description : This method used to scroll and validate Taboola logo
	 * 
	 * @author Manikandan
	 */
	public synchronized void scrollAndValidateTaboolaLogo() {
		try {

			actionUtil.scrollToElement(txtDNPA, "Taboola Feed Logo");
			Thread.sleep(5000l);
			actionUtil.validateisElementDisplayed(lnkTaboolaFeedLogo, "Taboola Feed Logo",
					"Taboola Feed Logo is displayed", "Taboola Feed Logo is not displayed", "green");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Taboola feed Logo");
			Assert.fail("Unable to validate Taboola feed Logo");
		}
	}

	/**
	 * 
	 * Description: Method used to click on View All button.
	 * 
	 * @author Sushmita P H
	 * @param sectionType
	 */
	public synchronized void clickOnViewAll(String sectionType) {
		try {
			WebActionUtil.scrollDownByCoordinates();
			actionUtil.waitForElement(btnViewAll(sectionType), "View All button");
			actionUtil.clickOnElement(btnViewAll(sectionType), "View All button");
			actionUtil.info("Able to click on View All button");
			actionUtil.validationinfo("Able to click on View All button", "blue");
			actionUtil.poll(2000);
			actionUtil.switchToNewTab();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on View All button");
			Assert.fail("Unable to click on View All button");
		}
	}

	/**
	 * Description: This method is used to click on Footer link.
	 * 
	 * @author SreeLatha
	 * @param footerLink
	 */
	public synchronized void clkFooterLink(String footerLink) {
		try {

			actionUtil.clickOnElement(lnkFooters(footerLink), "Footers link");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.error("Unable to perform action on " + footerLink + "link");
			WebActionUtil.fail("Unable to perform action on " + footerLink + "link");
			Assert.fail("Unable to perform action on " + footerLink + "link");
		}

	}

}