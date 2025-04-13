package ReuseableMethods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownHandling {
	
	WebDriver driver;
	WebElement element;
	WebDriverWait wait;
	
	public DropDownHandling(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver, Duration.ofSeconds(2));
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
}
