package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandlingConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty( "webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		WebElement headerFrame = driver.findElement(By.xpath("//frame[@name='main']"));
		
		// we need to use .switchTo mehtod and .frame to switch to frame 
		driver.switchTo().frame(headerFrame);
		WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'Title bar')]"));
		System.out.println(header.getText());
		
		// in order to switch back to default frame we need to use below code 
		driver.switchTo().defaultContent();
		
		// Practice
		// switch to footer and print out the footer text then switch back to default frame. 
		// 10 min to write 4 lines of code/ 

	}
	
}


