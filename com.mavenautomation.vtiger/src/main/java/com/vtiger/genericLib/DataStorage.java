package com.vtiger.genericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataStorage 
{
	static FileInputStream fis;
	static Properties pobj=new Properties();
	public String getDataFromProperty(String key) throws IOException
	{
		fis=new FileInputStream("./src/test/resources/DataContainer/commonData.properties");
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}
	public String getDataFromExcel(String SheetName,int rowNum,int cellNum) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/DataContainer/Exceldata.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Cell cel = book.getSheet(SheetName).getRow(rowNum).getCell(cellNum);
		String value = cel.getStringCellValue();
		return value;
	}
}

