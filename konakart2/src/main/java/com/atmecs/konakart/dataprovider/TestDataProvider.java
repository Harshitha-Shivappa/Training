package com.atmecs.konakart.dataprovider;

import org.testng.annotations.DataProvider;

import com.atmecs.konakart.constants.FileConstant;
import com.atmecs.konakart.utils.ProvideData;

/**
 * The class is used for creating the data provider for receiving the value of excel file
 *
 */

public class TestDataProvider {
	@DataProvider(name = "Testing")
	public Object[][] testData() {
		ProvideData provideData = new ProvideData(FileConstant.TESTDATA_FILE);
		return provideData.testData(0);
	}
}
