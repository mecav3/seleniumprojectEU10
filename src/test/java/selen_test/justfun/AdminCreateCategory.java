package selen_test.justfun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import selen_test.JS;

import java.util.*;
import java.util.stream.Collectors;

public class AdminCreateCategory extends RootBase {

    @Test
    public void test06_admin0_active_login() {
        hoold();
        wd.get(url);
        pl("\n-----Testing Active Admins : ");
        for (Map.Entry<String, String> entry :
                admins.entrySet().stream().filter(n -> companies.get(n.getValue()).equalsIgnoreCase("active")).collect(Collectors.toList())) {
            pl(entry.getKey());
            login(entry.getKey());
            Assert.assertTrue(loginIsSucces()); // TODO gettitle bööle olmaz şifre yok çakıyo
            break;
        }
    }

    @Test
    public void test07_create_a_category() {

        Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "User List");
        wd.findElement(By.cssSelector("a[data-target='#submenu-3']")).click();
        wd.findElement(By.linkText("Category")).click();

        Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "Category List");

        JS.click(wd, wd.findElement(By.id("companyCreateLink")));

        Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "Create New Category");

        String category = "MyCategory_" + new Random().nextInt(999);

        wd.findElement(By.id("description")).sendKeys(category);
        wd.findElement(By.name("action")).click();
        new Select(wd.findElement(By.tagName("select"))).selectByValue("100");
        pl("\n----creating category : " + category);
        List<WebElement> wes = wd.findElements(By.xpath("//td[2]"));

        Assert.assertTrue(wes.stream().anyMatch(z -> z.getText().equals(category)));
        JS.writee(wd,"created: "+category);

    }

    @AfterClass
    public void tearDown() {
        // wd.quit();
        //   SelenUtil.kill_driver_process();
    }
}
