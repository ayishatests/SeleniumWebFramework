package bdd.automation.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * DriverFactory class will initialize and get the Webdriver.
 * We use ThreadLocal in DriverFactory.java,
 * DataProvider(parallel = true) in TestNGRunnerTest.java and
 * put "maven surefire" dependency in pom.xml to run tests in parallel.
 *
 * @Ayisha YEO
 * @version 1.0
 */
public class DriverFactory {

    /**
     *  initializeDriver() setup browser driver and initialize the webdriver driver, if driver null with browser of our choice .
     * @return driver - WebDriver
     */
    public static WebDriver initializeDriver(String browser)
    {   //Support Multiple Browsers
        WebDriver driver;
        switch (browser) {
            //Initialize browser driver with chrome driver
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            }  //Initialize browser driver with firefox driver
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }  //Initialize browser driver with edge driver
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }  //Initialize browser driver with safari driver
    //    case "safari" -> { driver = new SafariDriver(); }
            default -> throw new IllegalStateException("INVALID BROWSER: " + browser);
        }
        //Common Web Action: Maximize window
        driver.manage().window().maximize();
        return driver;
    }

}
