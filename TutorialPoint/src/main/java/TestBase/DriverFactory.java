package TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

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
		private static  ThreadLocal<WebDriver> Driver = new ThreadLocal<WebDriver>();
		
		public  WebDriver getDriver() {
			return Driver.get();
		}
		
		public  void setDriver(WebDriver driverParm) {
			Driver.set(ThreadGuard.protect(driverParm));
		}
		
		
		public  void closeBrowser() {
			Driver.get().quit();
			Driver.remove();
		}

}
