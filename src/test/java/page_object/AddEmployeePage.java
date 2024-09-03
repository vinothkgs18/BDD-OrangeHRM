package page_object;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage {
	
	private static final Logger LOGGER=LogManager.getLogger(AddEmployeePage.class);
	private static AddEmployeePage addEmployeePage;

	
	// Single Ton pattern
	private AddEmployeePage() {
	}

	public static AddEmployeePage getInstance() {
		if (addEmployeePage == null) {
			addEmployeePage = new AddEmployeePage();
		}
		return addEmployeePage;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------
	
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//input")
	private List<WebElement> textBox;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private List<WebElement> saveButton;
	
	@FindBy(xpath="//p[text()='Successfully Saved']")
	private WebElement successTostMessage;
	
	@FindBy(xpath="(//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title'])[1]")
	private WebElement personDetailLabel;
	
	@FindBy(xpath="//div[@class='oxd-loading-spinner-container']")
	private WebElement loadingIcon;
	//---------------------------------------------------------------------------------------------------------------------------
	
	
	public void fillTextBox(int i, String value) {
		try {
		//Base.webDriverWait(textBox.get(i));
		Base.highLightElement(textBox.get(i));
		textBox.get(i).sendKeys(value);
		LOGGER.info("Enter the Text box as "+value);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickSaveButton(int number) {
	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		Base.highLightElement(saveButton.get(number));
		saveButton.get(number).click();
		LOGGER.info("Clicked the save button");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getTextFromSuccessMessage() {
		Base.webDriverWait(successTostMessage);
		Base.highLightElement(successTostMessage);
		String text = successTostMessage.getText();
		LOGGER.info("Record saved successfully, tost message displayed and message as "+text);
		return text;
	}
	
	

}
