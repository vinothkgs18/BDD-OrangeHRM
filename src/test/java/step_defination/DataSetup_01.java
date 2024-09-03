package step_defination;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object.AddEmployeePage;
import page_object.Base;
import page_object.DashboardPage;
import page_object.EmployeeListPage;
import page_object.Employee_ViewPage;
import page_object.LoginPage;
import page_object.PIM_Page;
import page_object.SideMenu;
import util.DriverManager;

public class DataSetup_01 {

	LoginPage loginPage = LoginPage.getInstance();
	DashboardPage dashboardPage = DashboardPage.getInstance();
	SideMenu sideMenu = SideMenu.getInstance();
	PIM_Page pim_Page = PIM_Page.getInstance();
	AddEmployeePage addEmployeePage = AddEmployeePage.getInstance();
	Employee_ViewPage employee_ViewPage=Employee_ViewPage.getInstance();
	EmployeeListPage employeeListPage=EmployeeListPage.getInstance();
	
	
	
	
	
	
	
	
	
	
	

	@Given("User can login the application as admin user")
	public void userCanLoginTheApplicationAsAdminUser() {
		loginPage.dologin("Admin", "admin123");
	}

	@When("User can click the PIM menu link in Side menu")
	public void userCanClickThePIMMenuLinkInSideMenu() {
		sideMenu.clickSideMenuLink(1);
	}

	@When("User can click the Add Employee tab")
	public void userCanClickTheAddEmployeeTab() {
		pim_Page.clickTopMenu(3);

	}

	@When("User can fill the {string},{string} and {string}")
	public void userCanFillTheAnd(String string, String string2, String string3) {
		addEmployeePage.fillTextBox(1, string);
		addEmployeePage.fillTextBox(3, string2);
		addEmployeePage.fillTextBox(4, string3);
		addEmployeePage.clickSaveButton(0);
	}

	@Then("Veify record saved successfully")
	public void veifyRecordSavedSuccessfully() {
		String msg = addEmployeePage.getTextFromSuccessMessage();
		Assert.assertEquals(msg, "Successfully Saved");
	}

	@When("User can go to add employee tab and click add button then fill the FirstName,LastName and Employee_ID")
	public void userCanGoToAddEmployeeTabAndClickAddButtonThenFillTheFirstNameLastNameAndEmployeeID(
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> mp = dataTable.asMaps();
		for (int i = 0; i < mp.size(); i++) {

			pim_Page.clickAddEmployeetab();

			addEmployeePage.fillTextBox(1, mp.get(i).get("FirstName"));
			addEmployeePage.fillTextBox(3, mp.get(i).get("LastName"));
			addEmployeePage.fillTextBox(4, mp.get(i).get("EmpID"));
			addEmployeePage.clickSaveButton(0);

		}
		

	}

	@When("User can go to Add Employee tab and fill all required filed then click save button then fill remain all required field under personl job and Report-to section click save")
	public void userCanGoToAddEmployeeTabAndFillAllRequiredFiledThenClickSaveButtonThenFillRemainAllRequiredFieldUnderPersonlJobAndReportToSectionClickSave(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> asMaps = dataTable.asMaps();
		for (int i = 0; i <asMaps.size(); i++) {
			pim_Page.clickAddEmployeetab();
			addEmployeePage.fillTextBox(1, asMaps.get(i).get("FirstName"));
			addEmployeePage.fillTextBox(3, asMaps.get(i).get("LastName"));
			addEmployeePage.clickSaveButton(0);
			String textFromSuccessMessage = addEmployeePage.getTextFromSuccessMessage();
			//employee_ViewPage.fillTextBox(8, asMaps.get(i).get("SSN_Number"));
			//System.out.println(asMaps.get(i).get("SSN_Number"));
			//employee_ViewPage.fillSSN(asMaps.get(i).get("SSN_Number"));
			employee_ViewPage.fillTextBox(10, asMaps.get(i).get("DOB"));
			employee_ViewPage.clickSaveButton(0);
			Base.scrollToElement();
			employee_ViewPage.clickSubMenus(5);
			Thread.sleep(2000);
			employee_ViewPage.fillTextBox(0, asMaps.get(i).get("Joined_Date"));
			employee_ViewPage.selectDropDown(0, 2);
			employee_ViewPage.selectDropDown(1, 1);
			employee_ViewPage.selectDropDown(4, 3);
			employee_ViewPage.clickSaveButton(0);
			employee_ViewPage.clickSubMenus(8);
			employee_ViewPage.clickAddButtons(0);
			//employee_ViewPage.fillTextBox(0, asMaps.get(i).get("SupervisorName"));
			employee_ViewPage.searchTextInTextBoxAndSelectSuggestedValue(0, asMaps.get(i).get("SupervisorName"));
			employee_ViewPage.selectDropDown(0, 2);
			employee_ViewPage.clickSaveButton(0);
			
			
		}

	}
	
	@When("User click can click on Employee list Tab")
	public void userClickCanClickOnEmployeeListTab() {
	   pim_Page.clickTopMenu(1);
	}
	
	
	@When("User enter the emplyee name as {string} in employee name field and click search button")
	public void userEnterTheEmplyeeNameAsInEmployeeNameFieldAndClickSearchButton(String string) {
	    employeeListPage.fillTextBox(0, string);
	    employeeListPage.clickSearchButton();
	}
	
	
	@Then("Verify user get {string} record in result based on search key")
	public void verifyUserGetRecordInResultBasedOnSearchKey(String string) {
		int rowCount = employeeListPage.getRowCount();
		System.out.println("<<<< "+rowCount+" >>>>");
		Assert.assertEquals(rowCount, Integer.parseInt(string));
	}

}
