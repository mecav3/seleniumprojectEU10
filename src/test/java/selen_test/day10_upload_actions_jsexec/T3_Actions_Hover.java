package selen_test.day10_upload_actions_jsexec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import selen_test.BrowserUtils;
import selen_test.Driver;

public class T3_Actions_Hover {
    @Test
    public void hoverTest() {
        Driver.getDriver().get("https://practice.cydeo.com/hovers");
        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("(//h5)[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("(//h5)[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("(//h5)[.='name: user3']"));

        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);
        actions.moveToElement(img1).perform();

        Assert.assertTrue(user1.isDisplayed());

        BrowserUtils.sleep(2);
        actions.moveToElement(img2).perform();
        Assert.assertTrue(user2.isDisplayed());

        BrowserUtils.sleep(2);
        actions.moveToElement(img3).perform();
        Assert.assertTrue(user3.isDisplayed());

    }
}

/**
 * TC #3: Hover Test
 * 1. Go to https://practice.cydeo.com/hovers
 * 2. Hover over to first image
 * 3. Assert:
 * a. “name: user1” is displayed
 * b. “view profile” is displayed
 * 4. Hover over to second image
 * 5. Assert:
 * a. “name: user2” is displayed
 * b. “view profile” is displayed
 * 6. Hover over to third image
 * 7. Confirm:
 * a. “name: user3” is displaye
 */
