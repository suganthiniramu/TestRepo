package com.tyss.acttime.scripts;

import org.testng.annotations.Test;

import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.baseutil.InitializePages;
import com.tyss.acttime.dataproviders.CreateTaskDataProvider;

public class DeleteSelectedTask extends BaseTest {
	@Test(description = "Create Task", dataProvider = "TestDataProviderForTasks", dataProviderClass = CreateTaskDataProvider.class)

	public void createTask(String customername,String projectName,String taskName) throws Exception {

		String username = prop.getProperty("UserName");
		String password = prop.getProperty("Password");

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		pages.loginPage.loginToApplication(username, password);

		/* Click on Tasks Tab */
		pages.taskPage.clkTaskTab();

		/* Click on Create Task button */
		pages.createTaskPage.clkCreateTaskTab();

		/* 	Select Customer Name */
		pages.createTaskPage.selectCustomerName(customername);
        
		/* 	Enter customer name*/
		pages.createTaskPage.setCustomerName(customername);

		/* Enter Project name*/
		pages.createTaskPage.setProjectName(projectName);

		/* Enter Task Name*/
		pages.createTaskPage.setTaskName(taskName);

		/* Click on Create Tasks button*/
		pages.createTaskPage.clkCreateTask();
		
		/* Click on Completed Tasks Tab */
		pages.completedtasksPage.clkCompletedTaskTab();

		/* Click on Projects and Customer Dropdown */
		pages.completedtasksPage.clkProjectsAndCustomersDropdown();

		/* Click on All Projects of All Customers Radio button */
		pages.completedtasksPage.clkAllProjectsofAllCustomerRadioButton();

		/* Click on Apply Filters Button */
		pages.completedtasksPage.clkApplyFilterButton();
		
		/* Click on Select Tasks CheckBox*/
		pages.completedtasksPage.clkSelectTasksCheckBox();
		
		/* Click on Delete Selected Tasks Button*/
		pages.completedtasksPage.clkDeleteSelectedTasksButton();
		
		/* Click on Delete Tasks Button*/
		pages.completedtasksPage.clkDeleteTasksButton();
		
	}
}
