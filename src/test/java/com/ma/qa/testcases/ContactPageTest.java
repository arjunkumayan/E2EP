package com.ma.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ma.qa.base.TestBase;
import com.ma.qa.pages.ContactsPage;
import com.ma.qa.pages.HomePage;
import com.ma.qa.pages.LoginPage;
import com.ma.qa.util.TestUtils;

public class ContactPageTest extends TestBase {
	
	LoginPage lp;
	ContactsPage cp;
	HomePage hp;
	TestUtils tu;
	public ContactPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		lp=new LoginPage();
		hp=new HomePage();
		cp=new ContactsPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		tu=new TestUtils();
		tu.switchToFrame();
		hp.clickOnContactLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest()
	{
		Boolean flag2=cp.verifyContactsIsDisplayed();
		Assert.assertTrue((flag2),"contacts labelismissing on the page");
	}
	@Test(priority=2)
	public void selectContactName()
	{
		//cp.selectContacts("Arjun Singh");
		cp.selectContacts("arjun singh");
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
