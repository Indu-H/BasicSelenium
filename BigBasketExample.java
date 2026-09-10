ackage Demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigBasketExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.bigbasket.com/pb/boss/");
		driver.findElement(By.xpath("(//input[@placeholder='Search for Products...'])[2]")).sendKeys("pineapple");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()=' - Organically Grown']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Add' ]/ancestor::li[@class='sc-cXPBUD gVNfkF'])[3]")).click();
