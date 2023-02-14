package selen_test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selen_test.JS;

public class SeleniumTest1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
         driver.get("https://www.w3schools.com/");

        System.out.println(driver.findElements(By.tagName("div")).size());
        JS.count_tags(driver,"div");

    }
}
