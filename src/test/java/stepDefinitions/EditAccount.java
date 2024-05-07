package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.BrowserDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class EditAccount {
	WebDriver driver;

	@Given("I click on edit account information")
	public void i_click_on_edit_account_information(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		driver = BrowserDriver.getDriver();
		driver.findElement(By.xpath("//a[text()='Edit your account information']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).clear();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataMap.get("FirstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).clear();
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataMap.get("LastName"));
	}

	@When("I click on continue")
	public void i_click_on_continue() {
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

	@Then("I validate account update confirmation message {string}")
	public void i_validate_account_update_confirmation_message(String confMessage) {
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText(), confMessage);
		// to fail the test capture screenshot
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText(), confMessage+ "Failed");
	}

}
