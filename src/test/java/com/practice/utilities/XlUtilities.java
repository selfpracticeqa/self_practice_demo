package com.practice.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlUtilities 
{
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public int getRowCount(String xlFile, String xlSheet) throws IOException
	{
		fis = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlSheet);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
		
	}
	
	public int getColumnCount(String xlFile, String xlSheet, int rowNum) throws IOException
	{
		fis = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		int columnCount = row.getLastCellNum();
		fis.close();
		workbook.close();
		return columnCount;
		
	}
	
	public String getCellData(String xlFile, String xlSheet, int rowNum, int columnNum) throws IOException
	{
		fis = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(columnNum);
		
		String data="";
		
		try
		{
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
		catch (Exception e)
		{
			return data;
		}
	}
	
	
	
}
