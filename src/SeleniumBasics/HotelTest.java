package SeleniumBasics;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HotelTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty( "webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		
		driver.get("http://tek-school.com/hotel/");
		
		WebElement hotelLocation = driver.findElement(By.xpath("//input[@id='hotel_location']"));
		hotelLocation.clear();
		hotelLocation.click();
		hotelLocation.sendKeys("California");
		
		Thread.sleep(3000);
		
		List<WebElement> selectHotel = driver.findElements(By.xpath("//ul[@class='dropdown-menu hotel_dropdown_ul']/li"));
		
		for(WebElement hotelName : selectHotel) {

			try{
			
				if(hotelName.getText().trim().contains("Hotel California")) {
					JavaScriptExecutorConcept.clickElementWithJS(hotelName, driver);
						}
				
			} catch(StaleElementReferenceException e) {
				e.printStackTrace();
				hotelName.click();
			}
		}
		
		
	}

}
