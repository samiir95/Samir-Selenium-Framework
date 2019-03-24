package step_definition;

import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerObject;
	
	@Given("^The user in the home page$")
	public void the_user_in_the_home_page() throws Throwable {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		
	}

	@When("^He click on the register link$")
	public void he_click_on_the_register_link() {
	   assertTrue(driver.getCurrentUrl().contains("register"));
	}

//	@When("^He entered the required data$")
//	public void he_entered_the_required_data() {
//		registerObject = new UserRegisterationPage(driver);
//		registerObject.userRegisteration("mohamed", "samir", "test500@gmail.com", "123456");
//	}
	
	@When("^He entered \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void he_entered(String firstname, String lastname, String email, String password) {
		registerObject = new UserRegisterationPage(driver);
    	registerObject.userRegisteration(firstname, lastname, email, password);
	}

	@Then("^The registeration page will be displayed successfully$")
	public void the_registeration_page_will_be_displayed_successfully()  {
		registerObject.userLogOut();
	}

}
