package selen_test.justfun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import selen_test.JS;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class ManagerCreateProduct extends RootBase {
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
    public void test07_login_as_manager0() {
        pl("\n-----Getting manager username & login to manager");
        Assert.assertEquals(wd.findElement(By.xpath("//h3")).getText(), "User List");
        String manager = wd.findElement(By.xpath("//td[.='Manager']/following-sibling::td[3]")).getText();
        logout();
        pl(manager);
        login(manager);
        Assert.assertTrue(loginIsSucces());
    }

    String product;

    @Test
    public void test08_create_a_product() {
        wd.findElement(By.cssSelector("a[data-target='#submenu-3']")).click();
        wd.findElement(By.linkText("Product")).click();
        Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "Product List");
        JS.click(wd, wd.findElement(By.id("companyCreateLink")));
        Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "Create New Product");

        pl("\n-----Creating product :"); // TODO check if exist
        product = "myProduct_" + (new Random().nextInt(999) + 1);
        wd.findElement(By.id("name")).sendKeys(product);
        wd.findElement(By.id("lowLimitAlert")).sendKeys("3");
        new Select(wd.findElement(By.id("category"))).selectByIndex(1);
        new Select(wd.findElement(By.id("productUnit"))).selectByIndex(3);
        wd.findElement(By.name("action")).click();
        pl(product);

        new Select(wd.findElement(By.tagName("select"))).selectByValue("100");
        List<WebElement> wes = wd.findElements(By.xpath("//td[3]"));
        Assert.assertTrue(wes.stream().anyMatch(p -> p.getText().equals(product)));
    }

}
