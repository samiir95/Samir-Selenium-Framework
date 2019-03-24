package pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "small-searchterms")
	WebElement searchTextBox;
	
	@FindBy(css = "input.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id = "ui-id-1")
	List <WebElement> productList;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement productLink;
	
	public void openProductDetails()
	{
		clickButton(productLink);
	}

	
	public void productSearch(String productName)
	{
		setTextinElementTxt(searchTextBox, productName);
		clickButton(searchBtn);
	}
	
	public void productSearchUsingAutoSuggest(String searchTxt) throws InterruptedException
	{
		setTextinElementTxt(searchTextBox, searchTxt);
		Thread.sleep(3000);
		productList.get(0).click();

	}
	

}
