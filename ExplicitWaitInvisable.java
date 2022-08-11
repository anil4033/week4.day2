package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitInvisable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();//to Have MDV setup Chrome
		ChromeDriver driver = new ChromeDriver();// Initiating Chrome Driver
		driver.get("http://www.leafground.com/pages/disapper.html");// Launch Browser
		driver.manage().window().maximize(); //Maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //setting implicit wait

		WebElement invisable = driver.findElement(By.id("btn"));
		
		//Explicitly wait
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.invisibilityOf(invisable));
		
		String text = driver.findElement(By.xpath("//button[@id='btn']/following::p")).getText();
		
		System.out.println(text);
	}

}
