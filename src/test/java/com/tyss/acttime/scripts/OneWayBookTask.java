package com.tyss.acttime.scripts;

import org.testng.annotations.Test;

import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.baseutil.InitializePages;
import com.tyss.acttime.dataproviders.CreateFlightDataProvider;
import com.tyss.acttime.dataproviders.CreateRequisitionDataProvider;

public class OneWayBookTask extends BaseTest {
	
	
	
	@Test(description = "One way Trip", dataProvider = "FlightdataProvider", dataProviderClass = CreateFlightDataProvider.class, priority = 1)
	public void createOneWay(String from,String destination,
			String title,String firstname,String middlename,String lastname,String email,String mobileno ) throws Exception {

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		
		/* click flight tab */
		pages.flightBookingPage.clkFlightTab();
		
		/* click on one way button */
		pages.flightBookingPage.clkOnewayButton();
		
		/* enter from text box */
		pages.flightBookingPage.enterFromTextBox(from);
		
		/* enter destination text box */
		pages.flightBookingPage.enterDestinationTextBox(destination);

		/* click depature date */
		pages.flightBookingPage.clkDepatureCalendar();
		
		/*click student fare */
		pages.flightBookingPage.clkStudentFare();
		
		/* close student fare tab */
		pages.flightBookingPage.closeStudentFare();
		
		/* click on search button */
		pages.flightBookingPage.clkSearch();
		
		/* click on book */
		pages.flightBookingPage.clkBook();
		
		/* select title */
		
		pages.flightBookingPage.selectTitle(title);
		
		/* enter first name */
		pages.flightBookingPage.enterFirstName(firstname);
		
		/*enter middle name */
		pages.flightBookingPage.enterMiddleName(middlename);
		
		/*enter last name */
		pages.flightBookingPage.enterLastName(lastname);
		
		/*enter email id */
		pages.flightBookingPage.enterEmail(email);
		
		/*enter phone no */
		pages.flightBookingPage.enterMobileNo(mobileno);
		
		/* click proceed button */
		pages.flightBookingPage.clkProceed();
		
		
		
		
		
		
	
	
	}
}
