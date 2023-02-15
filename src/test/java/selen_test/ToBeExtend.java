package selen_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ToBeExtend {

    protected WebDriver wd;
    protected String report = "";

    public void pl(String s) {
        System.out.println( s);
        report +=  s;
    }

    public void p(String s) {
        System.out.print(s);
    }

    public void pl(boolean b) {
        System.out.println(b);
    }

    @BeforeTest
    public void setUp() {
        wd = SelenUtil.getdrv();
    }

    public void hold() {
        SelenUtil.sleep(0.5);
    }

    public void hoold() {
        SelenUtil.sleep(1.5);
    }

    public void hooold() {
        SelenUtil.sleep(2.5);
    }

    public void clearBrowserCache() {
        wd.manage().deleteAllCookies();
    }

    @AfterTest
    public void tearDown() {
        //  SelenUtil.kill_driver_process();
    }
}
