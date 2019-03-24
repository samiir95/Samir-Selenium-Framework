package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "Email")
	WebElement emailTxt;
	
	@FindBy(id = "Password")
	WebElement passwordTxt;
	
	@FindBy(css = "input.button-1.login-button")
	WebElement loginBtn;
	
	
	
	public void userLogin(String email, String password) throws InterruptedException
	{
		setTextinElementTxt(emailTxt, email);
		setTextinElementTxt(passwordTxt, password);
		Thread.sleep(2000);
		clickButton(loginBtn);
	}
	
	
	
	
}
