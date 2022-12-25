package selen_test.day3_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_Locators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver drv = new ChromeDriver();

        drv.get("https://login1.nextbasecrm.com/");
        WebElement login = drv.findElement(By.className("login-inp"));
        login.sendKeys("incorrect");

        WebElement userPassword = drv.findElement(By.name("USER_PASSWORD"));
        userPassword.sendKeys("incorrect");

        WebElement element = drv.findElement(By.className("login-btn"));
        element.click();

        WebElement actualerrortext = drv.findElement(By.className("errortext"));

        String expected = "Incorrect login or password";

        System.out.println(expected.equals(actualerrortext.getText()));

    }
}
