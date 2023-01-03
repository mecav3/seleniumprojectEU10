package selen_test.day5_testNG_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selen_test.SelenUtil;

import java.util.List;

public class T3_RadioButton_Continue {
    public static void main(String[] args) throws InterruptedException {

        WebDriver drv = SelenUtil.getdrv("https://practice.cydeo.com/radio_buttons");

        clickVerifyRadiobutton(drv, "sport", "hockey");

        Thread.sleep(1500);

        clickVerifyRadiobutton(drv, "sport", "football");

        Thread.sleep(1500);
        clickVerifyRadiobutton(drv, "color", "yellow");

    }

    private static void clickVerifyRadiobutton(WebDriver drv, String nameAttribute, String idValue) {

        List<WebElement> sportRadioButtons = drv.findElements(By.name(nameAttribute));

        for (WebElement each : sportRadioButtons) {
            String eachId = each.getAttribute("id");
            System.out.println(eachId);

            if (eachId.equals(idValue)) {
                each.click();
                System.out.println("---- each is " + eachId);
                System.out.println("---- " + eachId + " isDisplayed() " + each.isDisplayed());
            }
        }
    }
}
/**
 * XPATH PRACTICES
 * DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
 * TC #3: Utility method task for (continuation of Task2)
 * 1. Open Chrome browser
 * 2. Go to https://practice.cydeo.com/radio_buttons
 * 3. Click to “Hockey” radio button
 * 4. Verify “Hockey” radio button is selected after clicking.
 * USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 * Create a utility method to handle above logic.
 * Method name: clickAndVerifyRadioButton
 * Return type: void or boolean
 * Method args:
 * 1. WebDriver
 * 2. Name attribute as String (for providing which group of radio buttons)
 * 3. Id attribute as String (for providing which radio button to be clicked)
 * Method should loop through the given group of radio buttons. When it finds the
 * matching option, it should click and verify option is Selected.
 * Print out verification: true
 */