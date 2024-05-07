package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	WebDriver driver;
	ElementUtils elementUtils;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(css = "[title=\"My Account\"]")
	private WebElement myAccountDropDown;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	public void clickOnMyAccount() {
//		myAccountDropDown.click();
		elementUtils.clickOnElement(myAccountDropDown, CommonUtils.EXPLICIT_WAIT_TIME);
	}

	public void SelectLoginOption() {
//		loginOption.click();
		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_TIME);
	}

}
