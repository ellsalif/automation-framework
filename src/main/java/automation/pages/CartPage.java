package automation.pages;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import automation.utils.Constants;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;

    public CartPage()
    {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#post-206 > content > div > div > div.cart-collaterals > div > div > a")
    private WebElement proceedToCheckoutButton;


    public  void ProceedToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", proceedToCheckoutButton);
    }

}
