package SeleniumBasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HotelAutomation {

	 String name;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// first we need to setup system.setProperty to execute ChromeDriver.exe
				System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
				// Create obj of ChromeDriver class
				WebDriver driver = new ChromeDriver();
				// setup window browser properties
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
				driver.get("http://tek-school.com/hotel/");
				// This is are elements we have in UI and we store them in WebElement
				WebElement hotelLocation = driver.findElement(By.xpath("//input[@id='hotel_location']"));
				WebElement selectHotelButton = driver.findElement(By.xpath("//button[@id='id_hotel_button']"));
				WebElement checkInTime = driver.findElement(By.xpath("//input[@id='check_in_time']"));
				WebElement checkOutTime = driver.findElement(By.xpath("//input[@id='check_out_time']"));
				WebElement searchButton = driver.findElement(By.xpath("//span[contains(text(),'Search Now')]"));
				// we will write codes for each UI element
				hotelLocation.sendKeys("California");
				selectHotelButton.click(); // once user click on dropdown list of hotels will be available
				// create an obj of a List with WebElement Data type and store athe dropdown
				// elements in that list
				List<WebElement> hotels = driver.findElements(By.xpath("//ul[@class='dropdown-menu hotel_dropdown_ul']/li"));
				// now we will write a for each loop to iterate inside the list
				for (WebElement hotel : hotels) {
					if (hotel.getText().equals("The Hotel Prime")) {
						hotel.click();
					}
				}
				checkInTime.click();
				// automate the calendar
				// easy way to automate a dataable
				List<WebElement> calendarDates = driver
						.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
				for (WebElement date : calendarDates) {
					if (date.getText().equals("23")) {
						date.click();
					}
				}
				Thread.sleep(5000);
				// checkOutTime.sendKeys("30-09-2020");
				// how to automate tables with iterating through rows and columns
				// we get the xpath with rows and columns index
				// we break the xpath and pass loop int for rows and columns
				// String calendarXpath =
				// "//table[@class='ui-datepicker-calendar']/tbody/tr[]/td[]";
				checkOutTime.click();
				String beforeXpath = "//table[@class='ui-datepicker-calendar']/tbody/tr[";
				String afterXPath = "]/td[";
				
				int weekDays = 7;
				int numWeeks = 5;
				
				String dayValue = null;
				for (int rowNumber = 1; rowNumber <= numWeeks; rowNumber++) {
					for (int colNumber = 1; colNumber <= weekDays; colNumber++) {
						dayValue= driver.findElement(By.xpath(beforeXpath+rowNumber+afterXPath+colNumber+"]")).getText();
						if (dayValue.equals("30")) {
							driver.findElement(By.xpath(beforeXpath+rowNumber+afterXPath+colNumber+"]")).click();
							break;
						}
					}
				}
				// takeScreenshot
				searchButton.click();
				
				
			}
	
		
		
		}
