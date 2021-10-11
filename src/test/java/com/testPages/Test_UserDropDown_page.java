package com.testPages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseTestPage.Testbase;

public class Test_UserDropDown_page extends Testbase{
	
	 //HomePage is logged in with correct User name.
	
	@Parameters({"username","pwd"})
	//@Test (priority=1)             
	public void checkValidUserTC_05(String uname,String pwd) throws IOException {
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();		
		  //System.out.println(title);	
		 String  username= dropdown.checkUsername();		  		  
		  Assert.assertEquals(username,property.getValue("username"));		 
	}
	
	
	// I switched to classic mode in chrome and while Automation it is automatically going to Classic mode.
	
	@Parameters({"username","pwd"})
	//@Test(priority=2)
	public void checkUserMenuDropDownTC_05(String uname,String pwd) {
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();
		dropdown.clickOnUserMenu();
	  List<String> actuallist=dropdown.getMenuOptions();
	  System.out.println(actuallist);
	  String[] expectedMenu= {"My Profile", "My Settings", "Developer Console", "Switch to Lightning Experience", "Logout"}; 
	//change Array to ArrayList
	 boolean flag= actuallist.equals(Arrays.asList(expectedMenu));
	 Assert.assertTrue(flag);
	
	}
	
	@Parameters({"username","pwd"})
	//@Test(priority=3)
	public void validateMyProfileTC_06_01(String uname,String pwd) throws InterruptedException, AWTException {
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();
		dropdown.clickOnUserMenu();
		dropdown.clickOnMyProfile();
		dropdown.clickOnmyProfileEdit("jain");		
	}
	
	@Parameters({"username","pwd"})
	//@Test(priority=3)
	public void validateMyProfileTC_06_02(String uname,String pwd) throws InterruptedException, AWTException {
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();
		dropdown.clickOnUserMenu();
		dropdown.clickOnMyProfile();
	     dropdown.clickOnmyProfilePost();	
	}
	
	@Parameters({"username","pwd"})
	//@Test(priority=3)
	public void validateMyProfileTC_06_03(String uname,String pwd) throws Exception {
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();
		dropdown.clickOnUserMenu();
		dropdown.clickOnMyProfile();
		dropdown.clickOnmyProfileFile();		
	}
	
	@Parameters({"username","pwd"})
	@Test(priority=3)
	public void validateMyProfileTC_06_04(String uname,String pwd) throws InterruptedException, AWTException {
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();
		dropdown.clickOnUserMenu();
		dropdown.clickOnMyProfile();
		dropdown.clickOnmyProfilePhoto();
	}
	
	@Parameters({"username","pwd"})
	//@Test(priority=4)
	public void validateMySettingTC_07_01(String uname,String pwd) {
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();
		dropdown.clickOnUserMenu();
		dropdown.clickOnMySetting();
		dropdown.clickOnPersonal();
		dropdown.clickOnLoginHistory();
		dropdown.clickOnDownload();
		
	}
	
	@Parameters({"username","pwd"})
	//@Test(priority=4)
	public void validateMySettingTC_07_02(String uname,String pwd) {
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();
		dropdown.clickOnUserMenu();
		dropdown.clickOnMySetting();
		dropdown.clickOnDisplayLayout();
		dropdown.clickOnCustomizeTab();
		dropdown.selectCustomApp("Salesforce Chatter");
		dropdown.selectTab("Reports");
		Assert.assertTrue(dropdown.isSelected("Reports"));
	}
	
	@Parameters({"username","pwd"})
	//@Test(priority=4)
	public void validateMySettingTC_07_03(String uname,String pwd) throws IOException {
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();
		dropdown.clickOnUserMenu();
		dropdown.clickOnMySetting();
	    dropdown.clickOnEmail();
	    dropdown.clickOnEMailSetting();
	    String msg=dropdown.enterEmailNameId("a",property.getValue("email")); //property is reference variable for object util file
	   Assert.assertEquals(msg,"Your settings have been successfully saved.");
	
	}
	
	@Parameters({"username","pwd"})
     // @Test(priority=4)
	public void validateMySettingTC_07_04(String uname,String pwd) throws IOException {
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();
		dropdown.clickOnUserMenu();
		dropdown.clickOnMySetting();
		dropdown.clickOnCalender();
		dropdown.clickOnActivityReminder();
		String reminderWindow=dropdown.OpenTestReminder();
		//System.out.println(ReminderWindow);
		Assert.assertEquals(reminderWindow,"Activity Reminders ~ Salesforce - Developer Edition");
		
	}
	
	
	
	@Parameters({"username","pwd"})
	//@Test(priority=5)
	public void validateDevConsoleTC_08(String uname,String pwd) throws InterruptedException {
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();
		dropdown.clickOnUserMenu();
		dropdown.openDevConsole();
	}
	
	@Parameters({"username","pwd"})
	//@Test(priority=6)
	public void validateLogoutTC_09(String uname,String pwd) {
		loginpage.enterUsername(uname, pwd);
		String title=loginpage.clickOnLogin();
		dropdown.clickOnUserMenu();
	String titleOfLoginPage=dropdown.clickOnLogout();
	Assert.assertEquals(titleOfLoginPage,"Login | Salesforce");
	}
	
	
}
