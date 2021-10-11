package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basePage.Basepage;

public class CreateAccount_page extends Basepage {

	public CreateAccount_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "#Account_Tab")
	WebElement accounts;
	@FindBy(css = "input[value=' New ']")
	WebElement newBtn;
	@FindBy(css = "#acc2")
	WebElement aName;
	@FindBy(css = "select#acc6")
	WebElement type;
	//Visible text="Technology Partner"
	@FindBy(css = "select[name='00N4x00000EofQ1']")
	WebElement cPriority;
	@FindBy(css = "#bottomButtonRow input[title='Save']")
	WebElement saveBtn;
	@FindBy(xpath = "//a[@id='tryLexDialogX']")
	WebElement popUpClose;
	@FindBy(xpath = "//a[text()='Create New View']")
	WebElement createAccountView;
	@FindBy(css = "#fname")
	WebElement viewName;
	@FindBy(css = "#devname")
	WebElement viewUniqueName;	
	 @FindBy(css=".pbBottomButtons input[class='btn primary']") 
	 WebElement  saveBtn2;
	 @FindBy(css="select[title='View:']") 
	 WebElement  viewList;
	 @FindBy(css="select.title option") 
	 List<WebElement>  vList;
	 @FindBy(xpath ="//tbody//tr//div//form//a[1]") 
	 WebElement  editBtn;
	 @FindBy(css="#fcol1") 
	WebElement  col1;
	 @FindBy(css="#fop1") 
	 WebElement  col2;
	 @FindBy(css="#fval1") 
	 WebElement  col3;
	 @FindBy(css="#colselector_select_0") 
	 WebElement aField;	
	 @FindBy(css="#colselector_select_1") 
	 WebElement aField2;	 
	 @FindBy(css="#colselector_select_0_right .rightArrowIcon") 
	 WebElement addBtn;	
	 @FindBy(css="div.pbHeader .btn.primary") 
	 WebElement saveBt;	
	 @FindBy(xpath="//td[contains(@class,'x-grid3-hd x-grid3-cell')]//a") 
	 List<WebElement> accountNames;	
	 @FindBy(xpath="//td[contains(@class,'x-grid3-hd x-grid3-cell x-grid3-td-ACCOUNT_LAST_ACTIVITY')]") 
	 WebElement lastActivity;	
	 @FindBy(linkText="Merge Accounts") 
	 WebElement mAccount;
	
	  @FindBy(css="#srch") 
	  WebElement fAccount;
	  
	  @FindBy(css=".pbWizardBody input[value='Find Accounts']") 
	  WebElement fAccountBtn;
	  
	  @FindBy(css=".pbBottomButtons input[value=' Next ']") 
	  WebElement next;
	  @FindBy(css=".pbBottomButtons input[value=' Merge ']") 
	  WebElement merge;
	  @FindBy(css=".list tr  th a") 
	  List<WebElement> afterMergeList;
	 
	 
	 
	
	 

	public void clickOnAccounts() {
		click(accounts);		
		click(popUpClose);		
	}
	public String clickOnAccounts(String name,String typeText,String priority) {			
		
		click(newBtn);
		try {			
			enterText(aName,name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectText(type,typeText);
		selectText(cPriority,priority);
		click(saveBtn);	
		return getTitle();
	}
	
	public List<String> clickOnCreateView(String vName,String uName) {		
		
		click(createAccountView);
		try {
			enterText(viewName,vName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			enterText(viewUniqueName,uName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(saveBtn2);		
		click(viewList);
		List<String> viewL= new ArrayList<String>();
		for(WebElement ele:vList)
			viewL.add(ele.getText());		
		return viewL;
	}
	
	
	public boolean clickOnViewEdit(int accountIndex,String vName,String scol1,String scol2,String scol3,String avField) {
		
		click(viewList);
		getListOptions(viewList).selectByIndex(accountIndex);
		click(editBtn);
		wait(viewName);
		viewName.clear();
		enterText(viewName,vName);
		selectText(col1,scol1);
		selectText(col2,scol2);
		enterText(col3,scol3);
		try {
		selectText(aField,avField);
		click(addBtn);}
		catch(Exception e) {
			selectText(aField2,avField);			
		}
		click(saveBt);
		/*
		 * for(WebElement ele:accountNames) { if(!ele.getText().contains("a")) return
		 * false; }
		 */	
		if(!lastActivity.isDisplayed())
			return false;
		return true;
		
	}
	
	
	public boolean mergeAccounts(String accountname) {
		click(mAccount);
		enterText(fAccount,accountname);
		click(fAccountBtn);
		click(next);
		click(merge);
		handleAlert().accept();		
		for(WebElement ele:afterMergeList) {
			if(ele.getText().contains(accountname))
				return true;			
		}
		return false;
	}
	
	
}
