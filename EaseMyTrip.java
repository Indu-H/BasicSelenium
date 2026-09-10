package Assessment3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EaseMyTrip {

	public static void main(String[] args) throws InterruptedException {
		// step 1
				ChromeOptions options = new ChromeOptions();
				// step 2
				options.addArguments("--disable-notifications");
				//options.addArguments("--incognito");
				// step 3
				WebDriver driver=new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://www.easemytrip.com/");
				Thread.sleep(2000);
				driver.findElement(By.id("oway")).click();
				driver.findElement(By.id("pff")).click();
				driver.findElement(By.id("a_FromSector_show")).sendKeys("Bengaluru");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//p[@id='airportBengaluru']")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("ptt")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("a_Editbox13_show")).sendKeys("Delhi");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//p[@id='airportNew Delhi']")).click();
				Thread.sleep(2000);
				//driver.findElement(By.xpath("//input[@id='ddate' and @placeholder='Departure']")).click();
				driver.findElement(By.xpath("//li[text()='30' and @id='fiv_3_30/09/2026']")).click();
				driver.findElement(By.xpath("//p[text()='  Traveller & Class ' and @id='ptravlr']")).click();
				
				driver.findElement(By.xpath("(//button[@id='add'])[1]")).click();
				driver.findElement(By.id("spanEconomy")).click();
				driver.findElement(By.id("divSearchFlight")).click();
				String url=driver.getCurrentUrl();
				if(url.contains("flight-search/listing"))
				{
					System.out.println("flight result page is displayed");
				}
				else
				{
					System.out.println("flight page not displayed");
				}
				
				


	}

}
