package com.tyss.acttime.scripts;

import org.testng.annotations.Test;

import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.baseutil.InitializePages;
import com.tyss.acttime.dataproviders.CreateFlightDataProvider;

public class MulticityTrip extends BaseTest 
{
	@Test(description = "Multicity trip", dataProvider = "FlightdataProvider", dataProviderClass = CreateFlightDataProvider.class, priority = 3)
	public void createMulticityTrip(String from,String destination,
			String title,String firstname,String middlename,String lastname,String email,String mobileno ) throws Exception {

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		
		/* click on multicity */
		pages.flightBookingPage.clkMulticity();
		
		/* Enter first from */
		pages.flightBookingPage.enterFromTextBox(from);
		
		/* Enter Destination from */
		pages.flightBookingPage.enterDestinationTextBox(destination);
		
		/*click on depature calendar */
		pages.flightBookingPage.clkDepatureCalendar();
		
		/* enter second form */
		pages.flightBookingPage.enterSecondSource(destination);
		
		/* enter second destination */
		pages.flightBookingPage.enterSecondDestination(from);
		
		/* select second depature date */
		pages.flightBookingPage.clksecondDepature();
		
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
