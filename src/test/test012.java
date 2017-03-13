package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class test012 {

	public static XSSFWorkbook excelbook;
	public static XSSFSheet excelsheet;
	public static XSSFRow Row;
	public static XSSFCell cell;
	
	
	public static void main(String[] args) throws IOException{
		
//		WebDriver dr;
//		System.setProperty("webdriver.gecko.driver", Constants.Geckopath);

		FileInputStream input=new FileInputStream("C:\\Users\\sakthivel\\Documents\\Jar files\\ReadExcel.xlsx");
		excelbook=new XSSFWorkbook(input);
		excelsheet=excelbook.getSheetAt(1);
		int n=excelsheet.getLastRowNum();
		for(int i=0; i<=n; i++){
			String val=getData(i, 0);
			System.out.println(val);
			String val2="test00"+i;
			SetData(i, 0, val2);
		}
	}
	
	public static String getData(int row, int col){	
		DataFormatter formatit=new DataFormatter();
		cell=excelsheet.getRow(row).getCell(col);
		String cellvalue=formatit.formatCellValue(cell);
		return cellvalue;		
	}
	
	public static void SetData(int row, int col, String Status) throws IOException{
		Row=excelsheet.getRow(row);
		cell=Row.createCell(col);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(Status);
		FileOutputStream out= new FileOutputStream("C:\\Users\\sakthivel\\Documents\\Jar files\\ReadExcel.xlsx");
		excelbook.write(out);
		out.close();
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
