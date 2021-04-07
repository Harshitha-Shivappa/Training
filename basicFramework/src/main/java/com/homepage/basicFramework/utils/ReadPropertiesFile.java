package com.homepage.basicFramework.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
	static Properties property;
	static File file;
	static FileReader reader;

	public static Properties loadProperty(String pathName) throws IOException {
		property = new Properties();
		file = new File(pathName);
		reader = new FileReader(file);
		property.load(reader);

		return property;
	}
}