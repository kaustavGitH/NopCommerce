package com.test.NopCommerceSite.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	WebDriver driver;
	public DashboardPage(WebDriver driver)
	{
		driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Logout")
	WebElement logoutButton;
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement customerDropdown;
	
	@FindBy(xpath="//ul//a[@href='/Admin/Customer/List']")
	WebElement customerOption;
	
	public void clickOnLogout()
	{
		logoutButton.click();
	}
	public void navigateToCustomersPage()
	{
		customerDropdown.click();
		customerOption.click();
	}

}
