package com.pratik.ypassist.com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	Properties prop;

	public Properties getProperties() throws Exception {

		prop = new Properties();

		FileInputStream FIS = new FileInputStream(
				"F:\\Selenium Projects\\Project2\\com.pratik.ypassist\\src\\main\\resources\\config.properties");

		prop.load(FIS);
		
		
		
		prop.getProperty("url");

		return prop;
	}
}
