package ua.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppProperties {

    private static AppProperties appProperties;
    private  Properties properties;

    private AppProperties() {
        this.properties= new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/app.properties"));
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
