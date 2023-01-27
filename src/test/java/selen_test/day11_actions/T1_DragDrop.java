package selen_test.day11_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import selen_test.ToBeExtend;

public class T1_DragDrop extends ToBeExtend {
    // @Test
    public void testName() {
        wd.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        wd.findElement(By.id("onetrust-accept-btn-handler")).click();
        //BrowserUtils.sleep(1);
        new Actions(wd).dragAndDrop(
                wd.findElement(By.id("draggable")),
                wd.findElement(By.id("droptarget"))
        ).perform();

        Assert.assertEquals("You did great!", wd.findElement(By.id("droptarget")).getText());
    }

    @Test
    public void test2() {
        wd.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        wd.findElement(By.id("onetrust-accept-btn-handler")).click();

        Actions actions = new Actions(wd);
        actions.pause(250)
                .clickAndHold(wd.findElement(By.id("draggable")))
                .moveToElement(wd.findElement(By.id("droptarget")))
                .release()
                .perform();

        Assert.assertEquals("You did great!", wd.findElement(By.id("droptarget")).getText());
    }
}

/**
 * TC #: Drag and drop
 * 1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
 * 2. Drag and drop the small circle to bigger circle.
 * 3. Assert:
 * -Text in big circle changed to: “You did great!”
 */
