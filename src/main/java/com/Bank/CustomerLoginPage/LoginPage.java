package com.Bank.CustomerLoginPage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import com.Bank.ActionDriver.Action;
import com.github.javafaker.Faker;

 public class LoginPage {
	public WebDriver driver ;
	Faker faker = new Faker();
	 Action action = new Action();
	
	 public LoginPage ( WebDriver driver ) {
	     this.driver = driver ;
		 PageFactory.initElements(driver, this);
	 }
 
	 @FindBy( xpath = "//button[normalize-space()='Customer Login']")
	 private WebElement CustomerLoginButton;

	 @FindBy( xpath = "//select[@id='userSelect']")
	 private WebElement YourName;
	
	 @FindBy( xpath = "//button[@type='submit']")
	 private WebElement LoginButton;
	 
	 @FindBy( xpath = "//button[normalize-space()='Deposit']")
	 private WebElement DepositButton;
	 
	 @FindBy( xpath = "//input[@placeholder='amount']")
	 private WebElement AmountFieldDe;
	 
	 @FindBy( xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/button")
	 private WebElement BuutonDE;
	 
	 @FindBy( xpath = "//span[@class='error ng-binding']")
	 private WebElement MessageDepositSuccessful;
	 
	 @FindBy( xpath = "//button[normalize-space()='Withdrawl']")
	 private WebElement WithdrawlButton;
	 
	 @FindBy( xpath = "//input[@placeholder='amount']")
	 private WebElement AmountFieldWi;
	
	 @FindBy( xpath = "//button[@type='submit']")
	 private WebElement BuutonWi;
	 
	 @FindBy( xpath = "/html/body/div[1]/div/div[2]/div/div[2]/strong[2]")
	 private WebElement  Balance;
	 
	 @FindBy( xpath = "//button[@class='btn logout']")
	 private WebElement  logoutButton;
	 
	 @FindBy( xpath = " //button[@class='btn home']")
	 private WebElement  HomeButton;
	
 public void Login(String AmountDeposit,String AmountWithdrawl) throws Throwable{
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    action.click(driver,CustomerLoginButton);
    action.selectByVisibleText("Harry Potter", YourName);
    action.click(driver,LoginButton);
    Thread.sleep(2000);
    action.click(driver,DepositButton);
	action.typestring(AmountFieldDe, AmountDeposit);
    Thread.sleep(2000);
    action.click(driver, BuutonDE);
    Thread.sleep(3000);
    String MessageDeposit = action.getText(MessageDepositSuccessful);
    System.out.println(MessageDeposit);
	boolean myCheck = (MessageDeposit.contains("successfully"));
	SoftAssert mysoft = new SoftAssert();
	mysoft.assertEquals(myCheck, true, "Deposit Successful");
	Thread.sleep(3000);
	action.click(driver,WithdrawlButton);
	Thread.sleep(3000);
	action.typestring(AmountFieldWi,AmountWithdrawl);
	Thread.sleep(3000);
    action.click(driver, BuutonWi);
    Thread.sleep(3000);
    String MessageWithdrawl= action.getText(MessageDepositSuccessful);
    System.out.println(MessageWithdrawl);
	boolean myCheck1 = (MessageWithdrawl.contains("successfully"));
	SoftAssert mysoft1 = new SoftAssert();
	mysoft1.assertEquals(myCheck1, true, "Transaction successful");
	String Dep = AmountDeposit;
    System.out.println(Dep);
    Double Deposit = Double.parseDouble(Dep.trim());
    String Wit = AmountWithdrawl;
    System.out.println(Wit);
    Double Withdrawl = Double.parseDouble(Wit.trim());
    Thread.sleep(3000);
    String MyBalance = action.getText(Balance);
    System.out.println(MyBalance);
    Double MyBalance1 = Double.parseDouble(MyBalance.trim());
    SoftAssert mysoft2 = new SoftAssert();
	mysoft2.assertEquals(MyBalance1,Deposit- Withdrawl ,"check the Balance process ");
	mysoft2.assertAll();
	 action.click(driver,logoutButton);
	String ActuTitle = action.getTitle(driver);
	System.out.println(ActuTitle);
	boolean ExpTitle = (ActuTitle.contains("XYZ Bank"));
	mysoft.assertEquals( ExpTitle, true, "Check Title");
	Thread.sleep(3000);
	driver.navigate().back();
	action.click(driver,HomeButton);
	Thread.sleep(3000);
	String ActuTitle2 = action.getTitle(driver);
	System.out.println(ActuTitle2);
	boolean ExpTitle2 = (ActuTitle.contains("XYZ Bank"));
	mysoft.assertEquals( ExpTitle2, true, "Check Title");
	
	 }
	
}
