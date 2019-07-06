package com.ma.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ma.qa.base.TestBase;

public class ContactsPage extends TestBase {

	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'arjun singh')]/parent::td[1]//preceding-sibling::td[1]/input[1]")
	WebElement clickToContactsCheckBox;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsIsDisplayed()
	{
		return contactsLink.isDisplayed();
	}
	
	public void selectContacts(String name)
	{
		
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td[1]"
				+ "//preceding-sibling::td[1]/input[1]")).click();
		
		
	}
	
}
