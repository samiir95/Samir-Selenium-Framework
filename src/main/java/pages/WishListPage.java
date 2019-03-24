package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a.product-name")
	public WebElement productCell;
	
	@FindBy(css = "h1")
	public WebElement productHeader;
	
	@FindBy(name = "updatecart")
	WebElement updateWishListBtn;
	
	@FindBy(name = "removefromcart")
	WebElement removeFromCartCheck;
	
	@FindBy(css = "div.no-data")
	public WebElement emptyWishListLabel;
	
	public void removeProductFromCart()
	{
		clickButton(removeFromCartCheck);
		clickButton(updateWishListBtn);
	}
	

}
