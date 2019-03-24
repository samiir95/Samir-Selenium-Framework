package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {

	HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test
	public void userCanChangeCurrency() {

		try {
			homeObject = new HomePage(driver);
			homeObject.changeCurrency();
			searchObject = new SearchPage(driver);
			searchObject.productSearchUsingAutoSuggest("MacB");
			homeObject = new HomePage(driver);
			searchObject = new SearchPage(driver);
			productDetailsObject = new ProductDetailsPage(driver);
			assertTrue(productDetailsObject.productSalary.getText().contains("Ђ"));
			System.out.println(productDetailsObject.productSalary.getText());
		} catch (InterruptedException e) {
			System.out.println("An error has occured " + e.getMessage());
		}

	}
}
