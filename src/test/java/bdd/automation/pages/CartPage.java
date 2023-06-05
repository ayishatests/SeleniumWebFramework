package bdd.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * CartPage class contain the UI elements of product Name and Product Quantity as well as the link to the checkout button.
 * @author Ayisha YEO
 * @version 1.0
 */
public class CartPage extends BasePage{
    @FindBy(css = "td[class='product-name'] a") private WebElement productNameFld;
    @FindBy(css = "input[type=\"number\"]") private WebElement productQuantityFld;
    @FindBy(css = ".checkout-button") private WebElement proceedToCheckoutBtn;

    /**
     * BasePage(WebDriver driver)  constructor instantiates the webdriver driver, the WebDriverWait and the PageFactory.
     *
     * @param driver
     */
    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * getProductName() method gets the product name.
     * @return productNameFld
     */
    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOf(productNameFld)).getText();
    }

    /**
     * getProductQty() method gets the product quantity.
     * @return productQtyFld
     */
    public int getProductQuantity(){
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(productQuantityFld))
                .getAttribute("value"));
    }

    /**
     * proceedToCheckout() method give access to check out page, by clicking on proceedToCheckout button.
     */
    public void checkout(){
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn)).click();
    }

}
