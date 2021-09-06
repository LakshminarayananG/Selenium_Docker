package com.app.booking.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.util.Assert;

public class OrderConfirmationPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//font[contains(text(),'Flight Confirmation ')]")
	private WebElement flightConfirmation;

	@FindBy(xpath = "//font[contains(text(),'USD')]")
	private List<WebElement> prices;

	@FindBy(id = "sign-on")
	private WebElement signOff;

	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public String validateConfirmationPage() {
		this.wait.until(ExpectedConditions.visibilityOf(flightConfirmation));

		System.out.println("Flight Confirmation Details are as follows: " + this.flightConfirmation.getText());
		System.out.println("The total price is: " + this.prices.get(1).getText());
		String price = this.prices.get(1).getText();
		return price;
	}

	public void clickSignOff() {
		this.signOff.click();
	}

}
