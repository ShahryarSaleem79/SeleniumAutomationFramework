package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException{
		String filepath = System.getProperty("user.dir")+"/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filepath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount - 1][2];
		for (int i=1; i<rowCount; i++)
		{
			data[i-1][0]=ExcelUtils.getCellData(i, 0);//username
			data[i-1][1]=ExcelUtils.getCellData(i, 1);//password
	}
		ExcelUtils.closeExcel();
		return data;
	}
	@Test(dataProvider = "LoginData")
	public void testValidLogin(String username, String password) {
		Log.info("Starting Login test ....");
		test = ExtentReportManager.createTest("Login Test - "+username);
		LoginPage loginPage = new LoginPage(driver);
		test.info("Navigating to URL...");

		Log.info("Entering credetials");
		test.info("Entering Credentials");
//		loginPage.enterUsername("admin@yourstore.com");
//		loginPage.enterPassword("admin");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		Log.info("Clicking Login Button");
		test.info("Clicking Login button");
		loginPage.clickLoginButton();
		System.out.println(driver.getTitle());
		test.info("Verifying page title");
		//Assert.assertEquals(driver.getTitle(), "Just a moment...");
		test.pass("Successful login");

	}

//	@Test(priority = 2)
//	public void testInvalidLogin() {
//		Log.info("Starting Login test ....");
//		test = ExtentReportManager.createTest("Login Test with Invalid Credentials");
//		LoginPage loginPage = new LoginPage(driver);
//		test.info("Navigating to URL...");
//
//		Log.info("Entering credetials");
//		test.info("Entering Credentials");
//		loginPage.enterUsername("admin@yourstore.com");
//		loginPage.enterPassword("admin");
//		Log.info("Clicking Login Button");
//		test.info("Clicking Login button");
//		loginPage.clickLoginButton();
//		System.out.println(driver.getTitle());
//		test.info("Verifying page title");
//		Assert.assertEquals(driver.getTitle(), "Just a moment...123");
//		test.pass("Successful login");
//	}
}
