import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	
public static WebDriver driver;
	
	public  void  navigateActions(WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();	
	}
	public String getData(String sheetname) throws EncryptedDocumentException, IOException
	{
		String excelFilePath="./src/test/resources/nykaa.xlsx";
		FileInputStream fis=new FileInputStream(excelFilePath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		String value=sh.getRow(0).getCell(0).getStringCellValue();
		return value;	
	}
	public String getdataFromExcel(String sheetname,int rowno,int colno) throws EncryptedDocumentException, IOException
	{
		String excelFilePath="./src/test/resources/nykaa.xlsx";
		FileInputStream fis=new FileInputStream(excelFilePath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		String value=sh.getRow(rowno).getCell(colno).getStringCellValue();
		return value;	
	}
	public String getlogin(String sheetname,int rowno,int colno) throws EncryptedDocumentException, IOException
	{
		String excelFilePath="./src/test/resources/nykaa.xlsx";
		FileInputStream fis=new FileInputStream(excelFilePath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		String value=sh.getRow(rowno).getCell(colno).getStringCellValue();
		return value;	
	}

	
	public  void  navigatoNextTab()
	{
		String mainId=driver.getWindowHandle();
		Set<String>allId=driver.getWindowHandles();
		for(String Id:allId)
		{
			if(!Id.equals(mainId))
			{
			driver.switchTo().window(Id);
			}
		}
	}
	public void navigateToMainTab()
	{
		
		String mainId=driver.getWindowHandle();
		driver.switchTo().window(mainId);
	}
	public void scrollDown()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void scrollUp()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-500)");
	}
	
	public void waitElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/*
	public static synchronized void waitTillPageLoad(long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		// Wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = wd -> ((JavascriptExecutor) driver)
				.executeScript("return document.readyState").toString().equals("complete");
		// Get JS is Ready
	boolean jsReady = (Boolean) jsExecutor.executeScript("return document.readyState").toString().equals("complete");
		// Wait Javascript until it is Ready!
		if (!jsReady) {
			
			// Wait for Javascript to load
			wait.until(jsLoad);
		}
		else 
		{
			
		}
	}
	*/
}

