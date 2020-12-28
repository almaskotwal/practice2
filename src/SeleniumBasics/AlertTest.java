package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

			System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

			
			driver.get("https://ksrtc.in/oprs-web/");
			
			WebElement searchBus = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block btn-booking']"));
			searchBus.click();
			
			
			
			
			// handle window pop ups (webpage based popup) 
			// we use Switch method then Alert method to accept or deny 
			// we can print out the alert text as string 
			
			String alertText = driver.switchTo().alert().getText();
			
			System.out.println(alertText);
			
			driver.switchTo().alert().getText()
			
			driver.close();
			
	}

}
