package PomUtilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMCandidatesPage {

    WebDriver driver;
    WebDriverWait wait;

    public OrangeHRMCandidatesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // JOB TITLE
    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text--after')])[1]")
    private WebElement jobTitleDropdown;

    // VACANCY
    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text--after')])[2]")
    private WebElement vacancyDropdown;

    // HIRING MANAGER
    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text--after')])[3]")
    private WebElement hiringManagerDropdown;

    // STATUS
    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text--after')])[4]")
    private WebElement statusDropdown;

    // CANDIDATE NAME
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement candidateName;

    // SEARCH BUTTON
    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;


    // JOB TITLE
    public void getJobTitle(String value) {

        wait.until(ExpectedConditions.elementToBeClickable(jobTitleDropdown));
        jobTitleDropdown.click();

        By option = By.xpath(
            "//div[contains(@class,'oxd-select-option')]//*[normalize-space()='" + value + "']"
        );

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }


    // VACANCY
    public void getVacancy(String value) {

        wait.until(ExpectedConditions.elementToBeClickable(vacancyDropdown));
        vacancyDropdown.click();

        By option = By.xpath(
            "//div[contains(@class,'oxd-select-option')]//*[normalize-space()='" + value + "']"
        );

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }


    // HIRING MANAGER
    public void getHiringManager(String value) {

        wait.until(ExpectedConditions.elementToBeClickable(hiringManagerDropdown));
        hiringManagerDropdown.click();

        By option = By.xpath(
            "//div[contains(@class,'oxd-select-option')]//*[normalize-space()='" + value + "']"
        );

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }


    // STATUS
    public void getStatus(String value) {

        wait.until(ExpectedConditions.elementToBeClickable(statusDropdown));
        statusDropdown.click();

        By option = By.xpath(
            "//div[contains(@class,'oxd-select-option')]//*[normalize-space()='" + value + "']"
        );

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }


    // CANDIDATE NAME
    public void getCandidateName(String value) {

        wait.until(ExpectedConditions.elementToBeClickable(candidateName));

        candidateName.click();
        candidateName.clear();
        candidateName.sendKeys(value);

        // Give OrangeHRM time to process the typed candidate name
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        /*
         * Candidate Name is an autocomplete field.
         * If OrangeHRM gives an exact matching option, click it.
         * If it does not give an option, continue to Search.
         */
        List<WebElement> options = driver.findElements(
            By.xpath(
                "//div[contains(@class,'oxd-autocomplete-option')]"
                + "//*[normalize-space()='" + value + "']"
            )
        );

        if (!options.isEmpty()) {

            for (WebElement option : options) {

                if (option.isDisplayed()) {
                    option.click();
                    break;
                }
            }
        }
    }


    // SEARCH BUTTON
    public void getSearchButton() {

        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }


    // VERIFY CANDIDATE
    public boolean verifyCandidate(String value) {

        By candidate = By.xpath(
            "//div[contains(@class,'oxd-table-card')]//*[normalize-space()='" + value + "']"
        );

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(candidate));

            List<WebElement> candidates =
                driver.findElements(candidate);

            return !candidates.isEmpty();

        } catch (Exception e) {

            return false;
        }
    }
}
