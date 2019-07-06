package com.ma.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ma.qa.base.TestBase;

public class LoginPage extends TestBase {

		
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up']")
	WebElement signUp;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement crmImage;
	//td[contains(text(),'CRMPRO')]
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle()
	{
		return driver.getTitle();
		
	}
	
	
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginBtn.click();
		return new HomePage();
		
		
	}
	
	public boolean validateCrmImage()
	{
		return crmImage.isDisplayed();
	}
}
