package bdd.automation.constants;

/**
 * EndPoint enum stores baseurl page endpoints (other pages links from the base url page). e.g: going to store page, checkout page, account page, ...
 * @author Ayisha YEO
 * @version 1.0
 */
public enum EndPoint {
    STORE("/store"),
    ACCOUNT("/account"),
    ADD_TO_CART("/?wc-ajax=add_to_cart"),
    CHECKOUT("/checkout");

    public final String url;

    EndPoint(String url) {
        this.url = url;
    }
}
