package com.tyss.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tyss.acttime.util.WebActionUtil;

public class Login_Page {
	/**
	 * @author shreya.u@testyantra.com
	 */
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public Login_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* Sign In Button */
	@FindBy(id = "loginButton")
	private WebElement btnSignIn;

	/* User Name Text Box */
	@FindBy(name = "username")
	private WebElement txtUsername;

	/* Password Text Box */
	@FindBy(name = "pwd")
	private WebElement txtPassword;

	public synchronized void loginToApplication(String username, String password) {
		try {
			WebActionUtil.info("Login To the App");
			WebActionUtil.typeText(txtUsername, username, "User Name Text Box");
			WebActionUtil.typeText(txtPassword, password, "Password Text Box");
			WebActionUtil.waitForElement(btnSignIn, " Dash Board Sign In Button", 20);
			WebActionUtil.clickOnWebElement(btnSignIn, "Sign In Button", "Unable To Click On Sign in Button");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.error("-Unable to sign in the Application");
			Assert.fail("Unable to signIn in the Login Page");
		}

	}

}
