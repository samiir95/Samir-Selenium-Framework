package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase{

	
	String productName = "Nike Tailwind Loose Short-Sleeve Running Shirt";
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	WishListPage wishListObject;

	@Test(priority = 1)
	public void userCanSearchWithAutoSug() throws InterruptedException {
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchObject.productSearchUsingAutoSuggest("Nike Tailwind");
		assertTrue(productDetailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
	    //System.out.println(productDetailsObject.productNameBreadCrumb.getText());

	}
	
	@Test(priority = 2)
	public void userCanAddProductToWishList() {
		productDetailsObject.addProductToWishList();
		assertTrue(productDetailsObject.WishListLink.getText().contains("wishlist"));
		productDetailsObject.openWishListPage();
		wishListObject = new WishListPage(driver);
		assertTrue(wishListObject.productCell.getText().contains(productName));
		assertTrue(wishListObject.productHeader.getText().contains("Wishlist"));

	}
	
	@Test(priority = 3)
	public void userCanRemoveProductFromWishList() {
		wishListObject.removeProductFromCart();
		assertTrue(wishListObject.emptyWishListLabel.getText().contains("empty"));
		
	}
	
}
