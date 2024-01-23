package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class RegisterPage {
	WebDriver driver;
	private ElementUtils elementUils;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUils = new ElementUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstName;

	@FindBy(id = "input-lastname")
	private WebElement lastName;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-telephone")
	private WebElement telephone;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(id = "input-confirm")
	private WebElement conformPassword;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privecyPolicy;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueBtn;
	
	@FindBy(css="input[value='1'][name='newsletter']")
	private WebElement yesNewsLatterOption;
	
	@FindBy(xpath =" //div[contains(@class,\"alert-danger\")]")
	private WebElement dupicateEmailWarning;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement fistNameWarning;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	
	
	public void enterFirstName(String fname) {
		elementUils.typeTextIntoTheElement(firstName, fname, 30);
		//firstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		elementUils.typeTextIntoTheElement(lastName, lname, 30);
		//lastName.sendKeys(lname);
	}

	public void enterEmail(String emailId) {
		elementUils.typeTextIntoTheElement(email, emailId, 30);
		//email.sendKeys(emailId);
	}

	public void enterTelephone(String no) {
		elementUils.typeTextIntoTheElement(telephone, no, 30);
		//telephone.sendKeys(no);
	}

	public void enterPassword(String pass) {

		elementUils.typeTextIntoTheElement(password, pass, 30);
		password.sendKeys(pass);

	}

	public void enterConformPassword(String conformPass) {

		elementUils.typeTextIntoTheElement(conformPassword, conformPass, 30);
		//conformPassword.sendKeys(conformPass);

	}
	
	public void selectPrivecyPolicy()
	{
		elementUils.clickOnWebElement(privecyPolicy, 30);
		//privecyPolicy.click();
	}
	
	public AccountSucessPage clickOnContinueBtn()
	{
		elementUils.clickOnWebElement(continueBtn, 30);
		//continueBtn.click();
		return new AccountSucessPage(driver);
	}
	
	public void selectNewsLatterOption()
	{
		elementUils.clickOnWebElement(yesNewsLatterOption, 30);
		yesNewsLatterOption.click();
	}
	
	public String getDuplicateEmailWarningMsg()
	{
		return elementUils.getTextFromElement(dupicateEmailWarning, 30);
		//return dupicateEmailWarning.getText();
	}
	
	public String getFistNameWarning()
	{
		return elementUils.getTextFromElement(fistNameWarning, 30);
	}

	public String getLastNameWarning()
	{
		return elementUils.getTextFromElement(lastNameWarning, 30);
		//return lastNameWarning.getText();
	}
	
	public String getEmailWarning()
	{
		return elementUils.getTextFromElement(emailWarning, 30);
		//return emailWarning.getText();
	}
	
	public String getTelephoneWarning()
	{
		return elementUils.getTextFromElement(telephoneWarning, 30);
	}
	
	public String getPasswordWarning()
	{
		return elementUils.getTextFromElement(passwordWarning, 30);
	}
	
}
