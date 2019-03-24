package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "strong.current-item")
	public WebElement productNameBreadCrumb;
	
	@FindBy(css = "input.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	
	@FindBy(css = "span.price-value-4")
	public WebElement productSalary;
	
	@FindBy(linkText = "Add your review")
	WebElement addYourReviewLink;
	
	@FindBy(id = "add-to-wishlist-button-27")
	WebElement addToWishListBtn;
	
	@FindBy(linkText = "wishlist")
	public WebElement WishListLink;
	
	@FindBy(css = "input.button-2.add-to-compare-list-button")
	public WebElement addToCompareListBtn;
	
	@FindBy(id = "add-to-cart-button-27")
	public WebElement addToCartBtn;
	
	public void openEmailFriendPage()
	{
		clickButton(emailFriendBtn);
	}
	
	public void openProductReviewPage()
	{
		clickButton(addYourReviewLink);
	}
	
	public void addProductToWishList()
	{
		clickButton(addToWishListBtn);
	}
	
	public void openWishListPage()
	{
		clickButton(WishListLink);
	}
	
	public void addToCompareListPage()
	{
		clickButton(addToCompareListBtn);
	}
	
	public void addToCart()
	{
		clickButton(addToCartBtn);
	}
}


