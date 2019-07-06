package com.ma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ma.qa.base.TestBase;

public class HomePage extends TestBase {

	ContactsPage cp;
	@FindBy(xpath = "//td[contains(text(),'User: Arjun Singh')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement taskLink;

	@FindBy(xpath = "//td[contains(text(),'User: Arjun Singh ')]")
	WebElement userName;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyUserNameDisplayed() {
 return userName.isDisplayed();
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContactLink() {

		contactLink.click();

		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();

	}

	public TaskPage clickOnTaskLink() {
		taskLink.click();
		return new TaskPage();

	}
}
