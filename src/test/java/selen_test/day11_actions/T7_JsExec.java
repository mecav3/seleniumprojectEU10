package selen_test.day11_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import selen_test.BrowserUtils;
import selen_test.ToBeExtend;

public class T7_JsExec extends ToBeExtend {
    @Test
    public void testName() {
        wd.get("https://practice.cydeo.com");
        Actions actions = new Actions(wd);
        WebElement cydeo = wd.findElement(By.linkText("CYDEO"));
        WebElement home = wd.findElement(By.linkText("Home"));

        JavascriptExecutor js = (JavascriptExecutor) wd;

        js.executeScript("arguments[0].scrollIntoView(true)", cydeo);
        BrowserUtils.sleep(2);
        js.executeScript("arguments[1].scrollIntoView(true)", cydeo, home);


    }
}
