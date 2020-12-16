package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModularManageSettingPage 
{
	@FindBy(linkText="Module Manager")
	private WebElement ModularManagetitle;

	public WebElement getModularManagetitle()
	{
		return ModularManagetitle;
	}
	
	
	@FindBy(partialLinkText="Layout Editor")
	private WebElement layoutEditorlink;

	public WebElement getlayoutEditorlink()
	{
		return layoutEditorlink;
	}
}
