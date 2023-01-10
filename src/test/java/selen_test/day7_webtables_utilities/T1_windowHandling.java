package selen_test.day7_webtables_utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selen_test.BrowserUtils;
import selen_test.SelenUtil;

public class T1_windowHandling {

    private WebDriver drv;

    @BeforeClass
    public void setUp() {
        drv = SelenUtil.getdrv();
    }

    @Test
    public void testWindowHandle() {
        drv.get("https://www.amazon.com");

        ((JavascriptExecutor) drv).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) drv).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) drv).executeScript("window.open('https://facebook.com','_blank');");

        BrowserUtils.switchWindowVerify(drv, "etsy","Etsy");
    }
}

/**
 * TC #1: Window Handle practice
 * 1. Create new test and make set ups
 * 2. Go to : https://www.amazon.com
 * 3. Copy paste the lines from below into your class
 * 4. Create a logic to switch to the tab where Etsy.com is open
 * 5. Assert: Title contains “Etsy”
 * Lines to be pasted:
 * ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
 * ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
 * ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
 * These lines will simply open new tabs using something called JavascriptExecutor
 * and get those pages. We will learn JavascriptExecutor later as well
 */
