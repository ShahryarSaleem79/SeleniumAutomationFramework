package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

	@Test
	public void testValidLogin() {
		Log.info("Starting Login test ....");
		test = ExtentReportManager.createTest("Login Test");
		LoginPage loginPage = new LoginPage(driver);
		test.info("Navigating to URL...");
		
		Log.info("Entering credetials");
		test.info("Entering Credentials");
		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterPassword("admin");
		Log.info("Clicking Login Button");
		test.info("Clicking Login button");
		loginPage.clickLoginButton();
		System.out.println(driver.getTitle());
		test.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		test.pass("Successful login");
		
	}
}
