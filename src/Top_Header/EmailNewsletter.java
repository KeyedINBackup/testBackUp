package Top_Header;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utility.*;
import pageFactory.EmailNewsletterPage;


public class EmailNewsletter {
	
	public static WebDriver dr;

	
  @Test(enabled=true, priority=0)
  public static void Email_Newsletter_001() throws InterruptedException {
	  EmailNewsletterPage EN= PageFactory.initElements(dr, EmailNewsletterPage.class);
	  EN.ENLink();
	  EN.FirstName(Constants.FirstName);
	  EN.LastName(Constants.lastName);
	  EN.Email(Constants.Email);
	  EN.EmailVerify(Constants.EmailVerify);
	  EN.PostalCode(Constants.pincode);
	  EN.CheckBox();
	  JavascriptExecutor jse=(JavascriptExecutor)dr;
	  jse.executeScript("window.scrollBy(0,150)");
	  EN.SignUpLink();
	  TimeUnit.SECONDS.sleep(3);
	  String PS=dr.getPageSource();
	  if(PS.contains("You have successfully subscribed for the newsletter")){
		  System.out.println("Email_Newsletter_001 test case Pass");
	  } else {
		  System.out.println("Email_Newsletter_001 test case Fail");
	  }  
	  
  }
  
  @Test(enabled=true, priority=1)
  public static void Email_Newsletter_002() throws InterruptedException {
	  EmailNewsletterPage EN= PageFactory.initElements(dr, EmailNewsletterPage.class);
	  EN.ENLink();
	  EN.EmailunsubscribeLink();
	  TimeUnit.SECONDS.sleep(2);
	  EN.Email(Constants.Email);
	  EN.EmailVerify(Constants.EmailVerify);
	  EN.Reason(Constants.UReason);
	  EN.UnsubscribeLink();
	  TimeUnit.SECONDS.sleep(3);
	  String PS=dr.getPageSource();
	  if(PS.contains("You have unsubscribed")){
		  System.out.println("Email_Newsletter_002 test case Pass");
	  } else {
		  System.out.println("Email_Newsletter_002 test case Fail");
	  }  
	  
  }
  
  
  
  @BeforeTest()
  public static void BrowserInitiation(){
	  System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
	  dr=new FirefoxDriver();
	  dr.get(Constants.URL);
	  dr.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
  }
  
  @AfterTest()
  public static void EOF(){
//	  dr.quit();
  }
  
  
}
