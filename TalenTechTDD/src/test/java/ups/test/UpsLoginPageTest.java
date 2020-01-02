package ups.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ReadExcelData;
import ups.actions.UpsLoginPageActions;
import ups.driver.UpsDriver;

public class UpsLoginPageTest extends UpsDriver {

	WebDriver driver;
	UpsLoginPageActions upsLoginTest;
	public static final String URL = "https://www.ups.com/lasso/login";

	public UpsLoginPageTest() {
		this.driver = getChromeDriver();
		upsLoginTest = new UpsLoginPageActions(this.driver);
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		/*
		 * driver.get(URL); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 */
	}

	@Test(dataProvider = "testdata", groups = { "smokeTEst" }, priority = 2)
	public void verifyLoginError(String userid, String password) throws InterruptedException {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		upsLoginTest.verifyImplicitConsent();

		System.out.println(userid + " " + password);

		upsLoginTest.clearUserID();
		upsLoginTest.clearPassword();

		upsLoginTest.userID(userid);
		upsLoginTest.password(password);

		upsLoginTest.login();

		Thread.sleep(2000);

		boolean bool = upsLoginTest.loginErrormsg();
		Assert.assertEquals(bool, true);

	}

	@DataProvider(name = "testdata")
	public Object[][] getExcelData() throws IOException {

		return ReadExcelData.readExcel("Book1.xlsx", "Sheet1");

	}

	@Test(groups = { "RegressionTest" }, priority = 1)
	public void funLoginMsg() {
		System.out.println("UPS Login: Test is Fun");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
