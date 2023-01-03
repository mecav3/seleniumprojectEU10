package selen_test.day3_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_Locators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://login1.nextbasecrm.com/");
        WebElement login = driver.findElement(By.className("login-inp"));
        login.sendKeys("incorrect");

        WebElement userPassword = driver.findElement(By.name("USER_PASSWORD"));
        userPassword.sendKeys("incorrect");

        WebElement element = driver.findElement(By.className("login-btn"));
        element.click();

        WebElement actualerrortext = driver.findElement(By.className("errortext"));
String actualtext = actualerrortext.getText();

        String expected = "Incorrect login or password";

        System.out.println(
                expected.equals(actualtext)
        );

    }
}
