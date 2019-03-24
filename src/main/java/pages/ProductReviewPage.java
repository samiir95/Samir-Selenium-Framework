package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxt;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTxt;
	
	@FindBy(id = "addproductrating_4")
	WebElement ratingReview;
	
	@FindBy(css = "input.button-1.write-product-review-button")
	WebElement submitReviewBtn;
	
	@FindBy(css = "div.result")
	public WebElement sucessMessage;
	
	public void addProductRevie(String reviewTitle, String review)
	{
		setTextinElementTxt(reviewTitleTxt, reviewTitle);
		setTextinElementTxt(reviewTxt, review);
		clickButton(ratingReview);
		clickButton(submitReviewBtn);
	}
}
