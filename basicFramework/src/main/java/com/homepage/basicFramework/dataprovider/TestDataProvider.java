package com.homepage.basicFramework.dataprovider;

import org.testng.annotations.DataProvider;

import com.homepage.basicFramework.constants.FileConstant;
import com.homepage.basicFramework.utils.ProvideData;

public class TestDataProvider {
	@DataProvider(name = "headerData")
	public Object[][] testData() {
		ProvideData provideData = new ProvideData(FileConstant.TESTDATA_FILE);
		Object[][] getData = provideData.testData(0);
		return getData;
	}
}
