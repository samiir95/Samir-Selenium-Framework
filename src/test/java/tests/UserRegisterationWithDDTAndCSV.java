package tests;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndCSV extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	CSVReader reader;
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() throws InterruptedException, IOException {
		// Get path of CSV
		String CSV_file = System.getProperty("user.dir")+ "\\src\\test\\java\\data\\UserData.csv";
		reader = new CSVReader(new FileReader(CSV_file));
		String [] csvCell;
		// While loop will be executed till the last value in CSV file.
		while((csvCell = reader.readNext())!= null)
		{
			String firstName = csvCell[0];
			String lasttName = csvCell[1];
			String email     = csvCell[2];
			String password  = csvCell[3];
			
			homeObject = new HomePage(driver);
			homeObject.openRegisterationPage();
			registerObject = new UserRegisterationPage(driver);
			registerObject.userRegisteration(firstName, lasttName, email, password);
			AssertJUnit.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
			registerObject.userLogOut();
			homeObject.openLoginPage();
			loginObject = new LoginPage(driver);
			loginObject.userLogin(email, password); 
			assertTrue(registerObject.logOutBtn.getText().contains("Log out"));
			registerObject.userLogOut();
		

		}
		
	}
}
