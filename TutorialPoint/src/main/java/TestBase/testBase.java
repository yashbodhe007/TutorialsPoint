package TestBase;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class testBase {
	public WebDriver driver;
	BrowserFactory bf = new BrowserFactory();

	@BeforeMethod
	  public void openBrowser() throws MalformedURLException {
		    DriverFactory.getInstance().setDriver(bf.createBrowserInstance("chrome"));
		    driver = DriverFactory.getInstance().getDriver();
			System.out.println("Browser Open");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
	
	@AfterMethod
	  public void afterMethod() {
		  System.out.println("Browser close");
		  DriverFactory.getInstance().closeBrowser();
	  }
	
	
}
