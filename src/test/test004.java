package test;

import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Utility.Constants;

public class test004 {

	public static WebDriver dr;
	
	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
		dr=new FirefoxDriver();
		dr.get("https://www.youtube.com/watch?v=UTnjtpftk4k&list=PL6flErFppaj2X3bInIqkw4wYGxT6n0n6H&index=1");
		TimeUnit.SECONDS.sleep(5);
		WebElement Skip=dr.findElement(By.xpath(".//*[text()='Skip Ad']"));
		Actions act=new Actions(dr);
		act.moveToElement(Skip).click().build().perform();
	}
}
