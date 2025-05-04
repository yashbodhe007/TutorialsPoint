package POM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import ReuseableMethods.AlertHandling;
import ReuseableMethods.ClickElement;
import TestBase.DriverFactory;
import TestBase.testBase;

public class AlertsFamesAndWindows extends testBase {
	
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
	
	
	Set<String> allTabs;
	List<String> allWindowsHandle;
	public AlertsFamesAndWindows() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
		CE= new ClickElement();	
		handlingAlert = new AlertHandling();

	}

	public void alertsFramesAndWindows() {
//		driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		CE.clickElement(Alerts_Frames_And_Windows, 5, 2);
//		test.log(Status.PASS, "clicked on Alerts_Frames_And_Windows ");
		wait.until(ExpectedConditions.visibilityOf(Browser_Windows));
		browserWindows();
		alert();
		CE.clickElement(Alerts_Frames_And_Windows, 5, 2);
	}
	
	public void browserWindows() {
		CE.clickElement(Browser_Windows, 5, 2);
		CE.clickElement(New_Tab, 5, 2);

		allTabs = DriverFactory.getInstance().getDriver().getWindowHandles();
		allWindowsHandle = new ArrayList<>(allTabs);

		System.out.println("Number of windows: " + allWindowsHandle.size());
		
		if (allWindowsHandle.size() > 1) {
			DriverFactory.getInstance().getDriver().switchTo().window(allWindowsHandle.get(1));
			System.out.println(new_tab_header.getText() + new_tab_header_message.getText());
			DriverFactory.getInstance().getDriver().close();
			DriverFactory.getInstance().getDriver().switchTo().window(allWindowsHandle.get(0));
		}
		else {
			System.out.println("Not enough windows open.");
		}

//		DriverFactory.getInstance().getDriver().switchTo().window(allWindowsHandle.get(1));
//		System.out.println(new_tab_header.getText() + new_tab_header_message.getText());
//		DriverFactory.getInstance().getDriver().close();
//		DriverFactory.getInstance().getDriver().switchTo().window(allWindowsHandle.get(0));
		
			
		
		CE.clickElement(New_Window, 5, 2);

		allTabs = DriverFactory.getInstance().getDriver().getWindowHandles();
		allWindowsHandle = new ArrayList<>(allTabs);
		
		if (allWindowsHandle.size() > 1) {
			DriverFactory.getInstance().getDriver().switchTo().window(allWindowsHandle.get(1));
			System.out.println(new_window_header.getText() + new_window_header_message.getText());
			DriverFactory.getInstance().getDriver().close();
			DriverFactory.getInstance().getDriver().switchTo().window(allWindowsHandle.get(0));
		}
		else {
			System.out.println("Not enough windows open.");
		}
		
		
//		DriverFactory.getInstance().getDriver().switchTo().window(allWindowsHandle.get(1));
//		System.out.println(new_window_header.getText() + new_window_header_message.getText());
//		DriverFactory.getInstance().getDriver().close();
//		DriverFactory.getInstance().getDriver().switchTo().window(allWindowsHandle.get(0));
		CE.clickElement(New_Window_Message, 5, 2);

		allTabs = DriverFactory.getInstance().getDriver().getWindowHandles();
		allWindowsHandle = new ArrayList<>(allTabs);

		if (allWindowsHandle.size() > 1) {
			DriverFactory.getInstance().getDriver().switchTo().window(allWindowsHandle.get(1));
			System.out.println(new_window_message_header.getText() + new_window_message_message.getText());
			DriverFactory.getInstance().getDriver().close();
			DriverFactory.getInstance().getDriver().switchTo().window(allWindowsHandle.get(0));
		}

		else {
			System.out.println("Not enough windows open.");
		}


		
		
		
		
//		DriverFactory.getInstance().getDriver().switchTo().window(allWindowsHandle.get(1));
//		System.out.println(new_window_message_header.getText() + new_window_message_message.getText());
//		DriverFactory.getInstance().getDriver().close();
//		DriverFactory.getInstance().getDriver().switchTo().window(allWindowsHandle.get(0));
	}
	
	public void alert() {
		CE.clickElement(alerts, 5, 2);	
		handlingAlert.handleSimpleAlerts(to_see_alert_button);
		handlingAlert.handleSimpleAlerts(alert_will_appear_after_5_seconds_button);
		handlingAlert.handleConfimationAlerts(confirm_box_will_appear_button);
		handlingAlert.handlePromptAlerts(prompt_box_will_appear_button, "prompt alert handling");
	}
	
	public void frames() {
		CE.clickElement(frames, 5, 2);	
	}
	
	public void nestedFrames() {
		
	}
	
	public void modalDialogs() {
		
	}
	

}
