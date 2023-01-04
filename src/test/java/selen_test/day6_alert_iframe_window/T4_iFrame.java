package selen_test.day6_alert_iframe_window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selen_test.SelenUtil;

public class T4_iFrame {
    WebDriver drv;

    @BeforeClass
    void setUp() {
        drv = SelenUtil.getdrv("https://practice.cydeo.com/iframe");
    }

    // @Ignore
    @Test
    public void iFrameTest1() {
        drv.switchTo().frame("mce_0_ifr");
//        drv.switchTo().frame(0);
//        drv.switchTo().frame(drv.findElement(By.xpath("//iframe[@id=''mce_0_ifr']")));

        Assert.assertTrue(drv.findElement(By.xpath("//p")).isDisplayed());

        /** iframe dont switch back automatically like alert */
        drv.switchTo().parentFrame();

        Assert.assertTrue(drv.findElement(By.xpath("//h3")).isDisplayed());
    }

}

/**
 * TC #4: Iframe practice
 * 1. Create a new class called: T4_Iframes
 * 2. Create new test and make set ups
 * 3. Go to: https://practice.cydeo.com/iframe
 * 4. Assert: “Your content goes here.” Text is displayed.
 * 5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
 */
