package POM;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ReuseableMethods.ClickElement;
import TestBase.testBase;
import io.reactivex.rxjava3.functions.Action;




public class Elements { 
	
	
	By Selenium_Automation_practise = By.xpath("//div[@class=\"toc-nav\"]/ul/li/a[contains(text(),'Selenium - Automation Practice')]");
	
	
//	By Elements = By.xpath("//*[text()=' Elements']");
	@FindBy(xpath = "//*[text()=' Elements']")
	WebElement Elements;
	
	
	@FindBy(xpath = "//h2[@id='headingOne']/following-sibling::div/descendant::li/a[text()=' Text Box']")
	WebElement Text_Box;
	@FindBy(xpath = "//input[@id='fullname']")
	WebElement Full_Name;
	@FindBy(xpath = "//input[@id='email']")
	WebElement Email;
	@FindBy(xpath = "//textarea[@id='address']")
	WebElement Current_Address;
	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit_button;
	

	@FindBy(xpath = "//h2[@id=\"headingOne\"]/following-sibling::div/descendant::li/a[text()=' Check Box']")
	WebElement check_box;
	@FindBy(xpath = "//li[@id='bs_1']/span[@class='plus']")
	WebElement plus_main_level1;
	@FindBy(xpath = "//li[@id='bf_1']/span[@class='plus']")
	WebElement plus_sub_level1;
	@FindBy(xpath = "//span[text()='Last Level 1 ']/preceding-sibling::input")
	WebElement checkbox_last_level_1;
	@FindBy(xpath = "//span[text()='Sub Level 2']/preceding-sibling::input")
	WebElement checkbox_sub_level_2;
	@FindBy(xpath = "//span[text()='Main Level 2 ']/preceding-sibling::input")
	WebElement checkbox_main_level_2;
	
	@FindBy(xpath = "//h2[@id='headingOne']/following-sibling::div/descendant::li/a[text()=' Radio Button']")
	WebElement radio_button;
	@FindBy(xpath = "//h1[text()='Radio Button']/../div/label[text()='Yes']/preceding-sibling::input")
	WebElement radio_button_yes;
	@FindBy(xpath = "//h1[text()='Radio Button']/../div/label[text()='Yes']/preceding-sibling::input/../following::div[@id='check']")
	WebElement radio_button_yes_message;
	
	@FindBy(xpath = "//h2[@id='headingOne']/following-sibling::div/descendant::li/a[text()=' Web Tables']")
	WebElement web_tables;
	@FindBy(xpath = "//h1[text()='Web Tables']/following::div//tbody/tr")
	List<WebElement> web_tables_rows;
	
	@FindBy(xpath = "//h2[@id='headingOne']/following-sibling::div/descendant::li/a[text()=' Buttons']")
	WebElement buttons;
	@FindBy(xpath = "//button[text()='Click Me']")
	WebElement click_me;
	@FindBy(xpath = "//*[@id='welcomeDiv']")
	WebElement click_me_message;
	@FindBy(xpath = "//button[text()='Right Click Me']")
	WebElement right_click_me;
	@FindBy(xpath = "//button[text()='Double Click Me']")
	WebElement double_click_me;
	@FindBy(xpath = "//*[@id='doublec']")
	WebElement double_click_me_message;
	
	@FindBy(xpath = "//h2[@id='headingOne']/following-sibling::div/descendant::li/a[text()=' Links']")
	WebElement links;
	@FindBy(xpath = "//a[text()='Home']")
	WebElement home;
	
	@FindBy(xpath = "//h2[@id='headingOne']/following-sibling::div/descendant::li/a[text()=' Upload and Download']")
	WebElement upload_and_download;
	@FindBy(xpath = "//a[text()='Download']")
	WebElement download_button;
	@FindBy(xpath = "//input[@id='uploadFile']")
	WebElement choose_file_button;
	
	@FindBy(xpath = "//h2[@id='headingOne']/following-sibling::div/descendant::li/a[text()=' Dynamic Properties']")
	WebElement dynamic_properties;
	@FindBy(xpath = "//button[@id='colorChange']")
	WebElement color_change;
	@FindBy(xpath = "//button[@id='visibleAfter']")
	WebElement visible_after_5_seconds;
	
	
	
	WebDriver driver;
	WebDriverWait wait ;
	JavascriptExecutor jse ;
	Actions actions;
	ClickElement CE;
	public Elements(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		jse = (JavascriptExecutor) driver;
		this.actions =new Actions(driver);
		CE= new ClickElement(driver);

		
	}
	
	public void elements() {
		driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
//		WebElement SeleniumAutomationPractise = driver.findElement(Selenium_Automation_practise);
		Actions actions = new Actions(driver);
//        actions.moveToElement(SeleniumAutomationPractise).perform();
		
//		jse.executeScript("arguments[0].scrollIntoView(true);", SeleniumAutomationPractise);
//		SeleniumAutomationPractise.click();
		
		
		Text_box();
		System.out.println("Text_box");
		Check_Box();
		System.out.println("Check_Box");
		Web_Tables();
		System.out.println("Web_Tables");
		Buttons();
		System.out.println("Buttons");
		Links();
		System.out.println("Links");
		Upload_and_Download();
		System.out.println("Upload_and_Download");
		Dynamic_Properties();
		System.out.println("Dynamic_Properties");
	}
	
