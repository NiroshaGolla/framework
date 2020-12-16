package com.vtiger.testScript;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.vtiger.genericLib.BaseClass;
import com.vtiger.objectRepository.AllEventsAndToDos;
import com.vtiger.objectRepository.CalenderHomePage;
import com.vtiger.objectRepository.ContactsHomePage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.OpenCreatedContactpage;

@Listeners(com.vtiger.genericLib.ListnerImplementation.class)
public class AddToDotoalreadyCreatedContactTest extends BaseClass
{
	@Test(groups= {"smoke"})
	public  void AddToDotoalready() throws IOException
	{
			HomePage hp=PageFactory.initElements(driver, HomePage.class);
			hp.getContactLink().click();
					
		//validate contacts homepage
			SoftAssert sa=new SoftAssert();
			sa.assertTrue(driver.getTitle().contains(picker.getDataFromExcel("TesCaseData",10,2)));
			wdcu.waitForElementToBeVisible(By.xpath("(//tr[contains(@id,'row')])[1]/td[3]"));
				
		//clicking on any contact
				ContactsHomePage chp=PageFactory.initElements(driver, ContactsHomePage.class);
				chp.getClickAnyContactLink().click();
					
		//validation on contact page		
			
				OpenCreatedContactpage occp=PageFactory.initElements(driver, OpenCreatedContactpage.class);
				sa.assertTrue(occp.getcontactTitle().getText().contains(picker.getDataFromExcel("TesCaseData",11,2)));
				occp.getclickAddToDo().click();
				
		//validating calender page
				CalenderHomePage clhp=PageFactory.initElements(driver, CalenderHomePage.class);
				sa.assertTrue(clhp.getcalenderTitle().getText().contains(picker.getDataFromExcel("TesCaseData",12,2)));
				
		 //adding document
		        
		     clhp.getenterSubject().sendKeys(picker.getDataFromExcel("TesCaseData",13,2));
		    clhp.getenterDescription().sendKeys(picker.getDataFromExcel("TesCaseData",14,2));
		    clhp.getclickCalender().click();
		    List<WebElement> tdate=clhp.gettomarrowDate();
		    // List<WebElement> tdate=driver.findElements(By.xpath("//td[contains(@class,'today')]/following-sibling::td"));
		     if(tdate.isEmpty())
		     {
	    	//weekend
			try {
		  clhp.getfetchWeekEnd().click();
			}
			catch(ElementNotInteractableException e)
			{
				
			clhp.getnextMonth().click();
			clhp.getfetchMonthEnd().click();
    		System.out.println(" Tomarrow's date selected sucessfully");
			}
		}
		 else if(tdate.get(0).getText().equals(" ")) // --> Check equals condition
		{
		        	//Handling monthend
			 clhp.getnextMonth().click();
			 clhp.getfetchMonthEnd().click();
			 System.out.println(" Tomarrow's date selected sucessfully");
		}
		else 
		{	//Regular week
		tdate.get(0).click();
		System.out.println("  Tomarrow's date selected sucessfully");
		}
		clhp.getSaveBtn().click();
		occp.getclickAddToDo().click();
		occp.getAllEventsAndTools().click();
		
		AllEventsAndToDos aeatd=PageFactory.initElements(driver, AllEventsAndToDos.class);
		String actual1=aeatd.getActualResult().getText();
		
		String expected=picker.getDataFromExcel("TesCaseData",13,2);
		Assert.assertEquals(actual1, expected);
		Reporter.log("AddToDo Created Sucessfully",true);
		//System.out.println("AddToDo Created Sucessfully");
		sa.assertAll();
	}
	
}
