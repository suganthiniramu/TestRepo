package com.tyss.acttime.dataproviders;

import org.testng.annotations.DataProvider;

import com.tyss.acttime.baseutil.BaseTest;
import com.tyss.acttime.util.commonutils.ExcelUtil;
/**
 * Description : Data Provider to fetch the data from Excel workbook.
 * @author Manish Kumar C D
 */

public class CreateTaskDataProvider {
        /**
		 * Description : Data Provider to fetch data from  Excel file according to specified sheet name.
		 * @author Manish Kumar C D
		 */
		@DataProvider(name = "TestDataProviderForTasks")
		public static Object[][] getTestData() {
			int noofrows = ExcelUtil.getRowCount(BaseTest.EXCELPATH, "createTaskdetails");
			int noofcols = ExcelUtil.getColoumCount(BaseTest.EXCELPATH, "createTaskdetails");
			Object[][] workflowdata = new Object[noofrows][noofcols];
			
			for (int i = 1; i <= noofrows; i++) {
				String data[] = ExcelUtil.getRowData(BaseTest.EXCELPATH, "createTaskdetails", i);

				for (int j = 0; j < data.length; j++) {

					workflowdata[i - 1][j] = data[j];
				}

			}
			return workflowdata;

		}
	}


