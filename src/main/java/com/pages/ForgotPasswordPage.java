package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basePage.Basepage;

public class ForgotPasswordPage extends Basepage {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(css="#un")
	WebElement Username;	
	@FindBy(css="#continue")
	WebElement continueBtn;
	@FindBy(css=".message")
	WebElement resetMsg;
	
	public void checkUsernameField(String uname) {
		Username.sendKeys(uname);
	}
	public String clickOncontinue() {
		continueBtn.click();
		return resetMsg.getText();
		
	}
	

}
