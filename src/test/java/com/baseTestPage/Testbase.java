package com.baseTestPage;


import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basePage.Basepage;
import com.pages.CreateAccount_page;
import com.pages.ForgotPasswordPage;
import com.pages.Home_page;
import com.pages.SFDC_Login_page;
import com.pages.UserDropDown_page;
import com.utilityFiles.BrowserInit;
import com.utilityFiles.FilePath;
import com.utilityFiles.PropertyFileUtil;

public class Testbase{
	

	public WebDriver driver;
	public BrowserInit webBrowser;  //BrowserInit class is in the Utility package
	public PropertyFileUtil property;//PropertyFileUtil class is in Utility package
	public Basepage basepage;
	public SFDC_Login_page loginpage;
	public Home_page homepage;
	public ForgotPasswordPage fPpage;
	public UserDropDown_page dropdown;
	public CreateAccount_page account;
	

	
	@BeforeMethod
	public void setUp() throws IOException {
		//System.out.println("times call this method");
		webBrowser= new BrowserInit(); //object of BrowserInit class		
		property= new PropertyFileUtil(); //object of PropertyFileUtil		
		String browserName=property.getValue("browser"); //read property file browser value
		driver= webBrowser.getBrowser(browserName);//this will return object of a browser
		
		//Customize browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Configure Log file
		DOMConfigurator.configure("log4j.xml");
		
		
		//initializing basepage driver
				basepage=new Basepage(driver);
				//initializing Login page
				loginpage=new SFDC_Login_page(driver);
				//initialize home page
				homepage= new Home_page(driver);
				//initializing forgotpassword page
				fPpage=new ForgotPasswordPage(driver);
				//initializing user dropdown page
				dropdown=new UserDropDown_page(driver);
				//initializing CreateAccount_page
				account=new CreateAccount_page(driver);				
				//Getting URL				
				String URL= property.getValue("url");
				 driver.get(URL);
	}
	
	
	
	//@AfterMethod
	public void takeScreenshot() throws IOException {		
		basepage.screenshot();
		driver.close();
		
	}
	

}
