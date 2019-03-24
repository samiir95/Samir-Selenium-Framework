package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.CompareProductPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareList extends TestBase{

	String firstProductName = "Apple MacBook Pro 13-inch";
	String secondProductName = "Asus N551JK-XO076H Laptop";

	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	CompareProductPage compareProductObject;

	@Test(priority = 1)
	public void userCanCompareProducts() throws InterruptedException {
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		compareProductObject = new CompareProductPage(driver);

		searchObject.productSearchUsingAutoSuggest("MacB");
		assertTrue(productDetailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(firstProductName));
		//System.out.println(productDetailsObject.productNameBreadCrumb.getText());
		productDetailsObject.addToCompareListPage();
		
		searchObject.productSearchUsingAutoSuggest("Asus");
		assertTrue(productDetailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(secondProductName));
		productDetailsObject.addToCompareListPage();

		Thread.sleep(2000);
		driver.navigate().to("http://demo.nopcommerce.com" + "/compareproducts");
		assertTrue(compareProductObject.firstProduct.getText().contains(secondProductName));
		assertTrue(compareProductObject.secondProduct.getText().contains(firstProductName));
		compareProductObject.compareProducts();

	}
	
	@Test(priority = 2)
	public void userCanClearCompareList()  {
		
		compareProductObject.clearCompareList();
		assertTrue(compareProductObject.noDataLbl.getText().contains("You have no items to compare."));
	}
}
