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

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage()
    {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "billing_first_name")
    private WebElement firstName;

    @FindBy(id = "billing_last_name")
    private  WebElement lastName;

    @FindBy(id = "billing_company")
    private  WebElement companyName;

    @FindBy(id = "select2-billing_country-container")
    private  WebElement countryRegion;

    @FindBy(id = "billing_address_1")
    private WebElement address;

    @FindBy(id = "billing_address_2")
    private  WebElement address1;

    @FindBy(id = "billing_city")
    private  WebElement city;

    @FindBy(id = "billing_postcode")
    private  WebElement zipCode;

    @FindBy(id = "billing_phone")
    private  WebElement phone;

    @FindBy(id = "billing_email")
    private  WebElement emailAddress;

    @FindBy(id = "order_comments")
    private  WebElement oderNote;

    @FindBy(id = "ce4wp_checkout_consent_checkbox")
    private WebElement checkBox;

    @FindBy(id = "Field-numberInput")
    private  WebElement carNumber;

    @FindBy(id = "Field-expiryInput")
    private  WebElement expireDateCard;

    @FindBy(id = "Field-cvcInput")
    private WebElement securityCode;

    @FindBy(css = "#wc-woocommerce_payments-new-payment-method")
    private WebElement saveCard;

    @FindBy(id = "place_order")
    private  WebElement placeOrder;
    @FindBy(css = "#mailpoet_woocommerce_checkout_optin")
    private  WebElement rserveEmail;

    @FindBy(css = "#order_review > table > tfoot > tr.order-total > td > strong > span > bdi")
    private  WebElement totalAmount;
    @FindBy(css = "#post-207 > header > h1" )
    WebElement orderStatus;
    @FindBy(css = "#post-207 > content > div > div.woocommerce > div > p ")
    WebElement lastMessage;



    public  void provideBillingDetails()

    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until((ExpectedConditions.visibilityOf(address)));
        address.sendKeys("Melon");
        address1.sendKeys("apt 202");
    }

    public  String getTotalAmount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(totalAmount));
      return   totalAmount.getText();
    }


public  void paimentCard()
{
    carNumber.sendKeys("1234 3455 6782 9054");
    expireDateCard.sendKeys("12  24" );

}

public  void placeOrder()
{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
    wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrder);
    wait.until(ExpectedConditions.visibilityOf(lastMessage));
}


    public void providePersonalDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(address));
        firstName.sendKeys("Laurentiu");
        lastName.sendKeys("Raducu");
        address.sendKeys("abc");
        zipCode.sendKeys("8000");
        city.sendKeys("Zurich");
        emailAddress.sendKeys("laurentiu@bitheap.tech");
    }

    public String getOrderStatus()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(orderStatus));
        return orderStatus.getText();
    }
}
