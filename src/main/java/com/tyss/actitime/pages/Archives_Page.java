package com.tyss.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.acttime.util.WebActionUtil;

/**
 * Description This class has the implementations of the Archives related methods
 * @author Manish kumar C D
 */
public class Archives_Page {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public Archives_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/*  Customer Dropdown  */
	@FindBy(xpath="//select[@name='selectedCustomer']")
	private WebElement ddCustomer;

	/*  Show Button  */
	@FindBy(xpath="(//input[@type='button'])[3]")
	private WebElement btnShow;

	/* Select Project checkbox   */
	@FindBy(xpath="//input[@name='customers[1]']")
	private WebElement cbProject;

	/*  Archieve Selected button */
	@FindBy(xpath="//input[@type='button' and @value='Archive Selected']")
	private WebElement btnArchieveSelected;

	/*  Archieves Tab  */
	@FindBy(xpath="//a[.='Archives']")
	private WebElement tabArchieves;

     
	/**
	 * Description Method clicks on Customer Dropdown
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkCustomerdropDown(String value) {
		WebActionUtil.waitForElement(ddCustomer, "Customer Dropdown", 45);
		WebActionUtil.clickOnWebElement(ddCustomer, "CustomerDropdown", "Click on Customer Dropdown");
		WebActionUtil.selectByText(ddCustomer, value);

	}
	/**
	 * Description Method clicks on Show Button
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkShowButton() {
		WebActionUtil.waitForElement(btnShow, "Show Button", 45);
		WebActionUtil.clickOnWebElement(btnShow, "Show Button", "Click on Show Button");

	}
	
	/**
	 * Description Method clicks on Project Checkbox
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkProjectCheckbox() {
		WebActionUtil.waitForElement(cbProject, "Project Checkbox", 45);
		WebActionUtil.clickCheckBox(cbProject, "Project Checkbox");

	}
	
	/**
	 * Description Method clicks on Archieve Selected Button
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkArchieveSelectedButton() {
		WebActionUtil.waitForElement(btnArchieveSelected, "Archieve Selected Button", 45);
		WebActionUtil.clickOnWebElement(btnArchieveSelected, "Archieve Selected Button", "Click on ArchieveSelectedButton");

	}

	/**
	 * Description Method clicks on Archieves Tab
	 * @author Manish Kumar C D
	 * 
	 */
	public synchronized void clkArchievesTab() {
		WebActionUtil.waitForElement(tabArchieves, "Archieves Tab", 45);
		WebActionUtil.clickOnWebElement(tabArchieves, "Archieves Tab", "Click on Archieves Tab");

	}


}
