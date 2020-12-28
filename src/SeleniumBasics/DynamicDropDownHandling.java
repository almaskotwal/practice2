package SeleniumBasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicDropDownHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty( "webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		
		
		// we need to open AA website
		
		driver.get("https://www.aa.com");
		
		//store the "From" field element in WebElement datatype
		
		WebElement from = driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.originAirport']"));
		
		// click on this field or clear it directly
		
		from.click();
		from.clear();
		from.sendKeys("wash");
		Thread.sleep(3000);
		
			
		List<WebElement> departure = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));
		
		for(WebElement city : departure) {
			
			try {
				
			if(city.getText().trim().contains("WAS")) {
				JavaScriptExecutorConcept.clickElementWithJS(city, driver);
			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			}
			city.click();
		}
		
		
		WebElement toCityOrAirport = driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.destinationAirport']"));
		toCityOrAirport.clear();
		toCityOrAirport.sendKeys("Cal");
		Thread.sleep(5000);
		
		List<WebElement> arrival = driver.findElements(By.xpath("//ul[@id='ui-id-2']/li/a"));
		for (WebElement city : arrival) {
			try {
				if (city.getText().trim().contains("FAT")) {
					JavaScriptExecutorConcept.clickElementWithJS(city, driver);
				}
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
			city.click();
		}
		
		
		// store NumberofPassengers UI element in a WebElement 
		WebElement numberOfOPassengers = driver.findElement(By.xpath("//select[@id='flightSearchForm.adultOrSeniorPassengerCount']"));
		// we create obj of Select class for static dropdown. 
		Select select = new Select(numberOfOPassengers);
		select.selectByVisibleText("5");
		
		
		
		
		WebElement departureDate = driver.findElement(By.xpath("//input[@id='aa-leavingOn']"));
		WebElement arrivalDate = driver.findElement(By.xpath("//input[@id='aa-returningFrom']"));
		WebElement searchButton = driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']"));
		// departure date 
		String depDate = "09/25/2020";
		String retDate = "10/25/2020";
		JavaScriptExecutorConcept.selectCalendarDateWithJS(driver, depDate, departureDate);
		JavaScriptExecutorConcept.selectCalendarDateWithJS(driver, retDate, arrivalDate);
		Thread.sleep(3000);
		searchButton.sendKeys(Keys.ENTER);  // SendKeys(Keys.enter) does the same job as .click() method
		

		
		
	}
		
}


