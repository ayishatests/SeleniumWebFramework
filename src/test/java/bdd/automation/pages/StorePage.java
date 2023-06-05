package bdd.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.charset.StandardCharsets;

/**
 *  StorePage contain the UI Elements and methods (actions) being performed on store page.
 * @author Ayisha YEO
 * @version 1.0
 */
public class StorePage extends BasePage{

    //WebUI Elements
    @FindBy(css = "a[title='View cart']") private WebElement viewCartLink;

    /**
     * BasePage(WebDriver driver)  constructor instantiates the webdriver driver, the WebDriverWait and the PageFactory.
     *
     * @param driver
     */
    public StorePage(WebDriver driver) {
        super(driver);
    }

    /**
     * addToCart(String productName) method with Explicit waits for better reliability to click on 'addToCart' button and 'viewCart' Link.
     * @param productName
     */

    public void addToCart(String productName){
        //WebUI Elements Actions: Css Locator to access 'Add product to cart' button
        String raw ="a[aria-label='Add “" + productName + "” to your cart']";
        byte[] bytes = raw.getBytes(StandardCharsets.UTF_8);
        String ut8Encoded = new String(bytes, StandardCharsets.UTF_8);
        By addToCartBtn = By.cssSelector(ut8Encoded);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }

}
