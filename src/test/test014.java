package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.Constants;

public class test014 {

	public static void main(String[] args) throws Exception{
		WebDriver dr;
		System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
		dr=new FirefoxDriver();
		dr.get("https://accounts.google.com/ServiceLogin");
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.findElement(By.id("Email")).sendKeys("testusertesting");
		dr.findElement(By.id("next")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("Passwd")).sendKeys("423423");
		dr.findElement(By.id("signIn")).click();
		WebElement ErrorMessage=dr.findElement(By.id("errormsg_0_Passwd"));
		String Color=ErrorMessage.getCssValue("color");
		String FontSize=ErrorMessage.getCssValue("font-size");
		String Text=ErrorMessage.getText();
		System.out.println("Error message is:"+Text);
		System.out.println("Error message color code is:"+Color);
		System.out.println("Error message Font Size is:"+FontSize);
		dr.close();
	}
}
