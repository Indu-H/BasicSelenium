package PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMHomePage {

    WebDriver driver;

    public OrangeHRMHomePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    // Recruitment
    @FindBy(xpath = "//span[text()='Recruitment']")
    private WebElement recruitment;


    // User dropdown
    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
    private WebElement userDropdown;


    // Logout
    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logout;


    public void getRecruitment() {

        recruitment.click();
    }


    public void getUserDropdown() {

        userDropdown.click();
    }


    public void getLogout() {

        logout.click();
    }
}
