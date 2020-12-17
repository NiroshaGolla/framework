package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCustomView
{
	@FindBy(className="lvtHeaderText")
	private WebElement CreateFilterPageTitle_text;
	
	@FindBy(name="viewName")
	private WebElement viewName_cb;
	
	@FindBy(name="setMetrics")
	private WebElement setMetrics_cb;
	
	@FindBy(name="setStatus")
	private WebElement setStatus_cb;
	
	@FindBy(css="input[type='submit']")
	private WebElement save_btn;	
	
	public WebElement filterPageTitle()
	{
		return CreateFilterPageTitle_text;
	}
	public WebElement ViewNameCB()
	{
		return viewName_cb;
	}
	public WebElement SetMetricsCB()
	{
		return setMetrics_cb;
	}
	public WebElement status()
	{
		return setStatus_cb;
	}
	
	public WebElement saveButton()
	{
		return save_btn;
	}
	
	
	
}
