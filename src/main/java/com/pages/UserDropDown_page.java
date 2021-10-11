package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.basePage.Basepage;
import com.utilityFiles.FilePath;

public class UserDropDown_page extends Basepage {

	public UserDropDown_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#userNavButton")
	WebElement User;
	@FindBy(css = "#userNav-menuItems a")
	List<WebElement> menuList;
	@FindBy(css = "#userNav-menuItems .menuButtonMenuLink.firstMenuItem")
	WebElement Profile;
	// @FindBy(css="a[class='contactInfoLaunch editLink'] img[title='Edit
	// Profile']")
	@FindBy(css = ".editPen>a[class*='contactInfoLaunch editLink']>img[title='Edit Profile']")
	WebElement Editlink;
	@FindBy(css = "#contactInfoContentId")
	WebElement EditpopUpFrame;
	@FindBy(css = "#aboutTab")
	WebElement AboutTab;
	@FindBy(css = "#lastName")
	WebElement Lastname;
	@FindBy(css = ".zen-btn.zen-primaryBtn.zen-pas")
	WebElement SaveAllBtn;
	//@FindBy(xpath = "//a[@title='Post']/span[contains(@class,'publisherattachtext')]")
	@FindBy(id="publisherAttachTextPost")
	WebElement PostBtn;
	@FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement Frame;
	@FindBy(xpath = "//body[contains(@class,'chatterPublisherRTE')]")
	WebElement Editor;
	@FindBy(css = "input#publishersharebutton")
	WebElement ShareBtn;
	@FindBy(css = "a[title*='Developer Console (New Window)']")
	WebElement DevConsole;
	@FindBy(css="a.menuButtonMenuLink[title='Logout']")
	WebElement logout;
	@FindBy(css="#username")
	WebElement Username;
	@FindBy(css=".menuButtonMenuLink[title='My Settings']")
	WebElement MySetting;
	@FindBy(css="#PersonalInfo_font")
	WebElement Personal;
	@FindBy(css="#LoginHistory_font.leafText")
	WebElement LoginHistory;
	@FindBy(css=".pShowMore a")
	WebElement Download;
	@FindBy(css=".folderIcon.DisplayAndLayout_icon")
	WebElement DisplayLayout;
	@FindBy(css=".leafText#CustomizeTabs_font")
	WebElement CustomizeTab;
	@FindBy(css="#p4")
	WebElement CustomApp;
	@FindBy (css="#duel_select_0")
	WebElement Tab;
	@FindBy (css=".rightArrowIcon")
	WebElement ArrowBtn;
	@FindBy (css=".btn.primary")
	WebElement SaveBtn;
	@FindBy(css="#duel_select_1")
	WebElement SelectedTab;
	@FindBy(css="#EmailSetup_font")
	WebElement Email;
	@FindBy(css=".leafText#EmailSettings_font")
	WebElement EmailSetting;
	@FindBy(css="#sender_name")
	WebElement EmailName;
	@FindBy(css="#auto_bcc1")
	WebElement AutoBcc;
	@FindBy(css="#sender_email")
	WebElement EmailAdd;
	@FindBy(css=".btn.primary")
	WebElement SaveBt;
	@FindBy(css="#meSaveCompleteMessage .messageText")
	WebElement TextMsg;
	@FindBy(css="#CalendarAndReminders_font")
	WebElement Calender;
	@FindBy(css=".leafText#Reminders_font")
	WebElement ActivityReminder;
	@FindBy(css="input#testbtn")
	WebElement OpenReminder;
	@FindBy(xpath="//a[@title='File']/span[contains(@class,'publisherattachtext')]")
	WebElement Filelink;	
	  @FindBy(css="#chatterUploadFileAction")
	  WebElement UploadFileBtn;	
	  @FindBy(css="input#chatterFile") WebElement
	  ChooseFileBtn;	
	 // @FindBy(css="#photoSection img.chatter-photo") 
	  @FindBy(id="displayBadge")
	  WebElement Img;	  
	  @FindBy(css=".photoUploadSection") 
	  WebElement AddPhotoBtn; 
	 // @FindBy(css="#uploadPhotoContentId") 
	  @FindBy(xpath="//iframe[@id='uploadPhotoContentId']")
	  WebElement FramePhotoUpload;
	  @FindBy(css=".fileInput") 
	  WebElement ChoosePhoto;
	  @FindBy(css="[name='j_id0:uploadFileForm:save'].btn.saveButton") 
	  WebElement SavePhoto;
	 
	
	

