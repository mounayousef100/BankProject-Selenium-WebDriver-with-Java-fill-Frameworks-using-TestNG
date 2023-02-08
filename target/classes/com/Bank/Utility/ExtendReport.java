package com.Bank.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReport {

	 public static ExtentReports extentReport;
	 public static ExtentReports getExtentReport() {
			
			String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
			reporter.config().setReportName("TutorialsNinja Automation Results");
			reporter.config().setDocumentTitle("Test Results");
			extentReport = new ExtentReports();
			extentReport.attachReporter(reporter);
			extentReport.setSystemInfo("Operating System","Windows 10");
			extentReport.setSystemInfo("Tested By","Arun Motoori");
			
			return extentReport;
			
		}
}
