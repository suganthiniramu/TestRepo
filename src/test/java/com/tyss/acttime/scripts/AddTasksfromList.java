package com.tyss.acttime.scripts;

import org.testng.annotations.Test;

import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.baseutil.InitializePages;
import com.tyss.acttime.dataproviders.CreateRequisitionDataProvider;

public class AddTasksfromList extends BaseTest {
	@Test(description = "Create Requisition", dataProvider = "TestDataProvider", dataProviderClass = CreateRequisitionDataProvider.class, priority = 2)

	public void createRequisition(String customername) throws Exception {

		String username = prop.getProperty("UserName");
		String password = prop.getProperty("Password");

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		pages.loginPage.loginToApplication(username, password);

		/* Click on TimeTrack Tab */
		pages.timetrackPage.clkTimeTrackTab();

		/* Click on Enter TimeTrack Tab */
		pages.timetrackPage.clkEnterTimeTrackTab();

		/* Click on Tasksfrom List Dropdown */
		pages.timetrackPage.clkAddTasksfromList();

		/* Select a Customer */
		pages.timetrackPage.clkCustomer();

		/* Select a Customer's Checkbox */
		pages.timetrackPage.clkCustomerCheckbox();

		/* Select a Customer */
		pages.timetrackPage.clkAddSelected();
	}
}
