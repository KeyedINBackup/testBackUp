package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Utility.Constants;

public class windowHandle {
  @Test
  public void handleWindow() {
	  WebDriver dr;
	  System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
	  dr=new FirefoxDriver();
	  dr.get("http://toolsqa.com/automation-practice-switch-windows/");
	  dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  dr.findElement(By.xpath(".//*[@id='button1']")).click();
	  java.util.Set<String> allWindows = dr.getWindowHandles();
	  for(String handle: allWindows){
		  dr.switchTo().window(handle);
//		  dr.manage().window().maximize();
		  dr.switchTo().defaultContent();
		  String title=dr.getCurrentUrl();
		  System.out.println(title);
		  
	  }
	  
	  
	  
  }
}
