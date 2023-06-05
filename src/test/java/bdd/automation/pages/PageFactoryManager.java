package bdd.automation.pages;

import org.openqa.selenium.WebDriver;

/**
 * PageFactoryManager class creates and instantiates each page Object class.
 * Create only instance of the page maintain that one instance throughout the program.
 * @author Ayisha YEO
 * @version 1.0
 */
public class PageFactoryManager {
    private static StorePage storePage;
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;

    public static StorePage getStorePage(WebDriver driver){
        return storePage == null ? new StorePage(driver) : storePage;
    }

    public static CartPage getCartPage(WebDriver driver){
        return cartPage == null ? new CartPage(driver) : cartPage;
    }

    public static CheckoutPage getCheckoutPage(WebDriver driver){
        return checkoutPage == null ? new CheckoutPage(driver) : checkoutPage;
    }

}
