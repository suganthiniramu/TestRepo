package com.tyss.actitime.pages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.reports.ExtentHCLManager;
import com.tyss.acttime.util.WebActionUtil;
/**
 * Description This class has the implementations of Creating a Task 
 * @author manish.k01@testyantra.com
 */
public class Create_Task_Page {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public Create_Task_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/* Task Tab */
	@FindBy(xpath = "//div[text()='Tasks']/following-sibling::img")
	private WebElement tabTasks;
	
	/*Create Tasks*/
	@FindBy(id="ext-gen33")
	private WebElement btnCreateTasks;
	
	/*Customer Dropdown */
	@FindBy(xpath="//select[@name='customerId']")
	private WebElement ddCustomer;
	
	/* Enter Customer Name*/
	@FindBy(xpath="//input[@name='customerName']")
	private WebElement tbEnterCustomerName;
	
	/*Enter Project Name*/
	@FindBy(xpath="//input[@name='projectName']")
	private WebElement tbProjectName;
	
	/*Enter Task Name*/
	@FindBy(id="task[0].name")
	private WebElement tbTaskName;
	
	
	@FindBy(xpath="//input[@class='hierarchy_element_wide_button']")
	private WebElement btnCreateTasks1;
	
	/**
	 * Description  Method clicks on Task Tab
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkTaskTab() {
		WebActionUtil.waitForElement(tabTasks, "Task  Tab", 20);
		WebActionUtil.clickOnElementUsingJS(tabTasks, "Task Tab");
	

	}

	/**
	 * Description  Method clicks on Create Task Tab
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkCreateTaskTab() {
		WebActionUtil.waitForElement(btnCreateTasks, " Create Task  Tab", 20);
		WebActionUtil.clickOnElementUsingJS(btnCreateTasks, "Create Task Tab");
	

	}
	/**
	 * Description Method selects the Customer Name from Drop down 
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void selectCustomerName(String CustomerName) {
		WebActionUtil.waitForElement(ddCustomer, "Customer Drop down", 5);
		WebActionUtil.selectByText(ddCustomer, CustomerName);

	}
	
	/**
	 * Description Method enters Customer Name
	 * @author Manish Kumar C D
	 */
	public synchronized void setCustomerName(String customerName) {
		WebActionUtil.waitForElement(tbEnterCustomerName, "Customer Name Text Box", 5);
		WebActionUtil.typeText(tbEnterCustomerName, customerName, "Customer Name Text Box");
		
	}
	
	
	/**
	 * Description Method enter Task Name
	 * @author Manish Kumar C D
	 */
	public synchronized void setTaskName(String taskName) {
		WebActionUtil.waitForElement(tbTaskName, "Task Name Text Box", 5);
		WebActionUtil.typeText(tbTaskName, taskName, "Task Name Text Box");
		
	}
	
	
	/**
	 * Description Method enters Project Name
	 * @author Manish Kumar C D
	 */
	public synchronized void setProjectName(String projectName) {
		WebActionUtil.waitForElement(tbProjectName, "Project Name Text Box", 5);
		WebActionUtil.typeText(tbProjectName, projectName, "Project Name Text Box");
		
	}
	
	/**
	 * Description  Method clicks on Create Task button
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkCreateTask() {
		WebActionUtil.waitForElement(btnCreateTasks, " Create Task  Tab", 20);
		WebActionUtil.clickOnWebElement(btnCreateTasks1, "CreateTasks" ,"Create Task button" );
	    
	}
	
	/*TPG manager pool*/
	/* Search job element */
	//public synchronized String searchTpg(String requisitionNo) {
		//return driver.findElement(By.xpath("//a[text()='"+requisitionNo+"']/../following-sibling::td[6]/a[@id='pendWith']")).getText();
	//}
	

}
