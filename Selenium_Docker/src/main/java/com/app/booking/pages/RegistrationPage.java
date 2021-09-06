package com.app.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name = "firstName")
	private WebElement firstNameTxt;

	@FindBy(name = "lastName")
	private WebElement lastNameTxt;

	@FindBy(id = "email")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement passwordTxt;

	@FindBy(name = "confirmPassword")
	private WebElement confirmPassTxt;

	@FindBy(id = "register-btn")
	private WebElement submitBtn;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public void launchApp() {
		this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
		this.driver.manage().window().maximize();
		this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));
	}

	public void enterUserDetails(String firstName, String lastName) {
		this.firstNameTxt.sendKeys(firstName);
		this.lastNameTxt.sendKeys(lastName);
	}

	public void enterUserCreds(String username, String password) {
		this.userName.sendKeys(username);
		this.passwordTxt.sendKeys(password);
		this.confirmPassTxt.sendKeys(password);
	}

	public void submit() {
		this.submitBtn.click();
	}

}
