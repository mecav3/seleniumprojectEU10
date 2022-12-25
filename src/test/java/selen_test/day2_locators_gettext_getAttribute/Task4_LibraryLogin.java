package selen_test.day2_locators_gettext_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// By.className & By.id & byTag
//className & Tag are not unique most of time
//id is always unique
public class Task4_LibraryLogin {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");

// Negative testing
        String email = "incornnrect@email.com";
        String password = "incobbnrrect_pass";

        WebElement userNameInput = driver.findElement(By.className("form-control"));
        userNameInput.sendKeys(email);

        WebElement userPasswordInput = driver.findElement(By.id("inputPassword"));
        userPasswordInput.sendKeys(password);

        WebElement signInButton = driver.findElement(By.tagName("button"));
        signInButton.click();
    }
}