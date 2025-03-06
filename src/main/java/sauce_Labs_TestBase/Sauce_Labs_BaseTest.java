package sauce_Labs_TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sauce_Labs_BaseTest {

	protected static Properties prop;
	public static WebDriver driver;
	
	
	public static void initialisation() {
		String browserName=prop.getProperty("browsername");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().clearDriverCache().setup();
//			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().clearDriverCache().setup();
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(prop.getProperty("SAUCE_LABS_URL"));

	}
	protected Sauce_Labs_BaseTest() {
		try {
		prop=new Properties();
		Path root=FileSystems.getDefault().getPath("").toAbsolutePath();
		Path filePath=Paths.get(root.toString(), "config.properties");
		FileInputStream fis=new FileInputStream(filePath.toString());
		prop.load(fis);
		}
		catch(FileNotFoundException e){
			e.getStackTrace();
		}
		catch(IOException e) {
			e.getStackTrace();
		}
		
	}
	
	}

