package com.vtiger.genericLib;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation implements ITestListener 
{

	@Override
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		System.out.println(result.getName()+"Test case start");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+"Test case sucess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Date d=new Date();
		String currentDateTime=d.toString().replace(":", "-");
		System.out.println("Current dste time is : "+currentDateTime);
		String testcasename=result.getName();
		System.out.println(testcasename+"test case fail");
		EventFiringWebDriver efwd=new EventFiringWebDriver(BaseClass.driver);
		File sourceFile=efwd.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile,new File("./screenshot/"+testcasename+currentDateTime+".png"));
		}catch(IOException e)
		{	
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+"Test case skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+"fails but some percentage");
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(context.getName()+"Execution starts");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(context.getName()+"Execution starts");
	}

}
