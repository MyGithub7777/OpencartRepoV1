package com.opencart.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageLayer.Homepage;
import com.opencart.pageLayer.Loginpage;
import com.opencart.testBase.TestBase;
import com.opencart.utilities.UtilClass;

public class LoginTest extends TestBase {
	
	@Test
	public void validateloggingintotheApplicationusingvalidcredentials() throws InterruptedException
	{
		String expected_output = "My Account";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage login_obj = new Loginpage(driver);
		UtilClass util_obj = new UtilClass(driver);

		homepage_obj.clickOnMyAccountLink();
		homepage_obj.clickOnLoginLink();
		
		logger.info("login page opened");
		
		Thread.sleep(2000);
		login_obj.enterEmail("davidmiller1@gmail.com");
		login_obj.enterPassword("Test@1234");
		login_obj.clickOnLoginButton();
		logger.info("logged in");
		Assert.assertEquals(util_obj.getTitleOfPage(), expected_output);	
	}
	
	@Test
	public void validateloggingintotheApplicationusinginvalidcredentials() throws InterruptedException
	{
		String expected_output = "Account Login";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage login_obj = new Loginpage(driver);
		UtilClass util_obj = new UtilClass(driver);
		
		homepage_obj.clickOnMyAccountLink();
		homepage_obj.clickOnLoginLink();
		logger.info("login page opened");
		Thread.sleep(2000);
		login_obj.enterEmail("davidmiller8@gmail.com");
		login_obj.enterPassword("Test1234rtfd");
		login_obj.clickOnLoginButton();
		logger.info("Not logged in");
		Assert.assertEquals(util_obj.getTitleOfPage(), expected_output);
	}



}
