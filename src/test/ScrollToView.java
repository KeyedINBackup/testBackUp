package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;

import Utility.Constants;

public class ScrollToView {

public static void main(String[] args){
	
	WebDriver dr;
	System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
	dr=new FirefoxDriver();
	dr.get("http://202.129.196.139:2240/Home");
	dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement text=dr.findElement(By.xpath("//div[@class='content-inner-list']/div[1]"));
	JavascriptExecutor jse=(JavascriptExecutor)dr;
//	jse.executeScript("arguments[0].scrollIntoView(true);", text);
	jse.executeScript("arguments[0].style.border='4px solid red'", text);
	String gtext=text.getText();
	System.out.println("The Viewed element text is: "+gtext);
		
}
}
