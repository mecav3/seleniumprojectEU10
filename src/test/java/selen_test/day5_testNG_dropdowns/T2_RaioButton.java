package selen_test.day5_testNG_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selen_test.SelenUtil;

public class T2_RaioButton {
    public static void main(String[] args) throws InterruptedException {

        WebDriver drv = SelenUtil.getdrv("https://practice.cydeo.com/radio_buttons");
        WebElement hockeyButton = drv.findElement(By.xpath("//input[@id='hockey']"));

        Thread.sleep(1000);
        hockeyButton.click();

        System.out.println("hockeyButton.isSelected() " +hockeyButton.isSelected());

    }
}

/**
 * XPATH PRACTICES
 * DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
 * TC #2: Radiobutton handling
 * 1. Open Chrome browser
 * 2. Go to https://practice.cydeo.com/radio_buttons
 * 3. Click to “Hockey” radio button
 * 4. Verify “Hockey” radio button is selected after clicking.
 * USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */