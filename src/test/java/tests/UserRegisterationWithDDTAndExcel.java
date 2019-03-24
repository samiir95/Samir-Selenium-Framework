package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndExcel extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name = "ExcelData")
	public Object[][] userRegisterData() throws IOException {
		// Get data from excel reader class
		ExcelReader er = new ExcelReader();
		return er.getExcelData();
	}

	@Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
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


}
