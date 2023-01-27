package selen_test.day11_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import selen_test.Driver;
import selen_test.ToBeExtend;

public class ActionsPractice extends ToBeExtend {

    @Test
    public void testName() {
        wd.get("https://practice.cydeo.com");
        Actions actions = new Actions(wd);
        actions.moveToElement(wd.findElement(By.linkText("CYDEO"))).perform();
         actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
    }

    @Test
    public void test1() {
        Driver.closeDriver();
    }
}
/**
 * TC #4: Scroll practice
 * 1- Open a chrome browser
 * 2- Go to: https://practice.cydeo.com/
 * 3- Scroll down to “Powered by CYDEO”
 * 4- Scroll using Actions class “moveTo(element)” method
 * TC #5: Scroll practice 2
 * 1- Continue from where the Task 4 is left in the same test.
 * 2- Scroll back up to “Home” link using PageUP butto
 */
