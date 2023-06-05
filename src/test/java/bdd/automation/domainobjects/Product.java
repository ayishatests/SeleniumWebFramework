package bdd.automation.domainobjects;

/**
 * Product class contains information about a product like name, quantity...
 * @author Ayisha YEO
 * @version 1.0
 */
public class Product {
    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
