package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import Utility.Constants;

public class test005 {

	public static WebDriver dr; public static XSSFCell cell; public static XSSFRow row; public static XSSFSheet Sheet;
	public static XSSFWorkbook ExcelBook; public static String path;
	
	public static void main(String[] args) throws IOException{
		
		System.getProperty("webdriver.gecko.driver", Constants.Geckopath);
		path="C:\\Users\\sakthivel\\Documents\\Jar files\\ReadExcel.xlsx";
		FileInputStream input= new FileInputStream(path);
		ExcelBook= new XSSFWorkbook(input);
		Sheet=ExcelBook.getSheetAt(1);
		int n=Sheet.getLastRowNum();
		for(int i=0; i<=n; i++){
			DataFormatter format= new DataFormatter();
			cell=Sheet.getRow(i).getCell(0);
			String data=format.formatCellValue(cell);
		 System.out.println(data);
		 writeCell(i, 1, "Printed");
		}
		
	}
	
	public static void writeCell(int Row, int col, String result) throws IOException{
		row=Sheet.getRow(Row);
		cell=row.createCell(col);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(result);
		FileOutputStream out=new FileOutputStream(path);
		ExcelBook.write(out);
		out.close();
				
	}
}
