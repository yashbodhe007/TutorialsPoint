package TestBase;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	//Singleton design Pattern
		//private constructor so that no one else can create object of this class
		private DriverFactory() {
			
		}
		
		private static DriverFactory instance  = new DriverFactory();
		
		public static DriverFactory getInstance() {
			return instance;
		}
		
		
		//factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
		ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
		
		public synchronized WebDriver getDriver() {
			return driver.get();
		}
		
		public synchronized void setDriver(WebDriver driverParm) {
			driver.set(driverParm);
		}
		
		
		public synchronized void closeBrowser() {
			driver.get().quit();
			driver.remove();
		}

}
