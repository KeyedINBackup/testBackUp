package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.Constants;

public class verifyURL {
	
	public static WebDriver dr;
	
	public static void main(String[] args) throws IOException{
		
		System.setProperty("webdriver.gecko.driver", Constants.Geckopath);
		dr=new FirefoxDriver();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.get("http://202.129.196.139:2240/Home");
		List<WebElement> options=dr.findElements(By.tagName("a"));
		int n=options.size();
		System.out.println("The total number of link present in the URL is: "+n);
		for(int i=0; i<n; i++){
			WebElement urlContent=options.get(i);
			String url=urlContent.getAttribute("href");
//			System.out.println("The link is :"+url);
			VerifyLinks(url);		
		}
		
	}

	public static void VerifyLinks(String linkUrl) throws IOException{
		try{
		URL url = new URL(linkUrl);
		HttpURLConnection httpCon=(HttpURLConnection)url.openConnection();
		httpCon.setConnectTimeout(3000);
		httpCon.connect();
		if(httpCon.getResponseCode()==200){
			System.out.println(linkUrl+"-"+httpCon.getResponseMessage());
		}if(httpCon.getResponseCode()==httpCon.HTTP_NOT_FOUND){
			System.out.println(linkUrl+"-"+httpCon.HTTP_NOT_FOUND);
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
}
