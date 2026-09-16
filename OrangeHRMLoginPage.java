package PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage {

    WebDriver driver;

    public OrangeHRMLoginPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    // Username
    @FindBy(name = "username")
    private WebElement username;

    // Password
    @FindBy(name = "password")
    private WebElement password;

    // Login button
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;


    public void getUsername(String value) {

        username.sendKeys(value);
    }


    public void getPassword(String value) {

        password.sendKeys(value);
    }


    public void getLoginButton() {

        loginButton.click();
    }
}
