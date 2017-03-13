package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class EmailNewsletterPage {
	
		public static WebDriver dr;

		@FindBy(xpath="//*[@class='utilityNav-list']/li[1]") 
		@CacheLookup private WebElement EmailNewsLetterLink;
		
		@FindBy(id="FirstName") 
		@CacheLookup private WebElement Fname;
		
		@FindBy(id="LastName") 
		@CacheLookup private WebElement Lname;
		
		@FindBy(id="Email") 
		@CacheLookup private WebElement EmailId;
		
		@FindBy(id="EmailVerify") 
		@CacheLookup private WebElement EmailVerifyId;
		
		@FindBy(id="ZipPostalCode") 
		@CacheLookup private WebElement ZipPostalCode;
		
		@FindBy(id="NewsletterOptIn") 
		@CacheLookup private WebElement NewsletterCheckBox;
		
		@FindBy(xpath=".//*[text()='click here']") 
		@CacheLookup private WebElement Emailunsubscribe;
		
		@FindBy(xpath=".//*[@id='main']/div/section/form/div[2]/button") 
		@CacheLookup private WebElement SignUp;
		
		@FindBy(id="Opinion")
		@CacheLookup private WebElement TextArea;
		
		@FindBy(xpath=".//*[text()='Unsubscribe']")
		@CacheLookup private WebElement Unsubscribe;
		
		
		public void ENLink(){
			EmailNewsLetterLink.click();
		}
		
		
		public void FirstName(String text){
			Fname.sendKeys(text);
		}
		
		public void LastName(String text){
			Lname.sendKeys(text);
		}

		public void Email(String text){
			EmailId.sendKeys(text);
		}
		
		public void EmailVerify(String text){
			EmailVerifyId.sendKeys(text);
		}
		
		public void PostalCode(String text){
			ZipPostalCode.sendKeys(text);
		}
		
		public void CheckBox(){
			NewsletterCheckBox.click();
		}
		
		public void SignUpLink(){
			SignUp.click();
		}
		
		public void EmailunsubscribeLink(){
			Emailunsubscribe.click();
		}
		
		public void Reason(String text){
			TextArea.click();
		}
		
		public void UnsubscribeLink(){
			Unsubscribe.click();
		}
		
		
		
		
}
