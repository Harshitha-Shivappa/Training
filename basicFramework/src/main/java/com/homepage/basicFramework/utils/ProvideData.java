package com.homepage.basicFramework.utils;

public class ProvideData {
	Object[][] object;
	ReadExcelFile read;

	public ProvideData(String filePath) {
		read = new ReadExcelFile(filePath);
	}

	public Object[][] testData(int sheetIndex) {
		int index = sheetIndex;
		int rowNo = 1;
		int rowCount = read.totalRowsinSheet(index);
		int colCount = read.totalColsinSheet(index, rowNo);

		Object[][] data = new Object[rowCount][colCount];

		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			for (int colIndex = 0; colIndex < colCount; colIndex++)
				data[rowIndex][colIndex] = ReadExcelFile.getData(sheetIndex, rowIndex + 1, colIndex);
		}
		return data;
	}
}
