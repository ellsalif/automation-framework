package automation.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class PhantomJs implements DriverStrategy{

    /**
     * Constructeur du driver PhantomJS
     */
    @Override
    public WebDriver setStrategy() {
        System.setProperty("phantomjs.binary.path","src/main/ressources/phantomjs.exe");
        DesiredCapabilities desiredCapabilities =  new DesiredCapabilities();
       // desiredCapabilities.setJavascriptEnabled();
        return new PhantomJSDriver(desiredCapabilities);

    }
}
