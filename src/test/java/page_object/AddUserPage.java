package page_object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.DriverManager;

public class AddUserPage {
	
	public static AddUserPage addUserPage;
	private AddUserPage() {
		
	}
	
	public static AddUserPage getInstance() {
		if (addUserPage== null){
			addUserPage=new AddUserPage();
		}
		return addUserPage;
	}
	
	@FindBy(xpath="//div[@class='oxd-select-text-input']")
	private List<WebElement> clickDropDown;
	
	@FindBy(xpath="//div[@role='option']")
	private List<WebElement>dropDownOptions;
	
	@FindBy(xpath="//div//following-sibling::input")
	private List<WebElement> textBox;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	private WebElement SuccessfullySavedTostMessage;
	
	@FindBy(xpath="//div[text()='Searching....']")
	private WebElement textOfAutoSuggestionSearching;
	

	@FindBy(xpath="//label[text()='Username']")
	private WebElement label;
	
	
	
	
	//------------------------------------------------------------------------------------------------------------
	
	public void SelectDropDown(int dropDown,int value) {
		clickDropDown.get(dropDown).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dropDownOptions.get(value).click();
	}
	
	public void fillSingleSelectionTextBox(int textBoPosition,String value) {
		textBox.get(textBoPosition).sendKeys(value);
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), 3);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Searching....']")));
		//wait.until(ExpectedConditions.invisibilityOf(textOfAutoSuggestionSearching));
		dropDownOptions.get(0).click();
	}
	public void fillTextBox(int textBoPosition,String value) {
		textBox.get(textBoPosition).sendKeys(value);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public String verifySuccessTostMessage() {
		String text=null;
		try {
		 text = SuccessfullySavedTostMessage.getText();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return text;
	}

}
