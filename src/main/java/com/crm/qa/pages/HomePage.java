package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[@class='user-display']")
	WebElement displayName;

	@FindBy(xpath = "//div[@id='main-nav']//a[3]")
	WebElement contactsTab;

	@FindBy(xpath = "//div[@id='main-nav']//a[5]")
	WebElement dealsTab;

	@FindBy(xpath = "//div[@id='main-nav']//a[6]")
	WebElement taskTab;

	// Initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public String verifyHomePageTitle() {
		return driver.getTitle();

	}

	public boolean verifydisplayName() {
		return displayName.isDisplayed();

	}

	public ContactsPage clinkOnContactsTab() {
		contactsTab.click();
		return new ContactsPage();

	}

	public DealsPage clickOnDealsTab() {
		dealsTab.click();
		return new DealsPage();

	}

}
