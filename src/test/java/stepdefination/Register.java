package stepdefination;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSucessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {

	WebDriver driver;
	private RegisterPage registerPage;
	private HomePage homePage;
	private AccountSucessPage accountSuccessPage;
	private DriverFactory driverFactory;

	@Given("User navigate to register account page")
	public void user_navigate_to_register_account_page() {

		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();

		registerPage = homePage.clickOnRegisterBtn();

	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerPage.enterFirstName(dataMap.get("firstName"));

		registerPage.enterLastName(dataMap.get("lastName"));

		registerPage.enterEmail(CommonUtils.getRandomEmail());

		registerPage.enterTelephone(dataMap.get("telephone"));

		registerPage.enterPassword(dataMap.get("password"));

		registerPage.enterConformPassword(dataMap.get("password"));
	}

	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerPage.enterFirstName(dataMap.get("firstName"));

		registerPage.enterLastName(dataMap.get("lastName"));

		registerPage.enterEmail(dataMap.get("duplicateemail"));

		registerPage.enterTelephone(dataMap.get("telephone"));

		registerPage.enterPassword(dataMap.get("password"));

		registerPage.enterConformPassword(dataMap.get("password"));

	}

	@When("User select privecy policy")
	public void user_select_privecy_policy() {

		registerPage.selectPrivecyPolicy();

	}

	@When("User click on continue button")
	public void user_click_on_continue_button() {

		accountSuccessPage = registerPage.clickOnContinueBtn();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {

		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
		//Assert.assertTrue(accountSuccessPage.getPageHeading().contains("Your Account Has Been Created!"));

	}

	@When("User select yes for newslatter")
	public void user_select_yes_for_newslatter() {

		registerPage.selectNewsLatterOption();

	}

	@Then("User should get proper warning message about duplicate email")
	public void user_should_get_proper_warning_message_about_duplicate_email() {

		Assert.assertTrue(
				registerPage.getDuplicateEmailWarningMsg().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enters any details into fields")
	public void user_dont_enters_any_details_into_fields() {

		// No need to write a code
	}

	@Then("User should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() {

		Assert.assertTrue(
				registerPage.getDuplicateEmailWarningMsg().contains("Warning: You must agree to the Privacy Policy!"));

		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFistNameWarning());

		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastNameWarning());

		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailWarning());

		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWarning());

		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarning());

	}

}
