package com.Bank.BankManagerLoginPage;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.Bank.ActionDriver.Action;
import com.github.javafaker.Faker;

public class AddCustomerPage {
	public WebDriver driver;
	Faker faker = new Faker();
	Action action = new Action();
	SoftAssert mysoft = new SoftAssert();

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[ng-click='manager()']")
	private WebElement CustomerLoginButton;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[1]")
	private WebElement AddCustomer;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	private WebElement FirstNameField;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement LastNameField;

	@FindBy(xpath = "//input[@placeholder='Post Code']")
	private WebElement PostCodeField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement AddCustomerBuuton;

	@FindBy(xpath = "//input[@placeholder='Search Customer']")
	private WebElement Customers;

	@FindBy(xpath = "//tbody/tr")
	private List<WebElement> SearchCustomers;

	public void AddCustomer() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action.click(driver, CustomerLoginButton);
		action.click(driver, AddCustomer);
		String firstName = faker.name().firstName();
		action.typestring(FirstNameField, firstName);
		String LirstName = faker.name().lastName();
		action.typestring(LastNameField, LirstName);
		action.typestring(LastNameField, LirstName);
		String PostCode = "E" + faker.number().toString();
		action.typestring(PostCodeField, PostCode);
		action.click(driver, AddCustomerBuuton);
		String myTexyintheAlert = driver.switchTo().alert().getText();
		System.out.println(myTexyintheAlert);
		boolean myCheck = myTexyintheAlert.contains("successfully");
		mysoft.assertEquals(myCheck, true, "customer add successfully");
		driver.switchTo().alert().accept();
		driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list");
		action.typestring(Customers, firstName);
		int myActualUsers = SearchCustomers.size();
		mysoft.assertEquals(myActualUsers, 1);
		mysoft.assertAll();

	}

}
