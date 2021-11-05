package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import constant.Constant;

public class DetailBookPage extends GeneralPage {
	private By addtocollectionButton = By.xpath("//button[contains(text(),'Add To Your Collection')]");
	private By gotostoreButton = By.xpath("//button[contains(text(),'Back To Book Store')]");
	
	protected WebElement getAddToCollectionButton() {
		return Constant.WEBDRIVER.findElement(addtocollectionButton);
	}
	
	protected WebElement getGoToStoreButton() {
		return Constant.WEBDRIVER.findElement(gotostoreButton);
	}
	
	public void addToCollection() {
		this.getAddToCollectionButton().click();
	}
	
	public void goToStore() {
		this.getGoToStoreButton().click();
	}
}
