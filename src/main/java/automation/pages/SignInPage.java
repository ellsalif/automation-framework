package automation.pages;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import automation.utils.Utils;

import java.time.Duration;

public class SignInPage {
    protected WebDriver driver;

    public SignInPage()
    {
        driver= DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".xoo-el-username_cont > div:nth-child(1) > input:nth-child(2)")
    private WebElement signInEmail;

    @FindBy(css = "div.xoo-aff-cont-password:nth-child(2) > div:nth-child(1) > input:nth-child(2)")
    private  WebElement password;

    @FindBy(css = "button.button:nth-child(4)")
    private  WebElement getSignInButton;

    public  void  logIn(String email, String password)
    {
        signInEmail.sendKeys(email);
        this.password.sendKeys(Utils.decode64(password));
        getSignInButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(signInEmail));
    }



}
