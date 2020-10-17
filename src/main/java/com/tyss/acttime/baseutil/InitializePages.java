package com.tyss.acttime.baseutil;

import org.openqa.selenium.WebDriver;

import com.tyss.actitime.pages.Archives_Page;
import com.tyss.actitime.pages.Completed_Tasks_Page;
import com.tyss.actitime.pages.Create_Task_Page;
import com.tyss.actitime.pages.FlightBooking_Page;
import com.tyss.actitime.pages.Login_Page;
import com.tyss.actitime.pages.Open_Task_Page;
import com.tyss.actitime.pages.Projects_and_Customers_Page;
import com.tyss.actitime.pages.Task_Page;
import com.tyss.actitime.pages.Time_Track_Page;
import com.tyss.actitime.pages.Users_Page;
import com.tyss.acttime.util.WebActionUtil;


/**
 * Description    Initialize all pages with driver,ETO, WebAactionUtil
 * @author         shreya.u@testyantra.com,vivek.d@testyantra.com,aatish.s@testyantra.com
 * 
 */

public class InitializePages {
	public Login_Page loginPage;
	public Task_Page taskPage;
	public Create_Task_Page createTaskPage;
	public Projects_and_Customers_Page projectsandCustomerPage;
	public Completed_Tasks_Page completedtasksPage;
	public Time_Track_Page timetrackPage;
	public Archives_Page archivesPage;
	public Open_Task_Page opentaskPage;
	public Users_Page usersPage;
	public FlightBooking_Page flightBookingPage;
	public InitializePages(WebDriver driver,long ETO,WebActionUtil WebActionUtil) {
			
			loginPage = new Login_Page(driver, ETO, WebActionUtil);
			taskPage=new Task_Page(driver, ETO, WebActionUtil);
			createTaskPage=new Create_Task_Page(driver, ETO, WebActionUtil);
			projectsandCustomerPage=new Projects_and_Customers_Page(driver, ETO, WebActionUtil);
			completedtasksPage=new Completed_Tasks_Page(driver, ETO, WebActionUtil);
			timetrackPage=new Time_Track_Page(driver, ETO, WebActionUtil);
			archivesPage=new Archives_Page(driver, ETO, WebActionUtil);
			opentaskPage=new Open_Task_Page(driver, ETO, WebActionUtil);
			usersPage= new Users_Page(driver, ETO, WebActionUtil);
			flightBookingPage=new FlightBooking_Page(driver, ETO, WebActionUtil);
			
	}

}
