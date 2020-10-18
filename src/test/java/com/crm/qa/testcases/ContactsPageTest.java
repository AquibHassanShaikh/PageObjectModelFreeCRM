package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	String sheetName = "contact";

	public ContactsPageTest() {

		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		contactsPage = homePage.clinkOnContactsTab();
	}

	@Test(priority = 1)
	public void verifyContactPageLabel() {

		Assert.assertTrue(contactsPage.verifyContactPageLabel(), "Contacts Label Is Not Missing");
	}

	@DataProvider
	public Object[][] getCRMTestData() {

		Object data[][] = TestUtil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 2, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String firstname, String lastname, String company, String email) {
		// homePage.clinkOnContactsTab();
		contactsPage.newContactLink();
		contactsPage.createNewContact(firstname, lastname, company, email);

	}

	@Test
	public void CreateNewContact() {
		// homePage.clinkOnContactsTab();
		contactsPage.newContactLink();
		contactsPage.createNewContact("testftname11", "testltname22", "CompTest1122", "test@comptest123");

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
