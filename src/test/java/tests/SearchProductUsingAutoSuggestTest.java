package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggestTest extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;

	@Test
	public void userCanSearchWithAutoSug() throws InterruptedException {
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchObject.productSearchUsingAutoSuggest("MacB");
		assertTrue(productDetailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		System.out.println(productDetailsObject.productNameBreadCrumb.getText());

	}
}
