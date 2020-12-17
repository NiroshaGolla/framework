package com.vtiger.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CalenderHomePage
{
	@FindBy(xpath="//td[text()='Calendar']")
	private WebElement CalenderPageTitle_text;
	
	@FindBy(name="subject")
	private WebElement subject_tf;
	
	@FindBy(name="description")
	private WebElement description_tf;
	
	@FindBy(id="jscal_trigger_due_date")
	private WebElement Calender_icon;
	
	@FindBys(@FindBy(xpath="//td[contains(@class,'today')]/following-sibling::td"))
	private List<WebElement> TmrwDate;
	
	@FindBy(xpath="//td[contains(@class,'today')]/../following-sibling::tr[1]/td[2]")
	private WebElement Weekend;
	
	@FindBy(xpath="//td[text()='›']")
	private WebElement NextMonth;
	
	@FindBy(xpath="(//div[@class='calendar'])[1]/table/tbody/tr[1]/td[text()='1']")
	private WebElement MonthEnd;
	
	@FindBy(css="input[type='submit']")
	private WebElement save_btn;
	
	
	public WebElement getcalenderTitle()
	{
		return CalenderPageTitle_text;
	}
	public WebElement getenterSubject()
	{
		return subject_tf;
	}
	public WebElement getenterDescription()
	{
		return description_tf;
	}
	
	public WebElement getclickCalender()
	{
		return Calender_icon;
	}
	
	public List<WebElement> gettomarrowDate()
	{
		return TmrwDate;
	}
	public WebElement getnextMonth()
	{
		return NextMonth;
	}
	
	public WebElement getfetchWeekEnd()
	{
		return Weekend;
	}
	
	public WebElement getfetchMonthEnd()
	{
		return MonthEnd;
	}
	public WebElement getSaveBtn()
	{
		return save_btn;
	}
	
	
}
