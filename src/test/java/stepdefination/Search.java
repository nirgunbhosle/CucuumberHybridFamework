package stepdefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;

public class Search {

	WebDriver driver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	private DriverFactory driverFactory;

	@Given("User opens the appliction")
	public void user_opens_the_appliction() {
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();

	}

	@When("User enters valid product {string} into the search box field")
	public void user_enters_valid_product_into_the_search_box_field(String validproducttext) {
		homePage = new HomePage(driver);
		homePage.enterProductInSearchBox(validproducttext);
	}

	@When("User click on search button")
	public void user_click_on_search_button() {

		searchResultPage = homePage.clickOnSearchBtn();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {

		Assert.assertTrue(searchResultPage.displayStatusOfValidProduct());

	}

	@When("User enters invalid product {string} into the search box field")
	public void user_enters_invalid_product_into_the_search_box_field(String invalidproducttext) {

		homePage = new HomePage(driver);
		homePage.enterProductInSearchBox(invalidproducttext);
	}

	@Then("User should get a messege about no product found")
	public void user_should_get_a_messege_about_no_product_found() {

		Assert.assertEquals("There is no product that matches the search criteria.", searchResultPage.getMessageText());

	}

	@When("User dont enters any product into the search box field")
	public void user_dont_enters_any_product_into_the_search_box_field() {

		homePage = new HomePage(driver);
	}

}
