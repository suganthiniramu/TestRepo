package com.tyss.acttime.baseutil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tyss.acttime.util.WebActionUtil;

public class BasePage {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public BasePage(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;

	
}
}
