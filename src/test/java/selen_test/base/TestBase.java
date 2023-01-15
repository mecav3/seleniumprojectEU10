package selen_test.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import selen_test.SelenUtil;

 public abstract class TestBase {

    protected WebDriver drv;

    @BeforeClass
    protected void setUp() {
        drv = SelenUtil.getdrv("http://login1.nextbasecrm.com/");
    }

    @AfterClass
    protected void tearDown(){
        drv.close();
    }

}
