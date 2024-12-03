package automation.drivers;

import automation.drivers.strategies.DriverStrategy;
import automation.drivers.strategies.DriverStrategyImplementer;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class DriverSingleton {
    private  static DriverSingleton instance = null;
    private  static WebDriver driver;

    private DriverSingleton(String driver){
     instantiate(driver);
    }

    public WebDriver instantiate(String strategy)
    {
        DriverStrategy driverStrategy = DriverStrategyImplementer.choseStrategy(strategy);
        assert driverStrategy != null;
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public  static  DriverSingleton getInstance(String driver){
        if (instance == null){
            System.out.println("le driver n'est vide");
            instance = new DriverSingleton(driver);
        }
        System.out.println("le driver est vide");

        return instance;
    }

    public static void closeObjectInstance(){
        instance = null;
        driver.quit();

    }
    public  static  WebDriver getDriver(){
        return driver;
    }

}
