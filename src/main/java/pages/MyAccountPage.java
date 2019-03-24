package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "li.change-password")
	WebElement changePasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement oldPassText;
	
	@FindBy(id = "NewPassword")
	WebElement newPassText;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement newPassConfirmText;
	
	@FindBy(css = "input.button-1.change-password-button")
	WebElement changePassBtn;
	
	@FindBy(css = "div.result")
	public WebElement sucessResult;
	
	public void openChangePassScreen()
	{
		clickButton(changePasswordLink);
	}
	
	public void changePassword(String oldPass, String newPass)
	{
		setTextinElementTxt(oldPassText, oldPass);
		setTextinElementTxt(newPassText, newPass);
		setTextinElementTxt(newPassConfirmText, newPass);
		clickButton(changePassBtn);


	}
}
