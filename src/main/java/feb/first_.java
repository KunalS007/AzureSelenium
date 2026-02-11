package feb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class first_ 
{
	WebDriver driver;
	
	
	By clickOnSearchText = By.xpath("test");
	
	
	public first_(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement clickOnSearch()
	{
		return driver.findElement(clickOnSearchText);
	}
	
}
