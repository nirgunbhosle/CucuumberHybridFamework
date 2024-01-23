package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class SearchResultPage {
	WebDriver driver;
	private ElementUtils elementUils;
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUils = new ElementUtils(driver);
	}
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validProduct;
	
	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement messageText;
	
	public boolean displayStatusOfValidProduct()
	{
		return elementUils.displayStatusOfElement(validProduct, 30);
		//return validProduct.isDisplayed();
	}
	
	public String getMessageText()
	{
		return elementUils.getTextFromElement(messageText, 30);
		//return messageText.getText();
	}

}
