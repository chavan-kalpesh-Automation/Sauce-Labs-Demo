package sauce_Labs_TestClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sauce_Labs_PageClasses.HomePage;
import sauce_Labs_PageClasses.LoginPage;
import sauce_Labs_TestBase.Sauce_Labs_BaseTest;

public class HomePageTest extends Sauce_Labs_BaseTest {

	HomePage homepg;
	LoginPage loginpg;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialisation();
		homepg = new HomePage();
		loginpg = new LoginPage();
		loginpg.verifyLoginPage(prop.getProperty("std_UserName"), prop.getProperty("pwd"));

	}

	@Test
	public void homepglogo() {
		Assert.assertEquals(true, homepg.verifylogo());
//		System.out.println(homepg.verifylogo());
	}

	@Test
	public void getItemList() {
		homepg.verifyItemListedOnHomePage();
	}

	@Test
	public void Test() {
		homepg.verifySingleItemaddToCartFromList(prop.getProperty("itemname"));
	}
}
