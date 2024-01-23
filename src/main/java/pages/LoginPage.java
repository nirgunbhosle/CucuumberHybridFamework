package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils= new ElementUtils(driver);
	}
	
	@FindBy(id = "input-email")
	private WebElement enterEmail;
	
	@FindBy(id="input-password")
	private WebElement enterPassword;
	
	@FindBy(xpath="//input[@value=\"Login\"]")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warnningMsg;
	
	
	
	
	public void emailField(String email)
	{
		elementUtils.typeTextIntoTheElement(enterEmail, email, 30);
		// enterEmail.sendKeys(email);
	}
	

	public void passwordField(String password)
	{
		//enterPassword.sendKeys(password);
		elementUtils.typeTextIntoTheElement(enterPassword, password, 30);

	}
	
	public AccountPage clickOnLoginBtn()
	{
		elementUtils.clickOnWebElement(loginBtn, 30);
		//loginBtn.click();
		return new AccountPage(driver);
	}
	
	public String getWarningMsg()
	{  
		return elementUtils.getTextFromElement(warnningMsg, 30);
		//return warnningMsg.getText();
	}
}
