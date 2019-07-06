package com.ma.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ma.qa.base.TestBase;
import com.ma.qa.pages.HomePage;
import com.ma.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lp;
	HomePage hp;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = lp.validatePageTitle();
		System.out.println(title);

		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void verifyCRMImageTest() {
		Boolean flag = lp.validateCrmImage();
		Assert.assertTrue(flag);

	}

	@Test(priority = 3)
	public void loginTest() {
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
