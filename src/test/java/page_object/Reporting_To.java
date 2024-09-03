package page_object;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.DriverManager;

public class Reporting_To {
	private static final Logger LOGGER = LogManager.getLogger(Reporting_To.class);
	private static Reporting_To reportingTo;
	

	private Reporting_To() {

	}

	public static Reporting_To getInstance() {
		if (reportingTo == null) {
			reportingTo = new Reporting_To();
		}
		return reportingTo;
	}

	// --------------------------------------------------------------------------

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--text']")
	private List<WebElement> addButton;

	@FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//input")
	private List<WebElement> textBox;

	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	private List<WebElement> dropDown;

	@FindBy(xpath = "//div[@role='option']")
	private List<WebElement> dropDownValues;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private List<WebElement> saveButton;
	
	@FindBy(xpath="//a[@class='orangehrm-tabs-item']")
	private List<WebElement> catagery;
	
	@FindBy(xpath="//div[@role='option']")
	private List<WebElement>autoSugOptions;
	
	@FindBy(xpath="//div[text()='Searching....']")
	private WebElement textOfAutoSuggestionSearching;

	// -------------------------------------------------------------------------------

	public void clickAddButton(int i) {
		try {
		addButton.get(i).click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fillTextBox(int i, String value) {

		Base.highLightElement(textBox.get(i));
		textBox.get(i).sendKeys(value);
		LOGGER.info("Enter the Text box as " + value);
	}

	public void selectDropDown(int dropDownNumberInThisPage, int dropDownValue) {
		try {
		WebElement webDriverWait = Base.webDriverWait(dropDown.get(dropDownNumberInThisPage));
		Base.highLightElement(dropDown.get(dropDownNumberInThisPage));
		dropDown.get(dropDownNumberInThisPage).click();
		LOGGER.info("Enter the Dropdown valie as " + dropDownValues.get(dropDownValue).getText());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Base.highLightElement(dropDownValues.get(dropDownValue));
		dropDownValues.get(dropDownValue).click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	public void clickSaveButton(int number) {
		try {
		JavascriptExecutor js= (JavascriptExecutor)DriverManager.getDriver();
		js.executeScript("window.scrollBy(0,150)");
		Base.highLightElement(saveButton.get(number));
		saveButton.get(number).click();
		LOGGER.info("Clicked the save button");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectCatagery(int i) {
		try {
		Base.highLightElement(catagery.get(i));
		catagery.get(i).click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void fillAutoSuggestion(String text) {
		
		try {
		fillTextBox(0, text);
		Base.highLightElement(autoSugOptions.get(0));
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), 3);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Searching....']")));
		
		autoSugOptions.get(0).click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
