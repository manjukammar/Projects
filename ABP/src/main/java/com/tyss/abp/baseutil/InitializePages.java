package com.tyss.abp.baseutil;

import org.openqa.selenium.WebDriver;

import com.tyss.abp.pages.Article_Page;
import com.tyss.abp.pages.Cricket_Page;
import com.tyss.abp.pages.Footer_Page;
import com.tyss.abp.pages.Home_Page;
import com.tyss.abp.pages.LiveTv_Page;
import com.tyss.abp.pages.LiveTv_Shows_Page;
import com.tyss.abp.pages.Photo_Gallery_Page;
import com.tyss.abp.pages.Podcast_Page;
import com.tyss.abp.pages.Videos_Page;
import com.tyss.abp.util.WebActionUtil;

/**
 * Description Initialize all pages with driver,ETO, WebAactionUtil
 * 
 * @author Manikandan A
 * 
 */

public class InitializePages {
	public Home_Page homePage;
	public LiveTv_Shows_Page liveTvShowsPage;
	public Article_Page articlePage;
	public Footer_Page footerPage;
	public LiveTv_Page liveTvPage;
	public Photo_Gallery_Page photoGalleryPage;
	public Podcast_Page podCastPage;
	public Cricket_Page cricketPage;
	public Videos_Page videosPage;

	public InitializePages(WebDriver driver, long ETO, WebActionUtil actionUtil) {
		homePage = new Home_Page(driver, ETO, actionUtil);
		liveTvShowsPage=new LiveTv_Shows_Page(driver, ETO, actionUtil);
		articlePage=new Article_Page(driver, ETO, actionUtil);
		footerPage=new Footer_Page(driver, ETO, actionUtil);
		videosPage=new Videos_Page(driver, ETO, actionUtil);
		liveTvPage=new LiveTv_Page(driver, ETO, actionUtil);
		photoGalleryPage=new Photo_Gallery_Page(driver, ETO, actionUtil);
		podCastPage=new Podcast_Page(driver, ETO, actionUtil);
		cricketPage=new Cricket_Page(driver, ETO, actionUtil);
	}

}
