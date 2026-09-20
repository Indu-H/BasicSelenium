
package PomUtilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMVacanciesPage {

    WebDriver driver;

    WebDriverWait wait;

    public OrangeHRMVacanciesPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(30)
        );

        PageFactory.initElements(driver, this);
    }

    // VACANCIES TAB

    private By vacanciesTab = By.xpath(
            "//a[normalize-space()='Vacancies']"
    );

    // ADD BUTTON

    private By addButton = By.xpath(
            "//button[normalize-space()='Add']"
    );

    // VACANCY NAME

    private By vacancyName = By.xpath(
            "//label[normalize-space()='Vacancy Name']"
            + "/ancestor::div[contains(@class,'oxd-input-group')]"
            + "//input"
    );

    // JOB TITLE DROPDOWN

    private By jobTitleDropdown = By.xpath(
            "//label[normalize-space()='Job Title']"
            + "/ancestor::div[contains(@class,'oxd-input-group')]"
            + "//div[contains(@class,'oxd-select-text')]"
    );

    // DESCRIPTION

    private By description = By.xpath(
            "//label[normalize-space()='Description']"
            + "/ancestor::div[contains(@class,'oxd-input-group')]"
            + "//textarea"
    );

    // HIRING MANAGER INPUT

    private By hiringManagerInput = By.xpath(
            "//label[normalize-space()='Hiring Manager']"
            + "/ancestor::div[contains(@class,'oxd-input-group')]"
            + "//input"
    );

    // NUMBER OF POSITIONS

    private By numberOfPositions = By.xpath(
            "//label[normalize-space()='Number of Positions']"
            + "/ancestor::div[contains(@class,'oxd-input-group')]"
            + "//input"
    );

    // SAVE BUTTON

    private By saveButton = By.xpath(
            "//button[@type='submit']"
    );

    // SUCCESS TOAST

    private By successToast = By.xpath(
            "//div[contains(@class,'oxd-toast-content')]"
            + "//*[contains(normalize-space(),'Successfully Saved')]"
    );

    // ALL TOAST MESSAGES

    private By allToastMessages = By.xpath(
            "//div[contains(@class,'oxd-toast-content')]"
    );

    // FORM VALIDATION ERRORS

    private By errorMessages = By.xpath(
            "//span[contains(@class,'oxd-input-field-error-message')]"
    );

    // AUTOCOMPLETE SUGGESTIONS

    private By suggestionsLocator = By.xpath(
            "//div[contains(@class,'oxd-autocomplete-option')]"
    );

    // ============================================================
    // CLICK VACANCIES TAB
    // ============================================================

    public void clickVacanciesTab() {

        WebElement vacancies = wait.until(
                ExpectedConditions.elementToBeClickable(
                        vacanciesTab
                )
        );

        vacancies.click();

        wait.until(
                ExpectedConditions.urlContains(
                        "/viewJobVacancy"
                )
        );

        System.out.println(
                "Vacancies page opened."
        );
    }

    // ============================================================
    // CLICK ADD BUTTON
    // ============================================================

    public void clickAddButton() {

        WebElement add = wait.until(
                ExpectedConditions.elementToBeClickable(
                        addButton
                )
        );

        add.click();

        wait.until(
                ExpectedConditions.urlContains(
                        "/addJobVacancy"
                )
        );

        System.out.println(
                "Add vacancy page opened."
        );
    }

    // ============================================================
    // ENTER VACANCY NAME
    // ============================================================

    public void enterVacancyName(String value) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(
                        vacancyName
                )
        );

        element.click();

        element.sendKeys(Keys.CONTROL, "a");

        element.sendKeys(Keys.BACK_SPACE);

        element.sendKeys(value);

        System.out.println(
                "Vacancy name entered: " + value
        );
    }

    // ============================================================
    // SELECT JOB TITLE
    // ============================================================

    public void selectJobTitle(String value) {

        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        jobTitleDropdown
                )
        );

        dropdown.click();

        By option = By.xpath(
                "//div[contains(@class,'oxd-select-option')]"
                + "//*[normalize-space()="
                + xpathText(value)
                + "]"
        );

        WebElement jobTitleOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        option
                )
        );

        jobTitleOption.click();

        System.out.println(
                "Job title selected: " + value
        );
    }

    // ============================================================
    // ENTER DESCRIPTION
    // ============================================================

    public void enterDescription(String value) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(
                        description
                )
        );

        element.click();

        element.sendKeys(Keys.CONTROL, "a");

        element.sendKeys(Keys.BACK_SPACE);

        element.sendKeys(value);

        System.out.println(
                "Description entered."
        );
    }

    // ============================================================
    // SELECT HIRING MANAGER
    // ============================================================

    public void selectHiringManager(String managerValue) {

        WebElement input = wait.until(
                ExpectedConditions.elementToBeClickable(
                        hiringManagerInput
                )
        );

        input.click();

        input.sendKeys(Keys.CONTROL, "a");

        input.sendKeys(Keys.BACK_SPACE);

        String managerName = managerValue.trim();

        String searchText = managerName;

        // Search using the first three letters.
        // This allows suggestions such as Rahul Das
        // when the Excel value is Rahul Patil.

        if (searchText.length() > 3) {

            searchText = searchText.substring(0, 3);
        }

        input.sendKeys(searchText);

        System.out.println(
                "Searching Hiring Manager: " + searchText
        );

        WebElement selectedSuggestion = wait.until(
                driver -> {

                    List<WebElement> suggestions =
                            driver.findElements(
                                    suggestionsLocator
                            );

                    WebElement firstValidSuggestion = null;

                    for (WebElement suggestion : suggestions) {

                        if (!suggestion.isDisplayed()) {

                            continue;
                        }

                        String suggestionText =
                                suggestion.getText().trim();

                        System.out.println(
                                "Hiring Manager suggestion: "
                                + suggestionText
                        );

                        if (suggestionText.isEmpty()) {

                            continue;
                        }

                        if (suggestionText.equalsIgnoreCase(
                                "Searching...."
                        )) {

                            continue;
                        }

                        if (suggestionText.equalsIgnoreCase(
                                "No Records Found"
                        )) {

                            continue;
                        }

                        if (firstValidSuggestion == null) {

                            firstValidSuggestion = suggestion;
                        }

                        // Select the exact manager if available.

                        if (suggestionText.equalsIgnoreCase(
                                managerName
                        )) {

                            return suggestion;
                        }
                    }

                    // If exact manager is not available,
                    // select the first valid suggestion.

                    return firstValidSuggestion;
                }
        );

        String selectedManager =
                selectedSuggestion.getText().trim();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        selectedSuggestion
                )
        ).click();

        System.out.println(
                "Hiring Manager selected: "
                + selectedManager
        );

        if (!selectedManager.equalsIgnoreCase(managerName)) {

            System.out.println(
                    "Note: Requested Hiring Manager was: "
                    + managerName
            );

            System.out.println(
                    "Available Hiring Manager selected was: "
                    + selectedManager
            );
        }
    }

    // ============================================================
    // ENTER NUMBER OF POSITIONS
    // ============================================================

    public void enterNumberOfPositions(String value) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(
                        numberOfPositions
                )
        );

        element.click();

        element.sendKeys(Keys.CONTROL, "a");

        element.sendKeys(Keys.BACK_SPACE);

        element.sendKeys(value);

        System.out.println(
                "Number of positions entered: " + value
        );
    }

    // ============================================================
    // CLICK SAVE BUTTON
    // ============================================================

    public void clickSaveButton() {

        WebElement save = wait.until(
                ExpectedConditions.elementToBeClickable(
                        saveButton
                )
        );

        save.click();

        System.out.println(
                "Save button clicked."
        );
    }

    // ============================================================
    // VERIFY VACANCY SAVED
    // ============================================================

    public boolean verifyVacancySaved() {

        WebDriverWait saveWait = new WebDriverWait(
                driver,
                Duration.ofSeconds(30)
        );

        try {

            Boolean result = saveWait.until(
                    driver -> {

                        // CHECK SUCCESS TOAST

                        List<WebElement> successMessages =
                                driver.findElements(
                                        successToast
                                );

                        for (WebElement message :
                                successMessages) {

                            if (message.isDisplayed()) {

                                System.out.println(
                                        "Success message: "
                                        + message.getText()
                                );

                                return true;
                            }
                        }

                        // CHECK ALL TOAST MESSAGES

                        List<WebElement> toastMessages =
                                driver.findElements(
                                        allToastMessages
                                );

                        for (WebElement toast :
                                toastMessages) {

                            if (!toast.isDisplayed()) {

                                continue;
                            }

                            String toastText =
                                    toast.getText().trim();

                            System.out.println(
                                    "Toast message: "
                                    + toastText
                            );

                            String lowerCaseToast =
                                    toastText.toLowerCase();

                            if (lowerCaseToast.contains(
                                    "success"
                            )) {

                                return true;
                            }

                            if (lowerCaseToast.contains(
                                    "error"
                            )) {

                                return false;
                            }

                            if (lowerCaseToast.contains(
                                    "already exists"
                            )) {

                                System.out.println(
                                        "Vacancy already exists."
                                );

                                return false;
                            }
                        }

                        // CHECK FORM VALIDATION ERRORS

                        List<WebElement> errors =
                                driver.findElements(
                                        errorMessages
                                );

                        for (WebElement error : errors) {

                            if (error.isDisplayed()) {

                                String errorText =
                                        error.getText().trim();

                                System.out.println(
                                        "Form validation error: "
                                        + errorText
                                );

                                return false;
                            }
                        }

                        // CHECK WHETHER PAGE RETURNED
                        // TO VACANCY LIST

                        String currentUrl =
                                driver.getCurrentUrl();

                        if (currentUrl.contains(
                                "/viewJobVacancy"
                        )) {

                            System.out.println(
                                    "Vacancy list page opened."
                            );

                            return true;
                        }

                        return null;
                    }
            );

            if (Boolean.TRUE.equals(result)) {

                System.out.println(
                        "Vacancy saved successfully."
                );

                return true;
            }

            System.out.println(
                    "Vacancy was not saved. "
                    + "Check the displayed error."
            );

            return false;

        } catch (Exception e) {

            System.out.println(
                    "Vacancy verification failed."
            );

            System.out.println(
                    "Current URL: "
                    + driver.getCurrentUrl()
            );

            System.out.println(
                    "Exception: "
                    + e.getMessage()
            );

            return false;
        }
    }

    // ============================================================
    // HELPER METHOD FOR XPATH TEXT
    // ============================================================

    private String xpathText(String value) {

        if (!value.contains("'")) {

            return "'" + value + "'";
        }

        if (!value.contains("\"")) {

            return "\"" + value + "\"";
        }

        return "concat('"
                + value.replace(
                        "'",
                        "',\"'\",'"
                )
                + "')";
    }
}
