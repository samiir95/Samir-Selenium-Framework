package pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductPage extends PageBase{

	public CompareProductPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "a.clear-list")
	WebElement clearListBtn;
	
	@FindBy(css = "div.no-data")
	public WebElement noDataLbl;
	
	@FindBy(css = "table.compare-products-table")
	public List<WebElement> compareTable;
	
	@FindBy(tagName = "tr")
	public List<WebElement> allRows;
	
	@FindBy(tagName = "td")
	public List<WebElement> allCols;
	
	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement firstProduct;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement secondProduct;
	
	public void clearCompareList()
	{
		clickButton(clearListBtn);
	}
	
	public void compareProducts()
	{
		//Get All Rows
		System.out.println(allRows.size());
		//Get Data From Each Row
		for (WebElement row : compareTable) {
			//System.out.println(row.getText() + "\t");
			for (WebElement col : compareTable) {
				System.out.println(col.getText() );
			}
		}
	}
	
	
	
}
