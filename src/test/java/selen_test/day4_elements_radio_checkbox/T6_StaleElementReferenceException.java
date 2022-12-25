package selen_test.day4_elements_radio_checkbox;

import selen_test.SelenUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T6_StaleElementReferenceException {
    public static void main(String[] args) {
        WebDriver drv = SelenUtil.getdrv("https://practice.cydeo.com/abtest");
        WebElement element = drv.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println(element.isDisplayed());

        drv.navigate().refresh();

        /** need to reassign driver, because onrefresh reference to drv is lost*/

        element = drv.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println(element.isDisplayed());

    }
}
/**
 * TC #6: StaleElementReferenceException Task
 * 1- Open a chrome browser
 * 2- Go to: https://practice.cydeo.com/abtest
 * 3- Locate “CYDEO” link, verify it is displayed.
 * 4- Refresh the page.
 * 5- Verify it is displayed, again.
 */