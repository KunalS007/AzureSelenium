package feb;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pagination 
{
	@Test
	public void pagination() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://practice.expandtesting.com/dynamic-pagination-table");
		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		String columnName = driver.findElement(By.xpath("//*[contains(text(),'Extracurricular Activity')]")).getText();
		System.out.println(columnName);
		
		String activityName;
		WebElement cell;
//		boolean found = false;
		
		

		for (;;) { // infinite for-loop (controlled by break)

		    cell = driver.findElement(
		        By.xpath("//table[@id='example']//tbody/tr[2]/td[6]")
		    );
		    activityName = cell.getText().trim();

		    if (activityName.contains("Dance Club")) {
		        new Actions(driver).doubleClick(cell).perform();
		        break;
		    }

		    WebElement nextBtn = driver.findElement(By.xpath("//a[normalize-space()='Next']"));
		    if (nextBtn.getAttribute("class").contains("disabled")) {
		        System.out.println("Reached last page. Dance Club not found.");
		        break;
		    }

		    nextBtn.click();
		    Thread.sleep(800);
		}

		
//		do
//		{
//			cell = driver.findElement(By.xpath("(//table[@id='example']//tr[1])[2]//td[6]"));
//			activityName = cell.getText();
//			if(activityName.contains("Dance Club"))
//			{
//				found = true;
//				break;
//				
//			}
//			driver.findElement(By.xpath("//*[contains(text(),'Next')]")).click();
//			Thread.sleep(800);
//		}
//		while(true);
//		
//		if(found)
//		{
//			Actions action = new Actions(driver);
//			action.doubleClick(cell).perform();
//		}
//		else
//		{
//			System.out.println("Dance club not found");
//		}
	}
}
