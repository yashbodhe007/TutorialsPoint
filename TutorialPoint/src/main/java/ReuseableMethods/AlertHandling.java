package ReuseableMethods;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandling {
	
	
	
	WebDriver driver;
	WebElement element;
	WebDriverWait wait;
	
	public AlertHandling(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
				
	}

	
	public void handleSimpleAlerts(WebElement element) {
		//ok
		this.element=element;
		element.click();
		wait.until(ExpectedConditions.alertIsPresent());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		
		
		
	}
	public void handleConfimationAlerts(WebElement element) {
		//ok or cancel
		this.element=element;
		element.click();
		wait.until(ExpectedConditions.alertIsPresent());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().dismiss();
		
	}
	public void handlePromptAlerts(WebElement element, String string) {
		// text and button
		this.element=element;
		element.click();
		wait.until(ExpectedConditions.alertIsPresent());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Alert alert = driver.switchTo().alert();
		alert.sendKeys(string);
		alert.accept();

		
	}
	
	
}
