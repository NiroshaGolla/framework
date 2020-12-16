package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsHomePage 
{
	@FindBy(xpath="(//tr[contains(@id,'row')])[1]/td[3]")
	private WebElement waitCondition;
	
	@FindBy(xpath="(//tr[contains(@id,'row')])[1]/td[3]/a")
	private WebElement AnyContacts_link;
	
	@FindBy(linkText="Create Filter")
	private WebElement CreateFilter_link;
	
	@FindBy(xpath="//select[@id='viewname']/option[.='special view']")
	private WebElement FetchCreatedView_lb;
	
	@FindBy(css="img[title='Create Contact...']")
	private WebElement CreateContact_icon;
	
	@FindBy(linkText="Go to Advanced Search")
	private WebElement advanceSearchlink;
	
	@FindBy(css="td[class='detailedViewHeader']")
	private WebElement advanceSearchheader;

	
	@FindBy(xpath="//select[contains(@id,'fco')]")
	private WebElement selectingEmailFromListBox;
	
	
	@FindBy(xpath="//select[contains(@id,'fop')]")
	private WebElement selectingConditionFromListBox;
	
	@FindBy(xpath="//input[contains(@id,'fva')]")
	private WebElement enteringEmailid;

	@FindBy(xpath="(//input[@value=' Search Now '])[2]")
	private WebElement searchnow;

	@FindBy(xpath="//table[@class='lvt small']//tr[3]/td[7]")
	private WebElement fetchingCreatedEmailid;

	public WebElement getFetchingCreatedEmailid()
	{
		return fetchingCreatedEmailid;
	}
	public WebElement getSearchNowbtn()
	{
		return searchnow;
	}
	
	
	public WebElement getEnterEmailid()
	{
		return enteringEmailid;
	}
	public WebElement getConditionFromLB()
	{
		return selectingConditionFromListBox;
	}
	
	public WebElement getEmailFromLB()
	{
		return selectingEmailFromListBox;
	}
	
	public WebElement getadvanceSearcHeader()
	{
		return advanceSearchheader;
	}
	
	public WebElement getadvanceSearchlink()
	{
		return advanceSearchlink;
	}
	public WebElement getCreateContact()
	{
		return CreateContact_icon;
	}
	public WebElement getWaitCondition()
	{
		return waitCondition;
	}
	
	public WebElement getClickAnyContactLink()
	{
		return AnyContacts_link;
	}
	public WebElement getcreateFilterLink()
	{
		return CreateFilter_link;
	}
	public WebElement getFetchCreatedView()
	{
		return FetchCreatedView_lb;
	}
}
