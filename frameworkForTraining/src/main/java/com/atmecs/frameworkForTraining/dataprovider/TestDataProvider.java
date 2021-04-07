package com.atmecs.frameworkForTraining.dataprovider;

import org.testng.annotations.DataProvider;

import com.atmecs.frameworkForTraining.constants.FileConstant;
import com.atmecs.frameworkForTraining.utils.ProvideData;

/**
 * The class is used for creating the data provider for receiving the value of excel file
 * @author amrut.dash
 *
 */

public class TestDataProvider {
	@DataProvider(name = "headerData")
	public Object[][] testData() {
		ProvideData provideData = new ProvideData(FileConstant.TESTDATA_FILE);
		Object[][] getData = provideData.testData(0);
		return getData;
	}
}
