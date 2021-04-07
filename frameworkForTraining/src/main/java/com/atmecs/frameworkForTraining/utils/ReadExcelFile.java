package com.atmecs.frameworkForTraining.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * The class reads the excel file and returns the value of a particular location.
 * @author Amrut Dash
 *
 */

public class ReadExcelFile {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	/**
	 * The constructor takes file path as the parameter, reads the file and initializes the workbook
	 * @param filePath               
	 */
	public ReadExcelFile(String filePath) {
		try {
			File file = new File(filePath);
			FileInputStream fileInput = new FileInputStream(file);
			try {
				workbook = new XSSFWorkbook(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method takes parameter as
	 * @param index
	 * @param rowNum
	 * @param cellNum
	 * @return the data at that location
	 */
	public static String getData(int index, int rowNum, int cellNum) {
		
		sheet = workbook.getSheetAt(index);
		String data = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
	public   int totalRowsinSheet(int sheet) {
		int rowCount = workbook.getSheetAt(sheet).getLastRowNum();
		return rowCount;
	}
	
	public int totalColsinSheet(int sheetIndex,int rowCount) {
		int colCount = workbook.getSheetAt(sheetIndex).getRow(rowCount).getLastCellNum();
		return colCount;
	}
}
