package com.Bank.BankManagerLoginTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Bank.BankManagerLoginPage.AddCustomerPage;
import com.Bank.Base.Base;

public class AddCustomerTest extends Base {
	public WebDriver driver;
	private AddCustomerPage addCustomerPage;

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
		addCustomerPage = new AddCustomerPage(driver);
		addCustomerPage.AddCustomer();

	}
}
