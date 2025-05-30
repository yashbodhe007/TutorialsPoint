package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ReuseableMethods.ClickElement;
import TestBase.DriverFactory;
import TestBase.testBase;

public class Homepage extends testBase{
	static By Category = By.xpath("//button[@class='flex-group dropdown__toggle button-reset']");
	
	
	ClickElement CE;
//	WebDriver driver;
	public Homepage() {

		CE = new ClickElement();		
	}

	public void selectCategory() {
		WebElement category = DriverFactory.getInstance().getDriver().findElement(Category);		
//		CE.clickElement(category, 5, 2);
		category.click();	
	}
	
	public void categoryValue(String category_value) {
		WebElement softwaretesting = DriverFactory.getInstance().getDriver().findElement(By.xpath("//li[@class='category-button' and contains(text(),'"+ category_value +"')]"));
		softwaretesting.click();
	}

	public void categoryValueOption(String Value_options) {
		WebElement softwaretesting = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div/ul/li/a[contains(text(),'"+ Value_options +"')]"));
		softwaretesting.click();	
	}
}
