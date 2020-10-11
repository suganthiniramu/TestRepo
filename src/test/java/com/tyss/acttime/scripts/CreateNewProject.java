package com.tyss.acttime.scripts;

import org.testng.annotations.Test;

import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.baseutil.InitializePages;
import com.tyss.acttime.dataproviders.CreateProjectDataProvider;
import com.tyss.acttime.dataproviders.CreateRequisitionDataProvider;

public class CreateNewProject extends BaseTest {
	@Test(description = "Create Project", dataProvider = "TestProjectDataProvider", dataProviderClass = CreateProjectDataProvider.class)

	public void createProject(String customername, String projectname) throws Exception {

		String username = prop.getProperty("UserName");
		String password = prop.getProperty("Password");

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		pages.loginPage.loginToApplication(username, password);
		
		/* Click on Tasks Tab */
		pages.taskPage.clkTaskTab();

		/* Click on Projects And Customers Tab */
		pages.projectsandCustomerPage.clkProjectsAndCustomersTab();
		
		/* Click on Project button */
		pages.projectsandCustomerPage.clkCreateProjectButton();
		
		/* Click on Customer Dropdown */
		pages.projectsandCustomerPage.clkCustomer1(customername);
		
		/* Enter the ProjectName */
		pages.projectsandCustomerPage.setProjectName(projectname);
		
		/* Click on Projects button */
		pages.projectsandCustomerPage.clkCreateProjectbutton1();
	}
}
