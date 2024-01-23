package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnWebElement(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
	}

	public void typeTextIntoTheElement(WebElement element, String textTobeTyped, long durationOfTime) {
		WebElement webElement = waitForElement(element, durationOfTime);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textTobeTyped);
	}

	public WebElement waitForElement(WebElement element, long durationOfSeconds) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationOfSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}

	public void selectOptionDropdown(WebElement element, String dropDownOptions, long dueationOfSeconds) {
		WebElement webElement = waitForElement(element, dueationOfSeconds);
		Select select = new Select(webElement);
		select.selectByVisibleText(dropDownOptions);
	}

	public void acceptAlert(long durationOfTime) {
		Alert alert = waitForAlert(durationOfTime);
		alert.accept();

	}

	public void dismissAlert(long durationOfTime) {
		Alert alert = waitForAlert(durationOfTime);
		alert.dismiss();
	}

	public Alert waitForAlert(long durationOfSeconds) {
		Alert alert = null;
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationOfSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable e) {
			// TODO: handle exception
		}

		return alert;
	}

	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisiblityOfelement(element, durationInSeconds);

		Actions action = new Actions(driver);
		action.moveToElement(webElement).click().build().perform();
	}

	public WebElement waitForVisiblityOfelement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return webElement;

	}

	public void javaScriptClick(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisiblityOfelement(element, durationInSeconds);

		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].click();", webElement);
	}

	public void javaScriptType(WebElement element, long durationInSeconds, String textTobeTyped) {
		WebElement webElement = waitForVisiblityOfelement(element, durationInSeconds);

		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='"+textTobeTyped+"'", webElement);
	}
	
	public String getTextFromElement(WebElement element, long durationInSeconds)
	{
		WebElement webElemnt = waitForElement(element, durationInSeconds);
		return webElemnt.getText();
	}
	
	public boolean displayStatusOfElement(WebElement element, long durationInSecondsu)
	{
		try {
		WebElement webElemnt = waitForElement( element, durationInSecondsu);
		return webElemnt.isDisplayed();
		}
		catch (Throwable e) {
			// TODO: handle exception
			return false;
		}
	}
}
