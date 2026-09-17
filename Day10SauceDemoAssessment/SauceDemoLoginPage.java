package PomUtilities;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SauceDemoLoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public SauceDemoLoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        PageFactory.initElements(driver, this);
    }

    // USERNAME
    @FindBy(id = "user-name")
    private WebElement username;

    // PASSWORD
    @FindBy(id = "password")
    private WebElement password;

    // LOGIN BUTTON
    @FindBy(id = "login-button")
    private WebElement loginButton;


    // ENTER USERNAME
    public void enterUsername(String value) {

        wait.until(ExpectedConditions.visibilityOf(username));

        username.sendKeys(value);
    }


    // ENTER PASSWORD
    public void enterPassword(String value) {

        wait.until(ExpectedConditions.visibilityOf(password));

        password.sendKeys(value);
    }


    // CLICK LOGIN
    public void clickLogin() {

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        loginButton.click();
    }
}


