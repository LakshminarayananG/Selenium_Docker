package com.app.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "passCount")
	private WebElement passengers;

	@FindBy(id = "findFlights")
	private WebElement findFlights;

	public FlightsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public void selectPassengers(String numberofPass) {
		this.wait.until(ExpectedConditions.elementToBeClickable(passengers));
		Select select = new Select(passengers);
		select.selectByValue(numberofPass);

	}

	public void navigateToFlightsDetailsPage() {
		this.findFlights.click();
	}

}
