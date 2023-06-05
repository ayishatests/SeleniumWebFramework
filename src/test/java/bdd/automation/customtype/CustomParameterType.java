package bdd.automation.customtype;

import bdd.automation.domainobjects.Product;
import io.cucumber.java.ParameterType;

/**
 * CustomParameterType manages parameters in gherkin steps as generic parameters.
 * @author Ayisha YEO
 * @version 1.0
 */
public class CustomParameterType {

    @ParameterType(".*")
    public Product product(String name){
        return new Product(name.replace("\"", ""));
    }
}
