package com.tyss.acttime.scripts;

import org.testng.annotations.Test;

import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.baseutil.InitializePages;
import com.tyss.acttime.dataproviders.CreateFlightDataProvider;

public class ReturnTrip extends BaseTest {
	@Test(description = "Return trip", dataProvider = "FlightdataProvider", dataProviderClass = CreateFlightDataProvider.class, priority = 2)
	public void createReturnTrip(String from,String destination,
			String title,String firstname,String middlename,String lastname,String email,String mobileno ) throws Exception {

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		
		/* click flight tab */
		pages.flightBookingPage.clkFlightTab();
		
		/* click on Round button */
		pages.flightBookingPage.clkRoundButton();
		
		/* enter from text box */
		pages.flightBookingPage.enterFromTextBox(from);
		
		/* enter destination text box */
		pages.flightBookingPage.enterDestinationTextBox(destination);

		/* click depature date */
		pages.flightBookingPage.clkDepatureCalendar();
		
		/* click on return date */
		pages.flightBookingPage.clkreturndate();
		
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
