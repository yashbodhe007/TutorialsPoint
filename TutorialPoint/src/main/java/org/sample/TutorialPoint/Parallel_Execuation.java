package org.sample.TutorialPoint;

import org.testng.annotations.Test;

import POM.AlertsFamesAndWindows;
import POM.Driversetup;
import POM.Elements;
import POM.Forms;
import POM.Homepage;
import POM.Widgets;
import ReuseableMethods.ClickElement;
import TestBase.BrowserFactory;
import TestBase.DriverFactory;
import TestBase.testBase;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Parallel_Execuation extends testBase{
//	WebDriver driver;
	ClickElement CE;

  
  @Test
  public void Verify_Elements() {
	  System.out.println("1st Verify_Elements " + Thread.currentThread().getId());
	  Elements ELE = new Elements(driver);
	  ELE.elements();
	  System.out.println("Verify_Elements done");
  }
  
  @Test
  public void Verify_Forms() {
	  System.out.println("2nd Verify_Forms " + Thread.currentThread().getId());
	  Forms frm = new Forms(driver);
	  frm.Practise_Form();
	  System.out.println("Verify_Forms done");

  }
  
  @Test
  public void Verify_AlertsFamesAndWindows() {
	  System.out.println("3rd Verify_AlertsFamesAndWindows " + Thread.currentThread().getId());
	  AlertsFamesAndWindows AFW = new AlertsFamesAndWindows(driver);
	  AFW.alertsFramesAndWindows();	 
	  System.out.println("Verify_AlertsFamesAndWindows done");
  }
  
  @Test
  public void Verify_Widgets() {
	  System.out.println("4th Verify_Widgets " + Thread.currentThread().getId());
	  Widgets wid= new Widgets(driver);
	  wid.widgets();
	  System.out.println("Verify_Widgets done");

  }
  
  

  

}
