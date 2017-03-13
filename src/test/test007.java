package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebDriver;

import Utility.Constants;

public class test007 {

	public static WebDriver dr;
	public static XSSFWorkbook excelbook;
	public static XSSFSheet excelsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static void main(String[] args) throws IOException{
		
//		System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
		
		String FilePath="C:\\Users\\sakthivel\\Documents\\Jar files\\ReadExcel.xlsx";
		FileInputStream input= new FileInputStream(FilePath);
		excelbook= new XSSFWorkbook(input);
		excelsheet=excelbook.getSheetAt(1);
		int n=excelsheet.getLastRowNum();
		for(int i=0; i<=n; i++){
			String result="Sample"+i;
			setdata(i, 0, result);
		}
		for(int j=0; j<=n; j++){
			String text=getdata(j,0);
			System.out.println(text);
		}
		
		
	}
	
	
	public static String getdata(int Row, int col){
		DataFormatter format=new DataFormatter();
		cell=excelsheet.getRow(Row).getCell(col);
		String cellvalue=format.formatCellValue(cell);
		return cellvalue;
		
	}
	
	public static void setdata(int Row, int col, String result) throws IOException{
		row=excelsheet.getRow(Row);
		cell=row.createCell(col);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(result);
		FileOutputStream out= new FileOutputStream("C:\\Users\\sakthivel\\Documents\\Jar files\\ReadExcel.xlsx");
		excelbook.write(out);
		out.close();
		
	}
}
