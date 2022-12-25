package selen_test.homework;

import selen_test.SelenUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Facebook_Task2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver drv = SelenUtil.getdrv("https://www.facebook.com");

        drv.findElement(By.id("email")).sendKeys("erg56yyhhgevv");
        drv.findElement(By.id("pass")).sendKeys("invalidpass" + Keys.ENTER);

        Thread.sleep(1500);

        System.out.println(
                "Log in to Facebook".equals(
                        drv.getTitle()
                )
        );
    }
}
