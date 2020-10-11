package com.tyss.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.acttime.util.WebActionUtil;
/**
 * Description This class has the implementations of Completed Tasks
 * @author manish.k01@testyantra.com
 */
public class Completed_Tasks_Page {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public Completed_Tasks_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
    /* Completed Tasks*/
	@FindBy(xpath="//a[.='Completed Tasks']")
	private WebElement tabCompletedTasks;
	
	/* Customers and Projects Dropdown */
	@FindBy(xpath="//span[@id='ext-gen36']")
	private WebElement ddCustomersandProjects;

	/* AllProjectsofAllCustomers Radio button */
	@FindBy(xpath="//img[@id='ext-gen179']")
	private WebElement rdbtnAllProjectsofAllCustomers;
	
	/*From date*/
	@FindBy(id="completionDateFrom_userText")
	private WebElement txtfrom;
	
	/*To date*/
	@FindBy(id="completionDateTo_userText")
	private WebElement txtto;
	
	/* Apply Filter button*/
	@FindBy(id="tasksFilterSubmitButton")
	private WebElement btnApplyFilter;
	
	/* Select Tasks Checkbox*/
	@FindBy(xpath="//input[@name='taskSelected[1]']")
	private WebElement cbSelectTasks;
	
	/* Delete Selected Tasks button*/
	@FindBy(xpath="//input[@class='hierarchy_element_wide_button']")
	private WebElement btnDeleteSelectedTasks;
    
	/* Delete Tasks button*/
	@FindBy(id="deleteButton")
	private WebElement btnDeleteTasks;

	/**
	 * Description Method  clicks on DeleteTasks Button
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkDeleteTasksButton() {
		WebActionUtil.waitForElement(btnDeleteTasks, "Delete Tasks button", 20);
		WebActionUtil.clickOnWebElement(btnDeleteTasks, "Delete Tasks button", "Unable to click on Delete Tasks button");

	}

	/**
	 * Description Method  clicks on Delete Selected Tasks Button
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkDeleteSelectedTasksButton() {
		WebActionUtil.waitForElement(btnDeleteSelectedTasks, "Delete Selected Tasks button", 20);
		WebActionUtil.clickOnWebElement(btnDeleteSelectedTasks, "Delete Selected Tasks button", "Unable to click onDelete Selected Tasks button");

	}

	/**
	 * Description Method  clicks on Select Tasks Checkbox
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkSelectTasksCheckBox() {
		WebActionUtil.waitForElement(cbSelectTasks, "Select Tasks Checkbox", 20);
		WebActionUtil.clickCheckBox(cbSelectTasks, "Select Tasks Checkbox");

	}

	/**
	 * Description Method  clicks on Completed Task Tab
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkCompletedTaskTab() {
		WebActionUtil.waitForElement(tabCompletedTasks, "Completed Task Tab", 20);
		WebActionUtil.clickOnWebElement(tabCompletedTasks, "Completed Task Tab", "Unable to Click on Completed Task Tab");

	}
	
	/**
	 * Description Method  clicks  on Projects And Customers dropdown
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkProjectsAndCustomersDropdown() {
		WebActionUtil.waitForElement(ddCustomersandProjects, "Projects And Customers Dropdown", 20);
		WebActionUtil.clickOnWebElement(ddCustomersandProjects, "Projects and Customers Dropdown", "Unable to Click on Projects and Customers Dropdown");

	}
	
	/**
	 * Description Method  clicks  on AllProjectsofAllCustomer Radio Button
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkAllProjectsofAllCustomerRadioButton() {
		WebActionUtil.waitForElement(rdbtnAllProjectsofAllCustomers, "AllProjectsofAllCustomer Radio Button", 20);
		WebActionUtil.clickOnWebElement(rdbtnAllProjectsofAllCustomers, "AllProjectsofAllCustomer Radio Button", "Unable to Click on AllProjectsofAllCustomer RadioButton");

	}
	
	/**
	 * Description Method  clicks  on AllProjectsofAllCustomer Radio Button
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkApplyFilterButton() {
		WebActionUtil.waitForElement(btnApplyFilter, "ApplyFilter Button", 20);
		WebActionUtil.clickOnWebElement(btnApplyFilter, "ApplyFilter Button", "Unable to Click on ApplyFilter Button");

	}
	
	
	
}
