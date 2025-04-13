package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driversetup {
	
	
	static WebDriver driver = null;

	public static WebDriver setup() {
		System.setProperty("webdriver.chrome.driver",  "C:\\project\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.tutorialspoint.com/index.htm");	
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver;
		
	}

}

