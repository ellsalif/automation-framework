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
import automation.utils.Utils;

import java.time.Duration;

public class ShopPage {
    private WebDriver driver;

    public ShopPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#main > ul > li.product.type-product.post-560.status-publish.instock.product_cat-mentorship.has-post-thumbnail.virtual.purchasable.product-type-simple > a.button.product_type_simple.add_to_cart_button.ajax_add_to_cart")
    private WebElement addToCarButton;

    @FindBy(css = "body > nav > div.wb4wp-wrapper > div.wb4wp-right > div > a > span")
    private  WebElement numberOfProducts;

    @FindBy(css = "body > nav > div.wb4wp-wrapper > div.wb4wp-right > div > a")
    private WebElement carButton;

    @FindBy(css = "#main > nav > ul > li:nth-child(2) > a")
    private  WebElement thirdPage;

    public  void addElementToCart() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCarButton);
        for(int i= 0; i <1000; i++){
            if (numberOfProducts.getText().contains(Constants.CART_QUANTITY)){
                System.out.println("Car has been update");
                return;
            }
            else {
                continue;
            }
        }



        System.out.println("Car has not been update");
        Utils.takeScreenshot();
    }

    public  void  proceedToCheckout()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(carButton));
        carButton.click();
    }

    public void goToThirdPage() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", thirdPage);
    }

    public  String getNumberOfProducts()
    {
        return numberOfProducts.getText();
    }

}
