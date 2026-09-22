package FinalAssessment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shopperstack {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.shoppersstack.com/products_page/139");
//		driver.findElement(By.id("electronics")).click();
//		driver.findElement(By.xpath("//a[text()='Cameras ']")).click();
		WebElement ele=driver.findElement(By.id("Check Delivery"));
		//WebElement ele=driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq')]"));
		//WebElement ele = driver.findElement(By.xpath("//fieldset[@class='MuiOutlinedInput-notchedOutline css-igs3ac']"));
		ele.sendKeys("583104");
		//ele.sendKeys("583104");
		WebElement cbutton = driver.findElement(By.id("Check"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.elementToBeClickable(cbutton));
	    cbutton.click();
		String text=driver.findElement(By.id("Check Delivery-helper-text")).getText();
		System.out.println(text);
		

	}

}