	public String checkUsername() {
		wait(User);
		System.out.println(User.getText());
		return User.getText();
	}

	public void clickOnUserMenu() {		
		click(User);
	}

	public List<String> getMenuOptions() {
		List<String> list = new ArrayList<String>();
		for (int index = 0; index < menuList.size(); index++)
			list.add(menuList.get(index).getText());
		// System.out.println(list);
		return list;
	}
	
	public void clickOnMyProfile() {
		click(Profile);	
	}

	public void clickOnmyProfileEdit(String lastname) throws InterruptedException, AWTException {
		
		
		click(Editlink);
		//wait(Editlink);
		/*
		 * js = (JavascriptExecutor) driver; js.executeScript("arguments[0].click();",
		 * Editlink);
		 */		 wait(EditpopUpFrame);		
		 driver.switchTo().frame(EditpopUpFrame);	

	}
	
	public void clickOnmyProfilePost() {		
		
		click(PostBtn);
		wait(Frame);
		switchFrame(Frame);	
		click(Editor);
		try {
			enterText(Editor,"Anju");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
		click(ShareBtn);		
	}
	
	public void clickOnmyProfileFile() throws Exception {
		click(Filelink);
		click(UploadFileBtn);
		String filePath=FilePath.UPLOADFILE;		
		enterText(ChooseFileBtn,filePath);		
	}	
	
	public void clickOnmyProfilePhoto() {
		wait(Img);
		mouseHover(Img);
		click(AddPhotoBtn);
		wait(FramePhotoUpload);
		switchFrame(FramePhotoUpload);
		try {
			enterText(ChoosePhoto,FilePath.PHOTOPATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(SavePhoto);
	}
	
	

	public void openDevConsole() throws InterruptedException {
		click(DevConsole);
		String parentWindow = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String childWindow = it.next();
			if (parentWindow != childWindow)
				driver.switchTo().window(childWindow);

		}
		driver.close();
		driver.switchTo().window(parentWindow);

	}
	
	public String clickOnLogout() {		
		click(logout);		
		wait(Username);
		return driver.getTitle();
	}
	
	public void clickOnMySetting() {
		click(MySetting);	
	}
	public void clickOnPersonal() {		
		click(Personal);	
	}
	public void clickOnLoginHistory() {		
		click(LoginHistory);
	}
	public void clickOnDownload() {
		click(Download);
	}
	public void clickOnDisplayLayout() {	
		click(DisplayLayout);
	}
	public void clickOnCustomizeTab() {		
		click(CustomizeTab);
	}
	public void selectCustomApp(String text) {
		wait(CustomApp);
		selectText(CustomApp,text);
		//getListOptions(CustomApp).selectByVisibleText(text);	      
	}
	public void selectTab(String text) {
		//getListOptions(Tab).selectByVisibleText(text);
		selectText(Tab,text);
		click(ArrowBtn);
		click(SaveBtn);
	}
	
	public boolean isSelected(String text) {		
		List<WebElement> list=getListOptions(SelectedTab).getOptions();
	  for(WebElement ele:list)
	  {
		  if(ele.getText().equals(text));
		  return true;
	  }
	  return false;
	}
	
	

	public void clickOnEmail() {
		click(Email);
	}
	
	public void clickOnEMailSetting() {
		click(EmailSetting);
	}
	public String enterEmailNameId(String name,String id) {	
		wait(EmailName);
		EmailName.sendKeys(name);	
		EmailAdd.clear(); //.clear to reset the text default field
		EmailAdd.sendKeys(id);
		click(SaveBt);
		wait(TextMsg);
		return TextMsg.getText();		
	}
	public void clickOnCalender() {
		click(Calender);
	}
	public void clickOnActivityReminder() {
		click(ActivityReminder);
	}
	
	public String OpenTestReminder()  {
		click(OpenReminder);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> ids=driver.getWindowHandles();
		Iterator itr=ids.iterator();
		while(itr.hasNext()) {
			String id=(String) itr.next();
			if(id!=driver.getWindowHandle()) {
				driver.switchTo().window(id);
				return driver.getTitle();
			}
		}
		return driver.getTitle();
	}
}
