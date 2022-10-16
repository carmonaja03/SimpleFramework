package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","json:target/cucumber-report/cucumber.json"},
        glue = {"steps","hooks"},
        monochrome = true,
        features = "src/test/resources/",
        tags = ("@ronin")
)
public class RunRoninTest {
}