	public void Text_box() {
		
		CE.clickElement(Elements, 2, 2);
		CE.clickElement(Text_Box, 2, 2);
		Full_Name.sendKeys("yash bodhe");
		Email.sendKeys("Yash@gmail.com");
		Current_Address.sendKeys("pune          jwehbf           cihwekbfc              ");
		Password.sendKeys("12345abced");
		CE.clickElement(submit_button, 10, 2);

	}
	
	public void Check_Box() {
		
		CE.clickElement(Elements, 2, 2);
		CE.clickElement(check_box, 2, 2);
		CE.clickElement(plus_main_level1, 2, 2);
		CE.clickElement(plus_sub_level1, 2, 2);
		CE.clickElement(checkbox_last_level_1, 2, 2);
		CE.clickElement(checkbox_sub_level_2, 2, 2);
		CE.clickElement(checkbox_main_level_2, 2, 2);
		
//		Elements.click();
//		check_box.click();
//		plus_main_level1.click();
//		plus_sub_level1.click();
//		checkbox_last_level_1.click();
//		checkbox_sub_level_2.click();
//		checkbox_main_level_2.click();
		
	}
	
	public void Radio_Button() {
		CE.clickElement(radio_button, 2, 2);
		CE.clickElement(radio_button_yes, 2, 2);
		System.out.println(radio_button_yes_message.getText());
	
	}
	
	public void Web_Tables() {
		CE.clickElement(web_tables, 2, 2);		
		for(int i=0  ; i<web_tables_rows.size() ; i++  ) {
			List<WebElement> row_datas = web_tables_rows.get(i).findElements(By.tagName("td"));
			System.out.println("Rows " + (i+1) + " data");
			
			for(WebElement row_data : row_datas) {
				System.out.println(row_data.getText() + "|");
			}
			System.out.println();	
		}
	}
	
	public void Buttons() {
		CE.clickElement(buttons, 2, 2);
		CE.clickElement(click_me, 2, 2);
		System.out.println(click_me_message.getText());
		actions.doubleClick(double_click_me).perform();
		System.out.println(double_click_me_message.getText());
	}
	
	public void Links() {
		CE.clickElement(links, 2, 2);
		String paranrWinID= driver.getWindowHandle();
		System.out.println("current url: "  + driver.getCurrentUrl() + "current handel" + paranrWinID);
		CE.clickElement(home, 2, 2);

		Set<String> allWinIDs = driver.getWindowHandles();
		System.out.println("All ids are: ");
		for(String allWinID: allWinIDs) {
			System.out.println(allWinID);
		}
		Iterator<String> itr = allWinIDs.iterator();
		while (itr.hasNext()) {
			String childWinID = itr.next();
			if(!paranrWinID.equalsIgnoreCase(childWinID)) {
				driver.switchTo().window(childWinID);
				System.out.println("child url: "  + driver.getCurrentUrl() + "child handel" + childWinID + "child title" + driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(paranrWinID);
	}

	
	public void Upload_and_Download() {
		CE.clickElement(upload_and_download, 2, 2);
		choose_file_button.sendKeys("C:\\\\Users\\\\2282081\\\\OneDrive - Cognizant\\\\Desktop\\\\pom.xml");
		
//		jse.executeScript("arguments[0].click();", choose_file_button);
		
//		choose_file_button.click();
		//ctrl+c
//		StringSelection file_Path = new StringSelection("C:\\Users\\2282081\\OneDrive - Cognizant\\Desktop\\pom.xml");
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file_Path, null);
		
		//ctrl+v
//		try {
//			Robot rb = new Robot();
//			rb.keyPress(KeyEvent.VK_CONTROL);
//			rb.keyPress(KeyEvent.VK_V);
//			rb.keyRelease(KeyEvent.VK_V);
//			rb.keyRelease(KeyEvent.VK_CONTROL);
//			rb.keyPress(KeyEvent.VK_ENTER);
//			rb.keyRelease(KeyEvent.VK_ENTER);
//		} catch (Exception e) {
//			System.out.println("flie upluad fail");
//			System.out.println(e);		CE.clickElement(dynamic_properties, 2, 2);


//		}
//	

	}
	
	
	public void Dynamic_Properties() {
		
//		dynamic_properties.click();
		CE.clickElement(dynamic_properties, 2, 2);
//		color_change.click();
		CE.clickElement(color_change, 2, 2);
		wait.until(ExpectedConditions.visibilityOf(visible_after_5_seconds));
		System.out.println(visible_after_5_seconds.getText());
//		Elements.click();
		
	}
}
