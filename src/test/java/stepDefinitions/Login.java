package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.BrowserDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class Login{
	
	WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	
	
	@Given("I navigate to login page")
	public void i_navigate_to_login_page() throws InterruptedException {
		driver = BrowserDriver.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.SelectLoginOption();
	}

//	@Given("I enter email {string}")
//	public void i_enter_email(String email) {
//		loginPage = new LoginPage(driver);
//		loginPage.enterUsername(email);
//	}
//
//	@Given("I enter password {string}")
//	public void i_enter_password(String password) {
//		loginPage.enterPassword(password);
//	}

	@When("I click on login")
	public void i_click_on_login() {
		loginPage.clickLoginButton();
	}

	@Then("I validate success message")
	public void i_validate_success_message() {
	    Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed());
	}
	
	// ^ and $ symbols must be there when we create step defs for data driven process
	@Given("^I enter email (.+)$")
	public void i_enter_email(String email) {
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(email);
	}

	@Given("^I enter password (.+)$")
	public void i_enter_password(String password) {
		loginPage.enterPassword(password);
	}

}