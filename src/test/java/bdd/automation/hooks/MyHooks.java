package bdd.automation.hooks;

import bdd.automation.context.TestContext;
import bdd.automation.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * MyHooks used to set up and teardown drivers before and after each scenario, it also helps us capture screenshot after each failed test.
 * @author Ayisha YEO
 * @version 1.0
 */
public class MyHooks {

    private WebDriver driver;
    private final TestContext context;
    public MyHooks(TestContext context){
        this.context = context;
    }

    /**
     * beforeScenario() initialize the Driver before each scenario.
     */
    @Before
    public void beforeScenario(){
        //We get browser from system property {maven} or set default browser as chrome.
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
        //we set driver we want to inject in different classes
        context.driver = driver;
    }

    /**
     * afterScenario() quit the driver before each scenario.
     */
    @After
    public void afterScenario(){
        driver.quit();
    }

    /**
     * addScreenshot() captures screenshot after each failed step and attach it to Spark Extent Report.
     * It is executed if only test has failed.
     * @param scenario
     */
    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        if(scenario.isFailed())
        {
            //Take Screenshot
            File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //Convert screenshot from file to byte array (with commons.io dependency)
            byte[] screenshotFile = FileUtils.readFileToByteArray(screenshot);
            //Attachment scenario screenshot to Spark Report
            scenario.attach(screenshotFile,"image/png","Screenshot");
        }

    }

}
