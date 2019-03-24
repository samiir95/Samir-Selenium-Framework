package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "removefromcart")
	WebElement removeCheck;
	
	@FindBy(name = "updatecart")
	WebElement updateCartBtn;
	
	@FindBy(css = "input.qty-input")
	WebElement quantityTxt;
	
	@FindBy(css = "span.product-subtotal")
	public WebElement subTotanLbl;
	
	@FindBy(css = "div.no-data")
	public WebElement noDataLbl;
	
	@FindBy(id = "termsofservice")
	WebElement agreeTermsCheck;
	
	@FindBy(id = "checkout")
	WebElement checkOutBtn;
	
	public void updateProductQuantityInCart(String quantity)
	{
		
		//Clear Quantity TextBox
		clearTxt(quantityTxt);
		setTextinElementTxt(quantityTxt, quantity);
		clickButton(updateCartBtn);
	}
	
	public void removeShoppingCart()
	{
		
		clickButton(removeCheck);
		clickButton(updateCartBtn);
	}
	
	public void openCheckOutPage()
	{
		clickButton(agreeTermsCheck);
		clickButton(checkOutBtn);

	}

}
