package com.app.search.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.app.baseTest.BaseTest;
import com.app.search.pages.SearchPage;

public class SearchTest extends BaseTest {

	@Test
	@Parameters({ "keyword" })
	public void searchPage(String keyword) {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.launchsearchApp();
		searchPage.doSearch(keyword);
		searchPage.goToVideos();
		int totalsearchResults = searchPage.getResult();
		Assert.assertTrue(totalsearchResults > 0);
	}

}
