package TestBase;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import ReuseableMethods.AlertHandling;
import ReuseableMethods.ClickElement;
import ReuseableMethods.DropDownHandling;
import ReuseableMethods.PropertiesOperations;

public class testBase extends ObjectsRepo {
//	public static WebDriver driver;
	BrowserFactory bf = new BrowserFactory();
	
	public static WebDriverWait wait ;
	public static JavascriptExecutor jse ;
	public static Actions actions;
	public static Select select;
	public static ClickElement CE;
	public static DropDownHandling ddh;
	public static AlertHandling handlingAlert;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeMethod
	  public void openBrowser() throws Exception {
		    DriverFactory.getInstance().setDriver(bf.createBrowserInstance(PropertiesOperations.getPropertyValueByKey("browser")));
//		    driver = DriverFactory.getInstance().getDriver();
		    DriverFactory.getInstance().getDriver().navigate().to("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

			System.out.println("Browser Open");
			DriverFactory.getInstance().getDriver().manage().window().maximize();
			DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			DriverFactory.getInstance().getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
			actions =new Actions(DriverFactory.getInstance().getDriver());
			jse = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		}
	
	@AfterMethod
	  public void closeBrowser() {
		  System.out.println("Browser close");
		  DriverFactory.getInstance().closeBrowser();
	  }
	
	
}
