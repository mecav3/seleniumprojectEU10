package selen_test.day8_properties_config_reader;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selen_test.ConfigurationReader;
import selen_test.WebDriverFactory;

public class ConfigPractice {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browserType = ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browserType);
        driver.get("https://www.google.com");

    }

    @Test
    public void testName() {
        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
        element.sendKeys("apple" + Keys.ENTER);
    }

}
