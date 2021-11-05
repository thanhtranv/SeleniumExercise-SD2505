package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;

import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.BookStorePage;
import pageobjects.DetailBookPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.ProfilePage;

public class AddCollection {
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
	public void AddCollectionTest() {
		HomePage homePage = new HomePage();
		homePage.open();
		homePage.goToLoginPage();
		
		LoginPage loginPage = new LoginPage();
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		
		
		BookStorePage bookstorePage = new BookStorePage();
		bookstorePage.selectBook(Constant.BOOKNAME);
		
		DetailBookPage detailbookPage = new DetailBookPage();
		JavascriptExecutor jse = (JavascriptExecutor)Constant.WEBDRIVER;
		jse.executeScript("window.scrollBy(0,250)");
		detailbookPage.addToCollection();
		
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = Constant.WEBDRIVER.switchTo().alert();
		String messageAlert = alert.getText();
		Assert.assertEquals(messageAlert, "Book added to your collection.");
		Constant.WEBDRIVER.switchTo().alert().accept();
		
		ProfilePage profilePage = new ProfilePage();
		jse.executeScript("window.scrollBy(0,250)");
		profilePage.goToProfilePage();
		String bookName = profilePage.getBookNameLabelValue(Constant.BOOKNAME);
		Assert.assertEquals(bookName, Constant.BOOKNAME, "Book is added to collection");
	}
}
