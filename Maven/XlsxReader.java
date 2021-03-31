package com.atmecs.selenium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsxReader {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public XlsxReader(String filePath) {
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

	public String getData(int index, int rowNum, int cellNum) {
		sheet = workbook.getSheetAt(index);
		String data = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}

	public int totalRowsInSheet(int sheetIndex) {
		String data1 = sheet.getSheetName();
		System.out.println("Sheet Name: "+data1);
		int rowCount = workbook.getSheetAt(sheetIndex).getLastRowNum();
		return rowCount;
	}

	public int totalColsInSheet(int sheetIndex, int rowCount) {
		int colCount = workbook.getSheetAt(sheetIndex).getRow(rowCount).getLastCellNum();
		return colCount;
	}
}
