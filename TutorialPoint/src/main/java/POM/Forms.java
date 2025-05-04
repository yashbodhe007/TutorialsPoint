package POM;

import java.time.Duration;
import java.util.HashMap;

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
import TestBase.DriverFactory;
import TestBase.testBase;

public class Forms extends testBase  {
	
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
	
	

	public Forms() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
		ddh = new DropDownHandling();
		CE= new ClickElement();
	}
	
	public void Practise_Form(HashMap<String, String> testData){
//		driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		CE.clickElement(forms, 5, 2);	
		CE.clickElement(Practice_Form, 5, 2);

		Frist_Name.sendKeys(testData.get("forms_practiseforms_Name"));
		Email.sendKeys(testData.get("forms_practiseforms_Email"));
		CE.clickElement(Gender_male, 2, 2);
		Mobile_No.sendKeys(testData.get("forms_practiseforms_Mobile"));
		Date_Of_Birth.sendKeys(testData.get("forms_practiseforms_Date of Birth"));
		Subject.sendKeys(testData.get("forms_practiseforms_Subjects"));
		CE.clickElement(Hobbies_Sports, 2, 2);
		choose_file.sendKeys("C:\\Users\\2282081\\OneDrive - Cognizant\\Desktop\\pom.xml");
		Current_address.sendKeys(testData.get("forms_practiseforms_Current Address"));

		ddh.dropDownByVisibleText(Choose_state_dropdown,"NCR");
		

		ddh.dropDownByValue(Choose_city_dropdown, "Lucknow");
		
		CE.clickElement(forms, 2, 2);	

	
		
		
	}

	
	
	
	
	
	
	
	
	
	

}
