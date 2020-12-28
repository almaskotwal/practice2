package SeleniumBasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EmiratesAutomationPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty( "webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		
		// we need to open AA website
		
		driver.get("https://www.aa.com/homePage.do");
		
		
		WebElement from = driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.originAirport']"));
		
		from.clear();
	
		from.sendKeys("was");
		
		List<WebElement> myDeparture = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));
		
		for(WebElement city : myDeparture) {
			
			try {
				
				if(city.getText().trim().contains("was")) {
					JavaScriptExecutorConcept.clickElementWithJS(city, driver);
				}
				
			} catch (StaleElementReferenceException e) {
				e.getStackTrace();
			}
			city.click();

		}
		
		
	}

}

