package ReuseableMethods;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import TestBase.DriverFactory;
import TestBase.ExtentFactory;
import TestBase.ExtentSetup;
import TestBase.ObjectsRepo;
import TestBase.testBase;

public class ListenersImplementation extends testBase implements ITestListener {
	
	static ExtentReports report;
//	   ExtentTest test;

	
	public void onTestStart(ITestResult result) {
		//before each tc
		test = report.createTest(result.getMethod().getMethodName());
		ExtentFactory.getInstance().setExtent(test);
	}

	
	public void onTestSuccess(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+ " is Passed.");
		ExtentFactory.getInstance().removeExtentObject();
	}

	
	public void onTestFailure(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+ " is Failed.");
		ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());
		
		//add screenshot for failed test.
				File src = ((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
				Date date = new Date();
				String actualDate = format.format(date);
				
				String screenshotPath = System.getProperty("user.dir")+"/Reports/screenshots/"+actualDate+".jpeg";
				File dest = new File(screenshotPath);
				
				try {
					FileUtils.copyFile(src, dest);
				} catch (IOException e) {
					e.printStackTrace();
				}
				test.addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
		
	}

	
	public void onTestSkipped(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+ " is skipped.");
		ExtentFactory.getInstance().removeExtentObject();
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	
	public void onStart(ITestContext context) {
		//setup method call
		report = ExtentSetup.setupExtentReport();
	}

	
	public void onFinish(ITestContext context) {
		//close extent
		report.flush();
	}

}
