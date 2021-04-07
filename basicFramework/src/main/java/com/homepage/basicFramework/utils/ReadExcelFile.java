package com.homepage.basicFramework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
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
	
	public static String getData(int index, int rowNum, int cellNum) {
		
		sheet = workbook.getSheetAt(index);
		return sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
	public   int totalRowsinSheet(int sheet) {
		return workbook.getSheetAt(sheet).getLastRowNum();
		
	}
	
	public int totalColsinSheet(int sheetIndex,int rowCount) {
		return workbook.getSheetAt(sheetIndex).getRow(rowCount).getLastCellNum();	
	}
}