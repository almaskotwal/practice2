package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://tek-school.com/real-estate/");
		 
		// We need to create and object of WebDriverWait in order to explicit wait
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		WebElement findButton = driver.findElement(By.xpath("//a[@id='btnleft']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(findButton));
	
		
		findButton.click();
		
		// some other methods inside the ExpectedConditions class
		//ElementToBeSelected
		//titles
		//visibilityOf()
		//titleContains()
		//FrameTobeAvailableandSwitchTo();
	}

}
