package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.ProfilePage;

public class DeleteBook {
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().browserVersion(null).setup();
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
		Constant.WEBDRIVER.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Constant.WEBDRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod 
	public void afterMethod() {
		Constant.WEBDRIVER.quit();
	}
	
	@Test
	public void DeleteBookTest() {
		HomePage homePage = new HomePage();
		homePage.open();
		homePage.goToLoginPage();
		
		LoginPage loginPage = new LoginPage();
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		ProfilePage profilePage = new ProfilePage();
		JavascriptExecutor jse = (JavascriptExecutor)Constant.WEBDRIVER;
		jse.executeScript("window.scrollBy(0,300)");
		profilePage.goToProfilePage();
		
		String bookName = "Learning JavaScript Design Patterns";
		profilePage.enterKeyword(bookName);
		profilePage.deleteBook(bookName);
		profilePage.confirmDialog();
		
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = Constant.WEBDRIVER.switchTo().alert();
		alert.accept();
		boolean deletedBook = profilePage.checkDeletedBook(bookName);
		Assert.assertEquals(true, deletedBook, "The book is not deleted as expected");
	}
}
