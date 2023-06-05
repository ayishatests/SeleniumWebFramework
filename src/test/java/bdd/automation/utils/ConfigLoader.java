package bdd.automation.utils;

import bdd.automation.constants.EnvType;

import java.util.Properties;

/**
 * ConfigLoader class sets different environments and configures their property files.
 * @author Ayisha YEO
 * @version 1.0
 */
public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;


    /**
     * ConfigLoader() configures property files for different environments.
     * we set STAGE and PROD Environment.
     */
    private ConfigLoader(){
        //convert system property with default value
        String env = System.getProperty("env", String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env)){
            case PROD -> properties = PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
            case STAGE -> properties = PropertyUtils.propertyLoader("src/test/resources/stage_config.properties");
            default -> throw new IllegalStateException("INVALID ENV: " + env);
        }
    }

    /**
     * getInstance() gets instance of ConfigLoader class.
     * @return ConfigLoader
     */
    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    /**
     * getBaseUrl() gets the baseUrl from each environment (PROD or STAGE).
     * @return String
     */
    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not specified in the stage_config.properties file");
    }

}
