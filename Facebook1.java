package Assessment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//span[text()='Create new account']")).click();
		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.id("_R_1cl2p4jikacppb6amH1_"));
		WebElement ele2 = driver.findElement(By.id("_R_1kl2p4jikacppb6amH1_"));
		System.out.println(ele1.getLocation());
		System.out.println(ele2.getLocation());
		if (ele1.getLocation().getY() == ele2.getLocation().getY()) 
		{
            System.out.println("aligns on same line");
        } 
		else 
		{
            System.out.println("not aligned on same line");
        }
        
	}

}
