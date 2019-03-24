package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	@Test
	public void userCanSearchForProducts()
	{
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchObject.productSearch(productName);
		searchObject.openProductDetails();
		assertTrue(productDetailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		System.out.println(productDetailsObject.productNameBreadCrumb.getText());
	}
}
