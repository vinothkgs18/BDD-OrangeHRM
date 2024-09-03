package page_object;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

	/*
	 * 
	 * Single ton implemented
	 */

	private static LoginPage loginPage;

	private LoginPage() {
	}

	public static LoginPage getInstance() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}
	

	// --------------------------------------------------------------------------------
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameTextBox;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordFieldTextBox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	private WebElement forgetPasswordlink;
	
	@FindBy(xpath = "//p[text()='Invalid credentials']")
	private WebElement errorMessageForInvalidCredential;
	
	@FindBy(xpath="//span[text()='Required']")
	private List<WebElement> warningMessageForCredentials;
	
	

	// ----------------------------------------------------------------------------------
	public void dologin(String userName, String password) {
		try {

		Base.highLightElement(userNameTextBox);
		userNameTextBox.sendKeys(userName);
		LOGGER.info("Enter the user name as " + userName);
		Base.highLightElement(passwordFieldTextBox);
		passwordFieldTextBox.sendKeys(password);
		LOGGER.info("Enter the password as " + password);
		Base.highLightElement(loginButton);
		loginButton.click();
		LOGGER.info("Clicked the login button");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void clickToForgetPassword() {
		forgetPasswordlink.click();
		LOGGER.info("Click the forget password link in the login page");
	}

	public void enterTheUserName(String userName) {
		userNameTextBox.sendKeys(userName);
		LOGGER.info("Enter the user name as " + userName);
	}

	public void enterThePassword(String password) {
		passwordFieldTextBox.sendKeys(password);
		LOGGER.info("Enter the password as " + password);
	}

	public void clickLoginButton() {
		loginButton.click();
		LOGGER.info("Clicked the login button");
	}
	
	public String getErrorMessageForInvalidCredential() {
		String text = errorMessageForInvalidCredential.getText();
		return text;
	}
	
	public String getWarningMessageForUserName() {
		String text = warningMessageForCredentials.get(0).getText();
		return text;
	}
	
	public String getWarningMessageForPassword() {
		String text = warningMessageForCredentials.get(1).getText();
		return text;
	}

}
