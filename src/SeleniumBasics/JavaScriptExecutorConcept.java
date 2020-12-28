package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {
			public static void main(String[] args) {
				// TODO Auto-generated method stub

				System.setProperty( "webdriver.chrome.driver", "C://chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

				driver.get("http://tek-school.com/real-estate/");
				
				WebElement FindButton = driver.findElement(By.xpath("//a[@id='btnleft']"));
				sendKeysWithJS(driver, "100000", "priceMin");
				sendKeysWithJS(driver,"500000","priceMax");
				clickElementWithJS(FindButton, driver);
				ScreenShotUtility.takeScreenshot(driver);
				
			}

			// what is JavaScriptExecutor?
			// -- JSE is an interface
			// -- JSE provides methods to execute JavaScript through selenium Driver
			// --JSE to run javascript on the selected window or current page

			// Where we can use JSE ?
			// Elements that are Deprecated in HTML
			// Select Date from Calendar
			// Select from Dynamic dropdown
			// Select elements on JS pages.

			// Some mehtods we can use with JS executor are:
			// ScrollPageDown
			// CLickElement
			// Send keys or send values
			// Select date from Calendar
			// -- not used in most of times
			// highlight the text
			// getTitle of the page with JS
			// Refresh browser

			// Click on element Using JSExecutor

			public static void clickElementWithJS(WebElement element, WebDriver driver) {

				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].click();", element);

			}

			// Sendkeys using JSExecutor
			// to use SendKeys with JS Element needs to have ID attribute.

			public static void sendKeysWithJS(WebDriver driver, String value, String ElementID) {

				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("document.getElementById('" + ElementID + "').value='" + value + "'");
			}

			// Scroll down using JS executor

			public static void scrollPageDownWithJS(WebDriver driver) {
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			}

			// Select Calendar date with JS

			public static void selectCalendarDateWithJS(WebDriver driver, String date, WebElement element) {
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].setAttribute('value','" + date + "');", element);
			}

			
			
		}