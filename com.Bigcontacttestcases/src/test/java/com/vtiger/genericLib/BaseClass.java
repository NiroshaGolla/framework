package com.vtiger.genericLib;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.Login;
//import org.testng.annotations.Parameters;
public class BaseClass 
{
	public WebDriverCommonUtils wdcu=new WebDriverCommonUtils();
	public static WebDriver driver;
	public DataStorage picker=new DataStorage();
	public SoftAssert soft=new SoftAssert();
	@BeforeSuite
	public void configBS()
	{
		System.out.println("DB Connect");
	}
	@BeforeTest
	public void configBT()
	{
		System.out.println("Before Test Dependency");
	}
	@BeforeClass
	public void configBC() throws IOException
	{
		/*if(browserValue.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}else if(browserValue.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}*/
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(picker.getDataFromProperty("url"));
		driver.manage().window().maximize();
		System.out.println("Launch Browser");
	}
	@BeforeMethod
	public void configBM() throws IOException 
	{
		Login l=PageFactory.initElements(driver, Login.class);
		l.getUserNameField().sendKeys(picker.getDataFromProperty("username"));
		l.getPasswordField().sendKeys(picker.getDataFromProperty("password"));
		l.getLoginButton().click();
		System.out.println("Login Done");
	}
	@AfterMethod
	public void configAM()
	{
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		wdcu.moveMouseonElement(hp.mouse_Over());
		hp.sign_out().click();
		System.out.println("Logout done");
	}
	@AfterClass
	public void configAC()
	{
		driver.quit();
		System.out.println("close browser");
	}
	@AfterTest
	public void configAT()
	{
		System.out.println("After test Dependency");
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("Db Dis-connect");
	}	
}
