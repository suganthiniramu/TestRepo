import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RelianceAssignment1 {
	public static void main(String [] args) throws InterruptedException, IOException
	{
		HashMap setkey= new HashMap();
		setkey.put("profile.default_content_setting_values.notifications",2);
		ChromeOptions opt=new ChromeOptions();
		opt.setExperimentalOption("prefs", setkey); 
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);	
		driver.get("https://www.reliancedigital.in/smart-phones/c/S101711?searchQuery=:relevance:availability:Exclude%20out%20of%20Stock&page=0");
		List<WebElement> homePageElement=driver.findElements(By.xpath("//p[@class='sp__name']"));

		FileInputStream fis=new FileInputStream("./src/test/resources/MobilData1.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(fis);
		XSSFSheet sheet=book.getSheetAt(0);
		
	/**	sheet.getRow(0).createCell(0).setCellValue("Home Page element");
		sheet.getRow(0).createCell(1).setCellValue("Actual Price");
		sheet.getRow(0).createCell(2).setCellValue("Discount Price");
		sheet.getRow(0).createCell(3).setCellValue("Discount "); */
		
		for(int i=0;i<homePageElement.size();i++)
		{
			
			String name=homePageElement.get(i).getText();
			System.out.println(name);
			String discountAmount=driver.findElement(By.xpath("//p[text()='"+name+"']/../div/div/div/span[1]")).getText();
			discountAmount=discountAmount.replace("?", "Rs");
			System.out.println(discountAmount);
			String actAmount=driver.findElement(By.xpath("//p[text()='"+name+"']/../div/div/div/span/em")).getText();
			actAmount=actAmount.replace("?", "Rs");
			System.out.println(actAmount);
			String discount=driver.findElement(By.xpath("//p[text()='"+name+"']/../div/div/div/span[3]")).getText();
			System.out.println(discount);
			int nameindex=name.indexOf("RAM");
			if(nameindex!=-1)
			{
				String[] splitdata=name.split(",");
			
				for(int j=0;j<splitdata.length;j++)
				{
				sheet.getRow(i+1).createCell(j).setCellValue(splitdata[j]);
				System.out.println(splitdata[j]);
			
					if(j==splitdata.length-1)
					{
						sheet.getRow(i+1).createCell(j+1).setCellValue(actAmount);
						sheet.getRow(i+1).createCell(j+2).setCellValue(discountAmount);
						sheet.getRow(i+1).createCell(j+3).setCellValue(discount);
					}
				}/* j loop closed */
			}/*if closed*/
		}
		FileOutputStream fos=new FileOutputStream(new File("./src/test/resources/MobileData1.xlsx"));
		book.write(fos);
		fos.close();
		driver.close();	
	}
}
