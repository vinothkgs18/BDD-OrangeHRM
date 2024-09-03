package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import page_object.AddEmployeePage;
import page_object.AddUserPage;
import page_object.AdminPage;
import page_object.DashboardPage;
import page_object.EmployeeListPage;
import page_object.Employee_ViewPage;
import page_object.Header;
import page_object.LoginPage;
import page_object.PIM_Page;
import page_object.Personal_DetailsPage;
import page_object.Reporting_To;
import page_object.SideMenu;
import page_object.Users;

public class PageUtils {
	private static final Logger LOGGER=LogManager.getLogger(PageUtils.class);
	
	public  void initPageFactory() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), DashboardPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), PIM_Page.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), SideMenu.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), AddEmployeePage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), Employee_ViewPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), EmployeeListPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), AdminPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), Users.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), AddUserPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), Personal_DetailsPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), Reporting_To.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), Header.getInstance());
		LOGGER.info("Initialized the page factory for All class");
	}
	
	
	
	
	public static void highLightElement(WebElement webElement) {
		LOGGER.info("Object created for JavaScript executor interface");
		JavascriptExecutor  js=(JavascriptExecutor)DriverManager.getDriver();
		LOGGER.info(" Calling heighLighted method ");
		js.executeScript("arguments[0].setAttribute('style','border:4px solid red');", webElement);
		
	}
	
	

}
