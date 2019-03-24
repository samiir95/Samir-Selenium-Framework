package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase {

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FirstName")
	WebElement firstNameTxtBox;

	@FindBy(id = "LastName")
	WebElement lastNameTxtBox;

	@FindBy(id = "Email")
	WebElement emailTxtBox;

	@FindBy(id = "Password")
	WebElement passwordTxtBox;

	@FindBy(id = "ConfirmPassword")
	WebElement passwordConfirmationTxtBox;

	@FindBy(id = "register-button")
	WebElement registerBtn;
	
	@FindBy(css = "div.result")
    public WebElement successMessage; // So that user can use it in assertion
	
	@FindBy(linkText = "Log in")
    WebElement loginLink;
	
	@FindBy(linkText = "Log out")
    public WebElement logOutBtn;
	
	public void userRegisteration(String firstName, String lastName, String email, String password) {
		// firstNameTxtBox.sendKeys(firstName);
		setTextinElementTxt(firstNameTxtBox, firstName);
		setTextinElementTxt(lastNameTxtBox, lastName);
		setTextinElementTxt(emailTxtBox, email);
		setTextinElementTxt(passwordTxtBox, password);
		setTextinElementTxt(passwordConfirmationTxtBox, password);
		clickButton(registerBtn);
	}
	
	public void userLogOut()
	{
		
		clickButton(logOutBtn);
	}
	
	public void openLoginPage() {
		clickButton(loginLink);
	}
}
