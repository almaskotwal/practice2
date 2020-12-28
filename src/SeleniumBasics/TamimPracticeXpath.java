package SeleniumBasics;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TamimPracticeXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. set property
				// 2. maximize
				// 3. timeouts
				// 4. get to the website
				// 5. get title
				// 6. enter user name and password and click enter
				// 7. check whether my account element exists
				// 8. check the following elements to see whether they exist:
						// - addMyFirstAddress, orderHistoryAndDetails, myCreditSlips, myAddresses, myPersonalInformation
				// 9. find all links in the page

		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.get("http://tek-school.com/hotel/login?back=my-account");
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
		
		userName.sendKeys("sdet2020@tekschool.us");
		password.sendKeys("welcome1");
		loginBtn.click();
		
		WebElement myFirstAddress = driver.findElement(By.xpath("//a[@title='Add my first address']"));
		WebElement orderHistory = driver.findElement(By.xpath("//a[@title='Orders']"));
		WebElement myCreditSlips = driver.findElement(By.xpath("//a[@title='Credit slips']"));
		WebElement myAddress = driver.findElement(By.xpath("//a[@title='Addresses']"));
		WebElement myPersonalInfo = driver.findElement(By.xpath("//a[@title='Information']"));
		
		System.out.println(myFirstAddress.isDisplayed());
		System.out.println(orderHistory.isDisplayed());
		System.out.println(myCreditSlips.isDisplayed());
		System.out.println(myAddress.isDisplayed());
		System.out.println(myPersonalInfo.isDisplayed());
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println("There are " +  allLinks.size() + " links in this page.");
		
		for (int i = 0; i < allLinks.size(); i++) {
			System.out.println(allLinks.get(i).getText());
			
			}

		}
	}

