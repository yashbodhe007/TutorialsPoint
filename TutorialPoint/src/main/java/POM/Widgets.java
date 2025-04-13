package POM;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.App;

import ReuseableMethods.AlertHandling;
import ReuseableMethods.ClickElement;
import ReuseableMethods.DropDownHandling;
import dev.failsafe.internal.util.Assert;
import org.testng.*;


public class Widgets {
	
	@FindBy(xpath = "//*[text()=' Widgets']")
	WebElement widgets;
	
	@FindBy(xpath = "//h2[@id='headingFour']/following-sibling::div/descendant::li/a[text()=' Accordion']")
	WebElement Accordion;
	@FindBy(xpath = "//h2[@id='headingTwentyOne']/button")
	WebElement What_is_Lorem_Ipsum;
	@FindBy(xpath = "//h2[@id='headingTwentyOne']/button/../following::div[1]/div/p")
	WebElement What_is_Lorem_Ipsum_text;
	@FindBy(xpath = "//h2[@id='headingTwentyTwo']/button")
	WebElement Why_do_we_use_it;
	
	@FindBy(xpath = "//h2[@id='headingFour']/following-sibling::div/descendant::li/a[text()=' Auto Complete']")
	WebElement Auto_Complete;
	@FindBy(xpath = "//input[@id='tags']")
	WebElement Tags_input;
	@FindBy(xpath = "(//div[text()='AppleScript'])[1]")
	WebElement AppleScript;
	
	@FindBy(xpath = "//h2[@id='headingFour']/following-sibling::div/descendant::li/a[text()=' Date Picker']")
	WebElement Date_Picker;
	@FindBy(xpath = "//div[text()='Select Date and Time']/following-sibling::div/input[@placeholder='Select date and time']")
	WebElement Select_date_and_Time;
	@FindBy(xpath = "//body/div[3]/div[1]/div/div/select")
	WebElement Select_month_from_dropdown;
	@FindBy(xpath = "//body/div[3]/div[1]/div/div/div/input")
	WebElement Enter_year;
	@FindBy(xpath = "//body/div[3]/div[2]/descendant::span[@aria-label='February 2, 2025']")
	WebElement Enter_todays_date;
	
	@FindBy(xpath = "//h2[@id='headingFour']/following-sibling::div/descendant::li/a[text()=' Slider']")
	WebElement Slider_tab;
	@FindBy(xpath = "//input[@id='ageInputId']")
	WebElement Slider;
	
	@FindBy(xpath = "//h2[@id='headingFour']/following-sibling::div/descendant::li/a[text()=' Progress Bar']")
	WebElement progressBar_tab;
	@FindBy(xpath = "//button[@id='startProgressTimer']")
	WebElement start_button;
	@FindBy(xpath = "//div[@role='progressbar']")
	WebElement progress_bar;

	@FindBy(xpath = "//h2[@id='headingFour']/following-sibling::div/descendant::li/a[text()=' Select Menu']")
	WebElement selectMenu_tab;
	@FindBy(xpath = "//input[@id='demo-multiple-select-input']")
	WebElement multiSelectDropdown;
	@FindBy(xpath = "//div[text()='Books']")
	WebElement multiSelectDropdownValue_Books;
	@FindBy(xpath = "//div[text()='Movies, Music & Games']")
	WebElement multiSelectDropdownValue_Movies_Music_and_Games;
	@FindBy(xpath = "//select[@id='inputGroupSelect03']")
	WebElement singleSelectDropdown;
	
