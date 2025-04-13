package org.sample.TutorialPoint;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import POM.AlertsFamesAndWindows;
import POM.Driversetup;
import POM.Elements;
import POM.Forms;
import POM.Homepage;
import POM.Widgets;


public class Test1 {
private WebDriver driver;

	//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	@Test(priority = 1)
	public void openBrowser() {
		System.out.println("Browser Open");
		driver = Driversetup.setup();
	}
	@Test(priority = 2)
	public void selectCategory() {
		Homepage homepage = new Homepage(driver);
		homepage.selectCategory();	
		homepage.categoryValue("Software Testing");
		homepage.categoryValueOption("Selenium");
	}
	@Test(priority = 3)
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
