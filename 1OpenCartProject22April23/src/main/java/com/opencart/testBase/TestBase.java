package com.opencart.testBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeTest
	public void start()
	{
		logger = Logger.getLogger("Opencart Automation Project");
		PropertyConfigurator.configure("Log4jFile.Properties");
		
		logger.info("-----------------------------");
		logger.info("Framework Execution Started");
	}
	
	@AfterTest
	public void end()
	{
		logger.info("-----------------------------");
		logger.info("Framework Execution Completed");
	}

	@BeforeMethod
	public void setup()
	{
		String browser = "Chrome";
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please provide valid browser name");
		}
		
		logger.info("Browser launches");
		driver.get("https://naveenautomationlabs.com/opencart/index.php?");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("Url, maximize, implcitly wait provided");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
		logger.info("Browser Closed");
	}
}
