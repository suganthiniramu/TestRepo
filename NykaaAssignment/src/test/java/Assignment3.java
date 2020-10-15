import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Assignment3 extends BaseClass
{
	public static void main(String [] args) throws InterruptedException, IOException
	{

		HashMap setkey= new HashMap();
		setkey.put("profile.default_content_setting_values.notifications",2);
		ChromeOptions opt=new ChromeOptions();
		opt.setExperimentalOption("prefs", setkey); 
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);	
		driver.get("https://www.nykaa.com/");
		Assignment3 nykaa=new Assignment3();
		
		Thread.sleep(3000);
		/* navigate brand */
		WebElement brand=driver.findElement(By.xpath("//a[text()='brands']"));
		nykaa.waitElement(brand);
		nykaa.navigateActions(brand);
		
		/*select lakmee */
		driver.findElement(By.xpath("//div[@id='scroller-container']//div[4]/a[text()='"+nykaa.getdataFromExcel("Assignment3", 0, 0)+"']")).click();
		
		
		nykaa.scrollDown();
		
		/*select discount as 40 % from excel */
		driver.findElement(By.xpath("//div[text()='Discount']")).click();
		WebElement discount=driver.findElement(By.xpath("//span[contains(text(),'"+nykaa.getdataFromExcel("Assignment3", 1, 0)+"')]/following-sibling::div"));
		nykaa.waitElement(discount);
		discount.click();
		
		/* select 4 star */
		driver.findElement(By.xpath("//div[text()='Avg Customer Rating']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'"+nykaa.getdataFromExcel("Assignment3", 2, 0)+"')]")).click();
		
		/* scroll up */
		
		
		
		/* select product */
		
		WebElement img=driver.findElement(By.xpath("//span[text()='"+nykaa.getdataFromExcel("Assignment3", 3, 0)+"']/ancestor::div[3]"));
		nykaa.navigateActions(img);
		
		WebElement preview=driver.findElement(By.xpath("//span[text()='"+nykaa.getdataFromExcel("Assignment3", 3, 0)+"']"));
		
		preview.click();
		
		nykaa.navigatoNextTab();
		
		nykaa.scrollDown();
		
		/* check pin code */
		WebElement pincode=driver.findElement(By.xpath("//input[@name='pincode']"));
		pincode.sendKeys("999999");
		driver.findElement(By.xpath("//button[text()='CHECK']")).click();
		String actualMessage = driver.findElement(By.xpath("//li[text()='Information not found for entered pincode.']")).getText();
		System.out.println(actualMessage);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-100)");

		/* click change */
		driver.findElement(By.xpath("//a[text()=' Change']")).click();
		nykaa.waitElement(pincode);
		pincode.clear();
		pincode.sendKeys("560036");
		driver.findElement(By.xpath("//button[text()='ADD TO BAG']/parent::div")).click();
		
	}

}
