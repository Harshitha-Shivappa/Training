package com.atmecs.demoProject.constants;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridConnection {
	static public URL url;
	String nodeurl;
	
	public WebDriver getConnection(WebDriver driver, String browser) {
		nodeurl = "http://192.168.56.1:4444/wd/hub";
		
		DesiredCapabilities capability = new DesiredCapabilities();
		try {
			url = new URL(nodeurl);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}
		if(browser.equals("chrome")) {
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName(browser);
		}
		else if(browser.equals("firefox")) {
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName(browser);
		}
		else if(browser.equals("internet explorer")) {
			capability = DesiredCapabilities.internetExplorer();
			capability.setBrowserName(browser);
		}
		capability.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(url, capability);
		return driver;
		
	}
}
