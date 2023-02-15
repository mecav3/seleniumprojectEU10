package selen_test.justfun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import selen_test.JS;

import java.util.List;
import java.util.Random;

public class RootCreateAdmin extends AccountBase {

    @Test
    public void test01_login() {
        login(users.get(0)); // TODO dependency here for root
        Assert.assertTrue(loginIsSucces());
        pl("logged in to " + users.get(0));
    }

    @Test
    public void test02_goto_user_list() {
        wd.findElement(By.cssSelector("a.nav-link.active.bg-success-light.text-dark")).click();
        wd.findElement(By.xpath("//a[.='User Registration']")).click();
        Assert.assertEquals(wd.findElement(By.xpath("//h3")).getText(), "User List");
    }

    @Test
    public void test03_create_user() {
        int i = 0;
        while (i++ < 1) {

            JS.click(wd, wd.findElement(By.id("userCreateLink")));
            Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "Create New User");

            List<WebElement> els = wd.findElements(By.tagName("input"));
            els.remove(0);

            String name = "admin" + new Random().nextInt(999);
            els.get(0).sendKeys(name);
            els.get(1).sendKeys("last_" + new Random().nextInt(99));
            els.get(2).sendKeys(name + "@xzmail.com");
            els.get(3).sendKeys("1234567890");
            els.get(4).sendKeys(pass);
            els.get(5).sendKeys(pass);
            new Select(wd.findElement(By.id("company"))).selectByIndex(2);

            wd.findElement(By.cssSelector("button[value='save']")).click();
            Assert.assertEquals(wd.findElement(By.xpath("//h3")).getText(), "User List");
            pl("adding user " + i);
        }
    }

    @AfterClass
    public void tearDown() {
//       wd.quit();
//         SelenUtil.kill_driver_process();
    }
}
