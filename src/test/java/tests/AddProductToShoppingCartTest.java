package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase{

	String productName = "Nike Tailwind Loose Short-Sleeve Running Shirt";
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	ShoppingCartPage shoppingCartObject;
	String quantity = "2";

	@Test(priority = 1)
	public void userCanSearchWithAutoSug() throws InterruptedException {
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchObject.productSearchUsingAutoSuggest("Nike tailwind");
		assertTrue(productDetailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		//System.out.println(productDetailsObject.productNameBreadCrumb.getText());

	}
	
	@Test(priority = 2)
	public void userCanAddProductToShoppingCart() throws InterruptedException  {
		productDetailsObject.addToCart();
		Thread.sleep(2000);
		driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
		Thread.sleep(2000);
		shoppingCartObject = new ShoppingCartPage(driver);
		assertTrue(shoppingCartObject.subTotanLbl.getText().contains("15.00"));

	}
	
	@Test(priority = 3)
	public void userCanUpdateShoppingCart() throws InterruptedException {
		shoppingCartObject.updateProductQuantityInCart(quantity);
		Thread.sleep(2000);
		assertTrue(shoppingCartObject.subTotanLbl.getText().contains("30.00"));

	}
	
	@Test(priority = 4)
	public void userCanRemoveFromShoppingCart() throws InterruptedException{
		shoppingCartObject.removeShoppingCart();
		Thread.sleep(2000);
		assertTrue(shoppingCartObject.noDataLbl.getText().contains("Your Shopping Cart is empty!"));

	}
}
