package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.Constants;

public class test019 {
	
	public static void main(String[] args){
	// This is a sample Program for Window Handle	
		WebDriver dr;
		System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
		dr=new FirefoxDriver();
		dr.get("http://toolsqa.com/automation-practice-switch-windows/");
		dr.findElement(By.id("button1")).click();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Set<String> handle=dr.getWindowHandles();
		for(String handle1: handle){
			dr.switchTo().window(handle1);
			String text=dr.getTitle();
			System.out.println(text);
			dr.switchTo().defaultContent();
		}
//		dr.quit();
	}

}
