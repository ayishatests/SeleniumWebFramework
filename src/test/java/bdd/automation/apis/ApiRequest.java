package bdd.automation.apis;

import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
/**
 * ApiRequest class holds the reusable GET and POST methods.
 * @author Ayisha YEO
 * @version 1.0
 */
public class ApiRequest extends SpecBuilder{
    /**
     * post() to make request in form of Given, When and Then.
     * @param endPoint
     * @param headers
     * @param formParams
     * @param cookies
     * @return Response
     */
    public static Response post(String endPoint, Headers headers,
                                HashMap<String, Object> formParams, Cookies cookies){
        return given(getRequestSpec()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
        when().
                post(endPoint).
        then().spec(getResponseSpec()).
                extract().
                response();
    }

    /**
     * get() gets response in form of Given, When and Then.
     * @param endPoint
     * @param cookies
     * @return Response
     */
    public static Response get(String endPoint, Cookies cookies){
        return given(getRequestSpec()).
                cookies(cookies).
        when().
                get(endPoint).
        then().spec(getResponseSpec()).
                extract().
                response();
    }

}
