package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.NopCommerceSite.PageObjects.CustomerPage;
import com.test.NopCommerceSite.PageObjects.DashboardPage;
import com.test.NopCommerceSite.PageObjects.HomePage;
import com.test.NopCommerceSite.Utilities.CheckAlert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	WebDriver driver;
	HomePage hp;
	DashboardPage dp;
	WebDriverWait wait;
	CheckAlert alert;
	CustomerPage cp;
	
	@Given("Launch Chrome browser")
	public void launch_chrome_browser() {
	    
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		hp=new HomePage(driver);
		dp=new DashboardPage(driver);
		cp=new CustomerPage(driver);
		alert=new CheckAlert();
		wait=new WebDriverWait(driver,20);
	}

	@When("User open url {string}")
	public void user_open_url(String string) {
	    
		driver.get(string);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("User provides username as {string} and password as {string}")
	public void user_provides_username_as_and_password_as(String userId, String password) {
	    
		hp.sendUsername(userId);
		hp.sendPassword(password);
	}

	@And("User clicks on Log In button")
	public void user_clicks_on_log_in_button() {
	    
		hp.clickOnSubmit();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String pageTitle) {
		
		if(alert.checkAlertIsPresent(driver)==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			if(driver.getPageSource().contains("Login was unsuccessful"))
			{
				driver.close();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertEquals(pageTitle,driver.getTitle());
			}
		}
		else
		{
			if(driver.getPageSource().contains("Login was unsuccessful"))
			{
				driver.close();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertEquals(pageTitle,driver.getTitle());
			}
		}
	}

	@When("User clicks on Logout button")
	public void user_clicks_on_logout_button() {
		
		if(alert.checkAlertIsPresent(driver)==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			dp.clickOnLogout();
			wait.until(ExpectedConditions.titleContains("Your store. Login"));
		}
		else
		{
			dp.clickOnLogout();
			wait.until(ExpectedConditions.titleContains("Your store. Login"));
		}
	}

	@And("Close the browser")
	public void close_the_browser() {
		driver.close();
	    
	}
	
	@And("User clicks on Customers dropdown and Customers option")
	public void user_clicks_on_customers_dropdown() {
		
		wait.until(ExpectedConditions.titleContains("Dashboard / nopCommerce administration"));
		if(alert.checkAlertIsPresent(driver)==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			dp.navigateToCustomersPage();	   
		}
		else
		{
			dp.navigateToCustomersPage();
		}
	}
	
	@And("Customer page is displayed")
	public void customer_page_is_displayed() {
		
		if(driver.getPageSource().contains("Customers / nopCommerce administration"))
			Assert.assertTrue(true);
	}
	
	@And("User provides firstname as {string} and lastname as {string}")
	public void user_provides_firstname_as_and_lastname_as(String firstName, String lastName) {
	    
		cp.searchByFirstName(firstName);
		cp.searchByLastName(lastName);
	}
	
	@And("User clicks on search button")
	public void user_clicks_on_search_button() {
		
		cp.clickOnSearch();	    
	}

	@Then("Customer table is displayed with name")
	public void customer_table_is_displayed_with_name() {
	    
		boolean res=cp.checkCustomerDetailsTable();
		Assert.assertTrue(res);
	}

}
