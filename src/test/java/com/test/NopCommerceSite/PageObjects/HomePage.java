package com.test.NopCommerceSite.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="Email")
	WebElement emailTxt;
	
	@FindBy(name="Password")
	WebElement passwordTxt;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	
	public void sendUsername(String username)
	{
		emailTxt.clear();
		emailTxt.sendKeys(username);
	}
	public void sendPassword(String password)
	{
		passwordTxt.clear();
		passwordTxt.sendKeys(password);
	}
	public void clickOnSubmit()
	{
		submitButton.click();
	}

}
