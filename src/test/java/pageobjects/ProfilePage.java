package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import constant.Constant;

public class ProfilePage extends GeneralPage {
	private By gotobookstoreButton = By.id("gotoStore");
	
	protected WebElement getGoToBookStoreButton() {
		return Constant.WEBDRIVER.findElement(gotobookstoreButton);
	}
	
	protected WebElement getBookNameLabel(String bookName) {
		return Constant.WEBDRIVER.findElement(By.xpath("//a[contains(text(),'"+bookName+"')]"));
	}
	
	protected WebElement getDeleteButton(String bookName) {
		return Constant.WEBDRIVER.findElement(By.xpath("//a[contains(text(),'"+bookName+"')]/../../../..//div[@class='action-buttons']//span[contains( @title,'Delete')]"));
	}
	
	protected List<WebElement> getBookList(String keyword) {
		return Constant.WEBDRIVER.findElements(By.xpath("//a[contains(text(),'"+keyword+"')]"));
	}
	
	public void goBookStorePage() {
		this.getGoToBookStoreButton().click();
	}
	
	public String getBookNameLabelValue(String bookName) {
		return this.getBookNameLabel(bookName).getText();
	}
	
	public void deleteBook(String bookName) {
		this.getDeleteButton(bookName).click();
	}
	
	public boolean checkDeletedBook(String name) {
		List<WebElement> list = this.getBookList(name);
		if(list.size() > 0) {
			return false;
		}
		else 
			return true;
	}
}
