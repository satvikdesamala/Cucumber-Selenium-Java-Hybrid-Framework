package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	public void enterUsername(String username) {
		
		elementUtils.enterText(userName, username, CommonUtils.EXPLICIT_WAIT_TIME);
//		userName.sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
//		password.sendKeys(pwd);
		elementUtils.enterText(password, pwd, CommonUtils.EXPLICIT_WAIT_TIME);
	}

	public void clickLoginButton() {
//		loginButton.click();
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_TIME);
	}
}
