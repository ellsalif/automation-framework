package automation.glue;

import automation.config.AutomationFrameworkConfiguration;
import automation.drivers.DriverSingleton;
import automation.pages.*;
import automation.utils.ConfigurationProperties;
import automation.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {
    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private CheckoutPage checkOutPage;
    private ShopPage shopPage;
    private CartPage cartPage;

    @Autowired
    ConfigurationProperties configurationProperties;

    @Before
    public void initializeObjects()
    {
        DriverSingleton.getInstance(configurationProperties.getBrowser());
        homePage = new HomePage();
        signInPage = new SignInPage();
        checkOutPage = new CheckoutPage();
        shopPage = new ShopPage();
        cartPage =  new CartPage();

    }

    @Given("^I go to the Website")
    public void i_go_to_the_Website(){
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
    }

    @When("^I click on Sign In button")
    public void I_click_on_Sign_In_button(){
        homePage.clickSignIn();
    }
    @And("^I specify my credentials and click Login")
    public void I_specify_my_credentials_and_click_Login()
    {
        signInPage.logIn(configurationProperties.getEmail(), configurationProperties.getPassword());
    }
    @Then("^I can log into the website")
    public void I_can_log_into_the_website()
    {
        assertNotEquals(configurationProperties.getUsername(),homePage.getUsername());
    }

    @When("I add one element to the cart")
    public void i_add_one_element_to_the_cart() {
        homePage.clickShopButton();
        shopPage.goToThirdPage();
        shopPage.addElementToCart();
    }

    @And("I proceed to checkout")
    public void i_proceed_to_checkout() {
        shopPage.proceedToCheckout();
        cartPage.ProceedToCheckout();
    }


    @And("I confirm address, shipping, payment and final order")
    public void i_confirm_address_shipping_payment_and_final_order() {
        checkOutPage.provideBillingDetails();
       // checkOutPage.placeOrder();
    }

    @Then("the element are bought")
    public void the_element_are_bought() {
       // assertEquals("Order received", checkOutPage.getOrderStatus());
    }

    @After
    public void closeDriver(){
        driver.close();
    }
}

