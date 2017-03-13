package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.Constants;

public class test003 {
	
	public static XSSFWorkbook ExcelBook;
	public static XSSFSheet Sheet;
	public static XSSFCell cell;
	public static XSSFRow Row;
	public static String FilePath;
	
	public static void main(String[] args) throws Exception{
		
		WebDriver dr;
		FilePath="C:\\Users\\sakthivel\\Documents\\Jar files\\ReadExcel.xlsx";
		FileInputStream File= new FileInputStream(FilePath);
		ExcelBook =new XSSFWorkbook(File);
		Sheet=ExcelBook.getSheetAt(0);
		System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
		dr=new FirefoxDriver();
		dr.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
		dr.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		/* DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
		 Cell cell1 = Sheet.getRow(0).getCell(0);
		 String CellValue1 = formatter.formatCellValue(cell1); //Returns the formatted value of a cell as a String regardless of the cell type.
		 Cell cell2 = Sheet.getRow(0).getCell(1);
		 String CellValue2 = formatter.formatCellValue(cell2);
		 Cell cell3 = Sheet.getRow(0).getCell(2);
		 String CellValue3 = formatter.formatCellValue(cell3); */
		
		String Message=getCellData(0, 0);
		String Value1=getCellData(0, 1);
		String Value2=getCellData(0, 2); 
		
		System.out.println("This is an Real time Example for Read and Write a Excel File using Selenium");
		
		System.out.println("The Message took from Excel is: "+Message);
		System.out.println("The Value took from Excel is: "+Value1);
		System.out.println("The Value took from Excel is: "+Value2);
		dr.findElement(By.xpath(".//*[@id='user-message']")).sendKeys(Message);
		dr.findElement(By.xpath(".//*[@id='get-input']/button")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.xpath(".//*[@id='sum1']")).sendKeys(Value1);
		dr.findElement(By.xpath(".//*[@id='sum2']")).sendKeys(Value2);
		WebElement button=dr.findElement(By.xpath(".//*[text()='Get Total']"));
		JavascriptExecutor jse = (JavascriptExecutor)dr;
		jse.executeScript("window.scrollBy(0,250)", "");
		TimeUnit.SECONDS.sleep(2);
		button.click();
		SetCellData(0, 3, "Test Passed");
		System.out.println("Excel File Written");
		dr.close();
		
	}
	
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		
		DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
		cell = Sheet.getRow(RowNum).getCell(ColNum);
		String Value = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		return Value;
		
	}
	
	public static void SetCellData(int RowNum, int ColNUm, String Result ) throws IOException{
		Row=Sheet.getRow(RowNum);
		cell=Row.createCell(ColNUm);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(Result);
		FileOutputStream Fos=new FileOutputStream(FilePath);
		ExcelBook.write(Fos);
		Fos.close();
		
	}
	
	

}
