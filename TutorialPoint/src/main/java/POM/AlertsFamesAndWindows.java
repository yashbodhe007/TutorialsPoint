package POM;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ReuseableMethods.ClickElement;

import ReuseableMethods.AlertHandling;

public class AlertsFamesAndWindows {
	
	@FindBy(xpath = "//*[text()=' Alerts, Frames & Windows ']")
	WebElement Alerts_Frames_And_Windows;
	@FindBy(xpath = "//h2[@id='headingThree']/following-sibling::div/descendant::li/a[text()=' Browser Windows']")
	WebElement Browser_Windows;
	@FindBy(xpath = "//h1[text()='Browser Windows']/following-sibling::button[text()='New Tab']")
	WebElement New_Tab;
	@FindBy(xpath = "//h1[text()='Browser Windows']/following-sibling::button[text()='New Window']")
	WebElement New_Window;
	@FindBy(xpath = "//h1[text()='Browser Windows']/following-sibling::button[text()='New Window Message']")
	WebElement New_Window_Message;
	@FindBy(xpath = "//body/div/descendant::h1")
	WebElement new_tab_header;
	@FindBy(xpath = "//body/main/descendant::h1")
	WebElement new_tab_header_message;
	@FindBy(xpath = "//body/div/descendant::h1")
	WebElement new_window_header;
	@FindBy(xpath = "//body/main/descendant::h1")
	WebElement new_window_header_message;
	@FindBy(xpath = "//body/div/descendant::h1")
	WebElement new_window_message_header;
	@FindBy(xpath = "//body/main/descendant::h1")
	WebElement new_window_message_message;
	
	@FindBy(xpath = "//h2[@id='headingThree']/following-sibling::div/descendant::li/a[text()=' Alerts']")
	WebElement alerts;
	@FindBy(xpath = "//h1[text()='Alerts']/../div/label[text()='Click Button to see alert']/following-sibling::button")
	WebElement to_see_alert_button;
	@FindBy(xpath = "//h1[text()='Alerts']/../div/label[text()='On button click, alert will appear after 5 seconds']/following-sibling::button")
	WebElement alert_will_appear_after_5_seconds_button;
	@FindBy(xpath = "//h1[text()='Alerts']/../div/label[text()='On button click, confirm box will appear']/following-sibling::button")
	WebElement confirm_box_will_appear_button;
	@FindBy(xpath = "//h1[text()='Alerts']/../div/label[text()='On button click, prompt box will appear']/following-sibling::button")
	WebElement prompt_box_will_appear_button;
	
	@FindBy(xpath = "//h2[@id='headingThree']/following-sibling::div/descendant::li/a[text()=' Frames']")
	WebElement frames;
	
	
	
	WebDriver driver;
	WebDriverWait wait ;
	JavascriptExecutor jse ;
	Actions actions;
	Select select;
	AlertHandling handlingAlert;
	Set<String> allTabs;
	List<String> allWindowsHandle;
	ClickElement CE;

	
	public AlertsFamesAndWindows(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		jse = (JavascriptExecutor) driver;
		this.actions =new Actions(driver);
		handlingAlert = new AlertHandling(driver);
		CE= new ClickElement(driver);

	}

	public void alertsFramesAndWindows() {
		driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		Alerts_Frames_And_Windows.click();
		browserWindows();
		alert();
		Alerts_Frames_And_Windows.click();

	}
	
	public void browserWindows() {
		CE.clickElement(Browser_Windows, 10, 2);
		CE.clickElement(New_Tab, 10, 2);
	

		allTabs = driver.getWindowHandles();
		allWindowsHandle = new ArrayList<>(allTabs);
		driver.switchTo().window(allWindowsHandle.get(1));
		System.out.println(new_tab_header.getText() + new_tab_header_message.getText());
		driver.close();
		driver.switchTo().window(allWindowsHandle.get(0));
		
		CE.clickElement(New_Window, 10, 2);

		allTabs = driver.getWindowHandles();
		allWindowsHandle = new ArrayList<>(allTabs);
		driver.switchTo().window(allWindowsHandle.get(1));
		System.out.println(new_window_header.getText() + new_window_header_message.getText());
		driver.close();
		driver.switchTo().window(allWindowsHandle.get(0));
		CE.clickElement(New_Window_Message, 10, 2);

		allTabs = driver.getWindowHandles();
		allWindowsHandle = new ArrayList<>(allTabs);
		driver.switchTo().window(allWindowsHandle.get(1));
		System.out.println(new_window_message_header.getText() + new_window_message_message.getText());
		driver.close();
		driver.switchTo().window(allWindowsHandle.get(0));
	}
	
	public void alert() {
		CE.clickElement(alerts, 10, 2);	
		handlingAlert.handleSimpleAlerts(to_see_alert_button);
		handlingAlert.handleSimpleAlerts(alert_will_appear_after_5_seconds_button);
		handlingAlert.handleConfimationAlerts(confirm_box_will_appear_button);
		handlingAlert.handlePromptAlerts(prompt_box_will_appear_button, "prompt alert handling");
	}
	
	public void frames() {
		CE.clickElement(frames, 10, 2);	
	}
	
	public void nestedFrames() {
		
	}
	
	public void modalDialogs() {
		
	}
	

}
