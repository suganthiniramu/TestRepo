package com.tyss.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.acttime.util.WebActionUtil;

/**
 * Description This class has the implementations of Creating a Open Task 
 * @author manish.k01@testyantra.com
 */
public class Open_Task_Page {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public Open_Task_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/* Task Tab */
	@FindBy(xpath = "//div[text()='Tasks']/following-sibling::img")
	private WebElement tabTasks;
	
	/* Open Task Tab*/
	@FindBy(xpath="//a[.='Open Tasks']")
	private WebElement tabOpenTasks;
	
	/*CustomersandProjects Dropdown*/
	@FindBy(xpath="//span[@id='ext-gen10']")
	private WebElement ddCustomersandProjects;
	
	/*Selected Customers and Projects Radio button*/
	@FindBy(xpath="//img[@id='ext-gen117']")
	private WebElement rdbtnSelectedCustomersandProjects;
	
	/* Customer Checkbox  */
	@FindBy(xpath="(//span[@class='checkbox'])[1]")
	private WebElement cbCustomer;
	
	/* Close Button  */
	@FindBy(xpath="//button[@id='ext-gen132']")
	private WebElement btnClose;
	
	/* Apply Filter button   */
	@FindBy(xpath="//input[@id='tasksFilterSubmitButton']")
	private WebElement btnApplyFilter;
	/**
	 * Description  Method clicks on Task Tab
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkTaskTab() {
		WebActionUtil.waitForElement(tabTasks, "Task  Tab", 45);
		WebActionUtil.clickOnElementUsingJS(tabTasks, "Task Tab");
	

	}
	
	/**
	 * Description  Method clicks on Open Task Tab
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkOpenTaskTab() {
		WebActionUtil.waitForElement(tabOpenTasks, "Open Task  Tab", 45);
		WebActionUtil.clickOnElementUsingJS(tabOpenTasks, "Open Task Tab");
	

	}
    
	/**
	 * Description  Method clicks on Customers and Projects Dropdown
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkCustomersandProjectsDropdown() {
		WebActionUtil.waitForElement(ddCustomersandProjects, "Customers and Projects Dropdown", 45);
		WebActionUtil.clickOnElementUsingJS(ddCustomersandProjects, "Customers and Projects Dropdown");
	

	}

	/**
	 * Description Method clicks on Selected Customers and Projects Radio button
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkSelectedCustomersandProjectsRadiobutton() {
		WebActionUtil.waitForElement(rdbtnSelectedCustomersandProjects, "Selected Customers and Projects Radio button", 45);
		WebActionUtil.clickOnWebElement(rdbtnSelectedCustomersandProjects, "Selected Customers and Projects Radio button", "Click on Selected Customers and Projects Radio button");

	}
	
	/**
	 * Description Method clicks on Customer Checkbox
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkCustomerCheckbox() {
		WebActionUtil.waitForElement(cbCustomer, "Customer Checkbox", 45);
		WebActionUtil.clickCheckBox(cbCustomer, "Customer Checkbox");

	}
    
	/**
	 * Description Method clicks on Close Button
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkCloseButton() {
		WebActionUtil.waitForElement(btnClose, "Close Button", 45);
		WebActionUtil.clickOnWebElement(btnClose, "CloseButton", "Click on Close Button");

	}

	/**
	 * Description Method clicks on Apply Filter Button
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkApplyFilterButton() {
		WebActionUtil.waitForElement(btnApplyFilter, "Apply Filter Button", 45);
		WebActionUtil.clickOnWebElement(btnApplyFilter, "Apply Filter Button", "Unable to click on Apply Filter Button");

	}

}
