package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebDriver;

import Utility.Constants;

public class test006 {

	public static XSSFWorkbook ExcelBook;
	public static XSSFSheet Sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static WebDriver dr;
	
	public static void main(String[] args) throws IOException{
		
		System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
		String FilePath="C:\\Users\\sakthivel\\Documents\\Jar files\\ReadExcel.xlsx";
		FileInputStream input=new FileInputStream(FilePath);
		ExcelBook= new XSSFWorkbook(input);
		Sheet=ExcelBook.getSheetAt(1);
		int n=Sheet.getLastRowNum();
		for(int i=0; i<=n; i++){
			getdata(i, 0);
			printResult(i, 0, "Tested");
		}
	}
	
	public static String getdata(int Row, int Col){
		DataFormatter format= new DataFormatter();
		cell=Sheet.getRow(Row).getCell(Col);
		String cellvalue=format.formatCellValue(cell);
		System.out.println(cellvalue);
		return cellvalue;	
	}
	
	public static void printResult(int Row, int col, String result) throws IOException{
		row=Sheet.getRow(Row);
		cell=row.createCell(col);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(result);
		FileOutputStream fileOut=new FileOutputStream("C:\\Users\\sakthivel\\Documents\\Jar files\\ReadExcel.xlsx");
		ExcelBook.write(fileOut);
		fileOut.close();
	}
	
}
