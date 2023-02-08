package com.Bank.CustomerLoginTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Bank.Base.Base;
import com.Bank.CustomerLoginPage.LoginPage;
import com.Bank.Dataprovider.ExcelDataProvider;

public class LoginTest extends Base {

	public WebDriver driver;
	private LoginPage loginPage;
	@Parameters("browser")
	@BeforeMethod
	public void OpenPage() throws IOException, InterruptedException {
		driver = intializEDriver();
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void Clouser() {
		driver.quit();
	}

	@Test(dataProvider = "LoginPage", dataProviderClass = ExcelDataProvider.class)
	public void Login(String amountDeposit, String amountWithdrawl) throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPage = new LoginPage(driver);
		loginPage.Login(amountDeposit, amountWithdrawl);

	}

}
