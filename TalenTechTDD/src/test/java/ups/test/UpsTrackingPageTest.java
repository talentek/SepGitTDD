package ups.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ups.actions.UpsTrackingPageActions;
import ups.driver.UpsDriver;

public class UpsTrackingPageTest extends UpsDriver {
	WebDriver driver;
	UpsTrackingPageActions upsTrackingTest;
	public static final String URL = "https://www.ups.com/track?loc=en_US&requester=ST/";

	public UpsTrackingPageTest() {
		this.driver = getChromeDriver();
		upsTrackingTest = new UpsTrackingPageActions(this.driver);
	}

	@BeforeSuite(alwaysRun=true)
	public void beforeClass() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(groups={"regressionTest"},priority=2)
	public void verifyTrackingError() {
		upsTrackingTest.editTrackBox();
		upsTrackingTest.submitTrack();
		boolean bool = upsTrackingTest.trackErrorMsg();
		System.out.println("First test");
		
		Assert.assertEquals(bool, true);
	}
	
	@Test(groups={"smokeTest"},priority=1)
	public void funTrackingMsg() throws InterruptedException{
		Thread.sleep(3000);
		System.out.println("Second test");
		System.out.println("UPS Tracking: Test is Fun");
	}

	@AfterSuite(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}

}
