package tests;

import org.testng.annotations.Test;

import data.ReadProperities;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;


import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndProperitiesFile extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	String fName = ReadProperities.userData.getProperty("firstname");
	String lName = ReadProperities.userData.getProperty("lastname");
	String email = ReadProperities.userData.getProperty("email");
	String pass =  ReadProperities.userData.getProperty("password");




	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(fName, lName, email, pass);
		AssertJUnit.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority = 2, dependsOnMethods = { "userCanRegisterSuccessfully" })
	public void registeredUserCanLogOut() {
		registerObject.userLogOut();
	}

	@Test(priority = 3 , dependsOnMethods = { "registeredUserCanLogOut" })
	public void registeredUserCanOpenLoginPage() {
		homeObject.openLoginPage();
	}

	

	@Test(priority = 4, dependsOnMethods = { "registeredUserCanOpenLoginPage" })
	public void registeredUserCanLogin() throws InterruptedException {
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, pass); 
		assertTrue(registerObject.logOutBtn.getText().contains("Log out"));
	}

}
