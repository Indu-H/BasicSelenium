package PomUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMLoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public OrangeHRMLoginPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );

        PageFactory.initElements(driver, this);
    }

    // USERNAME

    @FindBy(name = "username")
    private WebElement username;

    // PASSWORD

    @FindBy(name = "password")
    private WebElement password;

    // LOGIN BUTTON

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    // ENTER USERNAME

    public void enterUsername(String value) {

        wait.until(
                ExpectedConditions.visibilityOf(username)
        );

        username.clear();

        username.sendKeys(value);
    }

    // ENTER PASSWORD

    public void enterPassword(String value) {

        wait.until(
                ExpectedConditions.visibilityOf(password)
        );

        password.clear();

        password.sendKeys(value);
    }

    // CLICK LOGIN

    public void clickLogin() {

        wait.until(
                ExpectedConditions.elementToBeClickable(loginButton)
        );

        loginButton.click();

        wait.until(
                ExpectedConditions.urlContains("/dashboard")
        );
    }
}
