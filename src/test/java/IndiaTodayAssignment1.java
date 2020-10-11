import java.awt.AWTException;
import java.awt.Robot;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class IndiaTodayAssignment1 {

	public static void main(String[] args) throws AWTException, Exception
	{

		HashMap setkey = new HashMap();
		setkey.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("prefs", setkey);
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.indiatoday.in/");
		/* handle wid */
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
		
		/* scroll down */
		EventFiringWebDriver efwd = new EventFiringWebDriver(driver);
		efwd.executeScript("window.scrollBy(0,500)");
		WebElement topStory = driver
				.findElement(By.xpath("//span[text()='Top Stories']/..//div[1]/div/div/div/ul/li/a"));
		String homeHeading = topStory.getText();
		System.out.println(homeHeading);
		topStory.click();

		WebElement childHeading = driver.findElement(By.xpath("//h1[@itemprop='headline']"));
		String childHeadingText = childHeading.getText();
		System.out.println(childHeadingText);

		if (homeHeading.contains(childHeadingText)) {
			System.out.println("Heading open correctly");
		} else {
			System.out.println("It is not same");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');",
				childHeading);

		driver.close();
	}
}
