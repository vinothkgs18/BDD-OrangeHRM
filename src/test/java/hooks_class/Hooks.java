package hooks_class;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.DriverManager;
import util.PageUtils;

public class Hooks {

	DriverManager driverInstance;
	WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(Hooks.class);

	@Before(order = 1)
	public void startUp() {
		try {
		driverInstance = new DriverManager();
		driver = driverInstance.initializeBrowserDriver("chrome");
		PageUtils pageUtils = new PageUtils();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		LOGGER.info(
				"navigate to Application OrgangeHRM https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		pageUtils.initPageFactory();
		LOGGER.info("Called initPageFactory method");
		driver.manage().window().maximize();
		LOGGER.info("Maximaized the window");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		LOGGER.info("implicitWait inworked : 3 second");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	@After(order = 1)
	public void tearDown() {
		try {
		driver.quit();
		LOGGER.info("Browser quited");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@After(order = 2)
	public void afterStep(Scenario scenario) {
		
			
	}
	
	@AfterStep
	public void takeScreenshot(Scenario scenario) {
		try {
		TakesScreenshot tk = (TakesScreenshot) driver;
		byte[] image = tk.getScreenshotAs(OutputType.BYTES);
		scenario.attach(image, "image/png", "screenshot for failed step");
		LOGGER.info("take screenshot for faild steps");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
