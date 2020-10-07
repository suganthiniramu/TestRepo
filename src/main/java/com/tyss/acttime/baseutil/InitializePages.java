package com.tyss.acttime.baseutil;

import org.openqa.selenium.WebDriver;

import com.tyss.actitime.pages.Login_Page;
import com.tyss.actitime.pages.Task_Page;
import com.tyss.acttime.util.WebActionUtil;


/**
 * Description    Initialize all pages with driver,ETO, WebAactionUtil
 * @author         shreya.u@testyantra.com,vivek.d@testyantra.com,aatish.s@testyantra.com
 * 
 */

public class InitializePages {
	public Login_Page loginPage;
	public Task_Page taskPage;
	public InitializePages(WebDriver driver,long ETO,WebActionUtil WebActionUtil) {
			
			loginPage = new Login_Page(driver, ETO, WebActionUtil);
			taskPage=new Task_Page(driver, ETO, WebActionUtil);
	}

}
