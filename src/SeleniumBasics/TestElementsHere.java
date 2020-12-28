package SeleniumBasics;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestElementsHere {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.get("http://tek-school.com/retail/");
		
		WebElement desktopsMenu = driver.findElement(By.xpath("//a[text()='Desktops']"));
		
		desktopsMenu.click();
		
		List<WebElement> listOfMenuItems = driver.findElements(By.xpath("//nav[@id='menu']/div[2]/ul/li[1]/div/div/ul/li"));
		
		for(WebElement item : listOfMenuItems) {
			
			try {
				
			if(item.getText().contains("Mac")) {
				item.click();
			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			}
		}
		
		WebElement addToCart = driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
		
		addToCart.click();
		
		WebElement shoppingCart	= driver.findElement(By.xpath("//a[contains(text(),'shopping cart')]"));
		shoppingCart.click();
		
		WebElement unitPrice = driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody/tr[1]/td[5]"));
		WebElement totalPrice = driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody/tr[1]/td[6]"));
		WebElement quantity = driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody/tr[1]/td[4]//input"));
		
		double price = Double.parseDouble(unitPrice.getText().substring(1));
		double total = Double.parseDouble(totalPrice.getText().substring(1));
		int quantityOfItems = Integer.parseInt(quantity.getAttribute("value"));
		
		System.out.println(price);
		System.out.println(total);
		System.out.println(quantityOfItems);
		
		System.out.println(quantityOfItems * price);
		
		
		
		
	}
		

		
		
	
	}


