
package PomUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemoCheckoutPage {

    WebDriver driver;

    WebDriverWait wait;

    public SauceDemoCheckoutPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        PageFactory.initElements(driver, this);
    }

    // FIRST NAME
    @FindBy(id = "first-name")
    private WebElement firstName;

    // LAST NAME
    @FindBy(id = "last-name")
    private WebElement lastName;

    // POSTAL CODE
    @FindBy(id = "postal-code")
    private WebElement postalCode;

    // CONTINUE BUTTON
    @FindBy(id = "continue")
    private WebElement continueButton;

    // CHECKOUT OVERVIEW TITLE
    @FindBy(xpath = "//span[contains(@class,'title') and normalize-space()='Checkout: Overview']")
    private WebElement checkoutOverview;

    // FINISH BUTTON
    @FindBy(id = "finish")
    private WebElement finishButton;

    // THANK YOU MESSAGE
    @FindBy(xpath = "//h2[contains(@class,'complete-header') and normalize-space()='Thank you for your order!']")
    private WebElement thankYouMessage;


    // ENTER FIRST NAME
    public void enterFirstName(String value) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(firstName));

        firstName.clear();

        firstName.sendKeys(value);

        Thread.sleep(1000);
    }


    // ENTER LAST NAME
    public void enterLastName(String value) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(lastName));

        lastName.clear();

        lastName.sendKeys(value);

        Thread.sleep(1000);
    }


    // ENTER POSTAL CODE
    public void enterPostalCode(String value) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(postalCode));

        postalCode.clear();

        postalCode.sendKeys(value);

        Thread.sleep(1000);
    }


    // CLICK CONTINUE
    public void clickContinue() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(continueButton));

        continueButton.click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.urlContains("checkout-step-two.html"));
    }


    // VERIFY CHECKOUT OVERVIEW
    public boolean verifyCheckoutOverview() {

        try {

            wait.until(ExpectedConditions.visibilityOf(checkoutOverview));

            if (checkoutOverview.isDisplayed()) {

                System.out.println("Checkout: Overview page displayed.");

                return true;

            } else {

                System.out.println("Checkout: Overview page is not displayed.");

                return false;
            }

        } catch (Exception e) {

            System.out.println("Checkout: Overview page is not displayed.");

            return false;
        }
    }


    // CLICK FINISH
    public void clickFinish() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(finishButton));

        Thread.sleep(1000);

        finishButton.click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.urlContains("checkout-complete.html"));
    }


    // VERIFY THANK YOU MESSAGE
    public boolean verifyThankYouMessage() {

        try {

            wait.until(ExpectedConditions.urlContains("checkout-complete.html"));

            wait.until(ExpectedConditions.visibilityOf(thankYouMessage));

            if (thankYouMessage.isDisplayed()) {

                System.out.println("Thank you for your order! message displayed.");

                return true;

            } else {

                System.out.println("Thank you message is not displayed.");

                return false;
            }

        } catch (Exception e) {

            System.out.println("Thank you message is not displayed.");

            return false;
        }
    }
}
