package selen_test.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selen_test.ToBeExtend;

import java.util.List;

public class Opennexel extends ToBeExtend {
    List<WebElement> we;

    @Test
    public void testCase() {
        wd.get("https://www.openxcell.com");
        we = wd.findElements(By.tagName("a"));
        System.out.println("we.size() = " + we.size());
    }

    @Test
    public void testCase2() {
        int count = 1;
        int co=1;
        for (WebElement e : we) {
            if (!e.getText().isEmpty()) System.out.println(co++ + e.getText());
            else count++;
        }
        System.out.println("count = " + count);
    }
}

/**
 * TC #1: Checking the number of links on the page
 * 1. Open Chrome browser
 * 2. Go to https://www.openxcell.com
 * 3. Count the number of the links on the page and verify
 * Expected: 332
 * TC #2: Printing out the texts of the links on the page
 * 1. Open Chrome browser
 * 2. Go to https://www.openxcell.com
 * 3. Print out all of the texts of the links on the page
 * TC #3: Counting the number of links that does not have text
 * 1. Open Chrome browser
 * 2. Go to https://www.openxcell.com
 * 3. Count the number of links that does not have text and verify
 * Expected: 109
 * NOTE: EXPECTED NUMBER OF LINKS FOR THIS PRACTICE MAY BE DIFFERENT
 * FROM COMPUTER TO COMPUTER, OR FOR DIFFERENT OS (MAC-WINDOWS). SO
 * IF YOU ARE GETTING A DIFFERENT NUMBER, JUST USE THAT NUMBER FOR
 * VERIFICATION.
 */