package cucumberService.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        plugin = {"pretty",
                "json:target/reports/cucumber/cucumber.json",
        },
        monochrome = true,
        glue = {"classpath:cucumberService/definitions"},
        features = {"src/main/resources/featureFiles"}

)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
