package com.orangeHrm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static Workbook book;
	public static Sheet sheet;
	public static void openExcel(String filePath) {
		try {
			FileInputStream fis= new FileInputStream(filePath);
			 book= new XSSFWorkbook(fis); //to read the format of xlsx format
//			 book = new HSSFWorkbook(fis);//to read the fromat of xls format
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void loadSheet(String SheetName) {
		 sheet=book.getSheet(SheetName);
	}
	
	private static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	private static int columCount(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum();
	}
	private static String cellData(int rowIndex,int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}
	
	//return 2d object array of data
	
	public static Object[][] excelToArray(String filePath,String SheetName){
		
		openExcel(filePath);
		loadSheet(SheetName);
		int totalRows=rowCount();
		int totalColums=columCount(0);
		Object[][] data= new Object[totalRows-1][totalColums];
		for(int i=1;i<totalRows;i++) {
			for (int j=0;j<totalColums;j++) {
				//storing the values into 2d array
				data[i-1][j]=	cellData(i,j);
			}
		}
		return data;
		
	}
	
}
