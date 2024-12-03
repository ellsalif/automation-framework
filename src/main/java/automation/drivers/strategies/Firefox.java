package automation.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox implements DriverStrategy{


    /**
     * constructeur du driver firefox
     */
    @Override
    public WebDriver setStrategy() {
       FirefoxOptions options = new FirefoxOptions();
       options.addPreference("javascript.enabled", false);
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        return new FirefoxDriver();
    }
}
