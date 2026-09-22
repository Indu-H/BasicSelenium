package FinalAssessment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demoappqspders1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/toggle?sublist=0");
		WebElement ref1=driver.findElement(By.xpath("(//span[contains(@class,'absolute left-[3px] top-[2px] translate-x-0 inline-block w-3 h-3 transition duration-300 ')])[1]"));
		WebElement ref2 = driver.findElement(By.xpath("(//span[contains(@class,'absolute left-[3px] top-[2px] translate-x-0 inline-block w-3 h-3 transition duration-300 ease-in-out transform bg-white border border-gray-300 rounded-full')])[2]"));
		WebElement ref3 = driver.findElement(By.xpath("(//span[contains(@class,'absolute left-[3px] top-[2px] translate-x-0 inline-block w-3 h-3 transition duration-300 ease-in-out transform bg-white border border-gray-300 rounded-full')])[3]"));
		WebElement ref4 = driver.findElement(By.xpath("(//span[contains(@class,'absolute left-[3px] top-[2px] translate-x-0 inline-block w-3 h-3 transition duration-300 ease-in-out transform bg-white border border-gray-300 rounded-full')])[4]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].removeAttribute('disabled');",ref1);
		ref1.click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].removeAttribute('disabled');",ref2);
		ref2.click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].removeAttribute('disabled');",ref3);
		ref3.click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].removeAttribute('disabled');",ref4);
		ref4.click();
		driver.findElement(By.id("togglers")).click();
		String text = driver.findElement(By.xpath("//p[contains(text(), 'Your Order has been successfully placed!')]")).getText();
		System.out.println(text);
		if(text.equals("Your Order has been successfully placed!"))
		{
			System.out.println("Your Order placed");
		}
		else
		{
			System.out.println("order not placed");
		}
		Thread.sleep(2000);
		
		

		

	}

}
