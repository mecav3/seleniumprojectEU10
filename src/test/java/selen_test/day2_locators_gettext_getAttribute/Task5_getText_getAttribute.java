package selen_test.day2_locators_gettext_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//getText & getattribute of a webelement
public class Task5_getText_getAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.cydeo.com/registration_form");

        String expectedHeaderText = "Registration form";
        String actualHeaderText = driver.findElement(By.tagName("h2")).getText();

        System.out.println("verify header text : "+expectedHeaderText.equals(actualHeaderText));

        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        String actualPlaceHolder =   firstNameInput.getAttribute("placeholder");
        String expectedPlaceHolder = "first name";

        System.out.println("verify placeholder : "+expectedPlaceHolder.equals(actualPlaceHolder));
    }
}
