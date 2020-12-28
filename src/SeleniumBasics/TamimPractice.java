package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TamimPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.drive", "c:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		String amazonURL = "http://amazon.com";
		
		driver.get(amazonURL);
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		driver.navigate().refresh();
		driver.navigate().to("https://www.amazon.com/gp/bestsellers/?ref_=nav_cs_bestsellers");
		Thread.sleep(3000);
		
		driver.navigate().back();
		driver.close();
		
	}

}
