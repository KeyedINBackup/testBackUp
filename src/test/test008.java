package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebDriver;

public class test008 {
	
	public static WebDriver dr;
	public static XSSFWorkbook excelbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String Filepath; 
	
	
	public static void main(String[] ars) throws IOException{
		
		Filepath="C:\\Users\\sakthivel\\Documents\\Jar files\\ReadExcel.xlsx";
		FileInputStream input= new FileInputStream(Filepath);
		excelbook =new XSSFWorkbook(input);
		sheet=excelbook.getSheetAt(1);
		int n=sheet.getLastRowNum();
		for(int i=0; i<=n; i++){
			ReadData(i, 0);
			WriteData(i,0,"Passed");
		}
	}
	
	public static void ReadData(int Row, int col){
		DataFormatter formatter=new DataFormatter();
		cell=sheet.getRow(Row).getCell(col);
		String cellvalue=formatter.formatCellValue(cell);
		System.out.println(cellvalue);
	}
	
	public static void WriteData(int Row, int col, String status) throws IOException{
		row=sheet.getRow(Row);
		cell=row.createCell(col);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(status);
		FileOutputStream out=new FileOutputStream(Filepath);
		excelbook.write(out);
		out.close();
	}
	
	
	
}
