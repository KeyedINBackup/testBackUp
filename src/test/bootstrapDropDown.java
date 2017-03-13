package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class bootstrapDropDown {

	public static void main(String [] args){
		
		WebDriver dr;
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sakthivel\\Documents\\Jar files\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		dr=new FirefoxDriver();
		dr.navigate().to("http://toolsqa.com/");
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement DropDown = dr.findElement(By.xpath(".//*[text()='Tutorial']"));
		DropDown.click();
		List<WebElement> options=dr.findElements(By.xpath(".//*[@id='primary-menu']/li[2]/ul/li"));
		for(WebElement selection: options){
			String Actual=selection.getAttribute("innerHTML");
			if(Actual.contains("Maven")){
				selection.click();
			}
		}
		
	}
}
