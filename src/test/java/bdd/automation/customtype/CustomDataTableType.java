package bdd.automation.customtype;

import bdd.automation.domainobjects.BillingDetails;
import io.cucumber.java.DataTableType;

import java.util.Map;

/**
 * CustomDataTableType converts the table from gherkin directly to domain object.
 * @author Ayisha YEO
 * @version 1.0
 */
public class CustomDataTableType {

    @DataTableType
    public BillingDetails billingDetailsEntry(Map<String, String> entry){
        return new BillingDetails(entry.get("firstname"),
                entry.get("lastname"),
                entry.get("address_line1"),
                entry.get("city"),
                entry.get("state"),
                entry.get("zip"),
                entry.get("email"));
    }
}
