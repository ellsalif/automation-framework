package automation.drivers.strategies;

import org.openqa.selenium.WebDriver;

public interface DriverStrategy {

    /**
     *  methode d'initialisation du driver
     * @return objet driver selenium
     */

    WebDriver setStrategy();

}