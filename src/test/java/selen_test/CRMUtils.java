package selen_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRMUtils {
    public static void crmLogin(WebDriver drv) {

        drv.findElement(By.xpath("//input[@name=\"USER_LOGIN\"]"))
                .sendKeys("helpdesk1@cybertekschool.com");

        drv.findElement(By.xpath("//input[@name=\"USER_PASSWORD\"]"))
                .sendKeys("UserUser");

        drv.findElement(By.xpath("//input[@value=\"Log In\"]"))
                .click();
    }

    public static void crmLogin(WebDriver drv, String username, String password) {

        drv.findElement(By.xpath("//input[@name=\"USER_LOGIN\"]"))
                .sendKeys(username);

        drv.findElement(By.xpath("//input[@name=\"USER_PASSWORD\"]"))
                .sendKeys(password);

        drv.findElement(By.xpath("//input[@value=\"Log In\"]"))
                .click();
    }
}
/**
 * TC #4: Create utility method
 * 1. Create a new method for login
 * 2. Create a method to make Task3 logic re-usable
 * 3. When method is called, it should simply login
 * This method should have at least 2 overloaded versions.
 * Method #1 info:
 * • Name: login_crm()
 * • Return type: void
 * • Arg1: WebDriver
 * Method #2 info:
 * • Name: login_crm()
 * • Return type: void
 * • Arg1: WebDriver
 * • Arg2: String username
 * • Arg3: String password
 */