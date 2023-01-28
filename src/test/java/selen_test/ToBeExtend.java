package selen_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class ToBeExtend {
    protected WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = SelenUtil.getdrv();
    }

    public void hold(){
        SelenUtil.sleep(0.5);
    }

    public void hoold(){
        SelenUtil.sleep(1.5);
    }

    public void hooold(){
        SelenUtil.sleep(2.5);
    }
}
