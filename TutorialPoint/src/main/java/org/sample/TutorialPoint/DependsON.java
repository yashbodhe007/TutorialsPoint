package org.sample.TutorialPoint;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POM.AlertsFamesAndWindows;
import POM.Driversetup;
import POM.Elements;
import POM.Forms;
import POM.Homepage;
import POM.Widgets;

public class DependsON {
	private WebDriver driver;
	
	
	@Test
	public void openBrowser() {
		System.out.println("Browser Open");
		driver = Driversetup.setup();
		
	}
	@Test(dependsOnMethods = {"openBrowser"})
	public void selectCategory() {
		Homepage homepage = new Homepage(driver);
		homepage.selectCategory();	
		homepage.categoryValue("Software Testing");
		homepage.categoryValueOption("Selenium");
	}
	@Test(dependsOnMethods = {"selectCategory"})
	public void seleniumAutomationTesting() {
		Elements ELE = new Elements(driver);
		ELE.elements();
		Forms frm = new Forms(driver);
		frm.Practise_Form();
		AlertsFamesAndWindows AFW = new AlertsFamesAndWindows(driver);
		AFW.alertsFramesAndWindows();
		Widgets wid= new Widgets(driver);
		wid.widgets();
		
	}

}
