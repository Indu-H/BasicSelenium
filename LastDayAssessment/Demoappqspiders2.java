package FinalAssessment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demoappqspiders2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
		WebElement slider = driver.findElement(By.id("slide"));
		Actions act=new Actions(driver);
		Thread.sleep(3000);
		act.clickAndHold(slider).moveByOffset(200,0).release().perform();
		String text = driver.findElement(By.xpath("//h3[contains(text(),'Mens Cotton Jacket')]")).getText();
		System.out.println(text);
		if(text.equals("Mens Cotton Jacket..."))
		{
			System.out.println("found");
		}
		else
		{
			System.out.println("not found");
		}

	}

}
