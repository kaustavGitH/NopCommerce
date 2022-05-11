package com.test.NopCommerceSite.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage {
	
	WebDriver driver;
	public CustomerPage(WebDriver driver)
	{
		driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="SearchEmail")
	WebElement emailTxtBox;
	
	@FindBy(name="SearchFirstName")
	WebElement firstNameTxtBox;
	
	@FindBy(id="SearchLastName")
	WebElement lastNameTxtBox;
	
	@FindBy(id="SearchMonthOfBirth")
	WebElement monthDropdown;
	
	@FindBy(id="SearchDayOfBirth")
	WebElement dayDropdown;
	
	@FindBy(name="SearchCompany")
	WebElement companyTxtBox;
	
	@FindBy(id="SelectedCustomerRoleIds")
	WebElement customerRolesDropdown;
	
	@FindBy(id="search-customers")
	WebElement searchBtn;
	
	@FindBy(linkText="/Admin/Customer/Create")
	WebElement addNewBtn;
	
	@FindBy(xpath="//div[@class='dataTables_scroll']")
	WebElement customerDetails;
	
	public void searchByEmail(String email)
	{
		emailTxtBox.clear();
		emailTxtBox.sendKeys(email);
	}
	public void searchByFirstName(String fname)
	{
		firstNameTxtBox.clear();
		firstNameTxtBox.sendKeys(fname);
	}
	public void searchByLastName(String lname)
	{
		lastNameTxtBox.clear();
		lastNameTxtBox.sendKeys(lname);
	}
	public void searchByDateOfBirth(String month,String day)
	{
		Select monthOption=new Select(monthDropdown);
		monthOption.selectByValue(month);
		Select dayOption=new Select(dayDropdown);
		dayOption.selectByValue(day);
	}
	public void searchByCompany(String companyName)
	{
		companyTxtBox.clear();
		companyTxtBox.sendKeys(companyName);
	}
	public void searchByCustomerRoles(String roleName)
	{
		Select rolesOption=new Select(customerRolesDropdown);
		rolesOption.selectByValue(roleName);
	}
	public void clickOnSearch()
	{
		searchBtn.click();
	}
	public void clickOnAdd()
	{
		addNewBtn.click();
	}
	public boolean checkCustomerDetailsTable()
	{
		if(customerDetails.isDisplayed())
		{
				return true;
		}
		return false;
	}

}
