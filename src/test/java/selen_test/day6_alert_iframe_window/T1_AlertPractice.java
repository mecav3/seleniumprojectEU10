package selen_test.day6_alert_iframe_window;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selen_test.SelenUtil;

public class T1_AlertPractice {
    WebDriver drv;

    @BeforeClass
    void setUp() {
        drv = SelenUtil.getdrv("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void alertTest1() throws InterruptedException {
        drv.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        Alert alert = drv.switchTo().alert();
        Thread.sleep(1200);
        alert.accept();

        Assert.assertTrue(drv.findElement(By.xpath("//p[@id='result']")).isDisplayed());
        Assert.assertEquals(drv.findElement(By.xpath("//p[@id='result']")).getText(), "You successfully clicked an alert");
    }

    @Test
    public void alertdismissTest2() {
    }

    @Test
    public void alertsendTest3() {
    }

}

/**
 * TC #1: Information alert practice
 * 1. Open browser
 * 2. Go to website: http://practice.cydeo.com/javascript_alerts
 * 3. Click to “Click for JS Alert” button
 * 4. Click to OK button from the alert
 * 5. Verify “You successfully clicked an alert” text is displayed.
 * <p>
 * TC #2: Confirmation alert practice
 * 1. Open browser
 * 2. Go to website: http://practice.cydeo.com/javascript_alerts
 * 3. Click to “Click for JS Confirm” button
 * 4. Click to OK button from the alert
 * 5. Verify “You clicked: Ok” text is displayed.
 * <p>
 * TC #3: Information alert practice
 * 1. Open browser
 * 2. Go to website: http://practice.cydeo.com/javascript_alerts
 * 3. Click to “Click for JS Prompt” button
 * 4. Send “hello” text to alert
 * 5. Click to OK button from the alert
 * 6. Verify “You entered: hello” text is displayed
 */
