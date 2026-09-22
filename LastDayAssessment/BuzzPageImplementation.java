package PomImplementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import PomUtilities.OrangeHRMBuzzPage;
import PomUtilities.OrangeHRMHomePage;
import PomUtilities.OrangeHRMLoginPage;

public class BuzzPageImplementation {

public static void main(String[] args) throws IOException, InterruptedException {

    FileInputStream propertyFile =
            new FileInputStream("./src/test/resources/DDT/Day12OrangeHRM.properties");

    java.util.Properties properties = new java.util.Properties();

    properties.load(propertyFile);

    String url = properties.getProperty("url");
    String username = properties.getProperty("username");
    String password = properties.getProperty("password");

    propertyFile.close();

    FileInputStream excelFile =
            new FileInputStream("./src/test/resources/DDT/Buzztextfield.xlsx");

    Workbook workbook = WorkbookFactory.create(excelFile);

    Sheet sheet = workbook.getSheetAt(0);

    Row row = sheet.getRow(1);

    DataFormatter formatter = new DataFormatter();

    String Buzzfield = formatter.formatCellValue(row.getCell(0));

    ChromeOptions settings = new ChromeOptions();

    Map<String, Object> prefs = new HashMap<>();

    prefs.put("profile.password_manager_leak_detection", false);

    settings.setExperimentalOption("prefs", prefs);

    WebDriver driver = new ChromeDriver(settings);

    driver.manage().window().maximize();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.get(url);

    OrangeHRMLoginPage loginPage =
            new OrangeHRMLoginPage(driver);

    loginPage.enterUsername(username);

    loginPage.enterPassword(password);

    loginPage.clickLogin();

    OrangeHRMHomePage homePage =
            new OrangeHRMHomePage(driver);

    homePage.clickBuzzbutton();

    OrangeHRMBuzzPage buzzPage =
            new OrangeHRMBuzzPage(driver);

    buzzPage.enterBuzzfield(Buzzfield);

    buzzPage.clickPostbutton();

    boolean result =
            buzzPage.verifyRecentPost(Buzzfield);

    if (result) {

        System.out.println(
                "Buzz post is displayed in Recent Posts."
        );

    } else {

        System.out.println(
                "Buzz post is NOT displayed in Recent Posts."
        );
    }

    homePage.logout();

    workbook.close();

    excelFile.close();

    driver.quit();

    System.out.println(
            "OrangeHRM Buzz POM test completed."
    );
}


}
