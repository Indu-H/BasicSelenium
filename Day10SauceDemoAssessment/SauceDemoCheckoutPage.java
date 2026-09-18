
package PomUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );

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



    // COMMON METHOD TO ENTER TEXT

    private void enterText(WebElement element, String value) {

        wait.until(
                ExpectedConditions.elementToBeClickable(element)
        );

        element.click();

        element.sendKeys(Keys.CONTROL, "a");

        element.sendKeys(Keys.BACK_SPACE);

        element.sendKeys(value);


        String enteredValue =
                element.getAttribute("value");


        // JAVASCRIPT FALLBACK IF TEXT IS NOT ENTERED

        if (enteredValue == null || enteredValue.isEmpty()) {

            JavascriptExecutor js =
                    (JavascriptExecutor) driver;


            js.executeScript(
                    "var input = arguments[0];"
                    + "var value = arguments[1];"
                    + "var setter = Object.getOwnPropertyDescriptor("
                    + "window.HTMLInputElement.prototype, 'value').set;"
                    + "setter.call(input, value);"
                    + "input.dispatchEvent(new Event('input', {bubbles:true}));"
                    + "input.dispatchEvent(new Event('change', {bubbles:true}));",
                    element,
                    value
            );

        }


        wait.until(
                ExpectedConditions.attributeToBe(
                        element,
                        "value",
                        value
                )
        );

    }



    // ENTER FIRST NAME

    public void enterFirstName(String value)
            throws InterruptedException {

        enterText(firstName, value);

        System.out.println(
                "First Name entered: "
                        + firstName.getAttribute("value")
        );

        Thread.sleep(1000);

    }



    // ENTER LAST NAME

    public void enterLastName(String value)
            throws InterruptedException {

        enterText(lastName, value);

        System.out.println(
                "Last Name entered: "
                        + lastName.getAttribute("value")
        );

        Thread.sleep(1000);

    }



    // ENTER POSTAL CODE

    public void enterPostalCode(String value)
            throws InterruptedException {

        enterText(postalCode, value);

        System.out.println(
                "Postal Code entered: "
                        + postalCode.getAttribute("value")
        );

        Thread.sleep(1000);

    }



    // CLICK CONTINUE

    public void clickContinue() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        continueButton
                )
        );


        System.out.println(
                "First Name before Continue: "
                        + firstName.getAttribute("value")
        );


        System.out.println(
                "Last Name before Continue: "
                        + lastName.getAttribute("value")
        );


        System.out.println(
                "Postal Code before Continue: "
                        + postalCode.getAttribute("value")
        );


        continueButton.click();


        try {

            wait.until(
                    ExpectedConditions.visibilityOf(
                            checkoutOverview
                    )
            );

            System.out.println(
                    "Checkout: Overview page displayed."
            );


        } catch (Exception e) {

            System.out.println(
                    "Checkout: Overview page is not displayed."
            );


            System.out.println(
                    "Current URL: "
                            + driver.getCurrentUrl()
            );


            try {

                WebElement errorMessage =
                        driver.findElement(
                                By.cssSelector(
                                        "[data-test='error']"
                                )
                        );


                System.out.println(
                        "SauceDemo error: "
                                + errorMessage.getText()
                );


            } catch (Exception error) {

                System.out.println(
                        "No validation error message found."
                );

            }


            throw e;

        }

    }



    // VERIFY CHECKOUT OVERVIEW

    public boolean verifyCheckoutOverview() {

        try {

            wait.until(
                    ExpectedConditions.visibilityOf(
                            checkoutOverview
                    )
            );


            if (checkoutOverview.isDisplayed()) {

                return true;

            } else {

                return false;

            }


        } catch (Exception e) {

            return false;

        }

    }



    // CLICK FINISH

    public void clickFinish()
            throws InterruptedException {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        finishButton
                )
        );


        Thread.sleep(1000);


        finishButton.click();


        wait.until(
                ExpectedConditions.visibilityOf(
                        thankYouMessage
                )
        );

    }



    // VERIFY THANK YOU MESSAGE

    public boolean verifyThankYouMessage() {

        try {

            wait.until(
                    ExpectedConditions.visibilityOf(
                            thankYouMessage
                    )
            );


            if (thankYouMessage.isDisplayed()) {

                return true;

            } else {

                return false;

            }


        } catch (Exception e) {

            return false;

        }

    }

}
