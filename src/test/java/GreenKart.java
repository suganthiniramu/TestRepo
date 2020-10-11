
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GreenKart {
	
	
	public static void main(String[] args) throws InterruptedException
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");	
	driver.findElement(By.cssSelector("input[type='search']")).sendKeys("ca");
	driver.findElement(By.xpath("//button[@class='search-button']")).click();
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4")));
	List<WebElement> allitems=driver.findElements(By.xpath("//h4"));
	
	for(WebElement wb: allitems)
	{
		
		String vegName=wb.getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Cauliflower - 1 Kg']/..//div[2]//a[2]")));
		if(vegName.contains("Cauliflower"))
		{
			for(int i=0;i<2;i++)
			{
				driver.findElement(By.xpath("//h4[text()='Cauliflower - 1 Kg']/..//div[2]//a[2]")).click();
				driver.findElement(By.xpath("//h4[text()='Cauliflower - 1 Kg']/..//div[3]/button")).click();
			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Carrot - 1 Kg']/..//div[2]//a[2]")));
		 if(vegName.contains("Carrot"))
			{
				for(int i=0;i<3;i++)
				{
					driver.findElement(By.xpath("//h4[text()='Carrot - 1 Kg']/..//div[2]//a[2]")).click();
					driver.findElement(By.xpath("//h4[text()='Carrot - 1 Kg']/..//div[3]/button")).click();
				}
			}
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Capsicum']/..//div[2]//a[2]")));
		if(vegName.contains("Capsicum"))
		{
			for(int i=0;i<1;i++)
			{
				driver.findElement(By.xpath("//h4[text()='Capsicum']/..//div[2]//a[2]")).click();
				driver.findElement(By.xpath("//h4[text()='Capsicum']/..//div[3]/button")).click();
			}
			
		}
		}
	driver.findElement(By.xpath("//a[@class=\"cart-icon\"]//img")).click();
	driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
	driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
	driver.findElement(By.xpath("//button[text()='Apply']")).click(); 
	
	/*Apply promo code */

	String actResult=driver.findElement(By.xpath("//span[text()='Code applied ..!']")).getText();
	String expResult="Code applied ..!";

	/*Verify promo code */
	Assert.assertTrue(actResult.contains(expResult));
	System.out.println(" verify code verify successfully");

	/*Total verification */
	List<WebElement> total1=driver.findElements(By.xpath("//p[@class='amount']/../following-sibling::td"));
	List<WebElement> total=driver.findElements(By.xpath("//p"));
	for(WebElement wb1: total )
	{
		String s1=wb1.getText();
		System.out.println(s1);
	}
	int expAmount=0;
	System.out.println("Total amount");
	
	List<Integer> totAmount=new ArrayList();
	for(WebElement wb2: total1)
	{
		String s1=wb2.getText();
		Integer i=	Integer.parseInt(s1);
		expAmount=expAmount + i;
	}
	
	/* verify Total amount */
	String amountText=driver.findElement(By.xpath("//span[@class='totAmt']")).getText();
	Integer actAmount=Integer.parseInt(amountText);
if(actAmount.equals(expAmount))
{
System.out.println("The total amount is correct");
}
else
{
	System.out.println("The total amount is not correct");
}

/*Verify discount amount */

String dicountText=driver.findElement(By.xpath("//span[@class='discountAmt']")).getText();
Double discountAmount=Double.parseDouble(dicountText);
if(actAmount>discountAmount)
{
System.out.println("Discount amount is correct");
}
else
{
	System.out.println("Discount amount is not correct");
}

/* place order */
driver.findElement(By.xpath("//button[text()='Place Order']")).click();

/*Select country */
WebElement countryname=driver.findElement(By.xpath("//label[text()='Choose Country']/..//select"));
Select s=new Select(countryname);
s.selectByValue("India");
driver.findElement(By.xpath("//button[text()='Proceed']"));
driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
driver.findElement(By.xpath("//button[text()='Proceed']")).click();
driver.close();
		
	}
}
