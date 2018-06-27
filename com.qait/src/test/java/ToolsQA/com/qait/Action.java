package ToolsQA.com.qait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class Action {
	
	public WebDriver driver;

	public Action(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnBasicCourse() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Basic Course']")).click();		
	}
	
	public void verifyURL(String URL) {
		Assert.assertEquals(driver.getCurrentUrl(),URL);
	}
    
	public void greenBoxClick()
	{
		driver.findElement(By.className("greenbox")).click();;
		
	}
	
	public void verifyGreenBoxClick(String URL)
	{
		Assert.assertEquals(driver.getCurrentUrl(),URL);
	}
	
	public void RepaintBox()
	{
	
		WebElement mainframe = driver.findElement(By.id("main"));
		
		driver.switchTo().frame(mainframe);
		
		WebElement box1 = driver.findElement(By.xpath("//div[text()='Box 1']")); // Box 1 Identified
		
		String box1Color = box1.getAttribute("class"); // Storing Box1 color in a variable
		
		
		WebElement childframe = driver.findElement(By.id("child"));
	
		driver.switchTo().frame(childframe); // Switching to Child Frame
		

		while(true) {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(mainframe);
			WebElement childframe2 = driver.findElement(By.id("child"));
			driver.switchTo().frame(childframe2); // Switching to Child Frame
			WebElement box2 = driver.findElement(By.xpath("//div[text()='Box 2']")); // Box 2 Identified

			String box2Color = box2.getAttribute("class");
			
			if(box2Color.equalsIgnoreCase(box1Color)) {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(mainframe); // Switching to Main Frame
				break;
			}
			else {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(mainframe); // Switching to Main Frame
				WebElement repaintLink = driver.findElement(By.xpath("//a[text()='Repaint Box 2']"));
				repaintLink.click();
			}
		}
		
		
	}
	
	public void verifyPageAfterRepaint(String URL)
	{
		Assert.assertEquals(driver.getCurrentUrl(), URL);
		
	}
	
	
}
