package com.vtiger.objectRepository;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vtiger.genericLib.BaseClass;

public class AllEventsAndToDos extends BaseClass
{
	private WebElement actual;
	public WebElement getActualResult() throws IOException
	{
	actual = driver.findElement(By.xpath("//a[text()='"+picker.getDataFromExcel("TesCaseData",13,2)+"']"));
	return actual;
	}
}
