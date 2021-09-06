package com.app.booking.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.app.baseTest.BaseTest;
import com.app.booking.pages.FlightDetailsPage;
import com.app.booking.pages.FlightsPage;
import com.app.booking.pages.OrderConfirmationPage;
import com.app.booking.pages.RegistrationConfirmationPage;
import com.app.booking.pages.RegistrationPage;

public class BookFlight extends BaseTest {

	private String noOfPassengers;
	private String expectedPrice;

	@Test
	@Parameters({ "noOfPassengers", "expectedPrice" })
	public void registrationPageTest(String noOfPassengers, String expectedPrice) {
		this.noOfPassengers = noOfPassengers;
		this.expectedPrice = expectedPrice;
		RegistrationPage regpage = new RegistrationPage(driver);
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
		String price = orderpage.validateConfirmationPage();
		Assert.assertEquals(price, expectedPrice);
		orderpage.clickSignOff();
	}

}
