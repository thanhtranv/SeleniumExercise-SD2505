package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import constant.Constant;

public class GeneralPage {
	private By usernameLabel = By.id("userName-value");
	private By loginButton = By.id("login");
	private By profileMenuButton = By.xpath("//span[contains(text(),'"+Constant.PROFILE_MENU+"')]");
	private By searchTextBox = By.id("searchBox");
	private By okButtonDialog = By.id("closeSmallModal-ok");
	
	protected WebElement getLoginButton() {
		return Constant.WEBDRIVER.findElement(loginButton);
	}
	
	protected WebElement getUsernameLabel() {
		return Constant.WEBDRIVER.findElement(usernameLabel);
	}
	
	protected WebElement getProfileMenu() {
		return Constant.WEBDRIVER.findElement(profileMenuButton);
	}
	
	protected WebElement getSearchTextBox() {
		return Constant.WEBDRIVER.findElement(searchTextBox);
	}
	
	protected WebElement getOkButtonDialog() {
		return Constant.WEBDRIVER.findElement(okButtonDialog);
	}
	
	public void goToLoginPage() {
		this.getLoginButton().click();
	}
	
	public String getUserNameLabelValue() {
		return this.getUsernameLabel().getText();
	}
	
	public void goToProfilePage() {
		this.getProfileMenu().click();
	}
	
	public void enterKeyword(String keyword) {
		this.getSearchTextBox().sendKeys(keyword);
	}
	
	public void confirmDialog() {
		this.getOkButtonDialog().click();
	}
}
