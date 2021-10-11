package com.basePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.utilityFiles.FilePath.APPLICATION_SCREENSHOT;
import static com.utilityFiles.FilePath.USER_DIR;

//This class will contain one Constructor and Wrapper methods

public class Basepage {
   protected WebDriver driver;
   protected WebDriverWait wait;
   protected Actions actionOnelement;
   protected JavascriptExecutor js;
   protected Select select;
	//Constructor
	public Basepage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Wrapper method for ExplicitWait
      public void wait(WebElement element) {
    	  wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    	  wait.until(ExpectedConditions.visibilityOf(element));
      }		
	
      public void waitForClickable(WebElement element) {
    	  wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    	  wait.until(ExpectedConditions.elementToBeClickable(element));
      }
      
      public void wiatForFrame(WebElement frameLocator) {
    	  wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
      }
	
	//Wrapper method for Actions class
      public Actions action() {
    	  actionOnelement= new Actions(driver);
           return actionOnelement;
      }
      
    //Wrapper method for Screenshot, Screenshots will save in com.screenshot package
      public void screenshot() throws IOException {    	 
    	  Date date = new Date();
    	  String timeStamp = new SimpleDateFormat("mm-dd-yy").format(date);
    	  TakesScreenshot screen= (TakesScreenshot)driver;
    	  File src = screen.getScreenshotAs(OutputType.FILE);
    	  String destpath=USER_DIR+File.separator+APPLICATION_SCREENSHOT+File.separator+"screen";    	 
    	  FileUtils.copyFile(src,new File(destpath+timeStamp+".png")) ;
      }
      
      //Wrapper method for JavaScriptExecuter
      
      public void  clickOnDomElement(WebElement ele) {
    	  
    	   js = (JavascriptExecutor)driver;
    	   js.executeScript("arguments[0].click()",ele );
      }
      
      
      //Wrapper Method for clicking event on element
      public void click(WebElement ele) {
    	  wait(ele);    	 
    	  ele.click();
      }
      
     //Wrapper class for select by visible text
	
	  public void selectText(WebElement ele, String text)
	  { select= new Select(ele);
	  select.selectByVisibleText(text); }
	 
      
      //Wrapper class for select 
      
      public Select getListOptions(WebElement ele){
    	   select= new Select(ele);
    	return select;
      }
     
      
      //Wrapper method for sendKeys
      public  void enterText(WebElement obj,String textval) 

  	{
  		if(obj.isDisplayed())
  		{
  			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  			obj.sendKeys(textval);
  			//System.out.println("pass: "+textval+"value is entered in "+objName+"field");
  			//Call take screenshot function
//  			logger.log(LogStatus.PASS,textval+"value is entered in "+objName+"field");
  			
  			
  		}
  		else
  		{
  			System.out.println("fail:");
//  			logger.log(LogStatus.FAIL,textval+objName+"field does not exist please check application");
  			
  		}
  	}
  	
      //Wrapper method for SwitchToFrame
      
      public  void switchFrame(WebElement obj) {    		 
    	    if(obj.isDisplayed()) {      	    	
    	     driver.switchTo().frame(obj);
    	     System.out.println("Pass: we can switch to the "+obj+ " frame");
//    	     logger.log(LogStatus.PASS,  "Switch to frame" );
    	     
    	    }else {
    	     System.out.println("fail: we can't switch to the "+obj+ " frame");
//    	     logger.log(LogStatus.FAIL,  "Cannot Switch to frame" );
    	    }
    	}
      
      
      //Wrapper method for mouseHover
      
      public void mouseHover(WebElement obj) {
    		if(obj.isDisplayed()) {               //Actions class is defined in action() in this basepage
    	    action().moveToElement(obj).build().perform();    	
    		System.out.println("Pass: "+obj+" is present");
//    		logger.log(LogStatus.PASS,  "obj is present" );
    		}
    	 else {
    			System.out.println("Fail:"+obj+" is not present.Please chk application");
//    			logger.log(LogStatus.FAIL,  "obj is not present.Please chk application" );
    		}
    	}
      
      //Wrapper method for getting title of the page
      
      public String getTitle() {
    	  return driver.getTitle();
      }

      
      //Wrapper class for Alert
      
      public Alert handleAlert() {
    	  Alert al= driver.switchTo().alert();
    	  return al;
      }
}
