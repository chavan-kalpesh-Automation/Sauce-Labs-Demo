package sauce_Labs_Utility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import sauce_Labs_TestBase.Sauce_Labs_BaseTest;

public class CommonMethods_UtilityClass extends Sauce_Labs_BaseTest {

	public static WebDriverWait wait;
	Actions act;
	Select select;
	JavascriptExecutor js;
	Alert alert;
//	public static Faker faker;

	/****************************************
	 * *Get Current URL Of The Page*
	 * 
	 * @return
	 */

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	/*******************************
	 * Get Current Page Title
	 * 
	 * @return
	 */
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}

	/****************************************
	 * *GePerform Hover action on an Element*
	 * 
	 * @return
	 */
	public void clickAndHoldActionOnElement(WebElement clickAndHold) {
		act = new Actions(driver);
		act.clickAndHold(clickAndHold).build().perform();
	}

	/****************************************
	 * *Handle Select Tag Related Element Task*
	 * 
	 * @return
	 */
	public void selectItemByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);

	}

	public void selectItemByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);

	}

	public void selectItemByVisibleText(WebElement element, String visibleText) {
		select = new Select(element);
		select.selectByValue(visibleText);

	}

	/****************************************
	 * *Get Selected Item Text*
	 * 
	 * @return
	 */
	public String selectedItemText(WebElement element) {
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	/*****************************************
	 * Perform Click Action on an element where visible Text Matches From an element
	 * List
	 * 
	 * @param
	 */
	public void listItem(List<WebElement> elements, String visibleText) {
		for (WebElement element : elements) {
			if (element.getText().equals(visibleText)) {
				element.click();
				break;
			}

		}
	}

	/*****************************************
	 * Scroll To An Element
	 * 
	 * @param
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);

	}

	/*
	 * Handle Wait Related Task
	 */
	// Wait until visibility of element
	public void waitOnVisilibilityOfElement(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	// Wait until element to be present

	public void waitPresenceOfElement(By element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	// Wait Until element to be click
	public void waitElementTobeClickable(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// wait until alert to be present
	public void waitUntilAlertTobePresent() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// wait For an alert present and return with an alert
	public Alert waitForAlert() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}

	/*
	 * Handled Alert Related Task
	 */
	// Accept alert whenever it present

	public void acceptAlert() {
		alert = waitForAlert();
		alert.accept();
	}

	// Dismiss alert whenever it present
	public void dismissAlert() {
		alert = waitForAlert();
		alert.dismiss();
	}

	/*
	 * Faker Related changes
	 */
	static Faker faker = new Faker();

	public static String firstName() {

		String firstName = faker.name().firstName();
		return firstName;

	}

	public static String lastName() {
		String lastName = faker.name().lastName();
		return lastName;
	}

	public static String phoneNumber() {
		String phoneNumber = faker.name().lastName();
		return phoneNumber;
	}
	public static String postalCode() {
		String postalCode=faker.address().zipCode();
		return postalCode;
	}

	/*
	 * Window Handeling
	 */
	public List<String> windowHandeling() {
		// Get all window handles and hold them in a List
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandleList = new ArrayList<>(windowHandles);

		return windowHandleList;
	}

}
