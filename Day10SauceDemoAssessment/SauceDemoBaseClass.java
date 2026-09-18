
package BaseClassUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class SauceDemoBaseClass {


    protected WebDriver driver;

    protected Properties properties;



    @BeforeClass

    public void setUp() throws IOException {


        // CREATE PROPERTIES OBJECT

        properties = new Properties();



        // OPEN PROPERTY FILE

        FileInputStream propertyFile =
                new FileInputStream(
                        "./src/test/resources/DDT/SauceDemo.properties"
                );



        // LOAD PROPERTY FILE

        properties.load(propertyFile);



        // CLOSE PROPERTY FILE

        propertyFile.close();



        // CHROME SETTINGS

        ChromeOptions settings =
                new ChromeOptions();



        // AVOID CHANGE PASSWORD POPUP

        Map<String, Object> prefs =
                new HashMap<>();


        prefs.put(
                "profile.password_manager_leak_detection",
                false
        );


        settings.setExperimentalOption(
                "prefs",
                prefs
        );



        // LAUNCH BROWSER

        driver =
                new ChromeDriver(settings);



        // MAXIMIZE BROWSER

        driver.manage().window().maximize();



        // IMPLICIT WAIT

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(10)
        );



        System.out.println(
                "Browser launched."
        );

    }



    @AfterClass

    public void closeBrowser() {


        if (driver != null) {


            driver.quit();


            System.out.println(
                    "Browser closed."
            );

        }

    }

}
