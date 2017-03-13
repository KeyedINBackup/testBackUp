package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.Constants;

public class test0001 {

	public static void main(String[] args) throws InterruptedException{
		
		WebDriver dr;
		System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
		dr=new FirefoxDriver();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("This is a sample test for getting auto suggestion list");
		dr.get("https://www.google.co.in/");
		dr.findElement(By.name("q")).sendKeys("perfecto");
		WebElement result=dr.findElement(By.className("sbsb_b"));
		List<WebElement> options=result.findElements(By.tagName("li"));
		for(WebElement selection: options){
			String re=selection.getText();
			System.out.println(re);
			TimeUnit.SECONDS.sleep(3);
			if(re.equalsIgnoreCase("perfecto tool")){
				selection.click();
				
			}
		}
		
	}
	
}
