package sauce_Labs_TestClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sauce_Labs_PageClasses.LoginPage;
import sauce_Labs_TestBase.Sauce_Labs_BaseTest;

public class LoginPageTest extends Sauce_Labs_BaseTest {

	LoginPage loginpg;

	public LoginPageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialisation();
		loginpg=new LoginPage();
	}

	@Test
	public void logintoSauceLab() {
		loginpg.verifyLoginPage(prop.getProperty("std_UserName"), prop.getProperty("pwd"));

	}

	
	@AfterMethod
	public void teardown() {
//		driver.quit();
	}

}
