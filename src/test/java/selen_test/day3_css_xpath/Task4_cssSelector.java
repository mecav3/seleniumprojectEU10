package selen_test.day3_css_xpath;

import selen_test.SelenUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task4_cssSelector {
    public static void main(String[] args) {

        WebDriver drv = SelenUtil.getdrv("https://login1.nextbasecrm.com/?forgot_password=yes");

        System.out.println(
                drv.findElement(
                        By.cssSelector("button[class='login-btn']"))
                        .getText()
                        .equals("Reset password"));

    }
}
/**
 * Open a chrome browser
 * 2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
 * 3- Verify “Reset password” button text is as expected:
 * Expected: Reset password
 */
