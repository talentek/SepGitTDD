package ups.actions;

import org.openqa.selenium.WebDriver;

import ups.pages.UpsTrackingPageElements;

public class UpsTrackingPageActions {

	UpsTrackingPageElements trackingPage;

	public UpsTrackingPageActions(WebDriver driver) {
		trackingPage = new UpsTrackingPageElements(driver);
	}
	
	public void editTrackBox(){
		trackingPage.trackBox().sendKeys("HelloWorld123");
	}
	
	public void submitTrack(){
		trackingPage.trackButton().click();
	}
	
	public boolean trackErrorMsg(){
		return trackingPage.trackingErrorMsg().isDisplayed();
	}

}
