package com.cydeo.tests.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_HomeWork2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        String expectedHeader = "Log in to ZeroBank";
        String actualHeader =  driver.findElement(By.tagName("h3")).getText();

        System.out.println(expectedHeader);
        System.out.println(actualHeader);

        System.out.println("isTitleCorrect " + expectedHeader.equals(actualHeader));
    }
}
