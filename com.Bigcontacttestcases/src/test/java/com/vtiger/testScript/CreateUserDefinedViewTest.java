package com.vtiger.testScript;
import java.io.IOException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.genericLib.BaseClass;
import com.vtiger.objectRepository.ContactsHomePage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.NewCustomView;

@Listeners(com.vtiger.genericLib.ListnerImplementation.class)
public class CreateUserDefinedViewTest extends BaseClass
{
	@Test(groups= {"smoke"})
	public void createView() throws IOException 
	{
//opening contacts
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.getContactLink().click();
		
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(driver.getTitle().contains((picker.getDataFromExcel("TesCaseData", 3,2))));
		
//opening createfilter
		ContactsHomePage chp=PageFactory.initElements(driver, ContactsHomePage.class);
		chp.getcreateFilterLink().click();
//validating createfilterpage
		NewCustomView ncv=PageFactory.initElements(driver, NewCustomView.class);
		
		sa.assertTrue(ncv.filterPageTitle().getText().contains(picker.getDataFromExcel("TesCaseData", 4,2)));
		
//creating view
		ncv.ViewNameCB().sendKeys(picker.getDataFromExcel("TesCaseData",5,2));
		ncv.SetMetricsCB().click();
		ncv.status().click();
		ncv.saveButton().click();
			String actual="";
			try {
				actual=chp.getFetchCreatedView().getText();
			}catch(NoSuchElementException e)
			{
				System.out.println("View not created");
			}
			String expected=picker.getDataFromExcel("TesCaseData",5,2);
			Assert.assertEquals(actual, expected);
			Reporter.log("View Created Sucessfully",true);
			//System.out.println("View Created Sucessfully");
			sa.assertAll();
	}
}
