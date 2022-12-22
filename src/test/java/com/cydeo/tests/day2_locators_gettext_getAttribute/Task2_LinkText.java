package com.cydeo.tests.day2_locators_gettext_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Locator: find web element ByLinkText & Click on it
public class Task2_LinkText {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.cydeo.com");

        WebElement abTestlink = driver.findElement( By.linkText("A/B Testing") );

        abTestlink.click();

        String expectedTitle = "No A/B Test";

        String actualTitle = driver.getTitle();

        System.out.println("title verification : " + expectedTitle.equals(actualTitle) +" ." + actualTitle);

        driver.navigate().back();

        System.out.println("title verification : " + "Practice".equals(driver.getTitle()) + " ."+driver.getTitle());

    }
}
