package Demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountOfTextFields {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.instagram.com/accounts/emailsignup/");
		//List <WebElement> tfields = driver.findElements(By.xpath)
		List<WebElement> textfields = driver.findElements(By.tagName("input"));

	    System.out.println("Number of input fields: " + textfields.size());

	}

}
