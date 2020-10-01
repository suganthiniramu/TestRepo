package com.tyss.acttime.util;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.reports.ExtentHCLManager;

/**
 * Description: All the action utilities added in this class e.g
 * clickonelement,WaitforElement etc
 * 
 * @author : Shreya U ,Vivek Dogra,Aatish Slatia
 */


public class WebActionUtil {
	public WebDriver driver;
	WebDriverWait wait;
	public long ETO;
	public JavascriptExecutor jsExecutor;
	public Actions action;
	public static TakesScreenshot screenshot;

	public WebActionUtil(WebDriver driver, long ETO) {
		this.driver = driver;
		this.ETO = ETO;
		wait = new WebDriverWait(driver, ETO);
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		screenshot=(TakesScreenshot)driver;
	}

	
	/**
	 * @author Shreya Ugavekar
	 * @description Method for the pass updation in extent Report,Log file,TestNG
	 *              Report
	 */

	public static void pass(String message) {
		ExtentHCLManager.getTestReport().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}
	/**
	 * @author Shreya Ugavekar
	 * @description Method to provide info in the log,extent reports,testNg reports
	 */
	public static void info(String message) {
		Reporter.log(message, true);
		BaseTest.logger.info(message);
		ExtentHCLManager.getTestReport().info(message);
	
	}

	/**
	 * @author Shreya Ugavekar
	 * @description Method for the Warning updation in extent Report,Log file,TestNG
	 *              Reprt
	 */
	
	public void warn(String message) {

		BaseTest.logger.warn(message);
		Reporter.log(message, true);
	}

	/**
	 * @author Shreya Ugavekar
	 * @description Method for the error/Failure updation in extent Report,Log
	 *              file,TestNG Reprt
	 */

	public static void fail(String message) {
		Reporter.log(message, true);
		ExtentHCLManager.getTestReport().fail(MarkupHelper.createLabel(message, ExtentColor.RED));

	}
	public void error(String message) {

		BaseTest.logger.error(message);
		Reporter.log(message, true);
		ExtentHCLManager.getTestReport().error(message);
	}
	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
	
