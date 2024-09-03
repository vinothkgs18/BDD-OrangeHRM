package step_defination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test {
	
	@Given("user is on login page")
	public void userIsOnLoginPage() {
	   System.out.println("Given block executed");
	}
	@When("User enter the {string} and {string} and click login")
	public void userEnterTheAndAndClickLogin(String string, String string2) {
	   System.out.println("First string"+ string);
	}
	@Then("user navigate to home page")
	public void userNavigateToHomePage() {
	   System.out.println("Then");
	}

}
