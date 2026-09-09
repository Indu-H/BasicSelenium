package Assessment2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class DemoWebShop {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		//driver.findElement(By.xpath("(//a[text()='14.1-inch Laptop'])[2]"));
		//driver.findElement(By.linkText("/141-inch-laptop"));
		//driver.findElement(By.id("ui-id-3")).click();
		driver.findElement(By.id("small-searchterms")).sendKeys("laptop");
		driver.findElement(By.xpath("//li[@class='ui-menu-item']"));
		WebElement ele1=driver.findElement(By.xpath("(//input[@value='Add to cart'])[2]"));
        System.out.println(ele1.getSize());
        ele1.click();
        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
        WebElement w1=driver.findElement(By.xpath("//input[@name='removefromcart']"));
        System.out.println(w1.isSelected());
        System.out.println(w1.getRect().getX());
        System.out.println(w1.getRect().getY());
        System.out.println(w1.getRect().getHeight());
        System.out.println(w1.getRect().getWidth());
		if (driver.findElements(By.xpath("//div[@class='message']")).size() > 0) {
		    System.out.println("Before clicking: Alert message is displayed");
		} else {
		    System.out.println("Before clicking: Alert message is not displayed");
		}
		driver.findElement(By.xpath("//input[@value='Apply coupon']")).click();
		WebElement alertmsg = driver.findElement(By.xpath("//div[@class='message']"));

		if (alertmsg.isDisplayed()) {
		    System.out.println("After clicking Apply Coupon: Alert message is displayed");
		} else {
		    System.out.println("After clicking Apply Coupon: Alert message is not displayed");
		}
		Thread.sleep(3000);
//        WebElement w2=driver.findElement(By.xpath("//input[@value='Apply coupon']"));
//        
//        System.out.println(w2.isDisplayed());
//        w2.click();
//        System.out.println(w2.isDisplayed());
        WebElement laptop=driver.findElement(
			    By.xpath("(//img[@alt='Picture of 14.1-inch Laptop'])[2]")
			);

		File src=laptop.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ww/laptop.png");
		FileHandler.copy(src, dest);
		Thread.sleep(3000);
		driver.quit();
		
        
	}

}
