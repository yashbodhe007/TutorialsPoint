package org.sample.TutorialPoint;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.AlertsFamesAndWindows;
import POM.Elements;
import POM.Forms;
import POM.Widgets;
import ReuseableMethods.ClickElement;
import ReuseableMethods.ExcelOperations;
import ReuseableMethods.ListenersImplementation;
import TestBase.testBase;



@Listeners(ListenersImplementation.class)
public class Parallel_Execuation extends testBase{
	
//	  Elements ELE = new Elements();
//	  AlertsFamesAndWindows AFW = new AlertsFamesAndWindows();
//	  Forms frm = new Forms();
//	  Widgets wid= new Widgets();
	  
	  
  
  @Test
  public void Verify_Elements() throws Exception {
	  ExcelOperations excel = new ExcelOperations("Selenium - Automation Practice");
	  HashMap<String, String> testData = excel.getTestDataInMap(1);
	  System.out.println("Verify_Elements " + Thread.currentThread().getId());
	  Elements ELE = new Elements();
	  ELE.elements(testData);
	  System.out.println("Verify_Elements done");
	  System.out.println("Verify_Elements close " + Thread.currentThread().getId());
  }
  
  
  @Test
  public void Verify_AlertsFamesAndWindows()  {
	  System.out.println("Verify_AlertsFamesAndWindows " + Thread.currentThread().getId());
	  AlertsFamesAndWindows AFW = new AlertsFamesAndWindows();
	  AFW.alertsFramesAndWindows();	 
	  System.out.println("Verify_AlertsFamesAndWindows done");
	  System.out.println("Verify_AlertsFamesAndWindows close " + Thread.currentThread().getId());
  }
  
  @Test
  public void Verify_Forms() throws Exception {
	  ExcelOperations excel = new ExcelOperations("Selenium - Automation Practice");
	  HashMap<String, String> testData = excel.getTestDataInMap(2);
	  System.out.println("Verify_Forms " + Thread.currentThread().getId());
	  Forms frm = new Forms();
	  frm.Practise_Form(testData);
	  System.out.println("Verify_Forms done");
	  System.out.println("Verify_Forms close " + Thread.currentThread().getId());
  }
  
  @Test
  public void Verify_Widgets() {
	  System.out.println("Verify_Widgets " + Thread.currentThread().getId());
	  Widgets wid= new Widgets();
	  wid.widgets();
	  System.out.println("Verify_Widgets done");
	  System.out.println("Verify_Widgets close " + Thread.currentThread().getId());
  }
	 
}