	@FindBy(xpath = "//h2[@id='headingFour']/following-sibling::div/descendant::li/a[text()=' Horizontal Scroll']")
	WebElement horizontalScroll_tab;
	@FindBy(xpath = "//div[@class='horizan-scroll']")
	WebElement horizontal_Scroll;
	
	
	
	
	WebDriver driver;
	WebDriverWait wait ;
	JavascriptExecutor jse ;
	Actions actions;
	Select select;
	AlertHandling handlingAlert;
	ClickElement CE ;
	DropDownHandling dropdownhandling;
	Robot robot;
	public Widgets(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		jse = (JavascriptExecutor) driver;
		this.actions =new Actions(driver);
		handlingAlert = new AlertHandling(driver);
		CE = new ClickElement(driver);
		dropdownhandling = new DropDownHandling(driver);
		try {
			robot= new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void widgets() {
		driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
//		jse.executeScript("arguments[0].scrollIntoView(true);", widgets);
//		widgets.click();
		CE.clickElement(widgets, 2, 2);
		accordion();
		System.out.println("accordion done " );
//		widgets.click();
		CE.clickElement(widgets, 2, 2);
		autoComplete();
		System.out.println("autoComplete done " );
		datePicker();
		System.out.println("datePicker" );
		slider();
		System.out.println("slider" );
		progressBar();
		System.out.println("progressBar" );
		selectMenu();
		System.out.println("selectMenu" );
		horizontalScroll();
		System.out.println("horizontalScroll" );

		
	}
	
	public void accordion() {
//		wait.until(ExpectedConditions.elementToBeClickable(Accordion));
//		Accordion.click();
		CE.clickElement(Accordion, 2, 2);

//		What_is_Lorem_Ipsum.click();
		CE.clickElement(What_is_Lorem_Ipsum, 2, 2);
		System.out.println(What_is_Lorem_Ipsum_text.getText());
		
	}
	
	public void autoComplete() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Auto_Complete.click();
		CE.clickElement(Auto_Complete, 2, 2);
		Tags_input.sendKeys("a");
//		AppleScript.click();
		CE.clickElement(AppleScript, 2, 2);
	}
	
	public void datePicker() {
		CE.clickElement(Date_Picker, 2, 2);
		CE.clickElement(Select_date_and_Time, 2, 2);
//		CE.clickElement(Select_month_from_dropdown, 2, 2);
		dropdownhandling.dropDownByIndex(Select_month_from_dropdown, 1);
		System.out.println(dropdownhandling.getDropDownValue(Select_month_from_dropdown));
		Enter_year.clear();
		Enter_year.sendKeys("2025");
		CE.clickElement(Enter_todays_date, 2, 2);	
	}
	
	
	public void slider() {
		CE.clickElement(Slider_tab, 2, 2);
		int sliderWidth = Slider.getSize().getWidth();
		System.out.println(sliderWidth);
		
		actions.clickAndHold(Slider).moveByOffset(40, 90).release().perform();
		
		
		// keys class
//		actions.sendKeys(Slider, Keys.ARROW_RIGHT).perform();
		
		
		//java script executer
//		jse.executeScript("arguments[0].setAttribute('style' , 'right:90%;')", Slider);
		
		
		//robot class
//		int xccord = Slider.getLocation().getX();
//		int yccord = Slider.getLocation().getY();
//		robot.mouseMove(xccord, yccord);
//		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//		robot.mouseMove(xccord + 50 , yccord);
//		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		
		
	}
	public void progressBar() {
		CE.clickElement(progressBar_tab, 2, 2);
		CE.clickElement(start_button, 2, 2);
//		wait.until(driver1 ->progress_bar.getAttribute("style").contains("width: 100.02%;"));
		System.out.println(progress_bar.getAttribute("style"));
		
		
		
	}
	public void selectMenu() {
//		selectMenu_tab.click();
//		multiSelectDropdown.click();
//		multiSelectDropdownValue_Books.click();
//		multiSelectDropdownValue_Movies_Music_and_Games.click();
		CE.clickElement(selectMenu_tab, 2, 2);
		CE.clickElement(multiSelectDropdown, 2, 2);
		CE.clickElement(multiSelectDropdownValue_Books, 2, 2);
		CE.clickElement(multiSelectDropdownValue_Movies_Music_and_Games, 2, 2);
		CE.clickElement(singleSelectDropdown, 2, 2);
		dropdownhandling.dropDownByVisibleText(singleSelectDropdown, "Mrs.");
		

		
	}
	public void horizontalScroll() {
		CE.clickElement(horizontalScroll_tab, 2, 2);

		jse.executeScript("arguments[0].scrollLeft +=500;", horizontal_Scroll);
		jse.executeScript("arguments[0].scrollLeft -=200;", horizontal_Scroll);
		jse.executeScript("arguments[0].scrollTop +=300;", horizontal_Scroll);
		
//		actions.moveToElement(horizontal_Scroll)
//		.clickAndHold().moveByOffset(300, 0).release().perform();
	}
	
	
	
	
	
	
	
	

}
