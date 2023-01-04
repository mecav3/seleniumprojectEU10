package selen_test.day6_alert_iframe_window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selen_test.SelenUtil;

public class DropDownPractice {
    WebDriver drv;

    @BeforeClass
    public void SetUp() {
        drv = SelenUtil.getdrv("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void dropDownTask5() throws InterruptedException {
        Select stateDropdown = new Select(drv.findElement(By.xpath("//select[@id='state']")));
        stateDropdown.selectByVisibleText("Illinois");
        Thread.sleep(1200);
        stateDropdown.selectByValue("VA");
        Thread.sleep(1200);
        stateDropdown.selectByIndex(5);
        Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(), "California");
    }

    @Test
    public void dropDownTask6() {
        Select yearDropdown = new Select(drv.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(drv.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(drv.findElement(By.xpath("//select[@id='day']")));

        yearDropdown.selectByVisibleText("1924");
        monthDropdown.selectByValue("11");
        dayDropdown.selectByIndex(0);

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertTrue(actualYear.equals("1924"));
        Assert.assertEquals(actualMonth, "December");
        Assert.assertEquals(actualDay,"1");

    }

    @AfterClass
    public void tearDown() {
       // drv.close();
    }

}

/**
 * TC #5: Selecting state from State dropdown and verifying result
 * 1. Open Chrome browser
 * 2. Go to http://practice.cybertekschool.com/dropdown
 * 3. Select Illinois
 * 4. Select Virginia
 * 5. Select California
 * 6. Verify final selected option is California.
 * Use all Select options. (visible text, value, index

 * TC #6: Selecting date on dropdown and verifying
 * 1. Open Chrome browser
 * 2. Go to https://practice.cydeo.com/dropdown
 * 3. Select “December 1st, 1923” and verify it is selected.
 * Select year using : visible text
 * Select month using : value attribute
 * Select day using : index numbe

 */
