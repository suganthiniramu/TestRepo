package com.tyss.acttime.scripts;

import org.testng.annotations.Test;

import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.baseutil.InitializePages;
import com.tyss.acttime.dataproviders.CreateRequisitionDataProvider;

public class CompletedTasks extends BaseTest  {
	@Test(description = "Create Requisition", dataProvider = "TestDataProvider", dataProviderClass = CreateRequisitionDataProvider.class, priority = 2)

	public void createRequisition(String customername) throws Exception {

		String username = prop.getProperty("UserName");
		String password = prop.getProperty("Password");

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		pages.loginPage.loginToApplication(username, password);

		/* Click on Tasks Tab */
		pages.taskPage.clkTaskTab();

		/* Click on Completed Tasks Tab */
		pages.completedtasksPage.clkCompletedTaskTab();

		/* Click on Projects and Customer Dropdown */
		pages.completedtasksPage.clkProjectsAndCustomersDropdown();

		/* Click on All Projects of All Customers Radio button */
		pages.completedtasksPage.clkAllProjectsofAllCustomerRadioButton();

		/* Click on Apply Filters Button */
		pages.completedtasksPage.clkApplyFilterButton();
	}
}
