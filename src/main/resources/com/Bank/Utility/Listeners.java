package com.Bank.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.Bank.Base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base implements ITestListener{
	WebDriver driver = null;
	ExtentReports extentReport = ExtendReport.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThred = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extentTest = extentReport.createTest(testName);
		//extentTestThred.set(extentTest);
		
	}
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.PASS,testName+"Test Passed");
		//extentTestThred.get().log(Status.PASS,"Test Passed");
		
	}
	public void onTestFailure(ITestResult result) {
		//extentTestThred.get().fail(result.getThrowable());
		extentTest.fail(result.getThrowable());
	/*	String testName = result.getName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance()); }
		    catch (Exception e) {
			e.printStackTrace();
		                         }
		try {
		/*String ScreenshotFilePath =*///	takeScreenshot(testName , driver);
		//extentTestThred.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);
		 //   } catch (Exception e) {
			//	e.printStackTrace();
		  //  }	
		   
		
	}
	public void onTestSkipped(ITestResult result) {


	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}
	public void onTestFailedWithTimeout(ITestResult result) {


	}
	public void onStart(ITestContext context) {


	}
	public void onFinish(ITestContext context) {
		extentReport.flush();

	}

	
}
