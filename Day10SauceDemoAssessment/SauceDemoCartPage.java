package PomUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemoCartPage {

    WebDriver driver;
    WebDriverWait wait;

    public SauceDemoCartPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        PageFactory.initElements(driver, this);
    }

    // CHECKOUT BUTTON
    @FindBy(id = "checkout")
    private WebElement checkoutButton;


    // VERIFY BACKPACK IS DISPLAYED
    public boolean verifyBackpackDisplayed() {

        By backpack = By.xpath(
            "//div[contains(@class,'cart_item')]" +
            "[.//div[normalize-space()='Sauce Labs Backpack']]"
        );

        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(backpack)
        ).isDisplayed();
    }


    // CLICK CHECKOUT
    public void clickCheckout() {

        wait.until(
            ExpectedConditions.elementToBeClickable(checkoutButton)
        );

        checkoutButton.click();
    }
}


