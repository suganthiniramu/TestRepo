package com.tyss.acttime.scripts;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.baseutil.InitializePages;
import com.tyss.acttime.dataproviders.CreateRequisitionDataProvider;

public class CreateCustomer extends BaseTest {
	@Test(description = "Create Requisition", dataProvider = "TestDataProvider", dataProviderClass = CreateRequisitionDataProvider.class, priority = 2)

	public void createRequisition(String customername) throws Exception {

		String username = prop.getProperty("UserName");
		String password = prop.getProperty("Password");

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		pages.loginPage.loginToApplication(username, password);
		
		/* Click on Tasks Tab */
		pages.taskPage.clkTaskTab();

		/* Click on Projects And Customers Tab */
		pages.projectsandCustomerPage.clkProjectsAndCustomersTab();

		/* Click on New Customer Button */
		pages.projectsandCustomerPage.clkCreateNewCustomerButton();

		/* Set Customer Name */
		pages.projectsandCustomerPage.setCustomerName(customername);
		
		/* Click on Create Blank Customer */
		pages.projectsandCustomerPage.clkCreateBlankCustomersRadioButton();
		
		/* Click on Create Customer button */
		pages.projectsandCustomerPage.setCustomerDescription(customername);
		
   		
	}
}
