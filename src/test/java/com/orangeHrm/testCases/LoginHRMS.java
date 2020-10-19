package com.orangeHrm.testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class LoginHRMS {
	
	public static void main(String[] args) throws Exception {
		
		String filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestData.xlsx";
		
		FileInputStream fis= new FileInputStream(filePath);
		Workbook wbook= new XSSFWorkbook(fis);
		Sheet sht=wbook.getSheet("Sheet1");
		String r1c1=sht.getRow(0).getCell(0).toString();
		System.out.println(r1c1);
		
		int rows=sht.getPhysicalNumberOfRows();
		int cols=sht.getRow(0).getLastCellNum();
		System.out.println(rows+" "+cols);
		
		List<Map<String,String>> xlData=new ArrayList<>();
		for (Map<String, String> map : xlData) {
			
			System.out.println(xlData.add(map));
			
		}
		
		
		
	}
	
	
}





