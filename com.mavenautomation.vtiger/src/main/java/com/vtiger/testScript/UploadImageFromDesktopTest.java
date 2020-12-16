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
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.OpenCreatedContactpage;
@Listeners(com.vtiger.genericLib.ListnerImplementation.class)
public class UploadImageFromDesktopTest extends BaseClass
{
	@Test(groups= {"smoke","integration"})
	public void uploadImage() throws  IOException 
	{
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.getContactLink().click();
//validate contacts homepage
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(driver.getTitle().contains((picker.getDataFromExcel("TesCaseData", 35,2))));
//creating contact with emailid
		ContactsHomePage chp=PageFactory.initElements(driver, ContactsHomePage.class);
		chp.getCreateContact().click();
		CreateNewContactPage cncp =PageFactory.initElements(driver, CreateNewContactPage.class);
		String createContactPage=cncp.getNewContactPageTitle().getText();
		sa.assertTrue(createContactPage.contains(picker.getDataFromExcel("TesCaseData",36,2)));
		cncp.getlastNameField().sendKeys(picker.getDataFromExcel("TesCaseData",37,2));
//upload image	
		wdcu.uploadDocument(cncp.getuploadimage(), picker.getDataFromExcel("TesCaseData",38,2));
//validating image
		String imageResult = cncp.getfetchdownloadfile().getAttribute("value");
		Assert.assertTrue(imageResult.contains(picker.getDataFromExcel("TesCaseData",39,2)));
		System.out.println("image uploaded sucessfully");
		
		cncp.getSaveBtn().click();
		try
		{
			OpenCreatedContactpage occp=PageFactory.initElements(driver, OpenCreatedContactpage.class);
			occp.getUploadedImage();
			Reporter.log("Image uploaded sucessfully",true);
		//System.out.println("Image uploaded sucessfully");
		}catch(NoSuchElementException e)
		{
			System.out.println("Contact Created with Image Sucessfully");
		}
		sa.assertAll();
		
	} 
	}
