package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitNumWindowHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();//to Have MDV setup Chrome
		ChromeDriver driver = new ChromeDriver();// Initiating Chrome Driver
		driver.get("http://www.leafground.com/pages/Window.html");// Launch Browser
		driver.manage().window().maximize(); //Maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //setting implicit wait

		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		
		//Explicitly wait
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
				
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		
		System.out.println("workdone");
		
		driver.quit();
		
	}

}
