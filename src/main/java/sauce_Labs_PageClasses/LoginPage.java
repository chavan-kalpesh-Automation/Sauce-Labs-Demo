package sauce_Labs_PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sauce_Labs_TestBase.Sauce_Labs_BaseTest;

public class LoginPage extends Sauce_Labs_BaseTest {

	@FindBy(xpath="//input[@id='user-name']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginbtn;
	
	//Initializing the WebElement Using the PageFactory
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Page Actions 
	public  HomePage verifyLoginPage(String usrname ,String pass) {
		username.sendKeys(usrname);
		password.sendKeys(pass);
		loginbtn.click();
		return new HomePage();
	}
}
