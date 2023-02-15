package selen_test.justfun;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import selen_test.JS;

public class ManagerCreateAproveInvoice extends ManagerCreateProduct {

    @Test
    public void test09_goto_purchase_invoice() {
        wd.findElement(By.cssSelector("a[data-target='#submenu-4']")).click();
        wd.findElement(By.linkText("Purchase Invoice")).click();
        Assert.assertEquals(wd.findElement(By.tagName("h2")).getText(), "Purchase Invoice List");
        pl("\n-----Creating Purchase Invoice");
        JS.click(wd, wd.findElement(By.id("companyCreateLink")));
        Assert.assertEquals(wd.findElement(By.tagName("h3")).getText(), "Create New Purchase Invoice");
    }

    String invoice;

    @Test
    public void test10_create_purchase_invoice() {
        new Select(wd.findElement(By.id("vendor"))).selectByIndex(1);
        wd.findElement(By.name("action")).click();
        new Select(wd.findElement(By.id("product"))).selectByVisibleText(product);
        wd.findElement(By.id("quantity")).sendKeys("7");
        wd.findElement(By.id("price")).sendKeys("77");
        wd.findElement(By.id("tax")).sendKeys("7");
        wd.findElement(By.xpath("//button[@value='addItem']")).click();
        invoice = wd.findElement(By.id("invoiceNo")).getAttribute("value");
        p(invoice);
    }

    @Test
    public void test11_approve_purchase_invoice() {
        JS.click(wd, wd.findElement(By.id("companylistlink")));
        Assert.assertEquals(wd.findElement(By.tagName("h2")).getText(), "Purchase Invoice List");
        new Select(wd.findElement(By.tagName("select"))).selectByValue("100");
        pl(" approving..");
        wd.findElement(By.xpath("//td[.='" + invoice + "']/following-sibling::td[6]//button[.='Approve']")).click();
    }

    @AfterClass
    public void tearDown() {
        JS.alertt(wd, product + " : " + invoice);
        // wd.quit();
        //   SelenUtil.kill_driver_process();
    }
}
