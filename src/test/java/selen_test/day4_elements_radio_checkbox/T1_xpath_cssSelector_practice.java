package selen_test.day4_elements_radio_checkbox;

import selen_test.SelenUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practice {
    public static void main(String[] args) {

        WebDriver drv = SelenUtil.getdrv("https://practice.cydeo.com/forgot_password");
        drv.findElement(By.cssSelector("a[class='nav-link']"));
        drv.findElement(By.cssSelector("a.nav-link"));
        drv.findElement(By.cssSelector("a[href='/']"));
//---------------
        drv.findElement(By.cssSelector("div.example > h2"));
        drv.findElement(By.xpath("//h2[text()='Forgot Password']"));
        drv.findElement(By.xpath("//h2[.='Forgot Password']"));
//---------------
        drv.findElement(By.xpath("//label[@for='email']"));
                drv.findElement(By.cssSelector("label[for='email']"));
//---------------
        drv.findElement(By.xpath("//input[@name='email']"));
        drv.findElement(By.xpath("//input[contains(@pattern,'a-z')]"));
//---------------
        drv.findElement(By.xpath("//button[@id='form_submit']"));
        drv.findElement(By.xpath("//button[@class='radius']"));
//---------------
        WebElement element = drv.findElement(By.xpath("//div[@style='text-align: center;']"));
//----------------
        System.out.println(element.isDisplayed());

//<label for="email">E-mail</label>

    }
}
/**
 * a. “Home” link
 * b. “Forgot password” header
 * c. “E-mail” text
 * d. E-mail input box
 * e. “Retrieve password” button
 * f. “Powered by Cydeo text
 * 4. Verify all web elements are displayed.
 * First solve the task with using cssSelector only. Try to create 2 different
 * cssSelector if possible
 * Then solve the task using XPATH only. Try to create 2 different
 * XPATH locator if possibl
 */