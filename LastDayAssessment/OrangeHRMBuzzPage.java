package PomUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMBuzzPage {


WebDriver driver;
WebDriverWait wait;

public OrangeHRMBuzzPage(WebDriver driver) {

    this.driver = driver;

    this.wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(30)
    );

    PageFactory.initElements(driver, this);
}

@FindBy(xpath="//div[@class='oxd-buzz-post oxd-buzz-post--active']/descendant::textarea[@class='oxd-buzz-post-input']")
private WebElement Buzzfield;

@FindBy(xpath="//div[@class='oxd-buzz-post oxd-buzz-post--active']//button[@type='submit']")
private WebElement Postbutton;

public void enterBuzzfield(String value) {

    wait.until(ExpectedConditions.elementToBeClickable(Buzzfield));

    Buzzfield.click();

    Buzzfield.sendKeys(value);
}

public void clickPostbutton() {

    wait.until(ExpectedConditions.elementToBeClickable(Postbutton));

    Postbutton.click();
}

public boolean verifyRecentPost(String value) {

    WebElement recentPost = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'oxd-buzz-post')]//*[contains(text(),'" + value + "')]")
            )
    );

    return recentPost.isDisplayed();
}


}
