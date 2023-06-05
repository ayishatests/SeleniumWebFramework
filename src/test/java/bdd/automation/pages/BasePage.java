package bdd.automation.pages;

import bdd.automation.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * BasePage class initialize the Selenium Wait and UI elements of the PageFactory.
 * @author Ayisha YEO
 * @version 1.0
 */

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * BasePage(WebDriver driver)  constructor instantiates the webdriver driver, the WebDriverWait and use the PageFactory to instatiate all page objects UI elements at once.
     * @param driver
     */
    public BasePage(WebDriver driver) {//driver comes from page object manager
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Implementation of PageFactory
        PageFactory.initElements(driver, this);
    }

    /**
     * load (String url) method loads a particular page.
     * @param endPoint String
     */
    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }

    /**
     * waitForOverlaysToDisappear method closes the overlay popup.
     * @param overlay
     */
    public void waitForOverlaysToDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAY SIZE" + overlays.size());
        if(overlays.size() > 0){
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("Overlay is invisible");
        } else{
            System.out.println("Overlay is not found");
        }
    }

}
