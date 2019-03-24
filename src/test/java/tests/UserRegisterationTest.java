package tests;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() throws InterruptedException {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Mohammed", "Samir", "samir.test98@gmail.com", "123456");
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
		loginObject = new LoginPage(driver);
		loginObject.userLogin("samir.test98@gmail.com", "123456");
		assertTrue(registerObject.logOutBtn.getText().contains("Log out"));
	}

}
