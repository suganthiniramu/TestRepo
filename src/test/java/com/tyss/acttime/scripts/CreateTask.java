package com.tyss.acttime.scripts;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.Test;

import com.tyss.actitime.pages.Task_Page;
import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.baseutil.InitializePages;
import com.tyss.acttime.dataproviders.CreateRequisitionDataProvider;
import com.tyss.acttime.dataproviders.CreateTaskDataProvider;


public class CreateTask extends BaseTest {
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
		
	}
}
