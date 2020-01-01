package ups.actions;

import org.openqa.selenium.WebDriver;

import ups.pages.UpsLoginPageElements;

public class UpsLoginPageActions {
	UpsLoginPageElements loginPage;

	public UpsLoginPageActions(WebDriver driver) {
		this.loginPage = new UpsLoginPageElements(driver);
	}

	public void userID(String userid) {

		loginPage.userID().sendKeys(userid);
	}

	public void clearUserID() {
		loginPage.userID().clear();
	}

	public void password(String password) {
		loginPage.password().sendKeys(password);

	}

	public void clearPassword() {
		loginPage.password().clear();
	}

	public void login() {
		loginPage.login().click();
	}

	public boolean loginErrormsg() {
		boolean str = loginPage.errorMsg().isDisplayed();
		return str;
	}

}
