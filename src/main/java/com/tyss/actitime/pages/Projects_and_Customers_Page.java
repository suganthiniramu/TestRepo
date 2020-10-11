package com.tyss.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.tyss.acttime.util.WebActionUtil;
/**
 * Description This class has the implementations of Projects and Customers 
 * @author manish.k01@testyantra.com
 */
public class Projects_and_Customers_Page {
	
		public WebDriver driver;
		public WebActionUtil WebActionUtil;
		public long ETO = 10;

		public Projects_and_Customers_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			this.WebActionUtil = WebActionUtil;
			this.ETO = ETO;
		}
		
		/* Projects and Customers Tab */
		@FindBy(xpath = "//a[.='Projects & Customers']")
		private WebElement tabProjectsandCustomers;
		
		/* Create Customers button */
		@FindBy(xpath = "//div[@id='ext-comp-1002']")
		private WebElement btnCreateCustomer;
		
		/* Enter Customer Name*/
		@FindBy(xpath = "//textarea[@name='name']")
		private WebElement txtCustomerName;
		
		/*Customer Description */
		@FindBy(xpath = "//textarea[@name='description']")
		private WebElement taCustomerDescription;
		
		/*Create Blank Customer */
		@FindBy(xpath = "//input[@id='pre_fill_blank' and @value='create_blank_customer']")
		private WebElement rdbtnCreateBlankCustomer;
		
		/*Create Customer button1*/
		@FindBy(xpath = "//input[@name='createCustomerSubmit']")
		private WebElement btnCreateCustomer1;
		
		/* Click on Create Project button  */
		@FindBy(xpath="//div[@id='ext-comp-1004']")
		private WebElement btnCreateProject;
		
		/* Customer Dropdown*/
		@FindBy(xpath="//select[@name='customerId']")
		private WebElement ddCustomer;
		
		/* Enter Project Name  */
		@FindBy(xpath="//input[@name='name']")
        private WebElement txtProjectName;
		
		/* Click on Create Project Button */
		@FindBy(xpath="//input[@name='createProjectSubmit']")
		private WebElement btnCreateProject1;
		/**
		 * Description Method  clicks  on Projects And Customers Tab
		 * @author Manish Kumar C D
		 * 
		 */
		public synchronized void clkProjectsAndCustomersTab() {
			WebActionUtil.waitForElement(tabProjectsandCustomers, "Projects And CustomersTab", 20);
			WebActionUtil.clickOnWebElement(tabProjectsandCustomers, "Task Tab", "Unable to Click on Projects and Customers Tab");

		}
        
		/**
		 * Description Method  click on Create Project Button1
		 * @author Manish Kumar C D
		 * 
		 */
		public synchronized void clkCreateProjectbutton1() {
			WebActionUtil.waitForElement(btnCreateProject1, "Project Button1", 20);
			WebActionUtil.clickOnWebElement(btnCreateProject1, "Project Button1", "Unable to Click on Project button1");

		}
		/**
		 * Description Method  clicks  on Projects And Customers Tab
		 * @author Manish Kumar C D
		 * 
		 */
		public synchronized void clkCreateProjectButton() {
			WebActionUtil.waitForElement(btnCreateProject, "Project button", 20);
			WebActionUtil.clickOnWebElement(btnCreateProject, "Project button", "Unable to Click on Projects and Customers Tab");

		}
		

        
		/**
		 * Description Method  click on Customer Name
		 * @author Manish Kumar C D
		 * 
		 */
		public synchronized void clkCustomer1(String value) {
			WebActionUtil.waitForElement(ddCustomer, "Project button", 20);
			WebActionUtil.selectByText(ddCustomer, value);

		}


		/**
		 * Description Method clicks on Create New Customer
		 * @author Manish Kumar C D
		 * 
		 */
		public synchronized void clkCreateNewCustomerButton() {
			WebActionUtil.waitForElement(btnCreateCustomer, "Create New Customer Button", 5);
			WebActionUtil.clickOnWebElement(btnCreateCustomer, "Create New Customer Button",
					"Unable to click on create New Cutomer Button");

		}
        
		/**
		 * Description  Method to enter Project Name
		 * @author Manish Kumar C D
		 * 
		 */
		public synchronized void setProjectName(String customerName) {
			WebActionUtil.waitForElement(txtProjectName, "Project Name Text Box", 25);
			WebActionUtil.typeText(txtProjectName, customerName, "Project Name Text Box");
			
		}
		/**
		 * Description  Method to enter Customer Name
		 * @author Manish Kumar C D
		 * 
		 */
		public synchronized void setCustomerName(String customerName) {
			WebActionUtil.waitForElement(txtCustomerName, "Customer Name Text Box", 25);
			WebActionUtil.typeText(txtCustomerName, customerName, "Customer Name Text Box");
			
		}
        
		/**
		 * Description  Method to enter Customer Description
		 * @author Manish Kumar C D
		 * 
		 */
		public synchronized void setCustomerDescription(String customerName) {
			WebActionUtil.waitForElement(taCustomerDescription, "Customer Description Text Area field", 25);
			WebActionUtil.typeText(taCustomerDescription, customerName, "Customer Description Text Area field");
			
		}

		/**
		 * Description  Method to Click on Blank Customers Radio Button
		 * @author Manish Kumar C D
		 * 
		 */
		public synchronized void clkCreateBlankCustomersRadioButton() {
			WebActionUtil.scrollToElement(rdbtnCreateBlankCustomer, "Click on Blank Customers");
			WebActionUtil.waitForElement(rdbtnCreateBlankCustomer, "Click on Blank Customers", 25);
			WebActionUtil.clickCheckBox(rdbtnCreateBlankCustomer, "Click on Blank Customers");

		}

		/**
		 * Description Method clicks on Create Customer button1
		 * @author Manish Kumar C D
		 * 
		 */
		public synchronized void clkCreateCustomerButton1() {
			WebActionUtil.waitForElement(btnCreateCustomer1, "Create Customer Button1", 5);
			WebActionUtil.clickOnWebElement(btnCreateCustomer1, "Create Customer Button1",
					"Unable to click on create Customer Button1");

		}


		
		
}
