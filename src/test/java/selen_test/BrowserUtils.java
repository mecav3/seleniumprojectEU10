package selen_test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {
    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException ignored) {
        }
    }

    public static void switchWindowVerify(WebDriver drv, String expectedInURl, String expectedInTitle) {
        Set<String> handles = drv.getWindowHandles();
//iter
        for (String each : handles) {
            drv.switchTo().window(each);
            System.out.println("current : " + drv.getCurrentUrl());
            if (drv.getCurrentUrl().contains(expectedInURl)) break;
        }

        Assert.assertTrue(drv.getTitle().contains(expectedInTitle));
    }

    public static void verifyTitle(WebDriver drv, String expectedTitle) {
        Assert.assertEquals(drv.getTitle(), expectedTitle);
    }
}

/**
 * TC #2: Create utility method
 * 1. Create a new class called BrowserUtils
 * 2. Create a method to make Task1 logic re-usable
 * 3. When method is called, it should switch window and verify title.
 * Method info:
 * • Name: switchWindowAndVerify
 * • Return type: void
 * • Arg1: WebDriver
 * • Arg2: String expectedInUrl
 * • Arg3: String expectedTitle
 */