package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTC {

	public static void main(String args[])
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shubhinigam\\eclipse-workspace\\TATOC\\drivers\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://hris.qainfotech.com/login.php");
		
		WebElement user=driver.findElement(By.id("txtUserName"));
		user.sendKeys("shubhinigam");
		
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys("Shubhi@321#");
		
		WebElement submit=driver.findElement(By.xpath("//input[@type='submit']"));
		System.out.println(submit);
		submit.click();
		
		
		
		
		
		
	}

}
