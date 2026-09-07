package Assessment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyntraDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.myntra.com/");
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("watches");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Watches For Women']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//span[text()='wishlist'])[1]")).click();
		//(//span[contains(@class,'product-wishlist')])[1]
		//wishlist.click();

		Thread.sleep(2000);

		
	}
}
