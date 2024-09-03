package page_object;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.DriverManager;

public class Personal_DetailsPage {

	private static final Logger LOGGER = LogManager.getLogger(AddEmployeePage.class);
	WebDriverWait wait= new WebDriverWait(DriverManager.getDriver(), 30);

	// --------------------------Singe TOn
	private static Personal_DetailsPage personal_DetailsPage;

	private Personal_DetailsPage() {

	}

	public static Personal_DetailsPage getInstance() {
		if (personal_DetailsPage == null) {
			personal_DetailsPage = new Personal_DetailsPage();
		}
		return personal_DetailsPage;
	}

	// ---------------------------------------------------------------------
	
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//input")
	private List<WebElement> textBox;
	
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	private List<WebElement> dropDown;
	
	@FindBy(xpath = "//div[@role='option']")
	private List<WebElement> dropDownValues;
	
	
	@FindBy(xpath="//button[text()=' Save ']")
	private List<WebElement> saveButton;
	
	@FindBy(xpath="//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input']")
	private List<WebElement>radioButtons;
	
	
	
	
	
	//---------------------------------------------------
	
	
	
	public void fillTextBox(int i, String value) {

		try {
		Base.highLightElement(textBox.get(i));
		textBox.get(i).sendKeys(value);
		LOGGER.info("Enter the Text box as " + value);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectDropDown(int dropDownNumberInThisPage, int dropDownValue) {
		try {
		WebElement webDriverWait = Base.webDriverWait(dropDown.get(dropDownNumberInThisPage));
		Base.highLightElement(dropDown.get(dropDownNumberInThisPage));
		dropDown.get(dropDownNumberInThisPage).click();
		LOGGER.info("Enter the Dropdown valie as " + dropDownValues.get(dropDownValue).getText());
		Base.highLightElement(dropDownValues.get(dropDownValue));
		dropDownValues.get(dropDownValue).click();
		}
		catch (Exception e) {
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
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitForPage(String url) {
		try {
		wait.until(ExpectedConditions.urlContains(url));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitForLoadingIconInvisible() {
		try {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='oxd-loading-spinner']")));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectRadioButtonsForGender(int i) {
		try {
		radioButtons.get(i).click();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	

}
