package ua.config;

import java.io.IOException;
import java.util.Properties;

public class AppProperties {

    private static AppProperties appProperties;
    private  Properties properties;

    private AppProperties() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        this.properties= new Properties();
        try {
            properties.load(classLoader.getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static Properties getProperties(){
        if (appProperties == null){
            appProperties= new AppProperties();
        }
        return appProperties.properties;
    }
}

