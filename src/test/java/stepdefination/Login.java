package stepdefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private DriverFactory driverFactory;
	//private HomePage homePage;

	@Given("User navigate to login page")
	public void user_navigate_to_login_page() {
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();

		HomePage homePage = new HomePage(driver);

		homePage.clickOnMyAccount();
		loginPage = homePage.clickOnLoginBtn();

	}

	@When("User enters the valid email address {string} into email field")
	public void user_enters_the_valid_email_address_into_email_field(String emailaddresstext) {
		loginPage = new LoginPage(driver);
		loginPage.emailField(emailaddresstext);

	}

	@When("User enters the valid password {string} into the password field")
	public void user_enters_the_valid_password_into_the_password_field(String validpasswordtext) {

		loginPage.passwordField(validpasswordtext);

	}

	@When("User click on Login button")
	public void user_click_on_login_button() {
		accountPage = loginPage.clickOnLoginBtn();
	}

	@Then("User should get successfull logged in")
	public void user_should_get_successfull_logged_in() {

		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationDisplayed());

	}

	@When("User enters the invalid email address into email field")
	public void user_enters_the_invalid_email_address_into_email_field() {

		loginPage.emailField(CommonUtils.getRandomEmail());

	}

	@When("User enters the invalid password {string} into the password field")
	public void user_enters_the_invalid_password_into_the_password_field(String invalidpasswordtext) {

		loginPage.passwordField(invalidpasswordtext);

	}

	@Then("User should get proper warning message about credenials mismatch")
	public void user_should_get_proper_warning_message_about_credenials_mismatch() {
		Assert.assertTrue(loginPage.getWarningMsg().contains("Warning: No match for E-Mail Address and/or Password."));

	}

	@When("User dont enters the email address into email field")
	public void user_dont_enters_the_email_address_into_email_field() {

		loginPage.emailField("");

	}

	@When("User dont enters the password into the password field")
	public void user_dont_enters_the_password_into_the_password_field() {
		loginPage.passwordField("");

	}

}
