package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Constants;

public class test011 {
	
	public static void main(String[] args) throws InterruptedException{
		
		WebDriver dr;
		System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
		dr=new FirefoxDriver();
		dr.get("http://toolsqa.com/selenium-webdriver/handle-dynamic-webtables-in-selenium-webdriver/"); 
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement TutorialLinks = dr.findElement(By.xpath(".//*[@id='text-15']/div[2]"));
		JavascriptExecutor jse=(JavascriptExecutor)dr;
		jse.executeScript("arguments[0].scrollIntoView(true);", TutorialLinks);
	    List<WebElement> links=TutorialLinks.findElements(By.tagName("a"));
	    int n=links.size();
	    System.out.println("The Total number of available links is:"+n);
	    
	    for(int i=1; i<=n; i++){
	    	String str="html/body/div[1]/footer/div[1]/div/div/section[3]/div[2]/b[";
	    	String str1="]/a";
	    	WebDriverWait wait=new WebDriverWait(dr, 10);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str+i+str1)));
	    	dr.findElement(By.xpath(str+i+str1)).click();
	    	TimeUnit.SECONDS.sleep(3);
	    	dr.navigate().back();
	    	
	    	}
	    
	    dr.quit();
		}
	}
