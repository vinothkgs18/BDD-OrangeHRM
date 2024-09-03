package step_defination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object.AddUserPage;
import page_object.AdminPage;
import page_object.SideMenu;
import page_object.Users;
import util.DriverManager;

public class AdminFunc_SD {

	SideMenu sideMenu = SideMenu.getInstance();
	AdminPage adminPage = AdminPage.getInstance();
	Users users = Users.getInstance();
	AddUserPage addUserPage = AddUserPage.getInstance();
	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);

	@Given("User can click the Admin link on the side tab")
	public void userCanClickTheAdminLinkOnTheSideTab() {
		sideMenu.clickSideMenuLink(0);

	}

	@Given("User can click the User management on the top menu")
	public void userCanClickTheUserManagementOnTheTopMenu() {
		adminPage.clickTopMenu(0);

	}

	@Given("user can click the users option in the user management tab")
	public void userCanClickTheUsersOptionInTheUserManagementTab() {
		adminPage.clickSubMenu(0);
	}

	@When("User enter the user name as {string} and click the search button")
	public void userEnterTheUserNameAsAndClickTheSearchButton(String string) {

		users.fillTextBox(string);
		users.clickSearchButton();
	}

	@Then("Verify user should getting the result that match with our search keyword")
	public void verifyUserShouldGettingTheResultThatMatchWithOurSearchKeyword() throws InterruptedException {
		Thread.sleep(2000);
		// wait.until(ExpectedConditions.invisibilityOf(users.searchResultTextElement()));
		// wait.until(ExpectedConditions.visibilityOf(users.searchResultTextElement()));
		int actual = users.getRowCountForResult();
		Assert.assertEquals(actual, 1);
		System.out.println(users.getRowCountForResult()
				+ "  *********************************************************************");

	}

	@When("User select the admin from the User Role dropdown")
	public void userSelectTheAdminFromTheUserRoleDropdown() {
		users.clickDropDownOptions(0, 0);
		users.clickSearchButton();
	}

	@Then("Verify the search result")
	public void verifyTheSearchResult() throws InterruptedException {
		Thread.sleep(2000);
		int actual = users.getRowCountForResult();
		Assert.assertEquals(actual, 1);
		System.out.println(users.getRowCountForResult()
				+ "  *********************************************************************");
	}

	@When("user can click the add button")
	public void userCanClickTheAddButton() throws InterruptedException {
		users.clickAddButton();

	}

	@When("user can fill all required field {string} {string} {string} and click save button")
	public void userCanFillAllRequiredFieldAndClickSaveButton(String string, String string2, String string3)
			throws InterruptedException {
		addUserPage.SelectDropDown(0, 2);
		addUserPage.fillSingleSelectionTextBox(1, string);
		addUserPage.fillTextBox(2, string2);
		addUserPage.fillTextBox(3, "Spring*123");
		addUserPage.fillTextBox(4, "Spring*123");
		addUserPage.SelectDropDown(1, 1);
		addUserPage.clickSaveButton();
		//Thread.sleep(4000);

	}

	@Then("Verify user successfully saved message")
	public void verifyUserSuccessfullySavedMessage() {
		String text = addUserPage.verifySuccessTostMessage();
		System.out.println("@@@@@@@" + text);
	}

	@Given("User can select the any record and click the delete button on the top")
	public void userCanSelectTheAnyRecordAndClickTheDeleteButtonOnTheTop() {
		users.deleteParticularRecord(6);
	}

	@Then("verify success message for delete action")
	public void verifySuccessMessageForDeleteAction() {
		String text = users.verifySuccessTostMessage();
		System.out.println(text + "  ******************************************");
	}

	@When("User enter the name as {string} in the employee name field and select the first suggesstion")
	public void userEnterTheNameAsInTheEmployeeNameFieldAndSelectTheFirstSuggesstion(String string) {
		users.fillAutoCompleteTextBox(string, 0);

	}

	@When("Click the search button")
	public void clickTheSearchButton() {

		users.clickSearchButton();
	}

	@Then("Verify the employee name {string} that match with search critria")
	public void verifyTheEmployeeNameThatMatchWithSearchCritria(String string) {
		int rowCountForResult = users.getRowCountForResult();
		System.out.println("Result------------------->" + rowCountForResult);
		String result = users.getTextFromResult(3);
		System.out.println(result);
		Assert.assertEquals(string, result);
	}

	@When("User enter the name as {string} and select {string}")
	public void userEnterTheNameAsAndSelect(String string, String string2) {
		users.fillAutoCompleteTextBox(string, 0);
		users.clickDropDownOptions(1, 0);
	}

	@Then("Verify the employee Result row count")
	public void verifyTheEmployeeResultRowCount() {
		int rowCountForResult = users.getRowCountForResult();
		System.out.println(rowCountForResult);
	}

	@When("user fill all fields userName as {string} userRole as {string} employeeName as {string} and status as {string}")
	public void userFillAllFieldsUserNameAsUserRoleAsEmployeeNameAsAndStatusAs(String string, String string2,
			String string3, String string4) {

		users.clickDropDownOptions(0, 1);
		users.fillTextBox(string);
		users.fillAutoCompleteTextBox(string3, 0);
		users.clickDropDownOptions(1, 0);
	}

	@When("user click the reset button")
	public void userClickTheResetButton() {
		users.clickResetButton();
	}

}
