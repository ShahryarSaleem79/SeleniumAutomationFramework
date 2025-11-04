package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest {

	@Test
	public void testValidLogin() {
		Log.info("Starting Login test ....");
		LoginPage loginPage = new LoginPage(driver);
		
		Log.info("Entering credetials");
		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterPassword("admin");
		Log.info("Clciking Login Button");
		loginPage.clickLoginButton();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		
	}
}
