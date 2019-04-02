package tests;

import static org.testng.Assert.assertTrue;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationParallelTesting extends TestBase2{

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	Faker fakeData = new Faker();

	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();

	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() throws InterruptedException {
		homeObject = new HomePage(getDriver());
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(getDriver());
		registerObject.userRegisteration(firstName, lastName, email, password);
		System.out.println("User Data : " + firstName + " " + lastName + " " + email + " " + password);
		AssertJUnit.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(priority = 2, dependsOnMethods = { "userCanRegisterSuccessfully" })
	public void registeredUserCanLogOut() {
		registerObject.userLogOut();
	}

	@Test(priority = 3, dependsOnMethods = { "registeredUserCanLogOut" })
	public void registeredUserCanOpenLoginPage() {
		homeObject.openLoginPage();
	}

	@Test(priority = 4, dependsOnMethods = { "registeredUserCanOpenLoginPage" }, enabled = false)
	public void registeredUserCanLogin() throws InterruptedException {
		loginObject = new LoginPage(getDriver());
		loginObject.userLogin(email, password);
		assertTrue(registerObject.logOutBtn.getText().contains("Log out"));
	}

}
