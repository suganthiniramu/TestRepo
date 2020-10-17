package com.tyss.acttime.dataproviders;

import org.testng.annotations.DataProvider;

import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.util.commonutils.ExcelUtil;

public class CreateFlightDataProvider {
	
	/**
	 * Description : Data Provider to fetch data from  Excel file according to specified sheet name.
	 * @author suganthini
	 */
	@DataProvider(name = "FlightdataProvider")
	public static Object[][] getTestData() {
		int noofrows = ExcelUtil.getRowCount(BaseTest.EXCELPATH, "Flightdata");
		int noofcols = ExcelUtil.getColoumCount(BaseTest.EXCELPATH, "Flightdata");
		Object[][] workflowdata = new Object[noofrows][noofcols];
		
		for (int i = 1; i <= noofrows; i++) {
			String data[] = ExcelUtil.getRowData(BaseTest.EXCELPATH, "Flightdata", i);

			for (int j = 0; j < data.length; j++) {

				workflowdata[i - 1][j] = data[j];
			}

		}
		return workflowdata;

	}

}
