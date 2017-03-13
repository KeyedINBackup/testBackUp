package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.omg.SendingContext.RunTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.Constants;

public class test010 {
	public static void main(String[] args) throws IOException{
		WebDriver dr;
		System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
		dr=new FirefoxDriver();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.get("https://encodable.com/uploaddemo/");
		dr.findElement(By.xpath(".//*[@id='uploadname1']")).click();
		Runtime.getRuntime().exec("C:\\Users\\sakthivel\\Documents\\Jar files\\autoit-v3 (1)\\testUP.exe");
		
	}

}
