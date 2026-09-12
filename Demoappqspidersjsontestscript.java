package DataDrivenTesting;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demoappqspidersjsontestscript {

	public static void main(String[] args) throws IOException, ParseException {
		FileReader fir=new FileReader("./src/test/resources/DDT/Demoappqspiders.json");
		JSONParser jsonparser = new JSONParser();
		Object obj=jsonparser.parse(fir);
		JSONObject json=(JSONObject)obj;
		System.out.println((json.get("browser").toString()));
		String URL = json.get("url").toString();
		String BROWSER = json.get("browser").toString();
		String NAME = json.get("Name").toString();
		String EMAIL = json.get("Email Id").toString();
		String PASSWORD = json.get("Password").toString();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(NAME);
		driver.findElement(By.id("email")).sendKeys(EMAIL);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//button[text()='Register']")).click();
		

	}

}
