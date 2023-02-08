package com.Bank.Base;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	 public Properties prop ;
	 public static WebDriver driver ;
	   public WebDriver intializEDriver()throws IOException { 
		   prop = new Properties();
		   String propPath = System.getProperty("user.dir")+ "\\Configuration\\data.properties";
		   FileInputStream file = new FileInputStream(propPath);
		   prop.load(file );
	       String BrouserName = prop.getProperty("browser");
	         if (BrouserName.equalsIgnoreCase("chrome")) {
		       WebDriverManager.chromedriver().setup();
			   driver = new ChromeDriver(); }
			 else if (BrouserName.equalsIgnoreCase("fireFox")) {
			   WebDriverManager.firefoxdriver().setup();
			   driver = new FirefoxDriver(); }
			 else if (BrouserName.equalsIgnoreCase("Edge")) {
			    WebDriverManager.edgedriver().setup();
			    driver = new EdgeDriver();}
	          else if (BrouserName.equalsIgnoreCase("IE")) {
	             WebDriverManager.iedriver().setup();
		         driver = new InternetExplorerDriver();        
	   }

	       driver.manage().window().maximize();	
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       return driver;	  	 
 }
	   
	   public static void takeScreenshot(String testName ,WebDriver driver) throws IOException {
		   Date currentDate = new  Date ();
		   String TheAcutalData = currentDate.toString().replace(":","-");
		   TakesScreenshot src = ((TakesScreenshot)driver);
		   File SrcFile = src.getScreenshotAs((OutputType.FILE));
		   File Dest = new File(".//screenshots//" +TheAcutalData +".png");
		   FileUtils.copyFile(SrcFile,Dest);   
		 
	   }
	      

          //assign the current title to string title
         
         
	   
	/*   public void takeScreenshot(String testName ,WebDriver driver) throws Exception{
	        File scrShot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        String  DestFilePath = System.getProperty("user.dir")+".//screenshots//"+testName+".png";         
	         FileUtils.copyFile(scrShot,new File( DestFilePath ));
	        // return DestFilePath ;
	    } */
	
}
