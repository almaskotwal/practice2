package SeleniumBasics;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {

	public static void main(String[] args) {

		
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	    driver.get("http://tek-school.com/hotel/login?back=my-account");
		
	    String title = driver.getTitle();
		System.out.println(title);
		
		WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='passwd']"));
		WebElement signInButton = driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
		
		emailField.sendKeys("sdet2020@tekschool.us");
		passwordField.sendKeys("welcome1");
		signInButton.click();
		
		WebElement myAccount = driver.findElement(By.xpath("//h1[@class='page-heading']"));
		System.out.println(myAccount.isDisplayed());
		
		WebElement addMyFirstAddress = driver.findElement(By.xpath("//a[@title='Add my first address']"));
		WebElement orderHistoryAndDetails = driver.findElement(By.xpath("//a[@title='Orders']"));
		WebElement myCreditSlips = driver.findElement(By.xpath("//a[@title='Credit slips']"));
		WebElement myAddresses = driver.findElement(By.xpath("//a[@title='Addresses']"));
		WebElement myPersonalInformation = driver.findElement(By.xpath("//a[@title='Information']"));
		
		System.out.println(addMyFirstAddress.isDisplayed());
		System.out.println(orderHistoryAndDetails.isDisplayed());
		System.out.println(myCreditSlips.isDisplayed());
		System.out.println(myAddresses.isDisplayed());
		System.out.println(myPersonalInformation.isDisplayed());
		
		// print list of all links available in this page.
		// links in a UI has tag a
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size()); // print size of list
		
		for (int i = 0; i < allLinks.size(); i++) {
			System.out.println(allLinks.get(i).getText());
			
			if(allLinks.get(i).getText().equals("About Us")){
				allLinks.get(i).click();
				break;
			}
		}
		
	
	}
}
