package selen_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class ToBeExtend {

    protected WebDriver wd;

    public static void pl(String s) {
        System.out.println(s);
    }
    public static void p(String s) {
        System.out.print(s);
    }
    public static void pl(boolean b) {
        System.out.println(b);
    }

    @BeforeTest
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

    public void clearBrowserCache() {
        wd.manage().deleteAllCookies();
    }
}
