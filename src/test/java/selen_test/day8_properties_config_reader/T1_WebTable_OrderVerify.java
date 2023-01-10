package selen_test.day8_properties_config_reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selen_test.SelenUtil;
import selen_test.WebTableUtils;

public class T1_WebTable_OrderVerify {
    WebDriver drv;

    @Test
    public void testName() {
        WebElement we = drv.findElement(By.xpath("//table[@class=\"SampleTable\"]//td[.='Bob Martin']"));
        System.out.println("---" + we.getText());
        Assert.assertEquals(we.getText(), "Bob Martin");

        we = drv.findElement(By.xpath(
                "//table[@class=\"SampleTable\"]//td[.='Bob Martin']/following-sibling::td[3]"));
        Assert.assertEquals(we.getText(), "12/31/2021");
    }

    @Test
    public void test2() {

        System.out.println(
                WebTableUtils.returnOrderDate(drv, "Alexandra Gray")
        );
    }
        @Test
        public void test3() {
            WebTableUtils.orderVerify(drv,
                    "Bart Fisher",
                    "01/16/2021");
        }

    @BeforeClass
    public void setUp() {
        drv = SelenUtil.getdrv("https://practice.cydeo.com/web-tables");
    }

    @AfterClass
    public void tearDown() {
        //  drv.close();
    }
}

/**
 * TC #1: Web table practice
 * 1. Go to: https://practice.cydeo.com/web-tables
 * 2. Verify Bob’s name is listed as expected.
 * Expected: “Bob Martin”
 * 3. Verify Bob Martin’s order date is as expected
 * Expected: 12/31/2021
 */
