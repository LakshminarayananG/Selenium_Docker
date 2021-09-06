package com.app.booking.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.app.booking.pages.FlightDetailsPage;
import com.app.booking.pages.FlightsPage;
import com.app.booking.pages.OrderConfirmationPage;
import com.app.booking.pages.RegistrationConfirmationPage;
import com.app.booking.pages.RegistrationPage;

public class BookFlight {
	
	private WebDriver driver;
	private String noOfPassengers;
	private String expectedPrice;
	
	@BeforeTest
	@Parameters({"noOfPassengers","expectedPrice"})
	public void setupDriver(String noOfPassengers,String expectedPrice) {
		this.noOfPassengers=noOfPassengers;
		this.expectedPrice=expectedPrice;
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
		flightpage.selectPassengers(noOfPassengers);
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
		String price=orderpage.validateConfirmationPage();
		Assert.assertEquals(price, expectedPrice);
		orderpage.clickSignOff();
	}
	
	
	@AfterTest
	public void tearDown() {
		this.driver.quit();
	}

}
