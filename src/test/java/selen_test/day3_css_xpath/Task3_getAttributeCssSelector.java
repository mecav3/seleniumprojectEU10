package selen_test.day3_css_xpath;

import selen_test.SelenUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task3_getAttributeCssSelector {
    public static void main(String[] args) {

        WebDriver drv = SelenUtil.getdrv("https://login1.nextbasecrm.com/");

        WebElement element = drv.findElement(By.cssSelector("input[class='login-btn']"));

        String expected = "Log In";

        System.out.println(expected.equals(element.getAttribute("value")));


    }
    }
