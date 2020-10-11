package com.tyss.acttime.scripts;

import org.testng.annotations.Test;

import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.baseutil.InitializePages;
import com.tyss.acttime.dataproviders.CreateRequisitionDataProvider;
import com.tyss.acttime.dataproviders.CreateUsersDataProvider;

public class CreateUsers extends BaseTest {
	@Test(description = "Create Users", dataProvider = "TestUsersDataProvider", dataProviderClass = CreateUsersDataProvider.class)

	public void createRequisition(String firstname,String lastname,String emailaddress) throws Exception {

		String username = prop.getProperty("UserName");
		String password = prop.getProperty("Password");

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		pages.loginPage.loginToApplication(username, password);
		
		/* Click on User Tab */
		pages.usersPage.clkUsersTab();
		
		/* Click on User button */
		pages.usersPage.clkUsersbutton();
		
		/* Enter First Name */
		pages.usersPage.typeFirstNameTextBox(firstname);
		
		/* Enter Last Name */
		pages.usersPage.typeLastNameTextBox(lastname);
		
		/* Enter Email Address*/
		pages.usersPage.typeEmailAddressTextBox(emailaddress);
		
		/* Click on Enter Time Track Checkbox */
		pages.usersPage.clkEnterTimeTrackCheckbox();
		
		/* Click on GenerateTimeReportsCheckbox */
		pages.usersPage.clkGenerateTimeReportsCheckbox();
		
		/* Click on Has To Access Dropdown */
		pages.usersPage.clkHasAccessToDropdown();
		
		/* Click on AllProjects of AllCustomers Radio button*/
		pages.usersPage.clkAllProjectsofAllCustomersRadiobutton();
		
		/* Click on Close button*/
		pages.usersPage.clkClosebutton();
		
		/* Click on CreateUser button*/
		pages.usersPage.clkCreateUserButton();
	}
}
