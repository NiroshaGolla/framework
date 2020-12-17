package com.vtiger.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class OpenCreatedContactpage {

	@FindBy(xpath="//span[contains(text(),'Contact Information')]")
	private WebElement ContactPageTitle_text;
	
	@FindBy(linkText="Add To Do")
	private WebElement AddToDo_link;
	

	@FindBy(linkText="All Events & Todos")
	private WebElement allEventsTools;
	
	@FindBys(@FindBy(xpath="(//div[@id='tblContactInformation']//tr/td[1])"))
	private List<WebElement> attributeCount;
	
	
	public List<WebElement> getAttributeCount()
	{
		return attributeCount;
	}
	@FindBy(css="img[alt='Contacts Settings']")
	private WebElement settings_icon;

	@FindBy(xpath="//b[contains(text(),'Contact Image Information:')]/../../../../../following-sibling::div//img")
	private WebElement uploadedImage;

	public WebElement getUploadedImage()
	{
		return uploadedImage;
	}
	
	public WebElement getSettingsIcon()
	{
		return settings_icon;
	}
	public WebElement getAllEventsAndTools()
	{
		return allEventsTools;
	}
	
	public WebElement getcontactTitle()
	{
		return ContactPageTitle_text;
	}
	public WebElement getclickAddToDo()
	{
		return AddToDo_link;
	}
	
}
