package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        plugin = {"json:target/cucumber-json-report.json"},
        //plugin = {"pretty", "html:target/cucumber-html-report.html"},
        glue = "cucumber",
        monochrome = true,
        tags = "@RegressionTest"
)
public class RunTest {
}
