package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[@id='main-nav']//a[3]")
	@CacheLookup
	WebElement contactsTab;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	@CacheLookup
	WebElement contactsdisplayName;

	@FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]/button[1]")
	@CacheLookup
	WebElement newContactBtn;

	@FindBy(xpath = "//input[@name='first_name']")
	@CacheLookup
	WebElement firstName;

	@FindBy(xpath = "//input[@name='last_name']")
	@CacheLookup
	WebElement lastName;

	@FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/input[1]")
	@CacheLookup
	WebElement companyFalse;
	
	
	@FindBy(xpath = "//div[@name='company' and @aria-expanded='true']")
	@CacheLookup
	WebElement companyTrue;

	@FindBy(xpath = "//input[@placeholder='Email address']")
	@CacheLookup
	WebElement email;

	@FindBy(xpath = "//button[@class='ui linkedin button']")
	@CacheLookup
	WebElement saveBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);

	}

	public boolean verifyContactPageLabel() {

		return contactsdisplayName.isDisplayed();
	}

	public void newContactLink() {

		newContactBtn.click();

	}

	public void createNewContact(String firstname, String lastname, String comp, String mail) {

	 firstName.sendKeys(firstname);
	 lastName.sendKeys(lastname);
	 //wait = new WebDriverWait(driver,4);
	 //wait.until(ExpectedConditions.elementToBeClickable(companyFalse));
	 //companyFalse.click();
	 //wait.until(ExpectedConditions.elementToBeClickable(companyTrue));
	 companyFalse.sendKeys(comp);
	 email.sendKeys(mail);
	 saveBtn.click();
	 //contactsTab.click();
	}

}
