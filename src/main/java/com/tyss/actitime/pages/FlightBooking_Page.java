package com.tyss.actitime.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.util.WebActionUtil;
import com.tyss.acttime.util.commonutils.ExcelUtil;

public class FlightBooking_Page {

	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public FlightBooking_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* Task Tab */
	@FindBy(xpath = "//span[text()='Flights']")
	private WebElement tabflight;

	/* click one way */
	@FindBy(id = "oneway")
	private WebElement btnOneway;

	/* type from textbox */
	@FindBy(id = "gosuggest_inputSrc")
	private WebElement txtFrom;

	/* select from dropdown */
	@FindBy(id = "react-autosuggest-1")
	private WebElement sddFrom;

	/* type destination textbox */
	@FindBy(id = "gosuggest_inputDest")
	private WebElement txtDestination;

	/* select destination */
	@FindBy(id = "react-autosuggest-1")
	private WebElement sddDestinationList;

	/* click Depature calendar */
	@FindBy(xpath = "//input[@id='departureCalendar']/preceding-sibling::i")
	private WebElement btnDepatureCalendar;

	/* click student fare */
	@FindBy(id = "student_fare_check")
	private WebElement lnkStudentFare;

	/* close student fare */
	@FindBy(xpath = "//a[@id='pax_close']")
	private WebElement btnStudentFare;

	/* click on search button */
	@FindBy(id = "gi_search_btn")
	private WebElement btnSearch;

	/* click book */
	@FindBy(xpath = "//input[@value='BOOK']")
	private WebElement btnBook;

	/* select title of adualt */
	@FindBy(xpath = "//select[@class='form-control inputMedium']")
	private WebElement ddTitle;

	/* Enter first name */
	@FindBy(xpath = "//input[@placeholder='First Name/Given Name']")
	private WebElement txtFirstName;

	/* Enter middle name */
	@FindBy(xpath = "//input[@placeholder='Middle Name']")
	private WebElement txtMiddleName;

	/* Enter last name */
	@FindBy(xpath = "//input[@placeholder='Last Name/Surname']")
	private WebElement txtLastName;

	/* Enter the mail id */
	@FindBy(id = "email")
	private WebElement txtEmail;

	/* enter mobile no */
	@FindBy(name = "mobile")
	private WebElement txtMobileno;

	/* Proceed tab */
	@FindBy(xpath = "//div[text()='Proceed ']")
	private WebElement btnProceed;

	/* round Trip tab */
	@FindBy(id = "roundTrip")
	private WebElement btnroundTrip;

	/* return date */
	@FindBy(id = "returnCalendar")
	private WebElement btnreturnDate;

	
	/* multicity Button */
	@FindBy(id = "multiCity")
	private WebElement btnmulticity;

	/* enter second source */
	@FindBy(xpath = "(//input[@id='gosuggest_inputSrc'])[2]")
	private WebElement txtSecondSource;

	/* select drop down */
	@FindBy(id = "react-autosuggest-1")
	private WebElement sddSecondSource;

	/* enter second destination */
	@FindBy(xpath = "(//input[@id='gosuggest_inputDest'])[2]")
	private WebElement txtSecondDestination;

	/*selct second destination */
	@FindBy(id = "react-autosuggest-1")
	private WebElement sddSecondDestination;

	/*slect second depature */
	@FindBy(xpath="(//input[@id='departureCalendar'])[2]")
	private WebElement ddSecondDepature;
	
	/**
	 * Description Method to click the flight tab
	 * 
	 * @author sugathini
	 * 
	 */
	public synchronized void clkFlightTab() {
		WebActionUtil.waitForElement(tabflight, "Flight  Tab", 45);
		WebActionUtil.clickOnElementUsingJS(tabflight, "Flight Tab");
	}

	/**
	 * Description Method to click on one way button
	 * 
	 * @author sugathini
	 * 
	 */
	public synchronized void clkOnewayButton() {
		WebActionUtil.waitForElement(btnOneway, "one way button", 45);
		WebActionUtil.clickOnElementUsingJS(btnOneway, "one way button");
	}

	/**
	 * Description Method to click on Round Trip button
	 * 
	 * @author sugathini
	 * 
	 */
	public synchronized void clkRoundButton() {
		WebActionUtil.waitForElement(btnroundTrip, "Round trip button", 45);
		WebActionUtil.clickOnElementUsingJS(btnroundTrip, "Round trip button");
	}
	/**
	 * Description Method to click on Multicity Trip button
	 * 
	 * @author sugathini
	 * 
	 */
	public synchronized void clkMulticity() {
		WebActionUtil.waitForElement(btnmulticity, "Multicity trip button", 45);
		WebActionUtil.clickOnElementUsingJS(btnmulticity, "Multicity trip button");
	}
	
