package bdd.automation.apis;

import bdd.automation.constants.EndPoint;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;
/**
 * CartApi set the cookies in its constructor and have getCookies() method to fetch the cookies.
 * Here, we eliminate a lot of UI actions.
 * @author Ayisha YEO
 * @version 1.0
 */
public class CartApi {
    private Cookies cookies;

    public CartApi(Cookies cookies){
        this.cookies = cookies;
    }

    public Cookies getCookies(){
        return cookies;
    }

    /**
     * addToCart() method add product to the cart using API call from ApiRequest class post method. In response, we are fetching all the cookies and setting it to the rest-assured Cookies object.
     * @param productId
     * @param quantity
     * @return
     */
    public Response addToCart(int productId, int quantity){
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String, Object> formParams = new HashMap<>();
        formParams.put("product_sku", "");
        formParams.put("product_id", productId);
        formParams.put("quantity", quantity);

        Response response = ApiRequest.post(EndPoint.ADD_TO_CART.url, headers, formParams, cookies);
        if(response.getStatusCode() != 200){
            throw new RuntimeException("Failed to add product" + productId + " to the cart" +
                    ", HTTP Status Code: " + response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }

}
