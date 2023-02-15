package selen_test.justfun;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import selen_test.JS;

import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeCreatePinvoice extends RootBase {
    String e_manager;

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
    public void test07_login_as_employee0() {
        pl("\n-----Getting username & login to employee");
        Assert.assertEquals(wd.findElement(By.xpath("//h3")).getText(), "User List");
        String employee = wd.findElement(By.xpath("//td[.='Employee']/following-sibling::td[3]")).getText();
        e_manager = wd.findElement(By.xpath("//td[.='Manager']/following-sibling::td[3]")).getText();
        logout();
        pl(employee);
        login(employee);
        Assert.assertTrue(loginIsSucces());
    }

    @Test
    public void test09_goto_purchase_invoice() {
        wd.findElement(By.cssSelector("a[data-target='#submenu-4']")).click();
        wd.findElement(By.linkText("Purchase Invoice")).click();
        Assert.assertEquals(wd.findElement(By.tagName("h2")).getText(), "Purchase Invoice List");
        pl("\n-----Creating Purchase Invoice");
        JS.click(wd, wd.findElement(By.id("companyCreateLink")));
        Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "Create New Purchase Invoice");
    }

    String e_invoice;
    String e_product;

    @Test
    public void test10_create_purchase_invoice() {
        new Select(wd.findElement(By.id("vendor"))).selectByIndex(2);
        wd.findElement(By.name("action")).click();

        Select s = new Select(wd.findElement(By.id("product")));
        s.selectByIndex(2);
        e_product = s.getFirstSelectedOption().getText();

        wd.findElement(By.id("quantity")).sendKeys("8");
        wd.findElement(By.id("price")).sendKeys("88");
        wd.findElement(By.id("tax")).sendKeys("8");
        wd.findElement(By.xpath("//button[@value='addItem']")).click();
        e_invoice = wd.findElement(By.id("invoiceNo")).getAttribute("value");

        pl(e_product);
        pl(e_invoice);
    }
}
