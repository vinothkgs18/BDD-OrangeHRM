package page_object;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.DriverManager;

public class Employee_ViewPage extends Base {

	private static final Logger LOGGER = LogManager.getLogger(Employee_ViewPage.class);
	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 15);
	private static Employee_ViewPage employee_ViewPage;

	private Employee_ViewPage() {
	}

	public static Employee_ViewPage getInstance() {
		if (employee_ViewPage == null) {
			employee_ViewPage = new Employee_ViewPage();
		}
		return employee_ViewPage;
	}

	// -------------------------------------------------------------------------------------------

	@FindBy(xpath = "//label[text()='SSN Number']//parent::div//following-sibling::div//input")
	private WebElement ssnNumber;

	@FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//input")
	private List<WebElement> textBox;

	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	private List<WebElement> dropDown;

	@FindBy(xpath = "//div[@role='option']")
	private List<WebElement> dropDownValues;

	@FindBy(xpath = "//a[contains(@class,'orangehrm-tabs')]")
	private List<WebElement> subMenus;

	@FindBy(xpath = "//button[text()=' Save ']")
	private List<WebElement> saveButton;

	@FindBy(xpath = "//button[text()=' Add ']")
	private List<WebElement> addButtons;
	
	@FindBy(xpath="//h6[text()='Personal Details']")
	private WebElement personalDetailsLabel;
	
	@FindBy(xpath="//label[text()='SSN Number']//parent::div//following-sibling::div//input")
	private WebElement ssnField;
	
	@FindBy(xpath="//form//div[@class='oxd-loading-spinner']")
	private WebElement loadingIcon;
	
	@FindBy(xpath="//label[text()='SSN Number']")
	private WebElement testWait;

	// -----------------------------------------------------------------------------------------------
	public void fillTextBox(int i, String value) {
		Base.webDriverWait(textBox.get(i));
		textBox.get(i).sendKeys(value);
		LOGGER.info("Enter the Text box as " + value);
	}
	
	public void fillSSN(String value) {
		//wait.until(ExpectedConditions.textToBePresentInElement(testWait, "SSN Number"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ssnField.sendKeys(value);
		LOGGER.info("Enter the Text box as " + value);
	}

	public void selectDropDown(int dropDownNumberInThisPage, int dropDownValue) {
		dropDown.get(dropDownNumberInThisPage).click();
		LOGGER.info("Enter the Dropdown valie as " + dropDownValues.get(dropDownValue).getText());
		dropDownValues.get(dropDownValue).click();

	}

	public void clickSubMenus(int subMenuNumber) {
		
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(subMenus.get(subMenuNumber)));
		until.click();
		LOGGER.info("Clicked the Sub menus " + subMenus.get(subMenuNumber).getText());
	}

	public void clickSaveButton(int number) {
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(saveButton.get(number)));
		until.click();

		//saveButton.get(number).click();
		LOGGER.info("Clicked the save button");
	}

	public void clickAddButtons(int i) {
		addButtons.get(i).click();
		LOGGER.info("Clicked the Add button");
	}

	public void searchTextInTextBoxAndSelectSuggestedValue(int i, String value) {
		Base.webDriverWait(textBox.get(i));
		textBox.get(i).sendKeys(value);
		LOGGER.info("Enter the Text box as " + value);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		};
	
		dropDownValues.get(0).click();
		
		/*
		 * WebDriverWait wait= new WebDriverWait(DriverManager.getDriver(),10); //
		 * WebElement until =
		 * wait.until(ExpectedConditions.visibilityOf(dropDownValues.get(1)));
		 * wait.until(ExpectedConditions.elementToBeClickable(dropDownValues.get(1)));
		 * //until.click();
		 */
	}

}
