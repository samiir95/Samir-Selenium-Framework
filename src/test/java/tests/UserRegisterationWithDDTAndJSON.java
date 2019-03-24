package tests;

import org.testng.annotations.Test;

import data.JsonDataReader;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndJSON extends TestBase {

	JsonDataReader jsonReader = new JsonDataReader();
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		jsonReader.jsonReader();
		
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(jsonReader.firstName, jsonReader.lastName, jsonReader.email, jsonReader.password);
		AssertJUnit.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogOut();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(jsonReader.email, jsonReader.password);
		assertTrue(registerObject.logOutBtn.getText().contains("Log out"));
		registerObject.userLogOut();

	}
}
