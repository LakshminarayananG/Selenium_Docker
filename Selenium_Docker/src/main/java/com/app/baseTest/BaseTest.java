package com.app.baseTest;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	protected WebDriver driver;

	@BeforeTest
	public void setupDriver() throws MalformedURLException {

		// BROWSER => chrome / firefox
		// HUB_HOST => localhost / hostname

		String host = "localhost";
		DesiredCapabilities dc = DesiredCapabilities.chrome();

		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			dc = DesiredCapabilities.firefox();
		}

		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}

		String completeURL = "http://" + host + ":4444/wd/hub";
		this.driver = new RemoteWebDriver(new URL(completeURL), dc);
	}

	@AfterTest
	public void tearDown() {
		this.driver.quit();
	}

}
