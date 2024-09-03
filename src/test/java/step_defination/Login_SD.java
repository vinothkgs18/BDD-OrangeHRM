package step_defination;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object.DashboardPage;
import page_object.Header;
import page_object.LoginPage;

public class Login_SD {

	LoginPage loginPage = LoginPage.getInstance();
	DashboardPage dashboardPage=DashboardPage.getInstance();
	Header header= Header.getInstance();
	private static final Logger LOGGER = LogManager.getLogger(Login_SD.class);

	@Given("user enter the username as {string} and password as {string}")
	public void userEnterTheUsernameAsAndPasswordAs(String string, String string2) {
		loginPage.enterTheUserName(string);
		loginPage.enterThePassword(string2);
	}

	@When("User click login button")
	public void userClickLoginButton() {
		loginPage.clickLoginButton();
	}

	@Then("verify the error message as {string}")
	public void verifyTheErrorMessageAs(String string) {
		
			String actual = loginPage.getErrorMessageForInvalidCredential();
			Assert.assertEquals(actual, string);
	
	}
	
	@Then("verify the page is redirect to dashboard page")
	public void verifyThePageIsRedirectToDashboardPage() {
		String actual = dashboardPage.getDashboardText();
		Assert.assertEquals(actual, "Dashboard");
	  
	}
	
	@Then("Verify error warning message in both user name and password field")
	public void verifyErrorWarningMessageInBothUserNameAndPasswordField() {
	   String actual = loginPage.getWarningMessageForUserName();
	   Assert.assertEquals(actual, "Required");
	   
	   String actual1 = loginPage.getWarningMessageForPassword();
	   Assert.assertEquals(actual1, "Required");
	}
	
	
	@Then("Verify the profile name that user should match with user full name as {string}")
	public void verifyTheProfileNameThatUserShouldMatchWithProfileNameAs (String string) {
	  boolean verify = header.verifyNameInProfile(string);
	  Assert.assertEquals(true, verify);
	}

}
