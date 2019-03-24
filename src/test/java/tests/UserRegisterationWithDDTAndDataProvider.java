package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;


import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndDataProvider extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name = "testData")
	public static Object[][] userData()
	{
		return new Object[][]
				{
			{"Mohammed", "Samir", "testh@gmail.com", "123456"}
			,
			{"Moataz", "Nabil", "testuserh@gmail.com", "123456789"}
				};
		
	}
	
	
	@Test(priority = 1, alwaysRun = true, dataProvider = "testData")
	public void userCanRegisterSuccessfully(String fName, String lName, String email, String password) throws InterruptedException {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(fName, lName, email, password);
		AssertJUnit.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogOut();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password); 
		assertTrue(registerObject.logOutBtn.getText().contains("Log out"));
		registerObject.userLogOut();
	}
	
	/*
	@Test(priority = 2, dependsOnMethods = { "userCanRegisterSuccessfully" })
	public void registeredUserCanLogOut() {
		registerObject.userLogOut();
	}

	@Test(priority = 3 , dependsOnMethods = { "registeredUserCanLogOut" })
	public void registeredUserCanOpenLoginPage() {
		homeObject.openLoginPage();
	}

	

	@Test(priority = 4, dependsOnMethods = { "registeredUserCanOpenLoginPage" }, enabled = false)
	public void registeredUserCanLogin() throws InterruptedException {
		loginObject = new LoginPage(driver);
		loginObject.userLogin("samir.test98@gmail.com", "123456"); 
		assertTrue(registerObject.logOutBtn.getText().contains("Log out"));
	}*/

}
