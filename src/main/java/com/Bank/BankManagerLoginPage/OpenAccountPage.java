package com.Bank.BankManagerLoginPage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import com.Bank.ActionDriver.Action;
import com.github.javafaker.Faker;

public class OpenAccountPage {
	public WebDriver driver ;
	Faker faker = new Faker();
	 Action action = new Action();
	 public OpenAccountPage( WebDriver driver ) {
	    this.driver = driver ;
	    PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy( css = "button[ng-click='manager()']")
	 private WebElement CustomerLoginButton;

	 @FindBy( xpath = "//button[normalize-space()='Open Account']")
	 private WebElement OpenAccountButton;
	
	 @FindBy( xpath = "//select[@id='userSelect']")
	 private WebElement CustomerName;
	 
	 @FindBy( xpath = "//select[@id='currency']")
	 private WebElement Currency ;
	 
	 @FindBy( xpath = "//button[@type='submit']")
	 private WebElement Process;
	 
	
	
  public void OpenAccount() throws Throwable{
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    action.click(driver,CustomerLoginButton);
    action.click(driver,OpenAccountButton);
    action.selectByVisibleText("Harry Potter",CustomerName);
    action.selectByVisibleText("Dollar",Currency);
    action.click(driver,Process);
	String myTexyintheAlert = driver.switchTo().alert().getText();
	System.out.println(myTexyintheAlert);
	boolean myCheck = myTexyintheAlert.contains("successfully");
	SoftAssert mysoft = new SoftAssert();
	mysoft.assertEquals(myCheck, true, "customer add successfully");
	driver.switchTo().alert().accept();
	mysoft.assertAll();
			
	
	
	
	
	 }
}
