package com.homepage.basicFramework.constants;

import java.io.File;

public class FileConstant {
	public static final String USER_HOME= System.getProperty("user.dir")+File.separator;
	public static final String RESOURCES_HOME=USER_HOME+"src"+File.separator+"resources"+File.separator;
	public static final String LOCATOR_HOME=RESOURCES_HOME+"locators"+File.separator;
	public static final String LIB_HOME=USER_HOME+"lib"+File.separator;
	
	//Web driver path
	public static final String CHROME_PATH=LIB_HOME+"chromedriver.exe";
	public static final String FIREFOX_PATH=LIB_HOME+"geckodriver.exe";
	public static final String INTERNETEXPLORER_PATH=LIB_HOME+"IEDriverServer.exe";
	
	public static final String lOCATORS_FILE= LOCATOR_HOME+"headers.comLocators.properties";
	public static final String TESTDATA_FILE= RESOURCES_HOME+"testdata"+File.separator+"HomePageHeaders.xlsx";
	
	//wait
	public static final int EXPLICIT_WAIT=10;
	public static final int FLUENT_WAIT=10;
	public static final int PAGE_LOAD_TIME=10;
	public static final int FLUENT_POLL=1;
}
