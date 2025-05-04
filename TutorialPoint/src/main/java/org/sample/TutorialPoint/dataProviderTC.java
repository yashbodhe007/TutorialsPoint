package org.sample.TutorialPoint;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.Forms;
import ReuseableMethods.ExcelOperations;
import TestBase.testBase;

public class dataProviderTC extends testBase {
	
	
	ExcelOperations excel = new ExcelOperations("Selenium - Automation Practice");

	

	
  @Test (dataProvider = "vehData")
  public void Verify_Forms(Object obj1) throws Exception {
	  HashMap<String, String> testData = (HashMap<String, String>) obj1;
	  System.out.println("Verify_Forms " + Thread.currentThread().getId());
	  Forms frm = new Forms();
	  frm.Practise_Form(testData);
	  System.out.println("Verify_Forms done");
	  System.out.println("Verify_Forms close " + Thread.currentThread().getId());
  }
	
	
	@DataProvider (name = "vehData")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i-1][0] = testData;
		}
		return obj;
		
	}

}
