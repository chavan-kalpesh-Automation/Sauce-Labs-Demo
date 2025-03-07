package sauce_Labs_TestClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sauce_Labs_PageClasses.HomePage;
import sauce_Labs_PageClasses.LoginPage;
import sauce_Labs_TestBase.Sauce_Labs_BaseTest;
import sauce_Labs_Utility.CommonMethods_UtilityClass;

public class HomePageTest extends Sauce_Labs_BaseTest {

	HomePage homepg;
	LoginPage loginpg;
	CommonMethods_UtilityClass commonutility;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialisation();
		homepg = new HomePage();
		loginpg = new LoginPage();
		loginpg.verifyLoginPage(prop.getProperty("std_UserName"), prop.getProperty("pwd"));
		commonutility=new CommonMethods_UtilityClass();
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
	public void itemCheckoutFlow() {
		String actualresult = homepg.verifyItemCheckout(prop.getProperty("itemname"), prop.getProperty("name"),
				prop.getProperty("lname"), prop.getProperty("postalcode"));

		Assert.assertEquals(actualresult, "THANK YOU FOR YOUR ORDER");
	}
	@Test
	public void itemCheckoutFlowUsingFaker() {
		
		String firstname=CommonMethods_UtilityClass.firstName();
		String lastname=CommonMethods_UtilityClass.lastName();
		String postalcode=CommonMethods_UtilityClass.postalCode();
		
		String actualresult = homepg.verifyItemCheckout(prop.getProperty("itemname"), firstname,
				lastname, postalcode);

		Assert.assertEquals(actualresult, "THANK YOU FOR YOUR ORDER");
	}

	@Test
	public void itemaddToCart() {
		
		homepg.verifySingleItemaddToCartFromList(prop.getProperty("itemname"));
	}
}
