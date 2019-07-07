package com.ma.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ma.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'arjun singh')]/parent::td[1]//preceding-sibling::td[1]/input[1]")
	WebElement clickToContactsCheckBox;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='surname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement companyName;

	@FindBy(xpath = "//input[@type='button']/following-sibling::input[@type='submit' and @value='Save']")
	WebElement clickOnSaveButton;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsIsDisplayed() {
		return contactsLink.isDisplayed();
	}

	public void selectContacts(String name) {

		driver.findElement(
				By.xpath("//a[contains(text(),'" + name + "')]/parent::td[1]" + "//preceding-sibling::td[1]/input[1]"))
				.click();

	}

	public void createNewContact(String title, String ftname, String ltname, String company) {
		Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		companyName.sendKeys(company);
		clickOnSaveButton.click();

	}

}
