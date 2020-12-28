package SeleniumBasics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowsersConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

		// we will use chromeOptions class to define some properties or options for
		// browser

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		
		driver.get("https://ksrtc.in/oprs-web/");
		

		System.out.println("This is Parent window:    " + driver.getTitle());

		WebElement crm = driver.findElement(By.xpath("//p[contains(text(),'CRM')]"));
		crm.click();

		Set<String> windowsHandles = driver.getWindowHandles();
		System.out.println(windowsHandles.size());

		// Iterator is interface provided by collection framework to loop in collections
		// such as set.
		
		
		
		Iterator<String> iterator = windowsHandles.iterator();
		
		
		String parentWindow = iterator.next(); // this we store window handle of parent window index zero in set
		String childwindow = iterator.next();// this we store window handle of child window index 1 in set

		// switch to child window using .switchTo method
		driver.switchTo().window(childwindow);

		System.out.println("This is Child window:   " + driver.getTitle());

		// write code to login
		// homework practice

		driver.close();

		driver.switchTo().window(parentWindow);
		System.out.println("This is Parent window:    " + driver.getTitle());

		driver.quit();

	}

}
