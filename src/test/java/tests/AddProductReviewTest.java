package tests;

import static org.testng.Assert.assertTrue;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class AddProductReviewTest extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	ProductReviewPage productReviewObject;
	

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	EmailFriendPage emailFriendObject;
	
	String reviewTitle = "Test1";
	String review = "Your product is good";

	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Mohammed", "Samir", "samir.test94@gmail.com", "123456");
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
	public void openProductReview()
	{
		productDetailsObject.openProductReviewPage();
	}
	
	@Test(priority = 4, dependsOnMethods = { "openProductReview" })
	public void userCanReviewProduct()
	{
		productReviewObject = new ProductReviewPage(driver);
		productReviewObject.addProductRevie(reviewTitle, review);
		assertTrue(productReviewObject.sucessMessage.getText().contains("Product review is successfully added."));
	}
	
	@Test(priority = 5, dependsOnMethods = { "userCanReviewProduct" })
	public void registeredUserCanLogOut() {
		registerObject.userLogOut();
	}
	
}
