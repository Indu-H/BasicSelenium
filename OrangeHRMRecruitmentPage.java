package PomUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMRecruitmentPage {

    WebDriver driver;

    public OrangeHRMRecruitmentPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    
    // ADD BUTTON

    @FindBy(xpath = "//button[text()=' Add ']")
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


    // =====================================================
    // EMAIL
    // =====================================================

    @FindBy(xpath = "//label[contains(normalize-space(),'Email')]/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement email;


    // =====================================================
    // CONTACT NUMBER
    // =====================================================

    @FindBy(xpath = "//label[normalize-space()='Contact Number']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement contactNumber;


    // =====================================================
    // RESUME
    // =====================================================

    @FindBy(xpath = "//input[@type='file']")
    private WebElement resume;


    // =====================================================
    // DATE OF APPLICATION
    // =====================================================

    @FindBy(xpath = "//input[@placeholder='yyyy-dd-mm']")
    private WebElement dateOfApplication;


    // =====================================================
    // SAVE BUTTON
    // =====================================================

    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement saveButton;


    // =====================================================
    // CANDIDATES BUTTON
    // =====================================================

    @FindBy(xpath = "//a[text()='Candidates']")
    private WebElement candidates;


    // =====================================================
    // ADD BUTTON
    // =====================================================

    public void getAddButton() {

        addButton.click();
    }


    // =====================================================
    // FIRST NAME
    // =====================================================

    public void getFirstName(String value) {

        firstName.sendKeys(value);
    }


    // =====================================================
    // MIDDLE NAME
    // =====================================================

    public void getMiddleName(String value) {

        middleName.sendKeys(value);
    }


    // =====================================================
    // LAST NAME
    // =====================================================

    public void getLastName(String value) {

        lastName.sendKeys(value);
    }


    // =====================================================
    // VACANCY
    // =====================================================

    public void getVacancy(String value) {

        WebElement vacancyDropdown = driver.findElement(
                By.xpath(
                        "//label[normalize-space()='Vacancy']" +
                        "/ancestor::div[contains(@class,'oxd-input-group')]" +
                        "//div[contains(@class,'oxd-select-text')]"
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
    // EMAIL
    // =====================================================

    public void getEmail(String value) {

        email.sendKeys(value);
    }


    // =====================================================
    // CONTACT NUMBER
    // =====================================================

    public void getContactNumber(String value) {

        contactNumber.sendKeys(value);
    }


    // =====================================================
    // RESUME
    // =====================================================

    public void getResume(String path) {

        resume.sendKeys(path);
    }


    
    // DATE OF APPLICATION
    

    public void getDateOfApplication(String value)
    {
        WebElement applicationDate = driver.findElement(
                By.xpath("//label[normalize-space()='Date of Application']/ancestor::div[contains(@class,'oxd-input-group')]//input")
        );

        applicationDate.click();

        applicationDate.sendKeys(Keys.CONTROL, "a");

        applicationDate.sendKeys(Keys.BACK_SPACE);

        applicationDate.sendKeys(value);

        applicationDate.sendKeys(Keys.TAB);
    }
    
    // SAVE


    public void getSaveButton() {

        saveButton.click();
    }


    
    // CANDIDATES
    

    public void getCandidates() {

        candidates.click();
    }
}
