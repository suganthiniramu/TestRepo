package com.tyss.acttime.dataproviders;

import org.testng.annotations.DataProvider;

import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.util.commonutils.ExcelUtil;

public class CreateRequisitionDataProvider {

	@DataProvider(name = "TestDataProvider")
	public static Object[][] getTestData() {
		int noofrows = ExcelUtil.getRowCount(BaseTest.EXCELPATH, "AddCustomer");
		int noofcols = ExcelUtil.getColoumCount(BaseTest.EXCELPATH, "AddCustomer");
		Object[][] workflowdata = new Object[noofrows][noofcols];
		
		for (int i = 1; i <= noofrows; i++) {
			String data[] = ExcelUtil.getRowData(BaseTest.EXCELPATH, "AddCustomer", i);

			for (int j = 0; j < data.length; j++) {

				workflowdata[i - 1][j] = data[j];
			}

		}
		return workflowdata;

	}

	@DataProvider(name = "LoginDataProvider")
	public static Object[][] getWorkFlowData() {
		int noofrows = ExcelUtil.getRowCount(BaseTest.EXCELPATH, "appData");
		int noofcols = ExcelUtil.getColoumCount(BaseTest.EXCELPATH, "appData");
		Object[][] workflowdata = new Object[noofrows][noofcols];
		
		
		
		for (int i = 1; i <= noofrows; i++) {
			String data[] = ExcelUtil.getRowData(BaseTest.EXCELPATH, "appData", i);

			for (int j = 1; j < data.length-1; j++) {

				workflowdata[i - 1][j] = data[j];
			}

		}
		return workflowdata;

	}
}
