package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HotelRegistrationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		
		driver.get("http://tek-school.com/hotel/login?back=my-account");
		
		WebElement emailAddress = driver.findElement(By.xpath("//input[@id='email_create']"));
		emailAddress.sendKeys("kAlmas@test.com");

		WebElement createAnAccount = driver.findElement(By.xpath("//form[@id='create-account_form']//span[1]"));
		createAnAccount.click();
		
		
		
		WebElement title = driver.findElement(By.xpath("//input[@id='id_gender1']"));
		title.click();

		WebElement firstName = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		firstName.sendKeys("student");

		WebElement lastName = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
		lastName.sendKeys("tek");

		WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
		password.sendKeys("test001");

		WebElement days = driver.findElement(By.xpath("//select[@id='days']"));
		
		HotelRegistrationTest.select(days, "25");
		WebElement months = driver.findElement(By.xpath("//select[@id='months']"));
		HotelRegistrationTest.select(months, "1");
		
		WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
		HotelRegistrationTest.select(year, "2000");
		
		WebElement registerButton = driver.findElement(By.xpath("//span[contains(text(),'Register')]"));
		registerButton.click();

		ScreenShotUtility.takeScreenshot(driver);
		
	}
	
	public static void select(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);
	}

}
