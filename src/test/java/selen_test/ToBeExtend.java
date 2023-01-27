package selen_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import selen_test.SelenUtil;

public class ToBeExtend {
    protected WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = SelenUtil.getdrv();
    }
}
