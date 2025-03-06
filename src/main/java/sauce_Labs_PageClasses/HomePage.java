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

	@FindBy(xpath = "")
	WebElement thirdItem;

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
	
}