	/**
	 * Description Method to enter from text
	 * 
	 * @author sugathini
	 * @throws InterruptedException
	 * 
	 */

	public synchronized void enterFromTextBox(String from) {
		WebActionUtil.waitForElement(txtFrom, "From text box", 45);
		WebActionUtil.typeText(txtFrom, from, "from text box");
		
		WebActionUtil.waitForElement(sddFrom, "dropdown", 45);
		txtFrom.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		/*
		 * driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']")).sendKeys(
		 * from); Thread.sleep(3000);
		 * 
		 * Actions act = new Actions(driver);
		 * 
		 * act.sendKeys(Keys.ARROW_DOWN).click().build().perform();
		 */

		// Actions act = new Actions(driver);

		// act.sendKeys(Keys.ARROW_DOWN).click().build().perform();
	}

	
	public synchronized void enterSecondSource(String from)
	{
		WebActionUtil.waitForElement(txtSecondSource, "SecondSource text box", 45);
		WebActionUtil.typeText(txtSecondSource, from, "SecondSource text box");
		WebActionUtil.waitForElement(sddSecondSource, "dropdown", 45);
		txtSecondSource.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}
	
	
	
	
	/**
	 * Description Method to enter destination text
	 * 
	 * @author sugathini
	 * @throws InterruptedException
	 * 
	 */
	public synchronized void enterDestinationTextBox(String destination)
	{
		WebActionUtil.waitForElement(txtDestination, "Destination text box", 45);
		WebActionUtil.typeText(txtDestination, destination, "Destination text box");
		// 
		WebActionUtil.waitForElement(sddDestinationList, "dropdown", 45);
		txtDestination.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		// Actions act = new Actions(driver);

		// act.sendKeys(Keys.ARROW_DOWN).click().build().perform();

	}

	/**
	 * Description Method to enter 
	 * 
	 * @author sugathini
	 * 
	 * 
	 */
	public synchronized void enterSecondDestination(String destination)
	{
		WebActionUtil.waitForElement(txtSecondDestination, "SecondDestination text box", 45);
		WebActionUtil.typeText(txtSecondDestination, destination, "SecondDestination text box");
		
		WebActionUtil.waitForElement(sddSecondDestination, "dropdown", 45);
		txtSecondDestination.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		// Actions act = new Actions(driver);

		// act.sendKeys(Keys.ARROW_DOWN).click().build().perform();

	}	
	/**
	 * Description Method to click on DepatureCalendar
	 * 
	 * @author sugathini
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 * 
	 */
	public synchronized void clkDepatureCalendar()  
	{
		WebElement ddSelectDate=driver.findElement(By.xpath("//div[text()='"+ExcelUtil.getCellData(BaseTest.EXCELPATH, "Date", 0, 1)+"']"));
		WebActionUtil.waitForElement(btnDepatureCalendar, "Depature calendar", 45);
		WebActionUtil.clickOnElementUsingJS(btnDepatureCalendar, "Depature calendar");
		WebActionUtil.waitForElement(ddSelectDate, "Depature calendar", 45);
		WebActionUtil.clickOnElementUsingJS(ddSelectDate, "Dropdown");
	}
	
	/**
	 * Description Method to click second DepatureCalendar
	 * 
	 * @author sugathini
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 * 
	 */
	public synchronized void clksecondDepature() 
	{
		
		WebElement ddSelectDate2=driver.findElement(By.xpath("//div[text()='"+ExcelUtil.getCellData(BaseTest.EXCELPATH, "Date", 1, 1)+"']"));
		WebActionUtil.waitForElement(ddSecondDepature, "second Depature calendar", 45);
		WebActionUtil.clickOnElementUsingJS(ddSecondDepature, "second Depature calendar");
		WebActionUtil.waitForElement(ddSelectDate2, "date", 5);
		WebActionUtil.clickOnElementUsingJS(ddSelectDate2, "drop down");
		
	}

