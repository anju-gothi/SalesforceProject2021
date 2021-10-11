package com.testPages;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseTestPage.Testbase;
import com.sun.tools.sjavac.Log;

public class Test_SFDC_Login_page extends Testbase {
	
	@Parameters({"username"})
	//@Test(priority=1)
	public void LoginErrorMessage_1(String username) {
		
		loginpage.enterUsername(username,"");
		String title=loginpage.clickOnLogin();
		Assert.assertEquals(title,"Please enter your password." );
	}
	
	@Parameters({"username","pwd"})
	//@Test(priority=2)
	public void LoginToSalesForce_2(String username,String password){
		//Log.info("Inside second test");
	 loginpage.enterUsername(username,password);
	 String title=loginpage.clickOnLogin();
	 System.out.println(title);
	// Log.info(title);
	 Assert.assertEquals(title,"Home Page ~ Salesforce - Developer Edition" );
	 
	}	
	
	@Parameters({"username","pwd"})
	//@Test(priority=3)
	public void CheckRemeberMe_3(String username,String password) {		
		loginpage.enterUsername(username,password);
		loginpage.clickOnRememberme();
		String title=loginpage.clickOnLogin();
		Assert.assertEquals(title,"Home Page ~ Salesforce - Developer Edition" );//Sales force home page is displayed
		//System.out.println(driver.getTitle());		
		homepage.clickOnUser();	
		homepage.clickOnLogout();
		String uname=loginpage.checkUsernameField();
		//System.out.println(uname);
		Assert.assertEquals(uname,username);
	}
	
	@Parameters({"username"})
	//@Test(priority=4)
	public void ForgotPassword_4A(String uname){
		String title=loginpage.forgotPassword();
		//System.out.println(title);
		Assert.assertEquals(title,"Forgot Your Password | Salesforce" );
		fPpage.checkUsernameField(uname);
	   String msg=fPpage.clickOncontinue();
	   //System.out.println(msg);
	   
	}
	
	//@Test(priority=5)
	public void ValidateLoginErrorMessage_4B() {
	loginpage.enterUsername("123","22131" );
	String msg=	loginpage.clickOnLogin();	        
	System.out.println(msg);
	}
	

}
