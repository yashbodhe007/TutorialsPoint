package ReuseableMethods;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.DriverFactory;
import TestBase.testBase;

public class AlertHandling extends testBase {
	
	
	
//	WebDriver driver;
	WebElement element;
//	WebDriverWait wait;
	
	public AlertHandling() {
//		testBase.driver=driver;
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
//		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
				
	}

	
	public void handleSimpleAlerts(WebElement element) {
		//ok
//		this.element=element;
		element.click();
		wait.until(ExpectedConditions.alertIsPresent());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DriverFactory.getInstance().getDriver().switchTo().alert().accept();
		
		
		
	}
	public void handleConfimationAlerts(WebElement element) {
		//ok or cancel
//		this.element=element;
		element.click();
		wait.until(ExpectedConditions.alertIsPresent());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DriverFactory.getInstance().getDriver().switchTo().alert().dismiss();
		
	}
	public void handlePromptAlerts(WebElement element, String string) {
		// text and button
//		this.element=element;
		element.click();
		wait.until(ExpectedConditions.alertIsPresent());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Alert alert = DriverFactory.getInstance().getDriver().switchTo().alert();
		alert.sendKeys(string);
		alert.accept();

		
	}
	
	
}
