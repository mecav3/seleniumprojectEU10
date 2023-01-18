package selen_test.day10_upload_actions_jsexec;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import selen_test.BrowserUtils;
import selen_test.Driver;

public class T6_JS_Executer {
    @Test
    public void testName() {
        Driver.getDriver().get("https://www.softwaretestinghelp.com");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        BrowserUtils.sleep(1);
        js.executeScript("window.scrollBy(0,500)");

        BrowserUtils.sleep(1);
        js.executeScript("window.scrollBy(0,500)");

        BrowserUtils.sleep(1);
        js.executeScript("window.scrollBy(0,-500)");

    }
}

/**
 * TC #6: Scroll using JavascriptExecutor
 * 1- Open a chrome browser
 * 2- Go to: https://practice.cydeo.com/infinite_scroll
 * 3- Use below JavaScript method and scroll
 * a. 750 pixels down 10 times.
 * b. 750 pixels up 10 times
 * JavaScript method to use : window.scrollBy(0,0
 */
