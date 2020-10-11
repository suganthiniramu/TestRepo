package com.tyss.acttime.scripts;

import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.baseutil.InitializePages;

public class OpenTasks extends BaseTest{
	public void createRequisition() throws Exception {

		String username = prop.getProperty("UserName");
		String password = prop.getProperty("Password");

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		pages.loginPage.loginToApplication(username, password);
		
		/* Click on Tasks Tab */
		pages.opentaskPage.clkTaskTab();
		
		/* Click on Open Tasks Tab */
		pages.opentaskPage.clkOpenTaskTab();
		
		/* Click on CustomersandProjectsDropdown */
		pages.opentaskPage.clkCustomersandProjectsDropdown();
		
		/* Click on Selected Customers and Projects Radio button*/
		pages.opentaskPage.clkSelectedCustomersandProjectsRadiobutton();
		
		/* Click on CustomerCheckbox*/
		pages.opentaskPage.clkCustomerCheckbox();
		
		/* Click on Selected Customers and Projects Radio button*/
		pages.opentaskPage.clkCloseButton();
		
		/* Click on Selected Customers and Projects Radio button*/
		pages.opentaskPage.clkApplyFilterButton();
		
	}	
}
