package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

	HomePage homeObject;
	ContactUsPage contactUsObject;
	String fullName = "Mohammed Samir";
	String email = "msamir12@test.eu";
	String message = "welcome!";
	@Test
	public void userCancontactUs()
	{
		homeObject = new HomePage(driver);
		homeObject.openContactUsPage();
		contactUsObject = new ContactUsPage(driver);
		contactUsObject.contactUs(fullName, email, message);
		assertEquals(contactUsObject.successMessage.getText(), "Your enquiry has been successfully sent to the store owner.");
		System.out.println(contactUsObject.successMessage.getText());
		
	}
}
