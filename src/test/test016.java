package test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.Constants;

public class test016 {
	
	public static void main(String[] args) throws IOException{
		
		WebDriver dr;
		test015.SetExcelInfo("C:\\Users\\sakthivel\\Documents\\Jar files\\ReadExcel.xlsx");
		System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
		dr=new FirefoxDriver();
		dr.get("http://toolsqa.com/automation-practice-form/");
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String Fname=test015.GetExcelData(1, 0);
		String lname=test015.GetExcelData(2, 0);
		dr.findElement(By.name("firstname")).sendKeys(Fname);
		dr.findElement(By.name("lastname")).sendKeys(lname);
		dr.findElement(By.id("photo")).click();
		Runtime.getRuntime().exec("C:\\Users\\sakthivel\\Documents\\Jar files\\autoit-v3 (1)\\ToolsQAREGTest.exe");
		List<WebElement> options=dr.findElements(By.id("selenium_commands"));
		int n=options.size();
		for(int i=0; i<=n; i++){
			String S=options.get(i).getText();
			System.out.println(S);		
		}
	}

}
