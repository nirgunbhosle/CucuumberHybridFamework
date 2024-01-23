package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class AccountPage {

	private ElementUtils elementUtils; 
	WebDriver driver;
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(linkText = "Edit your account information")
	private WebElement EditYourAccountInformationOption;
	
	
	public boolean displayStatusOfEditYourAccountInformationDisplayed()
	{
		return elementUtils.displayStatusOfElement(EditYourAccountInformationOption, 30);
	}
}
