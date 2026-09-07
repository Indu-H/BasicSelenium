package Assessment1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class SauceDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		//span[text()='Products']
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement ele1=driver.findElement(By.xpath("//footer[@class='footer']"));//footer[@class='footer']
		js.executeScript("arguments[0].scrollIntoView(false)",ele1);  
		Thread.sleep(2000);
		TakesScreenshot tks = (TakesScreenshot)driver;
		File src=tks.getScreenshotAs(OutputType.FILE); // src means temporary folder
		File dest = new File("./Sd/products-page.png"); //.means project and dest means permanent folder
        FileHandler.copy(src, dest);
		

	}

}
