package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static final Logger LOGGER=LogManager.getLogger(DriverManager.class);
	private static WebDriver driver;
	public static Logger getLogger() {
		return LOGGER;
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		DriverManager.driver = driver;
	}
	
	public static WebDriver initializeBrowserDriver(String browserName) {
		try {
		if (browserName.equalsIgnoreCase("chrome")) {
			LOGGER.info("Test Executed in Chrome Browser");
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions=new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			DriverManager.setDriver(new ChromeDriver(chromeOptions));
		} 
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			DriverManager.setDriver(new EdgeDriver());
			LOGGER.info("Test Executed in Edge Browser");
		} else {
			LOGGER.info("Invalid Browser selection");
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return getDriver();
	}
	
	
	
	

	
	
	
	
	
	
	
	/*
	 * *************************************************************************************************************************************************
	//public WebDriver driver;
	public static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();
	
	private static final Logger LOGGER=LogManager.getLogger(DriverManager.class);
	
	
	
	public static WebDriver getDriver() {
		return tDriver.get();
	}
	
	public  WebDriver initializeBrowserDriver(String browserName) {
		try {
		if (browserName.equalsIgnoreCase("chrome")) {
			LOGGER.info("Test Executed in Chrome Browser");
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions=new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			tDriver.set(new ChromeDriver(chromeOptions));
		} 
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			tDriver.set(new EdgeDriver());
			LOGGER.info("Test Executed in Edge Browser");
		} else {
			LOGGER.info("Invalid Browser selection");
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return getDriver();
	}
	*/

}
