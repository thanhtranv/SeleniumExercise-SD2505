package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.BookStorePage;
import pageobjects.HomePage;

public class SearchBook {
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().browserVersion(null).setup();
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
		Constant.WEBDRIVER.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Constant.WEBDRIVER.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@AfterMethod 
	public void afterMethod() {
		Constant.WEBDRIVER.quit();
	}
                                  
	@Test
	public void SearchBookTest() {
		HomePage homePage = new HomePage();
		homePage.open();
		
		BookStorePage bookstorePage = new BookStorePage();
		String keyword = "Design";
		bookstorePage.enterKeyword(keyword);
		boolean checkBooks = bookstorePage.checkBookList(keyword);
		Assert.assertEquals(true, checkBooks, "Book is not displayed as expected");
		
	}
}
