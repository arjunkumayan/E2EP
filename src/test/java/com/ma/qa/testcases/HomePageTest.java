package com.ma.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ma.qa.base.TestBase;
import com.ma.qa.pages.ContactsPage;
import com.ma.qa.pages.HomePage;
import com.ma.qa.pages.LoginPage;
import com.ma.qa.util.TestUtils;

public class HomePageTest extends TestBase {

	LoginPage lp;
	HomePage hp;
	TestUtils tu;
	ContactsPage cp;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		tu = new TestUtils();
		cp = new ContactsPage();

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homepageTitle = hp.verifyHomePageTitle();
		Assert.assertEquals(homepageTitle, "CRMPRO", "Home PAge title is not matched");

	}

	@Test(priority = 2)
	public void verifyCorrectUSerNameTest() {
		tu.switchToFrame();
		Assert.assertTrue(hp.verifyUserNameDisplayed());

	}

	@Test(priority = 3)
	public void clickToContactLinkTest() {
		tu.switchToFrame();
		cp = hp.clickOnContactLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
