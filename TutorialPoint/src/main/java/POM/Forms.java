package POM;

import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import POM.*;
import ReuseableMethods.ClickElement;
import ReuseableMethods.DropDownHandling;

public class Forms {
	
	@FindBy(xpath = "//*[text()=' Forms']")
	WebElement forms;
	@FindBy(xpath = "//h2[@id='headingTwo']/following-sibling::div/descendant::li/a[text()=' Practice Form']")
	WebElement Practice_Form;
	@FindBy(xpath = "//form[@id='practiceForm']/div/label[text()='Name:']/../div/input")
	WebElement Frist_Name;
	@FindBy(xpath = "//form[@id='practiceForm']/div/label[text()='Email:']/../div/input")
	WebElement Email;
	@FindBy(xpath = "//form[@id='practiceForm']/div/label[text()='Gender:']/../div/div/div/label[text()='Male']/preceding-sibling::input")
	WebElement Gender_male;
	@FindBy(xpath = "//form[@id='practiceForm']/div/label[text()='Mobile(10 Digits):']/../div/input")
	WebElement Mobile_No;
	@FindBy(xpath = "//form[@id='practiceForm']/div/label[text()='Date of Birth:']/../div/input")
	WebElement Date_Of_Birth;
	@FindBy(xpath = "//form[@id='practiceForm']/div/label[text()='Subjects:']/../div/input")
	WebElement Subject;
	@FindBy(xpath = "//form[@id='practiceForm']/div/label[text()='Hobbies:']/../div/div/div/label[text()='Sports']/preceding-sibling::input")
	WebElement Hobbies_Sports;
	@FindBy(xpath = "//form[@id='practiceForm']/div/label[text()='Picture:']/../div/div/input")
	WebElement choose_file;
	@FindBy(xpath = "//form[@id='practiceForm']/div/label[text()='Current Address:']/../div/textarea")
	WebElement Current_address;
	@FindBy(xpath = "//form[@id='practiceForm']/div/label[text()='State and City']/../div/div/select[@id='state']")
	WebElement Choose_state_dropdown;
	@FindBy(xpath = "//form[@id='practiceForm']/div/label[text()='State and City']/../div/div/select[@id='city']")
	WebElement Choose_city_dropdown;
	
	
	WebDriver driver;
	WebDriverWait wait ;
	JavascriptExecutor jse ;
	Actions actions;
	Select select;
	DropDownHandling ddh;
	ClickElement CE;


	public Forms(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		jse = (JavascriptExecutor) driver;
		this.actions =new Actions(driver);
		ddh = new DropDownHandling(driver);
		CE= new ClickElement(driver);

		
	
	}
	
	public void Practise_Form(){
		driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

//		wait.until(ExpectedConditions.visibilityOf(forms));
//		actions.moveToElement(forms).click().perform();
		CE.clickElement(forms, 10, 2);	
		CE.clickElement(Practice_Form, 10, 2);

		Frist_Name.sendKeys("yash");
		Email.sendKeys("yash@cogni.com");
		CE.clickElement(Gender_male, 10, 2);
		Mobile_No.sendKeys("1234567890");
		Date_Of_Birth.sendKeys("12/12/2012");
		Subject.sendKeys("maths");
		CE.clickElement(Hobbies_Sports, 10, 2);
		choose_file.sendKeys("C:\\Users\\2282081\\OneDrive - Cognizant\\Desktop\\pom.xml");
		Current_address.sendKeys("pune");
		
		
//		select = new Select(Choose_state_dropdown);
//		select.selectByVisibleText("NCR");
		ddh.dropDownByVisibleText(Choose_state_dropdown,"NCR");
		
		
//		select= new Select(Choose_city_dropdown);
//		select.selectByValue("Lucknow");
		ddh.dropDownByValue(Choose_city_dropdown, "Lucknow");
		
		CE.clickElement(forms, 10, 2);	

//		wait.until(ExpectedConditions.visibilityOf(forms));
//		actions.moveToElement(forms).click().perform();
	
		
		
	}

	
	
	
	
	
	
	
	
	
	

}
