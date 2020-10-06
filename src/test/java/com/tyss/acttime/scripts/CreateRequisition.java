package com.tyss.acttime.scripts;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.Test;

import com.tyss.actitime.pages.Task_Page;
import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.baseutil.InitializePages;
import com.tyss.acttime.dataproviders.CreateRequisitionDataProvider;


public class CreateRequisition extends BaseTest{


	 @Test (description="Create Requisition",dataProvider = "TestDataProvider",dataProviderClass=CreateRequisitionDataProvider.class,priority = 2)

	 public void createRequisition(String customername) throws Exception{
		  
		 String username= prop.getProperty("UserName");
			String password= prop.getProperty("Password");
			
			InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
			pages.loginPage.loginToApplication(username, password);
			
		 Task_Page taskpage =new Task_Page(driver, ETO, WebActionUtil);
			// taskpage.clkReportsTab();
			 
			/*Click on Tasks Tab*/
		    taskpage.clkTaskTab();
			
			/*Click on Projects And Customers Tab*/
		  taskpage.clkProjectsAndCustomersTab();
			
			/*Click on New Customer Button*/
		 taskpage.clkCreateNewCustomerButton();
			
			/*Set Customer Name*/
		 taskpage.setCustomerName(customername+RandomStringUtils.randomAlphabetic(2));
		 
		 /*Set Customer Checkbox*/
        taskpage.clkAddMoreCustomersCheckBox();
        
        /*Set Customer Checkbox*/
        taskpage.clkCreateCustomerButton();
        String appurl= prop.getProperty("App_URL");
        
        driver.navigate().to(appurl);
	 }
}
