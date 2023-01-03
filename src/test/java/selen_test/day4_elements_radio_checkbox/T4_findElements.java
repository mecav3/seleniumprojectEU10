package selen_test.day4_elements_radio_checkbox;

import selen_test.SelenUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T4_findElements {
    public static void main(String[] args) {
        WebDriver drv = SelenUtil.getdrv("https://practice.cydeo.com/abtest");
        List<WebElement> allLinks = drv.findElements(By.tagName("a"));
        System.out.println(allLinks.size());
        for (WebElement link : allLinks) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        }
    }

}

/**
 * TC #4: FindElements Task
 * 1- Open a chrome browser
 * 2- Go to: https://practice.cydeo.com/abtest
 * 3- Locate all the links in the page.
 * 4- Print out the number of the links on the page.
 * 5- Print out the texts of the links.
 * 6- Print out the HREF attribute values of the link
 */