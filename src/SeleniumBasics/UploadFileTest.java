package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

		String url = "http://xndev.com/display-image";
		
		driver.get(url);
		
		
		WebElement chooseFile = driver.findElement(By.xpath("//div[@class='entry-content clearfix']//input"));
		
		String filePath = "C:\\Users\\Almas Kotwal\\Desktop\\Docs\\bald-eagle.jpg";
		
		chooseFile.sendKeys(filePath);
		
		ScreenShotUtility.takeScreenshot(driver);
		
	
	}

}
