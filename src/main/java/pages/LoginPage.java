package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	private By UsernameTextBox = By.id("Email");
	private By PasswordTextBox = By.id("Password");
	private By LoginButton 	   = By.xpath("//button[@class='button-1 login-button']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(UsernameTextBox).clear();
		driver.findElement(UsernameTextBox).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(PasswordTextBox).clear();
		driver.findElement(PasswordTextBox).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(LoginButton).click();
	}
	
	
}