	/**
	 * Description Method to click on return date
	 * 
	 * @author sugathini
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 * 
	 */
	public synchronized void clkreturndate()
	{
		WebElement ddreturnDate=driver.findElement(By.xpath("//div[text()='"+ExcelUtil.getCellData(BaseTest.EXCELPATH, "Date", 2, 1)+"']"));
		WebActionUtil.waitForElement(btnreturnDate, "returndate calendar", 45);
		WebActionUtil.clickOnElementUsingJS(btnreturnDate, "returndate calendar");
		WebActionUtil.waitForElement(ddreturnDate, "returndate calendar", 45);
		WebActionUtil.clickOnElementUsingJS(ddreturnDate, "Dropdown");
	}

	/**
	 * Description Method to click the student fare
	 * 
	 * @author sugathini
	 * 
	 */
	public synchronized void clkStudentFare() {
		WebActionUtil.waitForElement(lnkStudentFare, "Student fair  Tab", 45);
		WebActionUtil.clickOnElementUsingJS(lnkStudentFare, "Student fair Tab");
	}

	/**
	 * Description Method to close student fare
	 * 
	 * @author sugathini
	 * 
	 */
	public synchronized void closeStudentFare() {
		WebActionUtil.waitForElement(btnStudentFare, "close Student  Tab", 45);
		WebActionUtil.clickOnElementUsingJS(btnStudentFare, "close student Tab");
	}

	/**
	 * Description Method to click search button
	 * 
	 * @author sugathini
	 * 
	 */
	public synchronized void clkSearch() {
		WebActionUtil.waitForElement(btnSearch, "search button  Tab", 45);
		WebActionUtil.clickOnElementUsingJS(btnSearch, "search button Tab");
	}

	/**
	 * Description Method to click on book button
	 * 
	 * @author sugathini
	 * 
	 */
	public synchronized void clkBook() {
		WebActionUtil.waitForElement(btnBook, "book button", 45);
		WebActionUtil.clickOnElementUsingJS(btnBook, "book button");
	}

	/**
	 * Description Method to select title
	 * 
	 * @author sugathini
	 * 
	 */
	public synchronized void selectTitle(String title) {

		WebActionUtil.scrollToElement(ddTitle, "dropdown");
		WebActionUtil.waitForElement(ddTitle, "Flight  Tab", 45);
		WebActionUtil.selectByText(ddTitle, title);
	}

	/**
	 * Description Method to enter the first name
	 * 
	 * @author sugathini
	 * 
	 */
	public synchronized void enterFirstName(String firstname) {
		WebActionUtil.waitForElement(txtFirstName, "From text box", 45);
		WebActionUtil.typeText(txtFirstName, firstname, "from text box");
	}

	/**
	 * Description Method to enter the Middle name
	 * 
	 * @author sugathini
	 * 
	 */
	public synchronized void enterMiddleName(String middlename) {
		WebActionUtil.waitForElement(txtMiddleName, "From text box", 45);
		WebActionUtil.typeText(txtMiddleName, middlename, "from text box");
	}

	/**
	 * Description Method to enter the Last name
	 * 
	 * @author sugathini
	 * 
	 */
	public synchronized void enterLastName(String lastname) {
		WebActionUtil.waitForElement(txtLastName, "From text box", 45);
		WebActionUtil.typeText(txtLastName, lastname, "from text box");
	}

	/**
	 * Description Method to enter the email
	 * 
	 * @author sugathini
	 * 
	 */
	public synchronized void enterEmail(String email) {
		WebActionUtil.waitForElement(txtEmail, "From text box", 45);
		WebActionUtil.typeText(txtEmail, email, "from text box");
	}

	/**
	 * Description Method to enter the mobile no
	 * 
	 * @author sugathini
	 * 
	 */
	public synchronized void enterMobileNo(String mobile) {
		WebActionUtil.waitForElement(txtMobileno, "From text box", 45);
		WebActionUtil.typeText(txtMobileno, mobile, "from text box");
	}

	/**
	 * Description Method to click on Proceed
	 * 
	 * @author sugathini
	 * 
	 */
	public synchronized void clkProceed() {
		WebActionUtil.waitForElement(btnProceed, "From text box", 45);
		WebActionUtil.clickOnElementUsingJS(btnProceed, "Flight Tab");
	}
	
	public String getdataFromExcel(int rowno,int colno) throws EncryptedDocumentException, IOException, InvalidFormatException
	{
		String excelFilePath=BaseTest.EXCELPATH;
		FileInputStream fis=new FileInputStream(excelFilePath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Date");
		String value=sh.getRow(rowno).getCell(colno).getStringCellValue();
		return value;	
	}

}
