package com.tyss.acttime.reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tyss.acttime.util.WebActionUtil;
import com.tyss.acttime.util.commonutils.FileVariables;


public class Extent {
	
	private ExtentReports extent;
	FileVariables fileVariables = new FileVariables();

	public  ExtentReports getExtent(String filepath) {

		if (extent == null) {
			try {
				extent = new ExtentReports();
				extent.attachReporter(getHtmlReporter(filepath+  " _Report.html"));
				return extent; 
			} catch (Exception e) {
				WebActionUtil.info("Exception while creating report html file.");
				
			}
		}
		return extent;
	}
	
	private static ExtentHtmlReporter getHtmlReporter(String filePath) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "./conf\\extent-config.xml");
		return htmlReporter;
	}

}
