package FinalAssessment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demoappqspiders3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToMultiple?sublist=3");
		WebElement LaptopCharger = driver.findElement(By.id("dragElement1"));
		LaptopCharger.click();
		WebElement LaptopCover = driver.findElement(By.id("dragElement3"));
		LaptopCover.click();
		WebElement LaptopAccessories = driver.findElement(By.id("dropZone2"));
		Actions act=new Actions(driver);
		act.dragAndDrop(LaptopCharger,LaptopAccessories).perform();
		Thread.sleep(3000);
		
		act.dragAndDrop(LaptopCover, LaptopAccessories).perform();
		Thread.sleep(3000);
		
		WebElement MobileAccessories = driver.findElement(By.id("dropZone1"));
		WebElement MobileCover = driver.findElement(By.id("dragElement2"));
		MobileCover.click();
		WebElement MobileCharger = driver.findElement(By.id("dragElement4"));
		MobileCharger.click();
		act.dragAndDrop(MobileCover, MobileAccessories).perform();
		Thread.sleep(3000);
		
		act.dragAndDrop(MobileCharger, MobileAccessories).perform();
		Thread.sleep(3000);
	
		

	}

}
