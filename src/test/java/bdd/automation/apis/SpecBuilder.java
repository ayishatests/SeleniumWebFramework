package bdd.automation.apis;

import bdd.automation.utils.ConfigLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
/**
 * SpecBuilder class holds the RequestSpecification and ResponseSpecification.
 * Basically the common things that we send as part of the API Request.
 * These classes are good practices and are Reusable REST Assured Method:
 * SpecBuilder, ApiRequest, CartApi.
 * @author Ayisha YEO
 * @version 1.0
 */

public class SpecBuilder {
    /**
     *  getRequestSpec() gets the API Request Specification
     * @return RequestSpecification
     */
    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().
                setBaseUri(ConfigLoader.getInstance().getBaseUrl()).
                log(LogDetail.ALL).
                build();
    }

    /**
     * getResponseSpec() gets the API Response Specification.
     * @return ResponseSpecification
     */
    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().
                log(LogDetail.ALL).
                build();
    }
}
