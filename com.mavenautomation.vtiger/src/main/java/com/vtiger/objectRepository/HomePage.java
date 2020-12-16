package com.vtiger.objectRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HomePage 
{
	@FindBy(linkText="Contacts")
	private WebElement Contacts_link;
	
	@FindBy(linkText="Sign Out")
	private WebElement signout;
	
	@FindBy(xpath="//span[text()=' Administrator']/../following-sibling::td[1]")
	private WebElement mouseover;
	
	public WebElement getContactLink()
	{
		return Contacts_link;
	}	
	public WebElement mouse_Over()
	{
		return mouseover;
	}	
	public WebElement sign_out()
	{
		return signout;
	}	
	
}
