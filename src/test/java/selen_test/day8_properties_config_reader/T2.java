package selen_test.day8_properties_config_reader;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selen_test.SelenUtil;

public class T2 {
    WebDriver wd;
    @AfterMethod
    public void tearDown() {

    }

    @BeforeMethod
    public void setUp() {
        wd= SelenUtil.getdrv("");
    }

    @Test
    public void testName() {

    }
}
