package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basePage.Basepage;
import com.sun.tools.sjavac.Log;

public class SFDC_Login_page extends Basepage {

	public SFDC_Login_page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="#username")
	WebElement Username;
	@FindBy(css="#password")
	WebElement Password;
	@FindBy(css="#Login")
	WebElement LoginBtn;
	@FindBy(css="#error")
	List<WebElement> errorMsg;
	@FindBy(css="#rememberUn")
	WebElement rememberMe;
	@FindBy(css="#idcard-identity")
	WebElement UsernameField;
	@FindBy(css="#forgot_password_link")
	WebElement forgotPasswordLink;
	
	@FindBy(css="#un")
	WebElement Uname;
	
	public void enterUsername(String name,String pwd) {
		Username.sendKeys(name);
		Password.sendKeys(pwd);		
	}	
	public String clickOnLogin() {		
		click(LoginBtn);		
		  if(errorMsg.size()!=0) {
			  System.out.println(errorMsg.get(0).getText());
			  return errorMsg.get(0).getText(); }
		  else {			 
		return driver.getTitle();}		
	}
	
	public void clickOnRememberme() {
		click(rememberMe);
	}	
	
	public String checkUsernameField() {
		wait(UsernameField);
		return UsernameField.getText();
	}
	
	public String forgotPassword() {
		 click(forgotPasswordLink);
		 wait(Uname);
		 return driver.getTitle();
		
	}	
	
	
}
