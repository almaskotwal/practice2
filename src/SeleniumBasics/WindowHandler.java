package SeleniumBasics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandler {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://ksrtc.in/oprs-web/");
		
		WebElement mitra = driver.findElement(By.xpath("//li[2]//a[1]//img[1]"));
		mitra.click();
		
		Set<String> windowsHandles = driver.getWindowHandles();
		
		System.out.println("Number of windows: " + windowsHandles.size());
		System.out.println("Parent window: " + driver.getTitle());

		Iterator<String> iterator = windowsHandles.iterator();
		
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		driver.switchTo().window(childWindow);
				
		WebElement english = driver.findElement(By.xpath("//a[contains(text(),'English')]"));
		english.click();
		
		Actions action = new Actions(driver);
		WebElement about = driver.findElement(By.xpath("//a[@title='About']"));
		
		action.moveToElement(about).build().perform();
		driver.switchTo().window(parentWindow);
		
		
		
	}

}
