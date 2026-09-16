package PomUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMRecruitmentPage {

    WebDriver driver;
    WebDriverWait wait;

    public OrangeHRMRecruitmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // ADD BUTTON
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    // FIRST NAME
    @FindBy(name = "firstName")
    private WebElement firstName;

    // MIDDLE NAME
    @FindBy(name = "middleName")
    private WebElement middleName;

    // LAST NAME
    @FindBy(name = "lastName")
    private WebElement lastName;

    // EMAIL
    @FindBy(xpath = "//label[normalize-space()='Email']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement email;

    // CONTACT NUMBER
    @FindBy(xpath = "//label[normalize-space()='Contact Number']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement contactNumber;

    // RESUME
    @FindBy(xpath = "//input[@type='file']")
    private WebElement resume;

    // SAVE BUTTON
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;

    // CANDIDATES TAB
    @FindBy(xpath = "//a[normalize-space()='Candidates']")
    private WebElement candidates;


    // ADD
    public void clickAdd() {

        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }


    // FIRST NAME
    public void enterFirstName(String value) {

        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(value);
    }


    // MIDDLE NAME
    public void enterMiddleName(String value) {

        wait.until(ExpectedConditions.visibilityOf(middleName));
        middleName.sendKeys(value);
    }


    // LAST NAME
    public void enterLastName(String value) {

        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.sendKeys(value);
    }


    // VACANCY
    public void selectVacancy(String value) {

        By vacancyDropdownLocator = By.xpath(
            "//label[normalize-space()='Vacancy']" +
            "/ancestor::div[contains(@class,'oxd-input-group')]" +
            "//div[contains(@class,'oxd-select-text')]"
        );

        WebElement vacancyDropdown =
            wait.until(ExpectedConditions.elementToBeClickable(vacancyDropdownLocator));

        vacancyDropdown.click();

        By vacancyOptionLocator = By.xpath(
            "//div[contains(@class,'oxd-select-option')]" +
            "//*[normalize-space()='" + value + "']"
        );

        WebElement vacancyOption =
            wait.until(ExpectedConditions.elementToBeClickable(vacancyOptionLocator));

        vacancyOption.click();
    }


    // EMAIL
    public void enterEmail(String value) {

        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(value);
    }


    // CONTACT NUMBER
    public void enterContactNumber(String value) {

        wait.until(ExpectedConditions.visibilityOf(contactNumber));
        contactNumber.sendKeys(value);
    }


    // RESUME
    public void getResume(String path) {

        // File input is hidden, so don't use visibilityOf()
        resume.sendKeys(path);
    }


    // SAVE
    public void getSaveButton() {

        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }


    // CANDIDATES
    public void clickCandidates() {

        wait.until(ExpectedConditions.elementToBeClickable(candidates));
        candidates.click();
    }
}
