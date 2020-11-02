package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// PageFactories Object Repo:

	@FindBy(name = "email")
	@CacheLookup
	WebElement email;

	@FindBy(name = "password")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	@CacheLookup
	WebElement loginBtn;

	// Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();

	}

	public HomePage login(String em, String pwd) {

		email.sendKeys(em);
		password.sendKeys(pwd);
		loginBtn.click();

		return new HomePage();
	}

}
