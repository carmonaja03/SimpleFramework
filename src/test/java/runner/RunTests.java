package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","json:target/cucumber-report/cucumber.json"},
        tags = ("@sampleTest1 or @sampleTest2"),
        glue = {"steps","hooks"},
        features = "src/test/resources/"
)
public class RunTests {
}
