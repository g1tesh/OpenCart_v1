package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSUtility {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	FileInputStream FI;
	
	
	
	public int GetRowCount(String path) throws IOException
	{
		 FI = new FileInputStream(path);
		 workbook = new XSSFWorkbook(FI);
		 sheet = workbook.getSheet("Sheet1");
		 int rowcount = sheet.getLastRowNum();
		 workbook.close();
		 FI.close();
		 return rowcount;
	}
	
	public int GetColcount(String path) throws IOException
	{
		FI = new FileInputStream(path);
		workbook = new XSSFWorkbook(FI);
		sheet = workbook.getSheet("Sheet1");
		int colcount = sheet.getRow(1).getLastCellNum();
		workbook.close();
		FI.close();
		return colcount;
	}
	
	public String GetData(int rownum, int colnum, String path) throws IOException
	{
		FI = new FileInputStream(path);
		workbook = new XSSFWorkbook(FI);
		sheet = workbook.getSheet("Sheet1");
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter  = new DataFormatter();
		String data;
		
		try {
			data = formatter.formatCellValue(cell);
			}
		catch(Exception e)
			{
				data = "";
			System.out.println("exception caught");
			}
		workbook.close();
		FI.close();
		return data;
		
	}

}
