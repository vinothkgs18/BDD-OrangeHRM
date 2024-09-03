package page_object;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
	
	private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

	/*
	 * 
	 * Single ton implemented
	 */

	private static DashboardPage dashboardPage;

	private DashboardPage() {
	}

	public static DashboardPage getInstance() {
		if (dashboardPage == null) {
			dashboardPage = new DashboardPage();
		}
		return dashboardPage;
	}
	
	@FindBy(tagName="h6")
	private WebElement dashboardText;
	
	//-------------------------------------------------------------------------
	
	public String getDashboardText() {
		String text = dashboardText.getText();
		return text;
	}
	

}
