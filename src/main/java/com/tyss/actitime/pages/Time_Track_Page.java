package com.tyss.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.acttime.util.WebActionUtil;
/**
 * Description This class has the implementations of the Time Track Page related methods
 * @author Manish Kumar C D
 */
public class Time_Track_Page {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public Time_Track_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/* Time Track Tab */
	@FindBy(xpath = "//div[.='Time-Track']")
	private WebElement tabTimeTrack;
	
	/*Enter Time-Track Tab*/
	@FindBy(xpath="//a[.='Enter Time-Track']")
	private WebElement tabEnterTimeTrack;
	
	/*Add Tasks from the List Dropdown*/
	@FindBy(xpath="//span[.='Add Tasks from the List']")
	private WebElement ddAddTasksfromtheList;
	
	/*Select customer or Project dropdown*/
	@FindBy(xpath="//td[@class='dropdownButton']")
	private WebElement ddCustomerorProject;
	
	/*Select customer 1*/
	@FindBy(xpath="(//td[@class='name'])[2]")
	private WebElement ddCustomer1;
	
	/*Select customer 2*/
	@FindBy(xpath="(//td[@class='name'])[3]")
	private WebElement ddCustomer2;
	
	/*Select customer 2 checkbox*/
	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	private WebElement cbCustomer2;
	
	/*Add Selected button*/
	@FindBy(xpath="//button[@class='addSelectedButton']")
	private WebElement btnAddSelected;
	
	/*New link*/
	@FindBy(xpath="//a[.='New']")
	private WebElement lnkNew;
	
	/**
	 * Description  Method clicks on New link
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkNewLink() {
		WebActionUtil.waitForElement(lnkNew, "New link", 45);
		WebActionUtil.clickOnWebElement(lnkNew, "New link", "Unable to click on New link");
	

	}

	/**
	 * Description  Method clicks on Time Track Tab
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkTimeTrackTab() {
		WebActionUtil.waitForElement(tabTimeTrack, "Time Track  Tab", 45);
		WebActionUtil.clickOnElementUsingJS(tabTimeTrack, "Time Track Tab");
	

	}
	
	/**
	 * Description  Method clicks on Enter Time Track Tab
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkEnterTimeTrackTab() {
		WebActionUtil.waitForElement(tabEnterTimeTrack, "Enter Time Track  Tab", 45);
		WebActionUtil.clickOnElementUsingJS(tabEnterTimeTrack, "Enter Time Track Tab");
	

	}
	 
	/**
	 * Description  Method clicks on Select customer or Project dropdown
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkSelectCustomerorProjectdropdown() {
		WebActionUtil.waitForElement(ddCustomerorProject, "Select customer or Project dropdown", 45);
		WebActionUtil.clickOnElementUsingJS(ddCustomerorProject, "Select customer or Project dropdow");
	

	}

	/**
	 * Description  Method clicks on AddTasksfromList Dropdown
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkAddTasksfromList() {
		WebActionUtil.waitForElement(ddAddTasksfromtheList, "AddTasksfromList Dropdown", 45);
		WebActionUtil.clickOnElementUsingJS(ddAddTasksfromtheList, "AddTasksfromList Dropdown");
	

	}
	
	/**
	 * Description  Method clicks on Customer
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkCustomer() {
		WebActionUtil.waitForElement(ddCustomer2, "Customer", 45);
		WebActionUtil.clickOnElementUsingJS(ddCustomer2, "Customer");
	

	}
	
	/**
	 * Description  Method clicks on CustomerCheckbox
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkCustomerCheckbox() {
		WebActionUtil.waitForElement(cbCustomer2, "CustomerCheckbox", 45);
		WebActionUtil.clickOnElementUsingJS(cbCustomer2, "CustomerCheckbox");
	

	}

	/**
	 * Description  Method clicks on CustomerCheckbox
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkAddSelected() {
		WebActionUtil.waitForElement(btnAddSelected, "AddSelected button", 45);
		WebActionUtil.clickOnElementUsingJS(btnAddSelected, "AddSelected button");
	

	}
	
}
