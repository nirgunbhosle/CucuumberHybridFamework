package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 elementUtils= new ElementUtils(driver);
	}

	@FindBy(xpath = "//span[text()=\"My Account\"]")
	private WebElement myAccount;

	@FindBy(linkText = "Login")
	private WebElement loginBtn;

	@FindBy(linkText = "Register")
	private WebElement registerBtn;

	@FindBy(name = "search")
	private WebElement searchBoxField;

	@FindBy(xpath = "//button[contains(@class,'btn-default')]")
	private WebElement searchBtn;

	public void clickOnMyAccount() {
		//myAccount.click();
		elementUtils.clickOnWebElement(myAccount, 30);
	}

	public LoginPage clickOnLoginBtn() {
		//loginBtn.click();
		elementUtils.clickOnWebElement(loginBtn, 30);
		return new LoginPage(driver);
	}

	public RegisterPage clickOnRegisterBtn() {
		//registerBtn.click();
		
		elementUtils.clickOnWebElement(registerBtn, 30);
		return new RegisterPage(driver);
	}

	public void enterProductInSearchBox(String product) {
		//searchBoxField.sendKeys(product);
		elementUtils.typeTextIntoTheElement(searchBoxField, product, 30);

	}

	public SearchResultPage clickOnSearchBtn() {
		//searchBtn.click();
		
		elementUtils.clickOnWebElement(searchBtn, 30);
		return new SearchResultPage(driver);
	}
}
