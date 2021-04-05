package com.atmecs.selenium.utils;

import java.util.ArrayList;

public class ProvideData {
	static Sheet_Reader reader;

	public static ArrayList<Object[]> getDataFromSheet() {
		ArrayList<Object[]> values = new ArrayList<>();

		try {
			reader = new Sheet_Reader("C:\\Users\\Harshitha.Shivappa\\workspace\\Training\\TestData\\gmailData.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sheetName = "gmailData";
		for (int rowNum = 2; rowNum <= reader.getRowCount(sheetName); rowNum++) {
			String firstName = reader.getCellData(sheetName, "FirstName", rowNum);
			String lastName = reader.getCellData(sheetName, "LastName", rowNum);
			String userName = reader.getCellData(sheetName, "UserName", rowNum);
			String password = reader.getCellData(sheetName, "Password", rowNum);
			String confirm = reader.getCellData(sheetName, "Confirm", rowNum);

			Object obj[] = { firstName, lastName, userName, password, confirm };
			values.add(obj);
		}
		return values;
	}
}
