package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basePage.Basepage;

public class Home_page extends Basepage {
	
	//@FindBy(css=".uiImage[data-aura-rendered-by='6:730;a']")	
	@FindBy(css="#userNavButton")
	WebElement User;
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement Logout;	
	
	
	public Home_page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);		
	}
	
	public void clickOnUser() {		
		wait(User);
		User.click();}
	
	public void clickOnLogout() {
		wait(Logout);
		Logout.click();
	}
	
	
	


}
