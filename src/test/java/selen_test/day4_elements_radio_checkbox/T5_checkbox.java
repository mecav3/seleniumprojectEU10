package selen_test.day4_elements_radio_checkbox;

import selen_test.SelenUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_checkbox {
    public static void main(String[] args) throws InterruptedException {

        WebDriver drv = SelenUtil.getdrv("http://practice.cydeo.com/checkboxes");
        WebElement chkbox1 = drv.findElement(By.xpath("//input[@name='checkbox1']"));
        WebElement chkbox2 = drv.findElement(By.xpath("//input[@name='checkbox2']"));

        System.out.println("checkbox isselected : " + chkbox1.isSelected());
        System.out.println("checkbox isselected : " + chkbox2.isSelected());
        Thread.sleep(1000);
        chkbox1.click();
        chkbox2.click();

    }

}
/**
 * 1. Go to http://practice.cydeo.com/checkboxes
 * 2. Confirm checkbox #1 is NOT selected by default
 * 3. Confirm checkbox #2 is SELECTED by default.
 * 4. Click checkbox #1 to select it.
 * 5. Click checkbox #2 to deselect it.
 * 6. Confirm checkbox #1 is SELECTED.
 * 7. Confirm checkbox #2 is NOT selected.
 */