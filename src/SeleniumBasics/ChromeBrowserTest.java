package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserTest {

	public static void main(String[] args) {

		
		// to execute the Chrome browser, we need to set system property
		// The value for the system.setProperty is the path to the chromedriver.exe file
		System.setProperty("webdriver.chrom.driver", "C:\\chromedriver.exe");
		
		// we need to create an object of chromedriver while calling Webdriver interface
		WebDriver driver = new ChromeDriver();
		
		// maximize window
		driver.manage().window().maximize();
		
		// to open any URL, we need to use the driver.get command and pass the URL as a string
		driver.get("http://tek-school.com/retail/");
		
		// to get the title of the page, we will use driver.getTitle and store it in a String
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		// if title is TEK SCHOOL, browser should close, if not browser should remain open
		
		if(pageTitle.equals("TEK SCHOOL")) {
			driver.close();
		} else {
			System.out.println("Page title does not match");
		}
		

	}

}
