package page_object;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.DriverManager;

public class Base {
	
	public static WebDriver driver=DriverManager.getDriver();
	
	public static WebDriverWait wait;
	private static final Logger LOGGER=LogManager.getLogger(Base.class);
	static JavascriptExecutor js=(JavascriptExecutor)DriverManager.getDriver();;
	
	public static WebElement webDriverWait(WebElement webElement) {
		wait= new WebDriverWait(DriverManager.getDriver(),10);
		WebElement until = wait.until(ExpectedConditions.visibilityOf(webElement));
		return until;
		
	}
	
	public static void scrollToElement() {
		
		js.executeScript("window.scrollBy(0,-1000)");
	}
	
	public static void scrollToElementByLocator() {
		js.executeScript("arguments[0]scrollIntoView", null);
	}
	
	public static void highLightElement(WebElement webElement) {
		try {
		LOGGER.info("Object created for JavaScript executor interface");
		LOGGER.info(" Calling heighLighted method ");
		js.executeScript("arguments[0].setAttribute('style','border:4px solid red');", webElement);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}


}
