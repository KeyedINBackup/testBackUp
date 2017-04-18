package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import Utility.Constants;

public class testNG001 {
	public static WebDriver dr;
  @Test
  public void test001() throws Exception {
 
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
		
  }
  @BeforeTest
  public void beforeTest() {
		
		System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
		dr=new FirefoxDriver();
  }

  @AfterTest
  public void afterTest() {
	  dr.close();
  }

}
