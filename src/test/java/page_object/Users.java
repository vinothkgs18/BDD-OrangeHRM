package page_object;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.DriverManager;

public class Users {
	
	public static Users users;
	private Users() {
		
	}
	
	public static Users getInstance() {
		if(users==null) {
			users=new Users();
		}
		return users;
	}
	
	@FindBy(xpath="//label[text()='Username']//parent::div//following-sibling::div//child::input")
	private WebElement userNameTextBox;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath="//div[@class='oxd-table-card']//div[@role='row']")
	private List<WebElement> result;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span[@class='oxd-text oxd-text--span']")
	private WebElement resultText;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	private List<WebElement> dropDown;
	
	@FindBy(xpath="//div[@role='option']//span")
	private List<WebElement>dropDownOptions;
	
	@FindBy(xpath="//div[@class='oxd-autocomplete-option']//span")
	private List<WebElement>autoCompleteSuggestions;
	
	@FindBy(xpath="//button[text()=' Add ']")
	private WebElement addButton;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private List<WebElement> checkBox;
	
	@FindBy(xpath="//button[text()=' Delete Selected ']")
	private WebElement topDeleteButton;
	
	
	@FindBy(xpath="//button[text()=' Yes, Delete ']")
	private WebElement deleteOnPopup;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	private WebElement SuccessfullySavedTostMessage;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement textBoxAutoComplete;
	
	@FindBy(xpath="(//div[@role='row'])[2]//div[@role='cell']")
	private List<WebElement> textFromResult;
	
	@FindBy(xpath="//button[@type='reset']")
	private WebElement  reset;
	//------------------Method-------------------------------
	
	public void fillTextBox(String text) {
		userNameTextBox.sendKeys(text);
	}
	
	public void clickSearchButton() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchButton.click();
	}
	
	public int getRowCountForResult() {
		int size = result.size();
		return size;
	}
	
	public WebElement searchResultTextElement() {
		return resultText;
	}
	
	public void clickDropDownOptions(int i, int option) {
		dropDown.get(i).click();
		dropDownOptions.get(option).click();
	}
	
	public void clickAddButton() {
		try {
		addButton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteParticularRecord(int i) {
		//Base.scrollToElement();
		JavascriptExecutor js=(JavascriptExecutor)DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", checkBox.get(i));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		checkBox.get(i).click();
		topDeleteButton.click();
		deleteOnPopup.click();
		
	}
	
	public String verifySuccessTostMessage() {
		String text = SuccessfullySavedTostMessage.getText();
		return text;
	}
	
	public void fillAutoCompleteTextBox(String input, int options) {
		textBoxAutoComplete.sendKeys(input);
		autoCompleteSuggestions.get(options).click();
		
		//return autoCompleteSuggestions.get(options).getText();
	}
	
	public String getTextFromResult(int pos) {
		String text=textFromResult.get(pos).getText();
		return text;
	}
	
	public void clickResetButton() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reset.click();
	}

	
	
}

