package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	//via page object model
//	private By UsernameTextBox = By.id("Email");
//	private By PasswordTextBox = By.id("Password");
//	private By LoginButton 	   = By.xpath("//button[@class='button-1 login-button']");
	
	//via page factory model
	@FindBy(id="Email")
	WebElement UsernameTextBox; 
	@FindBy(id="Password")
	WebElement PasswordTextBox;
	@FindBy(xpath="//button[@class='button-1 login-button']")
	WebElement LoginButton;
	
	//declartion of the constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String username) {
		UsernameTextBox.clear();
		UsernameTextBox.sendKeys(username);
//		driver.findElement(UsernameTextBox).clear();
//		driver.findElement(UsernameTextBox).sendkeys(username);
	}
	
	public void enterPassword(String password) {
		PasswordTextBox.clear();
		PasswordTextBox.sendKeys(password);
//		driver.findElement(PasswordTextBox).clear();
//		driver.findElement(PasswordTextBox).sendkeys(password);
		
	}
	
	public void clickLoginButton() {
		LoginButton.click();
//		driver.findElement(LoginButton).click();
	}
	
	
}