	public synchronized void clickOnWebElement(WebElement element, String elementName,String message) {
	
		
			if (isElementClickable(element, elementName)) {
				element.click();
				pass("Click on " + elementName);
			}
			else {
				fail(message);
				Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(element))==null);
		} 
		
		 

		
	}

	/**
	 * @author Shreya Ugavekar
	 * @description Check whether the Element is displayed with expected conditions
	 * @param element elementName
	 */
	public synchronized boolean isElementClickable(WebElement element, String elementName) {

		info("Verify "+elementName+" is Clickable or Not");
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			fail(elementName + " is not Clickable ");
			return false;
		}
	}
	
	public void waitForElement(WebElement element, String eleName,long seconds) {
		try {
			
			wait= new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)) != null);
			
		} catch (Exception e) {
			fail( "Element is not visible---------" + eleName);
			
		}
	}
	public static void deleteDir(String pathToDeleteFolder) {
		File extefolder = new File(pathToDeleteFolder);
		if ((extefolder.exists())) {
			deleteFolderDir(extefolder);
		}
	}
	public static void deleteFolderDir(File folderToDelete) {
			File[] folderContents = folderToDelete.listFiles();
			if (folderContents != null) {
				for (File folderfile : folderContents) {
					if (!Files.isSymbolicLink(folderfile.toPath())) {
						deleteFolderDir(folderfile);
					}
				}

			}
			folderToDelete.delete();
		}
	/**
	 * @author Shreya Ugavekar
	 * @description Capture the screenshot of the complete screen 
	 * @param path driver
	 */
	public static String getScreenShot(String path) {

		File src = (screenshot.getScreenshotAs(OutputType.FILE));
		String destinationPath = path + getCurrentDateTime() + ".png";
		File destination = new File(destinationPath);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destinationPath;
	}
	
	/**
	 * @author Shreya Ugavekar
	 * @description To Enter the Text to the Text filed 
	 * @param element value elementName
	 */
	public synchronized void typeText(WebElement element, String value, String elementName) {
		try {
			info("Enter the value into " + elementName);
			element.sendKeys(value);
			pass("User is able to type " + value + " into " + elementName);
		} catch (AssertionError error) {
			fail(" User is not able to type " + value + " into " + elementName);
			Assert.fail("Unable to type on " + elementName);
		} catch (Exception e) {
			fail(" User is not able to type " + value + "into " + elementName);
			Assert.fail("Unable to type in " + elementName);
		}
	}
	
	/**
	 * @author Shreya Ugavekar
	 * @description To Select the value by the Visible Text
	 * @param element value elementName
	 */
	public synchronized void selectByText(WebElement element, String value) {
		try {
			info("Select the value " + value);
			Select selecvalue=new Select(element);
			selecvalue.selectByVisibleText(value);
			pass("User is able to select the value"+value);
		} catch (Exception e) {
			fail(" User is not able to Select" + value );
			Assert.fail("Unable to select  " + value);
		}

	}
	/**
	 * @author Shreya Ugavekar
	 * @description Click on the check box
	 * @param element  elementName
	 */
	public void clickCheckBox(WebElement element, String elementname) {

		if (element.isSelected()) {
			pass("Already Selected " + elementname);
		} else {
			element.click();
			pass("Selected the " + elementname);
		
		}
	}
	/**
	 * @author Shreya Ugavekar
	 * @description Scroll to the Element
	 * @param elementName 
	 */
	public void scrollToElement(WebElement element, String elementName)  {
		info("-------------Scrolling till the Element------------");
		try {
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
			pass("-------------Scrolling till the Element Completed------------");
		} catch (Exception e) {
		fail("-------------Scroll Till the Element Has Failed ------------");
		}

	}
	/**
	 * @author Shreya Ugavekar
	 * @description Click on the Element using JavaSCript 
	 * @param element  elementName
	 */
	public void clickOnElementUsingJS(WebElement element, String elementName) {
		try {
			if (isElementClickable(element, elementName)) {
				pass("User is able to click " + " into " + elementName);
				jsExecutor.executeScript("arguments[0].click();", element);
			}
		} catch (NoSuchElementException e) {
			pass("User is not able to click " + " into " + elementName);
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)) == null);
		}
	}
	/**
	 * @author Shreya Ugavekar
	 * @description Double Click On Element
	 * @param element  elementName
	 */
	public void doubleClickOnElement(WebElement element, String elementName) {
		try {
			pass("User is able to click " + " into " + elementName);
			action.doubleClick(element).perform();
		} catch (Exception e) {
			fail(" User is not able to double click on  " + elementName);
			Assert.fail("Unable to Double click on  " + elementName);
		}
	}
	

	/**
	 * @author Shreya Ugavekar
	 * @description Clear the Text
	 * @param element elementName
	 */
	public void clearText(WebElement element, String elementName) {
		try {
		info("Clear the Text Present in" + elementName);
		element.clear();
		pass("Cleared the Text Present in" + elementName);
		}catch (Exception e) {
		fail("Unable to clear the text in "+elementName);
		}
	}
	/**
	 * @author Aatish Slathia
	 * @description To create the duration of the Test Run
	 * @param element elementName
	 */
	public static String formatDuration(final long millis) {
	  	   long seconds = (millis / 1000) % 60;
	  	   long minutes = (millis / (1000 * 60)) % 60;
	  	   long hours = millis / (1000 * 60 * 60);

	  	   StringBuilder b = new StringBuilder();
	  	   b.append(hours == 0 ? "00" : hours < 10 ? String.valueOf("0" + hours) :
	  	   String.valueOf(hours));
	  	   b.append(":");
	  	   b.append(minutes == 0 ? "00" : minutes < 10 ? String.valueOf("0" + minutes) :    
	  	   String.valueOf(minutes));
	  	 b.append(":");
	  	   b.append(seconds == 0 ? "00" : seconds < 10 ? String.valueOf("0" + seconds) :
	  	   String.valueOf(seconds));
	  	   return b.toString();
	}
	
}
