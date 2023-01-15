package selen_test.day8_properties_config_reader;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selen_test.ConfigurationReader;
import selen_test.Driver;

public class T4_ConfigPractice {

    @Test
    public void testName() {
        Driver.getDriver().get("https://www.google.com");
        WebElement element = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        element.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);
    }

}
