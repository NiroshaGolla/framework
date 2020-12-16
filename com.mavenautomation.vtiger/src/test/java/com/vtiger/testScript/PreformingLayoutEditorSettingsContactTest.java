package com.vtiger.testScript;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.genericLib.BaseClass;
import com.vtiger.objectRepository.ContactsHomePage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LayoutEditorPage;
import com.vtiger.objectRepository.ModularManageSettingPage;
import com.vtiger.objectRepository.OpenCreatedContactpage;
@Listeners(com.vtiger.genericLib.ListnerImplementation.class)
public class PreformingLayoutEditorSettingsContactTest extends BaseClass
{
	@Test(groups= {"integration"})
	public void editorSetting() throws IOException 
	{
		SoftAssert sa=new SoftAssert();
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.getContactLink().click();
		
//validate contacts homepage
		
		sa.assertTrue(driver.getTitle().contains(picker.getDataFromExcel("TesCaseData",28,2)));
		
		ContactsHomePage chp=PageFactory.initElements(driver, ContactsHomePage.class);
		chp.getClickAnyContactLink().click();
		
		OpenCreatedContactpage occp=PageFactory.initElements(driver, OpenCreatedContactpage.class);
		List<WebElement> attributes=occp.getAttributeCount();
		
		int count=1;
		for(WebElement wb:attributes)
			{
			count++;
			if(wb.getText().equals(picker.getDataFromExcel("TesCaseData",29,2)))
			{
				break;
			}
		}
		occp.getSettingsIcon().click();
		
		
		ModularManageSettingPage mmsp=PageFactory.initElements(driver, ModularManageSettingPage.class);
		String head = mmsp.getModularManagetitle().getText();
		sa.assertTrue(head.contains(picker.getDataFromExcel("TesCaseData",30,2)));
		
			
		
		mmsp.getlayoutEditorlink().click();
		LayoutEditorPage lep=PageFactory.initElements(driver, LayoutEditorPage.class);
		String layoutResult = lep.getLayoutEditortitle().getText();
		
		sa.assertTrue(layoutResult.contains(picker.getDataFromExcel("TesCaseData",31,2)));
		
		
		WebElement upArrow=lep.getClickUpArrow();
		
		for(int i=1;i<=2;i++)
		{
			upArrow.click();
			WebDriverWait wdwait=new WebDriverWait(driver,20 );
			wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[.='Email']/../following-sibling::td/div/following-sibling::img)[1]")));
		}
		Navigation nav=driver.navigate();
		nav.back();
		nav.back();
		List<WebElement> attributesafter=occp.getAttributeCount();
		
		int countvalue=1;
		for(WebElement wb:attributesafter)
		{
			countvalue++;
			if(wb.getText().equals(picker.getDataFromExcel("TesCaseData",29,2)))
			{
				break;
			}
		}
		if(count-2==countvalue)
		{
			System.out.println("Arrow moved 2 steps up sucessfully");
		}
		else
		{
			System.out.println("Failed to move arrow up");	
		}
		occp.getSettingsIcon().click();
		mmsp.getlayoutEditorlink().click();
		
		WebElement downArrow=lep.getClickdownArrow();
		
		for(int i=1;i<=2;i++)
		{
		downArrow.click();
		}
	sa.assertAll();
	}
}