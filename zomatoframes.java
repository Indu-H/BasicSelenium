package Demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class zomatoframes {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.zomato.com/bangalore/delivery");
		driver.findElement(By.cssSelector("[type='button']")).click();
		WebElement ele = driver.findElement(By.id("auth-login-ui"));
		driver.switchTo().frame(ele);
		driver.findElement(By.xpath("//input[@type=\"number\"]")).sendKeys("8902345688");
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//div[text()='Delivery']")).getText());


	}

}
