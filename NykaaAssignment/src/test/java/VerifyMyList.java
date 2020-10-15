import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifyMyList extends BaseClass{
	
	
	
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
//		driver.get("https://www.nykaa.com/#");
		VerifyMyList nykaa=new VerifyMyList();
		
		/*login access */
		driver.findElement(By.xpath("//span[@class='AccountText']")).click();
		driver.findElement(By.xpath("//span[@class='new-login-button new-login-button--google']")).click();
		driver.findElement(By.id("identifierId")).sendKeys(nykaa.getlogin("Sheet2", 0, 0));
		driver.findElement(By.xpath("//span[text()='Next']/following-sibling::div")).click();
		driver.findElement(By.name("password")).sendKeys(nykaa.getlogin("Sheet2", 0, 1));
		driver.findElement(By.xpath("//span[text()='Next']/following-sibling::div")).click();
		
		Thread.sleep(3000);
		
		WebElement headerMenu=driver.findElement(By.xpath("//div[@id='HeaderMenu']"));
		nykaa.waitElement(headerMenu);
		nykaa.navigateActions(headerMenu);
		
		/* click on appliance */
		WebElement appliance=driver.findElement(By.xpath("//a[text()='appliances']"));
		nykaa.waitElement(appliance);
		nykaa.navigateActions(appliance);
		
		/* click on phillips */
		driver.findElement(By.xpath("//div[text()='Top Brands']/../ul/li/a[text()='"+nykaa.getdataFromExcel("MyList", 0, 0)+"']")).click();
		
		/* open new tab */
		
		nykaa.navigatoNextTab();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3000)");
		
		driver.findElement(By.xpath("//span[text()='3']")).click();
		
		
		WebElement product1=driver.findElement(By.xpath("//span[text()='"+nykaa.getdataFromExcel("MyList", 1, 0)+"']"));
		nykaa.waitElement(product1);
		
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,100)");
		
		
		nykaa.navigateActions(product1);
		driver.findElement(By.xpath("//span[text()='"+nykaa.getdataFromExcel("MyList", 1, 0)+"']/ancestor::a/following-sibling::div//div[1]/span")).click();
		driver.findElement(By.xpath("//span[@class='AccountText']/span")).click();
		driver.findElement(By.xpath("//a[text()='My Wishlist']")).click();
		
	
	
		
		WebElement product=driver.findElement(By.xpath("//span[text()='"+nykaa.getdataFromExcel("MyList", 1, 0)+"']/ancestor::div[2]"));
		
		/* notify me */
		driver.findElement(By.xpath("//span[text()='Notify Me']")).click();
		/* enter mail id */
		
		
		
		
		
		driver.findElement(By.xpath("//input[@placeholder='Your Email']")).sendKeys(nykaa.getlogin("Sheet2", 0, 0));
		driver.findElement(By.xpath("(//span[text()='Notify Me'])[2]")).click();
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
