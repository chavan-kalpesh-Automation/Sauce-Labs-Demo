package sauce_Labs_PageClasses;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sauce_Labs_TestBase.Sauce_Labs_BaseTest;
import sauce_Labs_Utility.CommonMethods_UtilityClass;

public class HomePage extends Sauce_Labs_BaseTest {
	CommonMethods_UtilityClass commonUtility;

	@FindBy(xpath = "//div[@class='app_logo']")
	WebElement applogo;

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> inventoryItemList;

	@FindBy(css = "//button[@class='btn_primary btn_inventory']")
	List<WebElement> addToCart;

	@FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//div[@class='shopping_cart_container']")
	WebElement shoppingCartbtn;

	@FindBy(xpath = "//a[@class='btn_action checkout_button']")
	WebElement checkOutbtn;

	@FindBy(xpath = "//input[@id='first-name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='last-name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postalCode;

	@FindBy(xpath = "//input[@class='btn_primary cart_button']")
	WebElement continuebtn;

	@FindBy(xpath = "//a[text()='FINISH']")
	WebElement finishbtn;

	@FindBy(xpath = "//div//h2[text()='THANK YOU FOR YOUR ORDER']")
	WebElement orderCompleteText;

//Initialization of web element using page object model 

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Page Actions

	public boolean verifylogo() {
		return applogo.isDisplayed();

	}

	public void verifyItemListedOnHomePage() {

	}

	public void verifySingleItemaddToCartFromList(String itemName) {
		commonUtility = new CommonMethods_UtilityClass();
		commonUtility.listItem(inventoryItemList, itemName);
		commonUtility.waitElementTobeClickable(addToCartBtn);
		addToCartBtn.click();

	}

	public String verifyItemCheckout(String itemName, String firstname, String lastname, String postalcode) {
		commonUtility = new CommonMethods_UtilityClass();
		commonUtility.listItem(inventoryItemList, itemName);
		commonUtility.waitElementTobeClickable(addToCartBtn);
		addToCartBtn.click();

		commonUtility.waitElementTobeClickable(shoppingCartbtn);
		shoppingCartbtn.click();

		commonUtility.waitElementTobeClickable(checkOutbtn);
		checkOutbtn.click();
		
		firstName.click();
		firstName.sendKeys(firstname);
		
		lastName.sendKeys(lastname);
		postalCode.sendKeys(postalcode);

		commonUtility.waitElementTobeClickable(continuebtn);
		continuebtn.click();
		
		commonUtility.waitElementTobeClickable(finishbtn);

		finishbtn.click();
		
		commonUtility.waitOnVisilibilityOfElement(orderCompleteText);
		
		String order_CompleteText=orderCompleteText.getText();
		
		return order_CompleteText;
		
	}

}
