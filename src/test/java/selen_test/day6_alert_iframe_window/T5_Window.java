package selen_test.day6_alert_iframe_window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selen_test.SelenUtil;

public class T5_Window {
    WebDriver drv;

    @BeforeClass
    void setUp() {
        drv = SelenUtil.getdrv("https://practice.cydeo.com/windows");
    }

    @Test
    public void testWindows() {
        Assert.assertEquals(drv.getTitle(), "Windows");

        System.out.println("window handle : " +drv.getWindowHandle());

        drv.findElement(By.xpath("//a[.='Click Here']")).click();
   /** clicken and open new window tab but seleneniun doesnt switch to new window*/

        Assert.assertEquals(drv.getTitle(), "Windows");

       for (String each : drv.getWindowHandles() ) {
           drv.switchTo().window(each);
           System.out.println(drv.getTitle());
       }

        Assert.assertEquals(drv.getTitle(), "New Window");


    }
}
/**
 * TC #5: Window Handle practice
 * 1. Create a new class called: T5_WindowsPractice
 * 2. Create new test and make set ups
 * 3. Go to : https://practice.cydeo.com/windows
 * 4. Assert: Title is “Windows”
 * 5. Click to: “Click Here” link
 * 6. Switch to new Window.
 * 7. Assert: Title is “New Window”
 */
