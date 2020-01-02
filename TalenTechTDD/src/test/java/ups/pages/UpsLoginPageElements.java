package ups.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpsLoginPageElements {

	WebDriver driver;

	public UpsLoginPageElements(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement implicitConsentSubmitBtn() {
		WebElement implicitConsentSubmitBtn = driver.findElement(By.id("implicit_consent_prompt_submit"));
		return implicitConsentSubmitBtn;
	}

	public WebElement userID() {
		WebElement userId = driver.findElement(By.name("userID"));
		return userId;
	}

	public WebElement password() {
		WebElement password = driver.findElement(By.name("password"));
		return password;
	}

	public WebElement login() {
		WebElement logIn = driver.findElement(By.xpath("//*[@id='submitBtn']"));
		return logIn;
	}

	public WebElement errorMsg() {
		WebElement errorMsg = driver.findElement(
				By.xpath("//p[@class='ups-invalid_color-list ups-error_alert-list icon ups-icon-exclamation']"));
		return errorMsg;
	}

}
