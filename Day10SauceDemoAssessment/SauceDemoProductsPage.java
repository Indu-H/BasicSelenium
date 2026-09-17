package PomUtilities;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemoProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    public SauceDemoProductsPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        PageFactory.initElements(driver, this);
    }

    // PRODUCTS PAGE TITLE
    @FindBy(xpath = "//span[@class='title' and normalize-space()='Products']")
    private WebElement productsTitle;

    // CART LINK
    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    // CART BADGE
    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;


    // VERIFY PRODUCTS PAGE
    public boolean verifyProductsPage() {

        return wait.until(
            ExpectedConditions.visibilityOf(productsTitle)
        ).isDisplayed();
    }


    // ADD SAUCE LABS BACKPACK
    public void addSauceLabsBackpack() {

        By backpackButton = By.xpath(
            "//div[contains(@class,'inventory_item')]" +
            "[.//div[normalize-space()='Sauce Labs Backpack']]" +
            "//button"
        );

        WebElement addButton = wait.until(
            ExpectedConditions.elementToBeClickable(backpackButton)
        );

        addButton.click();
    }


    // VERIFY CART CONTAINS 1 ITEM
    public boolean verifyCartCount(String expectedCount) {

        wait.until(
            ExpectedConditions.visibilityOf(cartBadge)
        );

        String actualCount = cartBadge.getText();

        return actualCount.equals(expectedCount);
    }


    // OPEN CART
    public void clickCart() {

        wait.until(ExpectedConditions.elementToBeClickable(cartLink));

        cartLink.click();
    }
}


