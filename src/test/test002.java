package test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.Constants;

public class test002 {

	public static void main(String[] args) throws InterruptedException{
		
		WebDriver dr;
		System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
		dr=new FirefoxDriver();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("This is the sample program to perform Random selection");
		dr.get("https://www.google.co.in/");
		dr.findElement(By.name("q")).sendKeys("TestNG");
		TimeUnit.SECONDS.sleep(3);
		WebElement options=dr.findElement(By.className("sbsb_b"));
		List<WebElement> OptionsList=options.findElements(By.tagName("li"));
		int n=OptionsList.size();
		System.out.println("The total number of options listed is : "+n);
		for(WebElement sel: OptionsList){
			Random rand= new Random();
			sel=OptionsList.get(rand.nextInt(n));
			String out=sel.getText();
			System.out.println("The randomly selected option is : "+out);
			sel.click();
			
			
		}
		
	}
}
