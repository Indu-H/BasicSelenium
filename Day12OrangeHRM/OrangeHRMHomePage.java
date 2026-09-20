package PomUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMHomePage {

    WebDriver driver;
    WebDriverWait wait;

    public OrangeHRMHomePage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );

        PageFactory.initElements(driver, this);
    }

    // RECRUITMENT

    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement recruitment;

    // MY INFO

    @FindBy(xpath = "//span[normalize-space()='My Info']")
    private WebElement myInfo;

    // USER DROPDOWN

    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
    private WebElement userDropdown;

    // LOGOUT

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logout;

    // CLICK RECRUITMENT

    public void clickRecruitment() {

        wait.until(
                ExpectedConditions.elementToBeClickable(recruitment)
        );

        recruitment.click();

        wait.until(
                ExpectedConditions.urlContains("/recruitment")
        );
    }

    // CLICK MY INFO

    public void clickMyInfo() {

        wait.until(
                ExpectedConditions.elementToBeClickable(myInfo)
        );

        myInfo.click();

        wait.until(
                ExpectedConditions.urlContains("/pim/viewPersonalDetails")
        );
    }

    // CLICK USER DROPDOWN

    public void clickUserDropdown() {

        wait.until(
                ExpectedConditions.elementToBeClickable(userDropdown)
        );

        userDropdown.click();
    }

    // LOGOUT

    public void logout() {

        clickUserDropdown();

        wait.until(
                ExpectedConditions.elementToBeClickable(logout)
        );

        logout.click();

        wait.until(
                ExpectedConditions.urlContains("/auth/login")
        );

        System.out.println("Logout completed.");
    }
}
