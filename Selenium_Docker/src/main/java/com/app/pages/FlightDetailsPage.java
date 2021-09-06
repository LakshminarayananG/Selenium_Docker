package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(id="reserveFlights")
	private WebElement flightContinue;
	
	@FindBy(id="buyFlights")
	private WebElement buyFlight;
	
	public FlightDetailsPage(WebDriver driver) {		
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickContinue() {
		this.wait.until(ExpectedConditions.elementToBeClickable(flightContinue));
		this.flightContinue.click();
	}
	
	public void navigateToConfirmationPage() {
		this.wait.until(ExpectedConditions.elementToBeClickable(buyFlight));
		this.buyFlight.click();
	}
	
	
	
	
	
	
	
	

}
