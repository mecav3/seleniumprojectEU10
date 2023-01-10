package selen_test;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
        } catch (Exception e) {
            System.out.println("ConfigurationReader File Exception");
        }
    }

    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }
}
