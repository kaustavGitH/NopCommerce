package com.test.NopCommerceSite.Utilities;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class CheckAlert {
	
	public boolean checkAlertIsPresent(WebDriver driver)
	{
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException exception)
		{
			return false;
		}
	}

}
