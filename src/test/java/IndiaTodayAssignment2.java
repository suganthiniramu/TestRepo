import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class IndiaTodayAssignment2 {

	
	public static void main(String[] args) throws Exception
	{
	
	HashMap setkey= new HashMap();
	setkey.put("profile.default_content_setting_values.notifications",2);
	ChromeOptions opt=new ChromeOptions();
	opt.setExperimentalOption("prefs", setkey); 	
	WebDriver driver=new ChromeDriver(opt);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.indiatoday.in/");	
	/* handle */
	try
	{
		WebElement wid=driver.findElement(By.xpath("//button[@class='crosscloseif']"));
		if(wid.isDisplayed())
		{
		wid.click();
		}
	}
	catch(Exception e)
	{
	System.out.println("Element is not displayed");
	}
	
	driver.findElement(By.xpath("//li[@class='all-menu']/a")).click();
	driver.findElement(By.xpath("//ul[@id='newlist']/li[1]")).click();
	String text=driver.findElement(By.xpath("//div[text()='advertisement']")).getText();
	System.out.println(text);
	if(text.contains("ADVERTISEMENT"))
	{
		System.out.println("Avertisement is present in education site");
	}
	else
	{
		System.out.println("Advertisement is not present");
	}
	
	
	}
}