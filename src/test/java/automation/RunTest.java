package automation;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports"},
        features ="src/main/resources/features",
        glue = {"automation.glue"}

)
public class RunTest {
    @Test
    public  void tests(){}


    public static void main(String[] args) {
        SpringApplication.run(RunTest.class, args);
    }
}
