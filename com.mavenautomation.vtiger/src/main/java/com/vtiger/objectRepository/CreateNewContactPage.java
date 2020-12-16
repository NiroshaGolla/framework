package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewContactPage 
{
/*
	@FindBy(xpath="//span[.='Creating New Contact']t")
	private WebElement newContactPage;
	
	public WebElement getNewContactPageTitle()
	{
		return newContactPage;
	}*/
	@FindBy(xpath="//span[.='Creating New Contact']")
	private WebElement newContactPageTitle;
	
	
	@FindBy(name="lastname")
	private WebElement lastName_tf;
	
	@FindBy(id="email")
	private WebElement emailid;
	
	@FindBy(name="imagename")
	private WebElement imageName_browse;
	
	@FindBy(css="input[value='download.jpg']")
	private WebElement fetchdownload_text;
	
	@FindBy(css="input[type='submit']")
	private WebElement save_btn;
	
	public WebElement getNewContactPageTitle()
	{
		return newContactPageTitle;
	}
	
	public WebElement getlastNameField()
	{
		return lastName_tf;
	}
	public WebElement getEmailid()
	{
		return emailid;
	}
	
	public WebElement getuploadimage()
	{
		return imageName_browse;
	}
	
	public WebElement getfetchdownloadfile()
	{
		return fetchdownload_text;
	}
	public WebElement getSaveBtn()
	{
		return save_btn;
	}
	
}
