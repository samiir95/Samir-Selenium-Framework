package tests;

import static org.testng.Assert.assertTrue;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	MyAccountPage myAccountObject;
	String oldPass = "123456";
	String newPass = "12345678";
	String firstName = "Mohammed";
	String lastName = "Samir";
	String email = "samir.test91@gmail.com";

	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, oldPass);
		AssertJUnit.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	


	@Test(priority = 2, dependsOnMethods = { "userCanRegisterSuccessfully" })
	public void loggedinUserCanOpenMyAccountPage() {
		homeObject.openMyAccountPage();
	}
	
	@Test (priority = 3, dependsOnMethods = { "loggedinUserCanOpenMyAccountPage" })
	public void loggedinUserCanChangePassword() 
	{
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.openChangePassScreen();
		myAccountObject.changePassword(oldPass, newPass);
		assertTrue(myAccountObject.sucessResult.getText().contains("Password was changed"));
	}
	
	@Test(priority = 4, dependsOnMethods = { "loggedinUserCanChangePassword" })
	public void registeredUserCanLogOut() {
		registerObject.userLogOut();
	}

	@Test(priority = 5 , dependsOnMethods = { "registeredUserCanLogOut" })
	public void registeredUserCanOpenLoginPage() {
		homeObject.openLoginPage();
	}

	

	@Test(priority = 6, dependsOnMethods = { "registeredUserCanOpenLoginPage" })
	public void registeredUserCanLogin() throws InterruptedException {
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, newPass); 
		assertTrue(registerObject.logOutBtn.getText().contains("Log out"));
	}

}
