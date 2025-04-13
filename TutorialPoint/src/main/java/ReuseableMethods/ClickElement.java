package ReuseableMethods;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ClickElement {
	
	
	
	WebDriver driver;
	WebDriverWait wait ;
	JavascriptExecutor jse ;
	Actions actions;
	public ClickElement(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		jse = (JavascriptExecutor) driver;
		this.actions =new Actions(driver);
	}
	
	
	public void clickElement(WebElement element, int timeout, int maxRetries) {
		int attempt = 0;
		
		while (attempt<maxRetries) {
			try {
				
				
				
				
				// 1.wait until element is visibile and clickable 
				wait.until(ExpectedConditions.visibilityOf(element));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				
				// 2. scroll to element
				jse.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
				
				//3. move to element
				actions.moveToElement(element).perform();
				
				//4. Click the element
				element.click();
//				Thread.sleep(5000);
				return;
				
				
			} catch (ElementClickInterceptedException e) {
				System.err.println("Click intercepted :" + e.getMessage());
				retryWithJsClick(element);
				
			} catch (TimeoutException e) {
				System.err.println("TImeout waiting for element:" + e.getMessage());
				retryWithJsClick(element);
				
			} catch (StaleElementReferenceException e) {
				System.err.println("Stale referencr: Retrying" + e.getMessage());
				retryWithJsClick(element);
				
			} catch (Exception e) {
				System.err.println("Expection while clicking:" + e.getMessage());
				retryWithJsClick(element);
				
			}
			attempt++;
				
		}
			System.err.println("Failed to click " + element + "after maxtries of " +maxRetries);
				
	}	
	
	private void retryWithJsClick(WebElement element) {
		try {
			jse.executeScript("arguments[0].click();",element);
			
		} catch (Exception e) {
			System.err.println("Failed JS click:" + e.getMessage());
		}
	}
	
}
	
	
	
	
	
	
	
	

