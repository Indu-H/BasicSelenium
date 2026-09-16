package PomUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;
public class OrangeHRMCandidatesPage {

    WebDriver driver;

    public OrangeHRMCandidatesPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    // =====================================================
    // CANDIDATE NAME
    // =====================================================

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement candidateName;


    // =====================================================
    // APPLICATION DATE
    // =====================================================

    public void getDateOfApplication(String value)
    {
        WebElement applicationDate = driver.findElement(
                By.xpath("//label[normalize-space()='Date of Application']/ancestor::div[contains(@class,'oxd-input-group')]//input")
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].value='';", applicationDate);

        applicationDate.sendKeys(value);
    }
    // =====================================================
    // SEARCH BUTTON
    // =====================================================

    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement searchButton;


    // =====================================================
    // JOB TITLE
    // =====================================================

    public void getJobTitle(String value)
    {
        WebElement jobTitleDropdown = driver.findElement(
                By.xpath(
                        "//label[normalize-space()='Job Title']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"
                )
        );

        jobTitleDropdown.click();

        WebElement jobTitleOption = driver.findElement(
                By.xpath(
                        "//div[contains(@class,'oxd-select-option')][normalize-space()='" + value + "']"
                )
        );

        jobTitleOption.click();
    }

    // =====================================================
    // VACANCY
    // =====================================================

    public void getVacancy(String value) {

        WebElement vacancyDropdown = driver.findElement(
                By.xpath(
                        "(//div[contains(@class,'oxd-select-text--after')])[2]"
                )
        );

        vacancyDropdown.click();

        WebElement vacancyOption = driver.findElement(
                By.xpath(
                        "//div[@role='listbox']//span[normalize-space()='" +
                        value +
                        "']"
                )
        );

        vacancyOption.click();
    }


    // =====================================================
    // HIRING MANAGER
    // =====================================================

    public void getHiringManager(String value) {

        WebElement hiringManagerDropdown = driver.findElement(
                By.xpath("(//div[contains(@class,'oxd-select-text--after')])[3]")
        );

        hiringManagerDropdown.click();

        WebElement hiringManagerOption = driver.findElement(
                By.xpath("//div[normalize-space(.)='" + value + "']")
        );

        hiringManagerOption.click();
    }
    // =====================================================
    // STATUS
    // =====================================================

    public void getStatus(String value) {

        WebElement statusDropdown = driver.findElement(
                By.xpath(
                        "(//div[contains(@class,'oxd-select-text--after')])[4]"
                )
        );

        statusDropdown.click();

        WebElement statusOption = driver.findElement(
                By.xpath(
                        "//div[@role='listbox']//span[normalize-space()='" +
                        value +
                        "']"
                )
        );

        statusOption.click();
    }


    // =====================================================
    // CANDIDATE NAME
    // =====================================================

    public void getCandidateName(String value) {

        candidateName.sendKeys(value);
    }


    // =====================================================
    // APPLICATION DATE
    // =====================================================

    public void getApplicationDate(String value)
    {
        WebElement applicationDate = driver.findElement(
                By.xpath("//label[normalize-space()='Date of Application']/ancestor::div[contains(@class,'oxd-input-group')]//input")
        );

        applicationDate.click();

        applicationDate.sendKeys(Keys.CONTROL, "a");

        applicationDate.sendKeys(Keys.BACK_SPACE);

        applicationDate.sendKeys(value);
    }

    
    // SEARCH
    

    public void getSearchButton() {

        searchButton.click();
    }


    
    // VERIFY CANDIDATE
    

    public boolean verifyCandidate(String candidateNameValue) {

        try {

            WebElement candidate = driver.findElement(
                    By.xpath(
                            "//div[contains(@class,'oxd-table-card')]" +
                            "//*[normalize-space()='" +
                            candidateNameValue +
                            "']"
                    )
            );

            return candidate.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
}
