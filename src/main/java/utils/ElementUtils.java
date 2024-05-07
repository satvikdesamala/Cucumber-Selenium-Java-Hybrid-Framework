package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);

		webElement.click();
	}

	public void enterText(WebElement element, String text, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));

		webElement.click();
		webElement.clear();
		webElement.sendKeys(text);
	}

	public WebElement waitForElement(WebElement element, long durationInSeconds) {

		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return webElement;
	}

	public void selectDropdown(WebElement element, String option, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);
		Select select = new Select(webElement);
		select.selectByVisibleText(option);
	}

	public void acceptAlert(long durationInSeconds) {
		
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();

	}
	
	public void dismissAlert(long durationInSeconds) {
		
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();

	}

	public Alert waitForAlert(long durationInSeconds) {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return alert;
	}
	
	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));

		Actions action = new Actions(driver);
		// moveToElement() means mouse hover and click() is to click
		action.moveToElement(webElement).click().build().perform();
		
	}
	
	public void javascriptClick(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));

		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();", webElement);
	}
	
	public void javascriptType(WebElement element, String text, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));

		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+text+"'", webElement);
	}
	
	public String getTextFromWebElement(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
		
		String text = webElement.getText();
		return text;
		
	}

}
