package com.vtiger.testScript;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.genericLib.BaseClass;
import com.vtiger.objectRepository.ContactsHomePage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.HomePage;
@Listeners(com.vtiger.genericLib.ListnerImplementation.class)
public class SearchContactbyAdvanceSearchbyEmailTest extends BaseClass
{
	@Test(groups= {"integration"})
	public void advanceSearch() throws IOException, AWTException 
	{
//open contacts
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.getContactLink().click();
		
//validate contacts homepage
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(driver.getTitle().contains(picker.getDataFromExcel("TesCaseData",18,2)));

//code for precondition(creating contact with emailid)
		ContactsHomePage chp=PageFactory.initElements(driver, ContactsHomePage.class);
		chp.getCreateContact().click();
		
		CreateNewContactPage cncp=PageFactory.initElements(driver,CreateNewContactPage.class);
		String createContactPage=cncp.getNewContactPageTitle().getText();
		sa.assertTrue(createContactPage.contains(picker.getDataFromExcel("TesCaseData",19,2)));
		cncp.getlastNameField().sendKeys(picker.getDataFromExcel("TesCaseData",20,2));
		cncp.getEmailid().sendKeys(picker.getDataFromExcel("TesCaseData",21,2));
		
		cncp.getSaveBtn().click();
		
		
//end of precondition
//Advance search
		hp.getContactLink().click();
		
		wdcu.waitForElementToBeVisible(By.linkText("Contacts"));
		
		chp.getadvanceSearchlink().click();
		
//validating advancesearch toolbar
		String advanceSearch=chp.getadvanceSearcHeader().getText();
		sa.assertTrue(advanceSearch.equals(picker.getDataFromExcel("TesCaseData",22,2)));
//seakrchByEmail
		
		wdcu.pickItemFromList(chp.getEmailFromLB(), picker.getDataFromExcel("TesCaseData",23,2));
		chp.getEmailFromLB().click();
		
		wdcu.pickItemFromList(chp.getConditionFromLB(), picker.getDataFromExcel("TesCaseData",24,2));
		chp.getConditionFromLB().click();
		
		chp.getEnterEmailid().sendKeys(picker.getDataFromExcel("TesCaseData",21,2));
		chp.getSearchNowbtn().click();
		String finalResult = "";
//validating advancesearch result
		int count = 0;
		while(count <= 100) {
			try {
			finalResult = chp.getFetchingCreatedEmailid().getText();
			}catch(Exception e)
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
			if(finalResult.equals(chp.getEmailFromLB())) {
				break;
			}
			count++;
		}
		Assert.assertTrue(finalResult.equals(picker.getDataFromExcel("TesCaseData",21,2)));
		Reporter.log("Search by email done sucessfully",true);
		//System.out.println("Search by email done sucessfully");
		sa.assertAll();
	}

}
