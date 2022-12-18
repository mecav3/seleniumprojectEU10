package com.cydeo.tests.day2_locators_gettext_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//check title & url
public class Task1_Verify {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://practice.cydeo.com");

        System.out.println("URL "+  ( driver.getCurrentUrl()  ).contains("cydeo") );

        System.out.println( "Title "+ driver.getTitle().equals("Practice"));

    }
}
