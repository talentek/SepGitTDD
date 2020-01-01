package ups.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UpsDriver {

	public WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}

	public WebDriver getFirefoxDriver() {
		System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}
