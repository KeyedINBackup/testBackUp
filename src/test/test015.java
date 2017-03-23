package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test015 {
	
		public static XSSFWorkbook EBook;
		public static XSSFSheet ESheet;
		public static XSSFRow Row;
		public static XSSFCell cell;
		
		public static void SetExcelInfo(String Path) throws IOException{
			 FileInputStream input=new FileInputStream(Path);
			 EBook= new XSSFWorkbook(input);
			 ESheet=EBook.getSheetAt(1);
		}
		
		public static String GetExcelData(int row, int col){
			DataFormatter format=new DataFormatter();
			cell=ESheet.getRow(row).getCell(col);
			String cellvalue=format.formatCellValue(cell);
			return cellvalue;
		
		}
		
		public static void setExcelData(int row, int col, String result) throws IOException{
			Row=ESheet.getRow(row);
			cell=Row.createCell(col);
			cell.setCellType(cell.CELL_TYPE_STRING);
			cell.setCellValue(result);
			FileOutputStream out=new FileOutputStream("C:\\Users\\sakthivel\\Documents\\Jar files\\ReadExcel.xlsx");
			EBook.write(out);
			out.close();
		}
		
		
	}

