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

public class AdminCreateProduct extends RootBase {

    @Test
    public void test06_admin0_active_login() {
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
    public void test07_create_a_product() {

        Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "User List");
        wd.findElement(By.cssSelector("a[data-target='#submenu-3']")).click();
        wd.findElement(By.linkText("Product")).click();
        Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "Product List");

        JS.click(wd, wd.findElement(By.id("companyCreateLink")));

        Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "Create New Product");

        String product = "myProduct_" + (new Random().nextInt(99) + 1);

        wd.findElement(By.id("name")).sendKeys(product);
        wd.findElement(By.id("lowLimitAlert")).sendKeys("3");

        new Select(wd.findElement(By.id("category"))).selectByIndex(1);
        new Select(wd.findElement(By.id("productUnit"))).selectByIndex(3);
        wd.findElement(By.name("action")).click();
        pl("crating product : " + product);
        new Select(wd.findElement(By.tagName("select"))).selectByValue("100");
        List<WebElement> wes = wd.findElements(By.xpath("//td[3]"));
        //   wes.forEach(z -> pl(z.getText()));
        Assert.assertTrue(wes.stream().anyMatch(p -> p.getText().equals(product)));
   JS.alertt(wd,"created: "  +product);

    }

    @AfterClass
    public void tearDown() {

        // wd.quit();
        //   SelenUtil.kill_driver_process();
    }
}
