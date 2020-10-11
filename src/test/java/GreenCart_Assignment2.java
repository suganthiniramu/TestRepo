
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class GreenCart_Assignment2 {

	public static void main(String[] args)
	{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");	
		driver.findElement(By.linkText("Top Deals")).click();
		String mainId=driver.getWindowHandle();
		Set<String> allId=driver.getWindowHandles();
		for(String Id:allId)
		{
		if(!Id.equals(mainId))
		{
		driver.switchTo().window(Id);
		WebElement pagesize=driver.findElement(By.id("page-menu"));
		Select s=new Select(pagesize);
		s.selectByVisibleText("10");
		driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();
		List<WebElement> row_table=driver.findElements(By.tagName("tr"));
		List<String> actList=new ArrayList();
		List<String> tempList=new ArrayList();
		for(WebElement wb:row_table)
		{
		String name=wb.getText();
		String[] name1=name.split(" ");
		
		actList.add(name1[0]);
		System.out.println(name1[0]);
		}
		tempList=actList;
		Collections.sort(tempList);
		if(actList.equals(tempList))
		{
			System.out.println("The data is arrange in ascending order:");
		}
		else
		{
			System.out.println("The data is arrange in descending sorted");
		}	
		}
		}
	driver.close();	
}
}	
	
	