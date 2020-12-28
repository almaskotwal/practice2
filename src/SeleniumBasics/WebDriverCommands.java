package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCommands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		// 1. set system property for chrome driver
		// 2. create object of chromDriver
		// 3. maximize brower
		// 4. set 30 seconds 
		// 5. navigate to TEK SCHOOL website
		// 6. get title
		// 7. refresh page
	
		String url = "http://tek-school.com/";
		
		System.setProperty("webdriver.chrom.driver", "C:\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicit wait before it throws an exception
		driver.manage().deleteAllCookies();
		driver.get(url);
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		driver.navigate().refresh();
		driver.navigate().to("http://tek-school.com/retail/");
		
		// hard stop and not recommended to use in automation
		Thread.sleep(3000);
		
		String testEnvPageTitle = driver.getTitle();
		System.out.println(testEnvPageTitle);

		Thread.sleep(3000);
		driver.navigate().back();
		
		Thread.sleep(3000);
		driver.navigate().forward();
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
