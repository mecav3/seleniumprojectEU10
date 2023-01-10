package selen_test.day8_properties_config_reader;

import org.testng.annotations.Test;

public class LearningProperties {
    @Test
    public void java_properties() {
        System.out.println(
                System.getProperty("os.name")
                        + " - " +
                        System.getProperty("user.name")
        );
    }
}
