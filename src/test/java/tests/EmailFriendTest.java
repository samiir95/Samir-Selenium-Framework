package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	EmailFriendPage emailFriendObject;

	String friendEmail = "Omar_test@gmail.com";
	String message = "Hey!";

	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Mohammed", "Samir", "samir.test92@gmail.com", "123456");
		AssertJUnit.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(priority = 2, dependsOnMethods = { "userCanRegisterSuccessfully" })
	public void userCanSearchWithAutoSug() throws InterruptedException {
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchObject.productSearchUsingAutoSuggest("MacB");
		assertTrue(productDetailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		// System.out.println(productDetailsObject.productNameBreadCrumb.getText());

	}

	@Test(priority = 3, dependsOnMethods = { "userCanSearchWithAutoSug" })
	public void userCanEmailFriend() {
		emailFriendObject = new EmailFriendPage(driver);
		productDetailsObject.openEmailFriendPage();
		emailFriendObject.emailFriend(friendEmail, message);
		assertEquals(emailFriendObject.result.getText(), "Your message has been sent.");
	}

	@Test(priority = 4, dependsOnMethods = { "userCanEmailFriend" })
	public void registeredUserCanLogOut() {
		registerObject.userLogOut();
	}
}
