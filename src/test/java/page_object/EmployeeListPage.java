package page_object;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.DriverManager;

public class EmployeeListPage {
	private static final Logger LOGGER = LogManager.getLogger(EmployeeListPage.class);
	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 15);

	private static EmployeeListPage employeeListPage;

	private EmployeeListPage() {

	}

	public static EmployeeListPage getInstance() {
		if (employeeListPage == null) {
			employeeListPage = new EmployeeListPage();
		}
		return employeeListPage;
	}

	// -------------------------------------------------------------------------------------------

	@FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//input")
	private List<WebElement> textBox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;

	@FindBy(xpath = "//div[@role='row']")
	private List<WebElement> listOfRows;

	@FindBy(xpath = "//div[@role='option']")
	private List<WebElement> dropDownValues;

	@FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span")
	private WebElement searchResultCount;

	// ---------------------------------------------------------------------------------------------

	public void fillTextBox(int i, String value) {
		Base.highLightElement(searchResultCount);
		wait.until(ExpectedConditions.visibilityOf(searchResultCount));
		Base.highLightElement(textBox.get(i));
		textBox.get(i).sendKeys(value);
		LOGGER.info("Enter the Text box as " + value);
	}

	public void clickSearchButton() {
		/*
		 * try { Thread.sleep(1000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */

		Base.highLightElement(searchButton);
		searchButton.click();
		LOGGER.info("Clicked search button");
		
	}

	public int getRowCount() {
		Base.highLightElement(searchResultCount);
		//wait.until(ExpectedConditions.visibilityOf(searchResultCount));
		int size = listOfRows.size() - 1;
		return size;
	}

}
