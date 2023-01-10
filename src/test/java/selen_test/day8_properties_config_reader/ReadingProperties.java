package selen_test.day8_properties_config_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties() throws IOException {
        Properties properties = new Properties();

        FileInputStream file = new FileInputStream("configuration.properties");

        properties.load(file);

        System.out.println("1 "+properties.getProperty("browser"));
        System.out.println("2 "+properties.getProperty("env"));
        System.out.println("3 "+properties.getProperty("usernam"));
        System.out.println("4 "+properties.getProperty("username"));



    }
}
