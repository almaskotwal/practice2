package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopUpConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		
		// in order to handle authentication pop-ups, 
		// we have to pass user name and password inside the URL
		// --->"//https://<username>:<password>@the-internet.herokuapp.com/basic_auth"
		
		String userName = "admin";
		String password = "admin";
		String url	= "http://" + userName + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth"; 
		System.out.println(url);
		driver.get(url);
	}

}
