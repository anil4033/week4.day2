package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionScrollScreenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();//to Have MDV setup Chrome
		ChromeDriver driver = new ChromeDriver();// Initiating Chrome Driver
		driver.get("https://www.redbus.in/");// Launch Browser
		driver.manage().window().maximize(); //Maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //setting implicit wait

		WebElement findElement = driver.findElement(By.xpath("//a[text()='T & C']"));
		
		Actions builder1 = new Actions(driver);		
		
		builder1.scrollToElement(findElement).perform();
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Images/snap1.png");// To save in specific folder
		FileUtils.copyFile(source, dest);
		
		
	}
	

}
