
package PomUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMMyInfoPage {

    WebDriver driver;

    WebDriverWait wait;

    public OrangeHRMMyInfoPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(30)
        );

        PageFactory.initElements(driver, this);
    }

    // FIRST NAME

    private By firstName = By.name("firstName");

    // MIDDLE NAME

    private By middleName = By.name("middleName");

    // LAST NAME

    private By lastName = By.name("lastName");

    // EMPLOYEE ID

    private By employeeId = By.xpath(
            "//label[normalize-space()='Employee Id']"
            + "/ancestor::div[contains(@class,'oxd-input-group')]"
            + "//input"
    );

    // PERSONAL DETAILS SAVE BUTTON

    private By personalDetailsSaveButton = By.xpath(
            "//h6[normalize-space()='Personal Details']"
            + "/ancestor::div[contains(@class,'orangehrm-card-container')][1]"
            + "//button[@type='submit']"
    );

    // FORM LOADER

    private By formLoader = By.cssSelector(
            "div.oxd-form-loader"
    );

    // WAIT UNTIL FORM LOADER DISAPPEARS

    private void waitForFormLoaderToDisappear() {

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        formLoader
                )
        );
    }

    // ENTER FIRST NAME

    public void enterFirstName(String value) {

        waitForFormLoaderToDisappear();

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(firstName)
        );

        element.click();

        element.sendKeys(Keys.CONTROL, "a");

        element.sendKeys(Keys.BACK_SPACE);

        element.sendKeys(value);

        System.out.println(
                "First Name entered: " + value
        );
    }

    // CLEAR MIDDLE NAME

    public void clearMiddleName() {

        waitForFormLoaderToDisappear();

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(middleName)
        );

        element.click();

        element.sendKeys(Keys.CONTROL, "a");

        element.sendKeys(Keys.BACK_SPACE);

        System.out.println(
                "Middle Name cleared and left blank."
        );
    }

    // ENTER LAST NAME

    public void enterLastName(String value) {

        waitForFormLoaderToDisappear();

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(lastName)
        );

        element.click();

        element.sendKeys(Keys.CONTROL, "a");

        element.sendKeys(Keys.BACK_SPACE);

        element.sendKeys(value);

        System.out.println(
                "Last Name entered: " + value
        );
    }

    // ENTER EMPLOYEE ID

    public void enterEmployeeId(String value) {

        waitForFormLoaderToDisappear();

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(employeeId)
        );

        element.click();

        element.sendKeys(Keys.CONTROL, "a");

        element.sendKeys(Keys.BACK_SPACE);

        element.sendKeys(value);

        System.out.println(
                "Employee ID entered: " + value
        );
    }

    // CLICK PERSONAL DETAILS SAVE BUTTON

    public void clickPersonalDetailsSave() {

        waitForFormLoaderToDisappear();

        WebElement saveButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        personalDetailsSaveButton
                )
        );

        saveButton.click();

        System.out.println(
                "Personal Details Save button clicked."
        );

        waitForFormLoaderToDisappear();
    }

    // GET FIRST NAME AFTER RELOGIN

    public String getFirstName() {

        waitForFormLoaderToDisappear();

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        firstName
                )
        ).getAttribute("value");
    }

    // GET MIDDLE NAME AFTER RELOGIN

    public String getMiddleName() {

        waitForFormLoaderToDisappear();

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        middleName
                )
        ).getAttribute("value");
    }

    // GET LAST NAME AFTER RELOGIN

    public String getLastName() {

        waitForFormLoaderToDisappear();

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        lastName
                )
        ).getAttribute("value");
    }

    // GET EMPLOYEE ID AFTER RELOGIN

    public String getEmployeeId() {

        waitForFormLoaderToDisappear();

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        employeeId
                )
        ).getAttribute("value");
    }

    // VERIFY UPDATED DETAILS

    public boolean verifyUpdatedDetails(
            String expectedFirstName,
            String expectedLastName,
            String expectedEmployeeId
    ) {

        String actualFirstName = getFirstName();

        String actualMiddleName = getMiddleName();

        String actualLastName = getLastName();

        String actualEmployeeId = getEmployeeId();

        System.out.println(
                "Expected First Name: " + expectedFirstName
        );

        System.out.println(
                "Actual First Name: " + actualFirstName
        );

        System.out.println(
                "Expected Middle Name: BLANK"
        );

        System.out.println(
                "Actual Middle Name: " + actualMiddleName
        );

        System.out.println(
                "Expected Last Name: " + expectedLastName
        );

        System.out.println(
                "Actual Last Name: " + actualLastName
        );

        System.out.println(
                "Expected Employee ID: " + expectedEmployeeId
        );

        System.out.println(
                "Actual Employee ID: " + actualEmployeeId
        );

        boolean firstNameMatched =
                actualFirstName.equals(expectedFirstName);

        boolean middleNameBlank =
                actualMiddleName == null
                || actualMiddleName.trim().isEmpty();

        boolean lastNameMatched =
                actualLastName.equals(expectedLastName);

        boolean employeeIdMatched =
                actualEmployeeId.equals(expectedEmployeeId);

        return firstNameMatched
                && middleNameBlank
                && lastNameMatched
                && employeeIdMatched;
    }
}
