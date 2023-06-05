package bdd.automation.utils;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

/**
 * CookieUtils integrates API to selenium by converting rest assured cookies to selenium cookies.
 * @author  Ayisha YEO
 * @version 1.0
 */
public class CookieUtils {

    /**
     *  convertRestAssuredCookiesToSeleniumCookies() method converts rest assured cookies to selenium cookies
     * @param cookies Cookies
     * @return List of Cookie
     */
    public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies){
        List<io.restassured.http.Cookie> restAssuredCookies;
        restAssuredCookies = cookies.asList();
        List<Cookie> seleniumCookies = new ArrayList<>();
        for(io.restassured.http.Cookie cookie: restAssuredCookies){
            seleniumCookies.add(new Cookie(cookie.getName(), cookie.getValue(), cookie.getDomain(),
                    cookie.getPath(), cookie.getExpiryDate(), cookie.isSecured(), cookie.isHttpOnly(),
                    cookie.getSameSite()));
        }
        return seleniumCookies;
    }
}
