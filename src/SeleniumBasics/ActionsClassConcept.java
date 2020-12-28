package SeleniumBasics;

import java.util.List;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.WebDriverUtility;

public class ActionsClassConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.get("http://tek-school.com/retail");
	
		
		WebElement desktopsMenu = driver.findElement(By.xpath("//a[text()='Desktops'"));
		
		desktopsMenu.click();
		
	List<WebElement> listOfDesktopItems = driver.findElements(By.xpath("//nav[@id=\\\"menu\\\"]/div[2]/ul/li[1]/div/div/ul/li"));
		
		Actions actions = new Actions(driver);
		
		for(WebElement items : listOfDesktopItems) {
		try {
			if(items.getText().trim().contains("Mac")) {
			actions.moveToElement(items).build().perform(); 
				items.click();
			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			}
		}
		
	
		
		WebElement successMessage = driver.findElement(By.xpath(""));
		successMessage.click();
		System.out.println(successMessage.getText());
		
		driver.quit();
	}

}
