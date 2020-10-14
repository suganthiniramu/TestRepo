import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment1 {
	
	public static WebDriver driver;
	public static void main(String [] args) throws InterruptedException, IOException
	{

		HashMap setkey= new HashMap();
		setkey.put("profile.default_content_setting_values.notifications",2);
		ChromeOptions opt=new ChromeOptions();
		opt.setExperimentalOption("prefs", setkey); 
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
		driver.get("https://www.nykaa.com/");
		Assignment1 ass=new Assignment1();
		/* navigate brand */
		WebElement brand=driver.findElement(By.xpath("//a[text()='brands']"));
		
		ass.waitElement(brand);
		ass.navigateActions(brand);
		
		/*click M.V.C */
		driver.findElement(By.xpath("(//a[text()='"+ass.getData("Sheet1")+"'])[1]")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		/* navigate first product */
		WebElement product=driver.findElement(By.xpath("(//div[@class='nw-pagecontainer']//div[1]/div/div/a)[1]"));
		ass.navigateActions(product);
		product.click();
		
		
		/* navigate to next tab */
		ass.navigatoNextTab(driver);
		/* click price */
		WebElement price=driver.findElement(By.xpath("//div[text()='Price']"));
		price.click();
		
		/*click first checkbox */
		driver.findElement(By.xpath("//div[text()='Price']//parent::div/../following-sibling::div//div/div/div/label/div")).click();
		price.click();
		
		ass.scrollDown();
		/*select color */
		
		WebElement color=driver.findElement(By.xpath("//div[text()='Color']"));
		ass.waitElement(color);
		color.click();
		
		
		/*select maroon color */
		//driver.findElement(By.xpath("//span[contains(text(),'Maroon')]/following-sibling::div']")).click();
		driver.findElement(By.xpath("//label[@class='control control--checkbox']/span[contains(text(),'Maroon')]/following-sibling::div")).click();
		ass.scrollUp();
		
		/*select catogory */
		driver.findElement(By.xpath("//div[text()='Category']")).click();
		driver.findElement(By.xpath("//label[@class='control control--checkbox']/span[contains(text(),'Lipstick')]")).click();
		/*select add bag */
		WebElement selectProduct=driver.findElement(By.xpath("//div[@class='product-list-box card desktop-cart']//a/div//img"));
		ass.navigateActions(selectProduct);
		String actProductName=selectProduct.getText();	
		System.out.println(actProductName);
		//WebElement bag=driver.findElement(By.xpath("//span[text()='M.A.C Retro Matte Lipstick - Ruby Woo']/ancestor::a/following-sibling::div//button"));
		
		WebElement bag=driver.findElement(By.xpath("//button[text()='ADD TO BAG']"));
		ass.waitElement(bag);
		bag.click();
		
		/* add to bag */
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		String expProduct=driver.findElement(By.xpath("//div[@class='product-name']")).getText();
		System.out.println(expProduct);
		
		if(actProductName.contains(expProduct))
		{
		System.out.println("Product select correctly");
		}
		else
		{
			System.out.println("Same product is not selected");
		}
		
		/* verify price */
		String actPrice=driver.findElement(By.xpath("//span[@class='actual-price']")).getText();
		Integer actAmount=Integer.parseInt(actPrice);
		
		 List<WebElement> total=driver.findElements(By.xpath("//div[@class='table-row']"));
		 int expAmount=0;
		 for(WebElement wb:total)
		 		{
					String s1=wb.getText();
					Integer i=	Integer.parseInt(s1);
					expAmount=expAmount + i;
				}
		
			
		if(actAmount.equals(expAmount))
		{
		System.out.println("The total amount is correct");
		}
		else
		{
			System.out.println("The total amount is not correct");
		}
		
		//driver.close();			
	}
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
	
	public  void  navigatoNextTab(WebDriver driver)
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
		WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
