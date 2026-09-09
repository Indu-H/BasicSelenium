package Assessment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.facebook.com/");
       
        Thread.sleep(2000);
        //WebElement ele2 = driver.findElement(By.xpath("//label[text()='Email address or mobile number']"));
        WebElement ele2=driver.findElement(By.id("_R_1h6kqsqppb6amH1_"));
        Thread.sleep(2000);
        System.out.println("DOM Attribute before entering: "+ ele2.getDomAttribute("value"));
        System.out.println("DOM Property before entering: "+ ele2.getDomProperty("value"));
        Thread.sleep(2000);
        //WebElement ele4 = driver.findElement(By.xpath("//label[text()='Email address or mobile number']"));
        ele2.sendKeys("indu@gmail.com");
        Thread.sleep(2000);
        System.out.println("DOM Attribute after entering: " + ele2.getDomAttribute("value"));
        System.out.println("DOM Property after entering: "+ ele2.getDomProperty("value"));
        WebElement ele1 = driver.findElement(By.xpath("//span[text()='Create new account']"));
        System.out.println("Location of Create new account: "+ ele1.getLocation());
        ele1.click();
        Thread.sleep(2000);
        WebElement ele3 = driver.findElement(By.xpath("(//span[text()='Submit'])[2]"));
        System.out.println("Size of Submit button: "+ ele3.getSize());
        System.out.println("Color: "+ ele3.getCssValue("color"));

        System.out.println("Font size: "+ ele3.getCssValue("font-size"));

        System.out.println("Text align: " + ele3.getCssValue("text-align"));
    }
}
