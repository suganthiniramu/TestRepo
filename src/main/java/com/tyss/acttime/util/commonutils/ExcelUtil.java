package com.tyss.acttime.util.commonutils;


import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.tyss.acttime.baseutil.BaseTest;


/**
 * @author: Harsha K.B
 * @description : Implemented all the generic method for the Excel.
 */

public class ExcelUtil{
	private ExcelUtil() {

	}
	/**
	 * @author:Harsha K.B
	 * 
	 *  Description:  Fetch the row count in the specified sheet
	 */
	public static int getRowCount(String sPath, String sSheet) {
		int iRowNum = 0;
		try {
			FileInputStream fis = new FileInputStream(sPath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sSheet);
			iRowNum = sht.getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iRowNum;
	}
	/**
	 * @author:Harsha K.B
	 * 
	 *  Description:  Fetch the column count in the specified sheet
	 */
	public static int getColoumCount(String sPath, String sSheet) {
		int colnum = 0;
		try {
			FileInputStream fis = new FileInputStream(sPath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sSheet);
			colnum = sht.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colnum;
	}
	/**
	 * @author:Harsha K.B
	 * 
	 *  Description:  Fetch the data from the cell
	 */
	public static String getCellData(String xlPAth, String sheetName, int rowNo, int colNo) {
		DataFormatter dataFormatter = new DataFormatter();

		int iRowNum = 0;
		String data = null;
		try {
			FileInputStream fis = new FileInputStream(xlPAth);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sheetName);
			iRowNum = sht.getLastRowNum();
			if (rowNo <= iRowNum) {
				Cell cell = sht.getRow(rowNo).getCell(colNo);
				data = dataFormatter.formatCellValue(cell);
			} else {
				BaseTest.logger.info("Please provide the valid Row Count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	/**
	 * @author:Harsha K.B
	 * @param sFilePath ,sSheet ,rowNo
	 *  Description:  Fetch the row data from the excel sheet
	 */
	public static String[] getRowData(String sFilePath, String sSheet, int rowNo) {
		DataFormatter dataFormatter = new DataFormatter();
		String sData[] = null;
		try {
			FileInputStream fis = new FileInputStream(sFilePath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sSheet);
			int iCellNum = sht.getRow(rowNo).getPhysicalNumberOfCells();
			sData = new String[iCellNum];
			for (int j = 0; j < iCellNum; j++) {
				Cell cell = sht.getRow(rowNo).getCell(j);
				sData[j] = dataFormatter.formatCellValue(cell);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return sData;
	}
	/**
	 * @author:Harsha K.B
	 * @param sFilePath ,sSheet ,colno
	 *  Description:  Fetch the column data from the specified sheet
	 */
	public static String[] getColoumData(String sFilePath, String sSheet, int colno) {
		DataFormatter dataFormatter = new DataFormatter();
		String sData[] = null;
		try {
			FileInputStream fis = new FileInputStream(sFilePath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sSheet);
			int iRowNum = sht.getLastRowNum();
			sData = new String[iRowNum];

			for (int i = 1; i <= iRowNum; i++) {
				Cell cell = sht.getRow(i).getCell(colno);
				sData[i - 1] = dataFormatter.formatCellValue(cell);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sData;
	}
	/**
	 * @author:Harsha K.B
	 * @param sFilePath ,sSheet ,colName
	 *  Description:  Fetch the column index
	 */
	public static int getColoumIndex(String filepath, String sSheet, String colName) {
		String[] firstrow = getRowData(filepath, sSheet, 0);
		int index = 0;
		for (int i = 0; i < firstrow.length; i++) {
			if (firstrow[i].equalsIgnoreCase(colName)) {
				index = i;
			}
		}
		return index;

	}
	/**
	 * @author:Harsha K.B
	 * @param  data
	 *  Description:  Check if an array contains blank
	 */
	public static boolean doesArrayContainsBlank(String[] data) {
		boolean blank = false;

		for (int i = 0; i < data.length; i++) {
			if (data[i].isEmpty() || data[i] == null) {
				blank = true;
				break;
			}
		}
		return blank;
	}
	/**
	 * @author:Harsha K.B
	 * @param  sFilePath,sSheet,sTestCaseId
	 *  Description:  To Read the excel data
	 *  @return String[]
	 */
	public static String[] toReadExcelData(String sFilePath, String sSheet, String sTestCaseId) {
		DataFormatter dataFormatter = new DataFormatter();
		String SData[] = null;
		try {
			// File Read
			FileInputStream fis = new FileInputStream(sFilePath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sSheet);
			int iRowNum = sht.getLastRowNum();
			for (int i = 0; i <= iRowNum; i++) {
				if (sht.getRow(i).getCell(0).toString().equals(sTestCaseId)) {
					int iCellNum = sht.getRow(i).getPhysicalNumberOfCells();
					SData = new String[iCellNum];
					for (int j = 0; j < iCellNum; j++) {
						Cell cell = sht.getRow(i).getCell(j);
						SData[j] = dataFormatter.formatCellValue(cell);
					}
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return SData;
		
	}
	/**
	 * @author:Harsha K.B
	 * @param  sFilePath,sSheet,colName,firstRowName
	 *  Description: Fetch the column Index
	 *  @return index]
	 */
	public static int getColoumIndex(String filepath, String sSheet, String colName, String firstRowName) {
		String[] firstRow = ExcelUtil.toReadExcelData(filepath, sSheet, firstRowName);
		int index = 0;
		for (int i = 0; i < firstRow.length; i++) {
			if (firstRow[i].equalsIgnoreCase(colName)) {
				index = i;
			}
		}
		return index;
	}

	
	/**
	 * @author:Harsha K.B
	 * @param  sPath,sSheet,sSheeet,row
	 *  Description: Fetch the cell count
	 *  @return column
	 */
	public static int getCellCount(String sPath, String sSheeet, int row) {
		int colnum = 0;
		try {
			FileInputStream fis = new FileInputStream(sPath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sSheeet);
			colnum = sht.getRow(row).getPhysicalNumberOfCells();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colnum;
	}
	/**
	 * @author:Harsha K.B
	 * @param  sPath,sSheet,sSheeet,row
	 *  Description: To Create cell
	 */
	public static void createCell(String sPath,String sSheeet,int row) {
		try {
			FileInputStream fis = new FileInputStream(sPath);
			   Workbook wb = (Workbook)WorkbookFactory.create(fis);
			   Sheet sht = wb.getSheet(sSheeet);
			   sht.getRow(row).createCell(6).setCellValue(" ");
		}catch (Exception e ) {
			e.printStackTrace();
		}
	}

}
