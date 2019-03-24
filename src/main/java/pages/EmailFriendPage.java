package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FriendEmail")
	WebElement friendEmailTxt;
	
	@FindBy(id = "PersonalMessage")
	WebElement messageTxt;
	
	@FindBy(name = "send-email")
	WebElement sendEmailBtn;
	
	@FindBy(css = "div.result")
	public WebElement result;
	public void emailFriend(String friendEmail, String message)
	{
		setTextinElementTxt(friendEmailTxt, friendEmail);
		setTextinElementTxt(messageTxt, message);
		clickButton(sendEmailBtn);
	}
}
