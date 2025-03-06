package sauce_Labs_TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleClass {
public static void main(String[] args) {
	WebDriver driver =new ChromeDriver();
	driver.get("https://www.saucedemo.com/v1/");
	
}
}
