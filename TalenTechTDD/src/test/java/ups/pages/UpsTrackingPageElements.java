package ups.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpsTrackingPageElements {

	WebDriver driver;

	public UpsTrackingPageElements(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement trackBox() {
		WebElement trackBox = driver.findElement(By.xpath("//*[@id='stApp_trackingNumber']"));
		return trackBox;
	}

	public WebElement trackButton() {
		WebElement trackButton = driver.findElement(By.xpath("//*[@id='stApp_btnTrack']"));
		return trackButton;
	}
	
	public WebElement trackingErrorMsg() {
		WebElement trackErrorMsg = driver.findElement(By.xpath("//*[@id='stApp_error_alert_list0']"));
		return trackErrorMsg;
	}

}
