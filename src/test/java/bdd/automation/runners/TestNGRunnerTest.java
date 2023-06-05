package bdd.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * TestNGRunnerTest class is cucumber TestNG test runner, it runs test sequentially and in parallel with data provider.
 * PLUGIN: to setup reports (Html / Json / xml / Extent report).
 * FEATURES: set up features path.
 * GLUE: to set up step definition path.
 * TAGS: to name and run scenarios.
 * MONOCHROME: to get clear formatted output logs in console.
 * @Ayisha YEO
 * @Version 1.0
 */

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"
        },
        features = "src/test/resources/bdd.automation",
        glue = {"bdd/automation"},
        tags = "@Smoke or @Regression",
        monochrome = true
)
//Add @failTest to tags, to implement failed test
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {
        //Run tests in parallel
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
