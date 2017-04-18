package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class test021 {

	public static XSSFWorkbook Wbook; 
	public static XSSFSheet Xsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static void SetExcelPath( int Sheetno) throws IOException{
		
		FileInputStream input= new FileInputStream("C:\\Users\\sakthivel\\Documents\\Jar files\\ReadExcel.xlsx");
		Wbook=new XSSFWorkbook(input);
		Xsheet=Wbook.getSheetAt(Sheetno);
	}
	
	public static String GetExcelData(int Row, int col){
		
		DataFormatter format=new DataFormatter();
		cell=Xsheet.getRow(Row).getCell(col);
		String cellvalue=format.formatCellValue(cell);
		System.out.println(cellvalue);
		return cellvalue; 
	}
	
	public static void SetExcelData(int Row, int col, String Result) throws IOException{

		row=Xsheet.getRow(Row);
		cell=row.createCell(col);
		cell.setCellValue(Result);
		FileOutputStream out= new FileOutputStream("C:\\Users\\sakthivel\\Documents\\Jar files\\ReadExcel.xlsx");
		Wbook.write(out);
		out.close();
		out.flush();
		
	}
	
	
	public static void main(String[] args) throws IOException{
		SetExcelPath(1);
		SetExcelData(1, 1, "This is Sparta");
		GetExcelData(1,1);
		
	}
	
	
}
