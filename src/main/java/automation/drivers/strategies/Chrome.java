package automation.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome  implements DriverStrategy {


    /**
     * constructeur du driver chorme
     * @return
     */

    @Override
    public WebDriver setStrategy() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--no-sandbox");
        options.addArguments("--enable-javascript");

        return new ChromeDriver(options);
    }
}
