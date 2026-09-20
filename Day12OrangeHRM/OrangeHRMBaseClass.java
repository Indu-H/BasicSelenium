package BaseClassUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomUtilities.OrangeHRMHomePage;
import PomUtilities.OrangeHRMLoginPage;

public class OrangeHRMBaseClass {

    protected WebDriver driver;
    protected Properties properties;

    @BeforeClass
    public void openBrowser() throws IOException {

        // Read properties file

        properties = new Properties();

        FileInputStream propertyFile = new FileInputStream(
                "./src/test/resources/DDT/Day12OrangeHRM.properties"
        );

        properties.load(propertyFile);

        propertyFile.close();

        // Chrome settings

        ChromeOptions settings = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

        prefs.put(
                "profile.password_manager_leak_detection",
                false
        );

        settings.setExperimentalOption(
                "prefs",
                prefs
        );

        // Launch browser

        driver = new ChromeDriver(settings);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(10)
        );

        System.out.println("OrangeHRM browser launched.");
    }

    @BeforeMethod
    public void loginBeforeEachTest() {

        // Clear previous login session
        driver.manage().deleteAllCookies();

        // Open OrangeHRM login page
        driver.get(properties.getProperty("url"));

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(30)
        );

        // Wait until login page is loaded
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name("username")
                )
        );

        OrangeHRMLoginPage loginPage =
                new OrangeHRMLoginPage(driver);

        loginPage.enterUsername(
                properties.getProperty("username")
        );

        loginPage.enterPassword(
                properties.getProperty("password")
        );

        loginPage.clickLogin();

        System.out.println("OrangeHRM login completed.");
    }
    @AfterClass
    public void closeBrowser() {

        if (driver != null) {

            driver.quit();

            System.out.println("OrangeHRM browser closed.");
        }
    }
}


