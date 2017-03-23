package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.jna.platform.FileUtils;

import Utility.Constants;

public class test013 {

	public static void main(String[] args) throws IOException{
		
		WebDriver dr;
		System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
		dr=new FirefoxDriver();
		dr.navigate().to("http://toolsqa.com/automation-practice-switch-windows/");
		File src=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(src, new File("C:\\Users\\sakthivel\\Documents\\Jar files\\test001.png"));
		
	}
}
