package selen_test.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_HomeWork3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com ");

        driver.findElement(By.linkText("Gmail")).click();

        String expected = "Gmail";
        String actual =
                driver.getTitle();

        System.out.println(actual.contains(expected));

        driver.navigate().back();

        System.out.println("Google".equals(driver.getTitle()));
    }
}
