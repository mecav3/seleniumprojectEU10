package selen_test.day5_testNG_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selen_test.SelenUtil;

public class T4_SimpleDropdown {

    WebDriver drv;

    @BeforeClass
    public void setUp() {
        drv = SelenUtil.getdrv("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void simpleDropdownTest() {
        WebElement element = drv.findElement(By.xpath("//select[@id='dropdown']"));
        Select simpleDropdown = new Select(element);
        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();
        String actualSimpleDropdownText = currentlySelectedOption.getText();
        Assert.assertEquals(actualSimpleDropdownText, "Please select an option");
    }

    @Test
    public void simpleDropdownTest1() {

        Select simpleDropdown = new Select(drv.findElement(By.xpath("//select[@id='state']")));

        String actualSimpleDropdownText = simpleDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSimpleDropdownText, "Select a State");
    }
}

/**
 * TC#4: Verifying “Simple dropdown” and “State selection” dropdown
 * default values
 * 1. Open Chrome browser
 * 2. Go to https://practice.cydeo.com/dropdown
 * 3. Verify “Simple dropdown” default selected value is correct
 * Expected: “Please select an option”
 * 4. Verify “State selection” default selected value is correct
 * Expected: “Select a State”
 */
