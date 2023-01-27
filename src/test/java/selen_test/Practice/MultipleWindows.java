package selen_test.Practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import selen_test.SelenUtil;
import selen_test.ToBeExtend;

public class MultipleWindows extends ToBeExtend {
    @Test
    public void testName() {
        wd.get("https://www.google.com");

        for (int i = 0; i < 5; i++)
            SelenUtil.newWindow(wd, "https://www.google.com");

        for (String handle : wd.getWindowHandles()) {
            wd.switchTo().window(handle);
            wd.findElement(By.name("q")).sendKeys(new Faker().chuckNorris().fact()+ Keys.ENTER);
        }
    }
}
