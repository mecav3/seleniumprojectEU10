package selen_test.day10_upload_actions_jsexec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import selen_test.Driver;

public class T2_Upload { // selenium cannot handle download
    @Test
    public void testupload() {

        Driver.getDriver().get("https://practice.cydeo.com/upload");
        String path = "C:\\Users\\hhm\\IdeaProjects\\seleniumprojectEU10\\configuration.properties";

        WebElement upload = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        upload.sendKeys(path);

        WebElement uploadbutton = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));
        uploadbutton.click();

        WebElement header = Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(header.isDisplayed());

    }
}

/**
 * TC #2 Upload Test
 * 1. Go to https://practice.cydeo.com/upload
 * 2. Find some small file from your computer, and get the path of it.
 * 3. Upload the file.
 * 4. Assert:
 * -File uploaded text is displayed on the pag
 */
