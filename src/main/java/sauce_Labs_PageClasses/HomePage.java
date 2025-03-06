package sauce_Labs_PageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sauce_Labs_TestBase.Sauce_Labs_BaseTest;

public class HomePage extends Sauce_Labs_BaseTest {
	@FindBy(xpath = "//div[@class='app_logo']")
	WebElement applogo;

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	WebElement inventoryItemList;

	@FindBy(css="")
	WebElement sample;
	
	@FindBy(xpath = "")
	WebElement secondItem;

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
//		List<WebElement> all_List = driver.findElements(inventoryItemList);
//		for (WebElement list : all_List) {
//			System.out.println(list.getText());
//		}

	}
}
