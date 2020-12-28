package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		
		driver.get("http://tek-school.com/retail/");
		
		WebElement component = driver.findElement(By.xpath(" //a[@class='dropdown-toggle'][contains(text(),'Components')]"));
		component.click();
		
		ScreenShotUtility.takeScreenshot(driver);

		
		WebElement monitors = driver.findElement(By.xpath(" //ul[@class='list-unstyled']//a[contains(text(),'Monitors (2)')]"));
		monitors.click();
		
		
		WebElement sortBy = driver.findElement(By.xpath("//select[@id='input-sort']"));
		
		
		Select select = new Select(sortBy);
		
		//select by value
		//select by index
		//select by visible text
		
		select.selectByVisibleText("Name (A - Z)");
		
		
		
		WebElement show = driver.findElement(By.xpath("//select[@id='input-limit']"));
	
		Select selectShow = new Select(show);
		selectShow.selectByIndex(3);
		
		ScreenShotUtility.takeScreenshot(driver);
		
		
	}
}

