package com.app.search.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.app.search.pages.SearchPage;

public class SearchTest {

	private WebDriver driver;
	
	@BeforeTest
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver", "C://Users//admin//Downloads//chromedriver_win32//chromedriver.exe");				
		this.driver= new ChromeDriver();
	}
	
	
	@Test
	@Parameters({"keyword"})
	public void searchPage(String keyword) {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.launchsearchApp();
		searchPage.doSearch(keyword);
		searchPage.goToVideos();
		int totalsearchResults=searchPage.getResult();
		Assert.assertTrue(totalsearchResults > 0);
	}
	
	
	@AfterTest
	public void tearDown() {
		this.driver.quit();
	}

	
}
