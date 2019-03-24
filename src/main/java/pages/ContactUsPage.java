package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FullName")
    WebElement yourNameTxt;
	
	@FindBy(id = "Email")
    WebElement yourEmailTxt;
	
	@FindBy(id = "Enquiry")
    WebElement enquiryTxt;
	
	@FindBy(name = "send-email")
    WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMessage;
	
	public void contactUs(String fullName, String email, String message)
	{
		setTextinElementTxt(yourNameTxt, fullName);
		setTextinElementTxt(yourEmailTxt, email);
		setTextinElementTxt(enquiryTxt, message);
		clickButton(submitBtn);
	}
}
