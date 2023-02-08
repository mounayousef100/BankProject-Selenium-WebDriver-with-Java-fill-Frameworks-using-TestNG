package com.Bank.BankManagerLoginTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Bank.BankManagerLoginPage.OpenAccountPage;
import com.Bank.Base.Base;

public class OpenAccountTest extends Base {
	public WebDriver driver;
	private OpenAccountPage openAccountPage;

	@BeforeMethod
	public void OpenPage() throws IOException, InterruptedException {
		driver = intializEDriver();
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void Clouser() {
		driver.quit();
	}

	@Test
	public void AddCustomer() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		openAccountPage = new OpenAccountPage(driver);
		openAccountPage.OpenAccount();

	}
}
