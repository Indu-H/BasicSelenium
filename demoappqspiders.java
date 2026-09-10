package Assessment3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoappqspiders {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
		driver.findElement(By.xpath("//div[@class='react-datepicker__input-container']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='2']")).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//input[@placeholder='Select A Date']"));
		String actualdate = ele.getAttribute("value");
		if(actualdate.equals("02/10/2026"))
		{
			System.out.println("selected date is correct");
		}
		else
		{
			System.out.println("wrong date is displayed");
		}
		
	}

}
