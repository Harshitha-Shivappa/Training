package com.atmecs.konakart.constants;

import java.io.File;

/**
 * The class assigns the path of all the files use in the project as constants and constants use in the project.
 */

public class FileConstant {
	public final static String USER_HOME= System.getProperty("user.dir")+File.separator;
	public final static String RESOURCES_HOME= USER_HOME+"src"+File.separator+"test"+File.separator+"resources"+File.separator;
	public final static String LOCATOR_HOME= RESOURCES_HOME+"locators"+File.separator;
	public final static String LIB_HOME =USER_HOME+"lib"+File.separator;
	
	public final static String CHROME_PATH= LIB_HOME+"chromedriver.exe";
	public final static String FIREFOX_PATH= LIB_HOME+"geckodriver.exe";
	public final static String INTERNETEXPLORER_PATH= LIB_HOME+"IEDriverServer.exe";
	
	public final static String lOCATORS_FILE= LOCATOR_HOME+"atmecs.comLocators.properties";
	public final static String TESTDATA_FILE= RESOURCES_HOME+"testdata"+File.separator+"konakart.xlsx";
	
	public final static int EXPLICIT_WAIT=30;
	public final static int FLUENT_WAIT=30;
	public final static int PAGE_LOAD_TIME=30;
	public final static int FLUENT_POLL=1;
}
