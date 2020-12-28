package SeleniumBasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty( "webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
				
		driver.get("https://www.united.com/en/us");
		
		WebElement from = driver.findElement(By.xpath("//input[@id='bookFlightOriginInput']"));
		from.click();
		from.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		from.sendKeys("den");
		
		List<WebElement> listOfCities = driver.findElements(By.xpath("//ul[@id='bookFlightOriginInput-menu']/li/button"));
		
		for(WebElement city : listOfCities) {
			
			try {
				if(city.getText().trim().contains("Denver")) {
					city.click();
				}
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
				
			}
		}
		
		WebElement departDate = driver.findElement(By.xpath("//input[@id='DepartDate']"));
		WebElement returnDate = driver.findElement(By.xpath("//input[@id='ReturnDate']"));
		
		departDate.click();
		departDate.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		
		String leavingDate = "Nov 25";
		String comingBack = "Nov 28";
		
		JavaScriptExecutorConcept.selectCalendarDateWithJS(driver, leavingDate, departDate);
		
		returnDate.click();
		returnDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		
		JavaScriptExecutorConcept.selectCalendarDateWithJS(driver, comingBack, returnDate);
		
		Practice.PickDateWithJS();
		
		
	}

	public static void PickDateWithJS() {
		driver.findElement(By.xpath("//input[@id='DepartDate']")).click();
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("document.getElementById('DepartDate').value='14'");
	}
	
}
