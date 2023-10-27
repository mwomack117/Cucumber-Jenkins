package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "src\\test\\resources\\config\\Configuration.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;		
		properties = new Properties();
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			try {
				properties.load(reader);
				reader.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration file not found at properties path: " + propertyFilePath);
		}
	}
	
	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null) return driverPath;
		else throw new RuntimeException("driver path not specified in the configuration.properties file");
	}
	
	public DriverType getBroswer() {
		String browser_maven = System.getProperty("browser");
		String browserName = properties.getProperty("browser");
		
		//check to see if browser is given through command line and if not use config browser property
		String browser = browser_maven != null ? browser_maven : browserName;
//		if (browser_maven != null) {
//			if(browser_maven.equalsIgnoreCase("chrome")) return DriverType.CHROME;
//			else if (browser_maven.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
//			else if (browser_maven.equalsIgnoreCase("edge")) return DriverType.EDGE;
//			else throw new RuntimeException("Browser Name Key value from command line is not valid : " + browser_maven);
//		}
		if(browser == null || browser.equalsIgnoreCase("chrome")) return DriverType.CHROME;
		else if (browser.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if (browser.equalsIgnoreCase("edge")) return DriverType.EDGE;
		else throw new RuntimeException("Invalid browser name used : " + browser);
//		if(browserName == null || browserName.equalsIgnoreCase("chrome")) return DriverType.CHROME;
//		else if (browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
//		else if (browserName.equalsIgnoreCase("edge")) return DriverType.EDGE;
//		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null) return url;
		else throw new RuntimeException("url not specified in the configuration.properties file");
	}
	
//	public long getImplicitlyWait() {
//		String implicitlyWait = properties.getProperty("implicitlyWait");
//		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
//		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		 
//	}

}
