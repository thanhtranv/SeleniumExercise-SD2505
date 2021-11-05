package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import constant.Constant;

public class BookStorePage extends GeneralPage {
	
	protected WebElement getDetailBookLink(String bookName) {
		return Constant.WEBDRIVER.findElement(By.xpath("//a[contains(text(),'"+bookName+"')]"));
	}
	
	protected List<WebElement> getBookList(String keyword) {
		return Constant.WEBDRIVER.findElements(By.xpath("//a[contains(text(),'"+keyword+"')]"));
	}
	
	public void selectBook(String bookName) {
		this.getDetailBookLink(bookName).click();
	}
	
	public boolean checkBookList(String name) {
		List<WebElement> list = this.getBookList(name);
		if(list.size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
