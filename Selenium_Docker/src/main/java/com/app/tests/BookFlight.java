package com.app.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.pages.FlightDetailsPage;
import com.app.pages.FlightsPage;
import com.app.pages.OrderConfirmationPage;
import com.app.pages.RegistrationConfirmationPage;
import com.app.pages.RegistrationPage;

public class BookFlight {
	
	private WebDriver driver;
	
	
	@BeforeTest
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver", "C://Users//admin//Downloads//chromedriver_win32//chromedriver.exe");				
		this.driver= new ChromeDriver();
	}
	
	
	@Test
	public void registrationPageTest() {
		RegistrationPage regpage= new RegistrationPage(driver);
		regpage.launchApp();
		regpage.enterUserDetails("Lakshmi", "test");
		regpage.enterUserCreds("Lakshmi", "Narayanan");
		regpage.submit();
	}
	
	
	@Test(dependsOnMethods = "registrationPageTest")
	public void registrationConfirmationPage() {
		RegistrationConfirmationPage regconfpage = new RegistrationConfirmationPage(driver);
		regconfpage.navigateToFlightsPage();
	}
	
	
	@Test(dependsOnMethods = "registrationConfirmationPage")
	public void flightDetailsPage() {
		FlightsPage flightpage = new FlightsPage(driver);
		flightpage.selectPassengers("2");
		flightpage.navigateToFlightsDetailsPage();
	}
	
	@Test(dependsOnMethods = "flightDetailsPage")
	public void findFlightsPage() {
		FlightDetailsPage flightdetpage = new FlightDetailsPage(driver);
		flightdetpage.clickContinue();
		flightdetpage.navigateToConfirmationPage();
	}
	
	@Test(dependsOnMethods = "findFlightsPage")
	public void confirmationPage() {
		OrderConfirmationPage orderpage = new OrderConfirmationPage(driver);
		orderpage.validateConfirmationPage();
		orderpage.clickSignOff();
	}
	
	
	@AfterTest
	public void tearDown() {
		this.driver.quit();
	}

}
