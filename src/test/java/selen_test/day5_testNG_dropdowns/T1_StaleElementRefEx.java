package selen_test.day5_testNG_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selen_test.SelenUtil;

public class T1_StaleElementRefEx {
    public static void main(String[] args) throws InterruptedException {

        WebDriver drv = SelenUtil.getdrv("https://practice.cydeo.com/add_remove_elements/");

        WebElement addElmButton = drv.findElement(By.xpath("//button[.='Add Element']"));
        addElmButton.click();

        WebElement delButton = drv.findElement(By.xpath("//button[@class='added-manually']"));
        System.out.println("delButton.isDisplayed()" +delButton.isDisplayed());

        Thread.sleep(1000);

        delButton.click();
// ctrl alt T
        try {
            System.out.println(delButton.isDisplayed());  // button deleted so it gives exception
        } catch (StaleElementReferenceException e) {
            System.out.println("exception thrown, element you try to reach is deleted");
        }
    }
}

/**
 * XPATH PRACTICES
 * DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
 * TC #1: StaleElementReferenceException handling  // deleted or not connected to DOM anymore
 * 1. Open Chrome browser
 * 2. Go to https://practice.cydeo.com/add_remove_elements/
 * 3. Click to “Add Element” button
 * 4. Verify “Delete” button is displayed after clicking.
 * 5. Click to “Delete” button.
 * 6. Verify “Delete” button is NOT displayed after clicking.
 * USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */