package org.sample.TutorialPoint;

import java.awt.Robot;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import POM.Driversetup;
import POM.Elements;
import POM.Forms;
import POM.Widgets;
import ReuseableMethods.ClickElement;

	


public class testing {
	
	private WebDriver driver;
	

	
	

	@Test(priority = 1)
	public void openBrowser() {
		System.out.println("Browser Open");
		driver = Driversetup.setup();
	}
	
	@Test(priority = 2)
	public void test() {
		driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
		Widgets wid = new Widgets(driver);
		Elements ele = new Elements(driver);
		ele.Check_Box();
		
		
		
		
		
		
		
	}
	
	
}


