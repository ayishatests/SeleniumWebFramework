package bdd.automation.domainobjects;

import bdd.automation.utils.CookieUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Cookies class set the application state, In selenium good practices to set the application state,
 * we need to use Rest Assured  because UI can be flaky and  slow.
 *  If you write a hundred of test cases you will be duplicating code and test can fail at any step, so it can block your tests.
 * @author Ayisha YEO
 * @version 1.0
 */
public class Cookies {
    private io.restassured.http.Cookies cookies;

    public io.restassured.http.Cookies getCookies() {
        return cookies;
    }

    public void setCookies(io.restassured.http.Cookies cookies) {
        this.cookies = cookies;
    }

    public void injectCookiesToBrowser(WebDriver driver){
        List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        int i = 0;
        for(Cookie cookie: seleniumCookies){
            System.out.println("COUNTER " + i + ": " + cookie.toString());
            driver.manage().addCookie(cookie);
            i++;
        }
        driver.navigate().refresh();
    }
}
