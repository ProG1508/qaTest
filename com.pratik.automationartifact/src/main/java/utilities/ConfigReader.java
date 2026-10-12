package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop1 = new Properties();
	
	String filePath = "F:\\Selenium Projects\\Project2\\com.pratik.automationartifact\\src\\test\\resources";
	
	public ConfigReader () 
	{
		try {
			FileInputStream fis = new FileInputStream( filePath + "\\config.properties");
			try {
				prop1.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getBrowser()
	{
		return prop1.getProperty("browser");
	}
	
	public String getURL() {
        return prop1.getProperty("url");
    }

    public String getUsername() {
        return prop1.getProperty("username");
    }

    public String getPassword() {
        return prop1.getProperty("password");
    }

    public int getTimeout() {
        return Integer.parseInt(prop1.getProperty("timeout"));
        
    }

}
