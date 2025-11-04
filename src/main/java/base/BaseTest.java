package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.Log;

public class BaseTest {

	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		Log.info("Starting WebDriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Log.info("navigating to URL...");
		driver.get("https://admin-demo.nopcommerce.com/login");		
	}
	@AfterMethod
	public void tearDown() {
		if (driver !=null) {
			Log.info("Closing Browser");
			driver.close();
		}
	}
	
}
