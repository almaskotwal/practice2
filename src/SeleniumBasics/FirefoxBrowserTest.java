package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowserTest {

	public static void main(String[] args) {

		// Setup System Property
				System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				// Open tekschool.us website 
				driver.get("https://tekschool.us/");
		
	}

}
