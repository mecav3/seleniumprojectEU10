package selen_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtils {

    public static String returnOrderDate(WebDriver drv, String costumerName) {
        String locator = "//td[.='" + costumerName + "']/following-sibling::td[3]";
        WebElement customerDataCell = drv.findElement(By.xpath(locator));
        return customerDataCell.getText();
    }

    public static void orderVerify(WebDriver drv, String costumerName,String expectedOrderDate) {
        String locator = "//td[.='" + costumerName + "']/following-sibling::td[3]";
        WebElement customerDataCell = drv.findElement(By.xpath(locator));
        Assert.assertEquals(expectedOrderDate,customerDataCell.getText());
    }
}
/**
 * TC #2: Web table practice Task1 cont.
 * 1. Create a new class called WebTableUtils.
 * 2. Create two methods to verify order
 *
 * Method #1 info:
 * • Name: returnOrderDate ()
 * • Return type: String
 * • Arg1: WebDriver driver
 * • Arg2: String costumerName
 * This method should accept a costumerName and return the costumer order date
 * as a String.
 *
 * Method #2 info:
 * • Name: orderVerify ()
 * • Return type: void
 * • Arg1: WebDriver driver
 * • Arg2: String costumerName
 * • Arg3: String expectedOrderDate
 * This method should accept above mentioned arguments and internally assert
 * expectedOrderDate matching actualOrderDate
 */

