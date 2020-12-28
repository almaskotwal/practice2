package SeleniumBasics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlerConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.get("https://ksrtc.in/oprs-web/");
				
		WebElement crm = driver.findElement(By.xpath("//li[3]//a[1]//img[1]"));
		crm.click();
		
		Set<String> windowsHandles = driver.getWindowHandles();
		System.out.println("Number of windows: " + windowsHandles.size());
		
		System.out.println("Parent window: " + driver.getTitle());
		
		
		Iterator<String> iterator = windowsHandles.iterator();
		
		String parentWindow = iterator.next(); // stores window handle of parent window
		String childWindow = iterator.next();  // stores window handle of child window
//		
//		
//		//switch to child window using .switchTo method
		driver.switchTo().window(childWindow);
//		
//		
		System.out.println("Child window: " + driver.getTitle());
//
		driver.close();
		
		driver.switchTo().window(parentWindow);
		driver.quit();
		
		
				// How to handle window handles in Selenium?
				// How to switch from parent window to child window in with Selenium ?
				// in interviews we usually explain the process and then if needed we write code
				// Ans:
				// In order to switch from parent window to child window we need to use
				// windowHandles
				// first we create a Set of String and store windowHandels in that set.
				// then we create an iterator which is part of collection interface family to
				// travel in Set
				// then we use .next() method of Iterator to get parent and child window handles
				// then we use driver.switchto(). window() and pass child window handle
				// then driver will move from parent window to child window. once we done with
				// our UI actions
				// in that window we can switch back to parent window and end the execution.
		
		
		
		
	}

}
