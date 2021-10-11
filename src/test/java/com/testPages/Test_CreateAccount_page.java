package com.testPages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseTestPage.Testbase;

public class Test_CreateAccount_page extends Testbase {
	
	@Parameters({"username","pwd"})
	//@Test (priority=1)             
	public void createAccountsTC_10(String uname,String pwd) throws IOException {
		
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();		
		  //System.out.println(title);	
		account.clickOnAccounts();
		 String accountTitle=account.clickOnAccounts("Tekarch","Technology Partner","High");
		 Assert.assertEquals(accountTitle,"Account: Tekarch ~ Salesforce - Developer Edition");
		 
	}
	
	
	@Parameters({"username","pwd"})
	//@Test (priority=1)             
	public void  CreatenewviewTC_11(String uname,String pwd) throws IOException {
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();		
		  //System.out.println(title);
		account.clickOnAccounts();
		 List<String> viewList=account.clickOnCreateView("Tekarch3", "training3");//viewName,Unique name
		 Assert.assertTrue(viewList.contains("Tekarch"));
	}
	
	@Parameters({"username","pwd"})
	//@Test (priority=1)             
	public void  EditviewTC_12(String uname,String pwd) throws IOException {
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();		
		  //System.out.println(title);
		account.clickOnAccounts();
		boolean flag=account.clickOnViewEdit(0, "TK", "Account Name", "contains", "a", "Last Activity");
	        Assert.assertTrue(flag);
	} 
	
	
	
	@Parameters({"username","pwd"})
	@Test (priority=1)             
	public void  MergeAccountsTC_13(String uname,String pwd) throws IOException {
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();		
		  //System.out.println(title);
		   account.clickOnAccounts();
		   boolean actual=account.mergeAccounts("Tekarch");
		   Assert.assertTrue(actual);
	
	}

}
