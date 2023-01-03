package selen_test.day5_testNG_dropdowns;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selen_test.SelenUtil;

public class TestNG_Selenium {
    WebDriver drv;

    @BeforeMethod
    public void setUp() {
        drv = SelenUtil.getdrv("https://www.google.com");
    }

    @Test
    public void selenium_test() {

        Assert.assertEquals(drv.getTitle(), "Google", "my 1st failure message if it fails");
    }

    @Test
    public void selenium_test1() {

        Assert.assertEquals(drv.getTitle(), "Googl", "my 2nd failure message if it fails");
    }

    @AfterMethod
    public void tearDown() {
        drv.close();
    }
}
