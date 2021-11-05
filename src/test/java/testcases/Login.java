package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class Login {
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().browserVersion(null).setup();
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
		Constant.WEBDRIVER.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod 
	public void afterMethod() {
		Constant.WEBDRIVER.quit();
	}
	
	@Test
	public void LoginTest() {
		HomePage homePage = new HomePage();
		homePage.open();
		homePage.goToLoginPage();
		
		LoginPage loginPage = new LoginPage();
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		
		String headerText = homePage.getUserNameLabelValue();
		Assert.assertEquals(headerText, Constant.USERNAME, "Username is not displayed as expected");
	}
}
