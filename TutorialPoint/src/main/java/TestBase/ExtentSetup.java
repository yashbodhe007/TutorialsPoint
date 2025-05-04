package TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentSetup extends testBase {
	
	static ExtentReports extent;
	
	public static ExtentReports setupExtentReport() {
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String DateTime = format.format(date);
		String reportPath = System.getProperty("user.dir") + "/Reports/ExecutionReport_"+DateTime+".html";
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("DocumentTitle");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("Report name");
		
		extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));
		
		return extent;
	}

}
