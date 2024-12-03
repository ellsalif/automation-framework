package automation.drivers.strategies;

import automation.utils.Constants;

public class DriverStrategyImplementer {

    public static DriverStrategy choseStrategy(String strategy){
        return switch (strategy) {
            case Constants.CHROME -> new Chrome();
            case Constants.PHANTOMJS -> new PhantomJs();
            case Constants.FIREFOX -> new Firefox();
            default -> null;
        };
    }
}
