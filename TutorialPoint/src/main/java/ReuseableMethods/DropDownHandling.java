package ReuseableMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.DriverFactory;
import TestBase.testBase;

public class DropDownHandling extends testBase {
	
	
	WebElement element;
	
	public DropDownHandling() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
//		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void dropDownByVisibleText(WebElement dropdownelement , String Text) {
		wait.until(ExpectedConditions.visibilityOf(dropdownelement));
		Select select = new Select(dropdownelement);
		select.selectByVisibleText(Text);
	}
	
	public void dropDownByValue(WebElement dropdownelement, String value) {
		wait.until(ExpectedConditions.visibilityOf(dropdownelement));
		Select select = new Select(dropdownelement);
		select.selectByValue(value);
	}
	
	public void dropDownByIndex(WebElement dropdownelement , int index) {
		wait.until(ExpectedConditions.visibilityOf(dropdownelement));
		Select select = new Select(dropdownelement);
		select.selectByIndex(index);
	}
	
	public String getDropDownValue(WebElement dropdownelement) {
		Select select = new Select(dropdownelement);
		return select.getFirstSelectedOption().getText();
	}	
	
	
	public List<String> getDropdownOptions(WebElement dropdownelement) {
		Select select = new Select(dropdownelement);
		
		List<WebElement> list_of_webelement = select.getOptions();
		List<String> actualContents  = new ArrayList<String>();
		
		for (WebElement webelement : list_of_webelement) {
			actualContents.add(webelement.getText());
		}
		return actualContents;
		
	}
	
}
