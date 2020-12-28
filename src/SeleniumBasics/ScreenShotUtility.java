package SeleniumBasics;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtility {

	
	//this method creates the proper format for the screenshot name
	public static String screenShotName() {
		
		Date date = new Date();
		String screenShot = date.toString().replace(":", "_").replace(" ", "_") + ".png";
		return screenShot;
	}
	
	public static void takeScreenshot(WebDriver driver) {
		
		String fileLocation = System.getProperty("user.dir") + "\\screenshots\\";
		String fileName = screenShotName();
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
		FileUtils.copyFile(file, new File(fileLocation+fileName));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
