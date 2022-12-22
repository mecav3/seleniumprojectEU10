package com.cydeo.tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Facebook_Task2 {
    public static void main(String[] args) {

      WebDriver drv = SelenUtil.getdrv("https://www.facebook.com");
     drv.findElement(By.id("email")).sendKeys("false@false.com");
     drv.findElement(By.id("pass")).sendKeys("invalidpass"+ Keys.ENTER);

        System.out.println(
                "Log into Facebook".equals(
                        drv.getTitle()
                )
        );
    }
}
