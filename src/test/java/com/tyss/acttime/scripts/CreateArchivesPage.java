package com.tyss.acttime.scripts;

import org.testng.annotations.Test;

import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.baseutil.InitializePages;
import com.tyss.acttime.dataproviders.CreateArchievesDataProvider;
import com.tyss.acttime.dataproviders.CreateRequisitionDataProvider;

public class CreateArchivesPage extends BaseTest {
	@Test(description = "Create Archives", dataProvider = "TestArchivesDataProvider", dataProviderClass = CreateArchievesDataProvider.class)

	public void createRequisition(String customername) throws Exception {

		String username = prop.getProperty("UserName");
		String password = prop.getProperty("Password");

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		pages.loginPage.loginToApplication(username, password);
        
		/* Click on Task Tab */
		pages.taskPage.clkTaskTab();

		/* Click on Projects And Customers Tab */
		pages.projectsandCustomerPage.clkProjectsAndCustomersTab();

		/* Click on Customer Dropdown */
		pages.archivesPage.clkCustomerdropDown(customername);

		/* Click on Show Button */
		pages.archivesPage.clkShowButton();

		/* Click on Project Checkbox */
		pages.archivesPage.clkProjectCheckbox();

		/* Click on ArchieveSelected Button */
		pages.archivesPage.clkArchieveSelectedButton();

		/* Click on  Archieves Tab*/
		pages.archivesPage.clkArchievesTab();
	}
}
