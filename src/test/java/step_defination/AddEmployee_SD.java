package step_defination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page_object.AddEmployeePage;
import page_object.PIM_Page;
import page_object.Personal_DetailsPage;
import page_object.Reporting_To;
import page_object.SideMenu;

public class AddEmployee_SD {
	SideMenu sideMenu = SideMenu.getInstance();
	PIM_Page pim_Page = PIM_Page.getInstance();
	Personal_DetailsPage personal_DetailsPage = Personal_DetailsPage.getInstance();
	AddEmployeePage addEmployeePage = AddEmployeePage.getInstance();
	Reporting_To reportingTo=Reporting_To.getInstance();
	

	@Given("User can click the PIM button in Side menu bar, after clicking user able to see the following options Configuration Employee List Add Employee Reports as top menu")
	public void userCanClickThePIMButtonInSideMenuBarAfterClickingUserAbleToSeeTheFollowingOptionsConfigurationEmployeeListAddEmployeeReportsAsTopMenu() {
		sideMenu.clickSideMenuLink(1);
	}

	@When("User click on Add Employee button on the top menu and user able to see all required field")
	public void userClickOnAddEmployeeButtonOnTheTopMenuAndUserAbleToSeeAllRequiredField() throws InterruptedException {
		
		Thread.sleep(3000);
		pim_Page.clickTopMenu(2);

	}

	@When("User fill First name as {string} last name as {string} and click save button")
	public void userFillFirstNameAsLastNameAsAndClickSaveButton(String string, String string2) {

		addEmployeePage.fillTextBox(1, string);
		addEmployeePage.fillTextBox(3, string2);
		addEmployeePage.clickSaveButton(0);
	}

	@When("User fill person details Driver License Number as {string} Nationality as {string} Marital Status as {string} Date of Birth as {string} Gender as {string} and click save button")
	public void userFillPersonDetailsDriverLicenseNumberAsNationalityAsMaritalStatusAsDateOfBirthAsGenderAsAndClickSaveButton(
			String string, String string2, String string3, String string4, String string5) throws InterruptedException {

		personal_DetailsPage.waitForPage(
				"https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/");
		personal_DetailsPage.waitForLoadingIconInvisible();
		personal_DetailsPage.fillTextBox(5, string);
		personal_DetailsPage.fillTextBox(6, string4);
		personal_DetailsPage.fillTextBox(9, string4);
		personal_DetailsPage.selectDropDown(0, 100);
		personal_DetailsPage.selectDropDown(1, 2);
		Thread.sleep(2000);
		personal_DetailsPage.selectRadioButtonsForGender(1);
	
		personal_DetailsPage.clickSaveButton(0);

	}
	
	@When("User fille supervisor name as {string} and reporting to as Dirct {string} and click save")
	public void userFilleSupervisorNameAsAndReportingToAsDirctAndClickSave(String string, String string2) {
	   reportingTo.selectCatagery(6);
		reportingTo.clickAddButton(0);
	   reportingTo.fillAutoSuggestion(string);
	   reportingTo.selectDropDown(0, 1);
	   reportingTo.clickSaveButton(0);
	}
	
	


}
