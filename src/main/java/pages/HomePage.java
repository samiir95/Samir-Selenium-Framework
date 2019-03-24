package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jsExecuter = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(linkText = "My account")
	public WebElement myAccountLink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(linkText = "Log in")
	WebElement loginLink;
	
	@FindBy(id = "customerCurrency")
	WebElement currencyDropDownList;
	
	@FindBy(linkText = "Computers")
	WebElement computersMenu;
	
	@FindBy(linkText = "Notebooks")
	WebElement noteBooksMenu;
	
	public void openRegisterationPage() {
		// registerLink.click();
		clickButton(registerLink);

	}
	
	public void openMyAccountPage()
	{
		clickButton(myAccountLink);
	}
	
	public void openContactUsPage()
	{
		scrollToBottom();
		clickButton(contactUsLink);
	}
	
	public void openLoginPage()
	{
		clickButton(loginLink);
	}
	
	public void changeCurrency()
	{
		select = new Select(currencyDropDownList);
		select.selectByIndex(1);
	}
	
	public void selectNoteBookMenu()
	{

		action.moveToElement(computersMenu)
		.moveToElement(noteBooksMenu).click().build().perform();
	}

}
