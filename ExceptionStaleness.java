package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptionStaleness {

	public static void main(String[] args) {
		//to call WDM for driver
				WebDriverManager.chromedriver().setup();
						
				//Launch browser			
				ChromeDriver driver = new ChromeDriver();
						
				//Load URL
				driver.get("http://leaftaps.com/opentaps/control/login");
						
				//Maximize browser
						
				driver.manage().window().maximize();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
						
				//Enter Username and Password
						
				driver.findElement(By.id("username")).sendKeys("demosalesmanager");
				driver.findElement(By.id("password")).sendKeys("crmsfa");
						
				//Click Login button
				driver.findElement(By.className("decorativeSubmit")).click();
						
				//Click on CRMSFA Link
				driver.findElement(By.linkText("CRM/SFA")).click();
		        
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				
				driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
				
				String windowHandle = driver.getWindowHandle();
				
				driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
				
				Set<String> windowHandles = driver.getWindowHandles();
				System.out.println("how many handels" + windowHandles.size());
				
				List<String> lstWindowsHandles = new ArrayList<String>(windowHandles);
				
				String secondWindowHandel = lstWindowsHandles.get(1);
				
				driver.switchTo().window(secondWindowHandel);						
				
				try {
					driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
				} catch (Exception e1) {
					System.out.println("Failed due to Stalness of Element2");
					driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
				}
				
				driver.switchTo().window(windowHandle);
				
				driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();
				
				Set<String> windowHandles1 = driver.getWindowHandles();
				System.out.println("how many handels" + windowHandles1.size());
				
				List<String> lstWindowsHandles1 = new ArrayList<String>(windowHandles1);
				
				String secondWindowHandel1 = lstWindowsHandles1.get(1);
				
				driver.switchTo().window(secondWindowHandel1);
											
				try {
					driver.findElement(By.xpath("(//a[@class='linktext'])[6")).click(); //Manually made an error in xpath so that it will fail and move to catch block
				} catch (Exception e) {
					System.out.println("Failed due to Stalness of Element2");
					driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
				}
				
				driver.switchTo().window(windowHandle);
				
				driver.findElement(By.xpath("//a[text()='Merge']")).click();
				
				Alert alert = driver.switchTo().alert();
				alert.accept();
				
				String title = driver.getTitle();
				
				if(title.equalsIgnoreCase("Merge Contacts | opentaps CRM")) {
					System.out.println("We are in expected page");			
				}else {
					System.out.println("We are not in expected page");		
				}
				
				

	}

}
