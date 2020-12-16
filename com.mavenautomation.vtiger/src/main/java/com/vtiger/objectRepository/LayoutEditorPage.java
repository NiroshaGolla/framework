package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LayoutEditorPage 
{
	@FindBy(xpath="//b[contains(.,'Layout Editor')]")
	private WebElement LayoutEditortitle;

	public WebElement getLayoutEditortitle()
	{
		return LayoutEditortitle;
	}
	
	@FindBy(xpath="(//span[.='Email']/../following-sibling::td/div/following-sibling::img)[1]")
	private WebElement upArrow;

	public WebElement getClickUpArrow()
	{
		return upArrow;
	}
	@FindBy(xpath="(//span[.='Email']/../following-sibling::td/div/following-sibling::img)[2]")
	private WebElement downArrow;

	public WebElement getClickdownArrow()
	{
		return downArrow;
	}	
}
