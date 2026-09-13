package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMDay6 {

    public static void main(String[] args)
            throws EncryptedDocumentException, IOException, InterruptedException {

        // =====================================================
        // PROPERTY FILE
        // =====================================================

        FileInputStream propFis =
                new FileInputStream(
                        "./src/test/resources/DDT/OrangeHRMDay6.properties"
                );

        Properties prop = new Properties();
        prop.load(propFis);

        String url = prop.getProperty("url");
        String browser = prop.getProperty("browser");


        // =====================================================
        // EXCEL FILE
        // =====================================================

        FileInputStream excelFis =
                new FileInputStream(
                        "./src/test/resources/DDT/Day6OrangeHRM.xlsx"
                );

        Workbook wb = WorkbookFactory.create(excelFis);

        Sheet sh = wb.getSheet("Sheet1");

        Row row = sh.getRow(1);

        DataFormatter formatter = new DataFormatter();


        // =====================================================
        // READ DATA FROM EXCEL
        // =====================================================

        String loginUsername =
                formatter.formatCellValue(row.getCell(1));

        String loginPassword =
                formatter.formatCellValue(row.getCell(2));

        String firstName =
                formatter.formatCellValue(row.getCell(3));

        String middleName =
                formatter.formatCellValue(row.getCell(4));

        String lastName =
                formatter.formatCellValue(row.getCell(5));

        String employeeId =
                formatter.formatCellValue(row.getCell(6));

        String username =
                formatter.formatCellValue(row.getCell(7));

        String password =
                formatter.formatCellValue(row.getCell(8));

        String confirmPassword =
                formatter.formatCellValue(row.getCell(9));

        String adminUsername =
                formatter.formatCellValue(row.getCell(10));

        String employeeName =
                formatter.formatCellValue(row.getCell(11));

        String role =
                formatter.formatCellValue(row.getCell(12));

        String status =
                formatter.formatCellValue(row.getCell(13));


        // =====================================================
        // PRINT EXCEL DATA
        // =====================================================

        System.out.println("======================================");
        System.out.println("DATA READ FROM EXCEL");
        System.out.println("Employee ID      = " + employeeId);
        System.out.println("Username         = " + username);
        System.out.println("Admin Username   = " + adminUsername);
        System.out.println("Employee Name    = " + employeeName);
        System.out.println("Role             = " + role);
        System.out.println("Status           = " + status);
        System.out.println("======================================");


        // =====================================================
        // CHROME SETTINGS
        // =====================================================

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


        // =====================================================
        // LAUNCH BROWSER
        // =====================================================

        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver(settings);

        } else {

            driver = new ChromeDriver(settings);

        }

        driver.manage().window().maximize();

        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));


        // =====================================================
        // LOGIN
        // =====================================================

        driver.get(url);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name("username")
                )
        ).sendKeys(loginUsername);

        driver.findElement(
                By.name("password")
        ).sendKeys(loginPassword);

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Login']")
                )
        ).click();


        // =====================================================
        // PIM
        // =====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[normalize-space()='PIM']")
                )
        ).click();


        // =====================================================
        // ADD EMPLOYEE
        // =====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Add']")
                )
        ).click();


        // =====================================================
        // FIRST NAME
        // =====================================================

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@name='firstName']")
                )
        ).sendKeys(firstName);


        // =====================================================
        // MIDDLE NAME
        // =====================================================

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@name='middleName']")
                )
        ).sendKeys(middleName);


        // =====================================================
        // LAST NAME
        // =====================================================

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@name='lastName']")
                )
        ).sendKeys(lastName);


        // =====================================================
        // EMPLOYEE ID
        // =====================================================

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.cssSelector("div.oxd-form-loader")
                )
        );

        WebElement employeeIdField = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//label[normalize-space()='Employee Id']" +
                                "/ancestor::div[contains(@class,'oxd-input-group')]" +
                                "//input"
                        )
                )
        );

        employeeIdField.click();

        employeeIdField.sendKeys(
                Keys.CONTROL,
                "a"
        );

        employeeIdField.sendKeys(
                Keys.BACK_SPACE
        );

        employeeIdField.sendKeys(employeeId);

        System.out.println(
                "Employee ID entered = " + employeeId
        );


        // =====================================================
        // CREATE LOGIN DETAILS
        // =====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//span[contains(@class,'oxd-switch-input')]"
                        )
                )
        ).click();


        // =====================================================
        // USERNAME
        // =====================================================

        WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//label[normalize-space()='Username']" +
                                "/ancestor::div[contains(@class,'oxd-input-group')]" +
                                "//input"
                        )
                )
        );

        usernameField.sendKeys(username);

        System.out.println(
                "Username entered = " + username
        );


        // =====================================================
        // PASSWORD
        // =====================================================

        WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//label[normalize-space()='Password']" +
                                "/ancestor::div[contains(@class,'oxd-input-group')]" +
                                "//input"
                        )
                )
        );

        passwordField.sendKeys(password);


        // =====================================================
        // CONFIRM PASSWORD
        // =====================================================

        WebElement confirmPasswordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//label[normalize-space()='Confirm Password']" +
                                "/ancestor::div[contains(@class,'oxd-input-group')]" +
                                "//input"
                        )
                )
        );

        confirmPasswordField.sendKeys(confirmPassword);


        // =====================================================
        // SAVE EMPLOYEE
        // =====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Save']")
                )
        ).click();


        // Wait until employee form loader disappears
        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.cssSelector("div.oxd-form-loader")
                )
        );

        Thread.sleep(3000);

        System.out.println("Employee saved successfully.");


        // =====================================================
        // ADMIN
        // =====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[normalize-space()='Admin']")
                )
        ).click();


        // =====================================================
        // WAIT FOR ADMIN PAGE
        // =====================================================

        wait.until(
                ExpectedConditions.urlContains(
                        "/admin/viewSystemUsers"
                )
        );

        System.out.println(
                "Admin page opened successfully."
        );


        // =====================================================
        // ADMIN USERNAME
        // =====================================================

        WebElement adminUsernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//label[normalize-space()='Username']" +
                                "/ancestor::div[contains(@class,'oxd-input-group')]" +
                                "//input"
                        )
                )
        );

        adminUsernameField.sendKeys(adminUsername);


        // =====================================================
        // USER ROLE
        // =====================================================

        WebElement userRoleDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//label[normalize-space()='User Role']" +
                                "/ancestor::div[contains(@class,'oxd-input-group')]" +
                                "//div[contains(@class,'oxd-select-text')]"
                        )
                )
        );

        userRoleDropdown.click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//div[@role='listbox']//span[normalize-space()='" +
                                role +
                                "']"
                        )
                )
        ).click();


        // =====================================================
        // EMPLOYEE NAME
        // =====================================================

        WebElement empName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//input[@placeholder='Type for hints...']"
                        )
                )
        );

        empName.sendKeys(employeeName);

        Thread.sleep(2000);


        // =====================================================
        // SELECT EMPLOYEE SUGGESTION
        // =====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "(//div[contains(@class,'oxd-autocomplete-option')])[1]"
                        )
                )
        ).click();


        // =====================================================
        // STATUS
        // =====================================================

        WebElement statusDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//label[normalize-space()='Status']" +
                                "/ancestor::div[contains(@class,'oxd-input-group')]" +
                                "//div[contains(@class,'oxd-select-text')]"
                        )
                )
        );

        statusDropdown.click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//div[@role='listbox']//span[normalize-space()='" +
                                status +
                                "']"
                        )
                )
        ).click();


        // =====================================================
        // SEARCH
        // =====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[normalize-space()='Search']"
                        )
                )
        ).click();

        System.out.println("Search button clicked.");


        // =====================================================
        // VERIFY EMPLOYEE
        // =====================================================

        try {

            WebElement record = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath(
                                    "//div[contains(@class,'oxd-table-card')]" +
                                    "//*[normalize-space()='" +
                                    username +
                                    "']"
                            )
                    )
            );

            if (record.isDisplayed()) {

                System.out.println(
                        "Employee is added successfully."
                );

            }

        } catch (Exception e) {

            System.out.println(
                    "Employee is NOT found in Records Found section."
            );
        }


        // =====================================================
        // LOGOUT
        // =====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//span[contains(@class,'oxd-userdropdown-tab')]"
                        )
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[normalize-space()='Logout']")
                )
        ).click();


        // =====================================================
        // CLOSE
        // =====================================================

        wb.close();
        excelFis.close();
        propFis.close();

        driver.quit();

        System.out.println("Test completed.");
    }
}
